window.addEventListener('scroll', function() {
    let navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) { 
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

function toggleEditMode() {
    const controls = document.querySelectorAll('.edit-controls');
    controls.forEach(control => {
        if (control.style.display === 'none') {
            control.style.display = 'block';
        } else {
            control.style.display = 'none';
        }
    });
}

// 상세정보 ~
$('#main-container .row').on('click', '.card', function() {
    const cardId = $(this).data('card-id');
    showModalWithDetails(cardId);
});

function showModalWithDetails(cardId) {
    // const cardElement = $(`div[data-card-id='${cardId}']`);
    const cardElement = $(`#project-${cardId} .card`);
    const parentElement = cardElement.closest(`#project-${cardId}`);
    
    // 상세보기 필요한 정보 가져오기
    const title = parentElement.find('span.project-name').text();
    const project_ImageSrc = parentElement.find('img').attr('src');
    console.log(title)
    const performance_ImageSrc = parentElement.data('individual-performance-img');
    const readmeUrl = parentElement.data('readme-url');
    const githubUrl = parentElement.data('github-url'); 
    
    // 모달에 정보를 랜더링합니다.
    document.getElementById("projectModalLabel").innerText = title;
    document.getElementById("projectModalImage").setAttribute("src", project_ImageSrc);
    document.getElementById("performanceModalImage").setAttribute("src", performance_ImageSrc);
    document.getElementById("projectModalREADMELink").innerHTML = `<a href="${readmeUrl}" target="_blank" style="text-decoration: none;">README 링크</a>`;
    document.getElementById("projectModalGithubLink").innerHTML = `<a href="${githubUrl}" target="_blank" style="text-decoration: none;">Github 링크</a>`;
    
    // 모달을 띄웁니다.
    var modal = new bootstrap.Modal(document.getElementById("projectModal"));
    modal.show();
}
// ~ 상세정보

// 추후 삭제할 함수
function getImageSrcByCardId(cardId) {
    const cardElement = document.querySelector(`.card[data-card-id="${cardId}"]`);
    if (cardElement) {
        const imgElement = cardElement.querySelector('img');
        if (imgElement) {
            return imgElement.getAttribute('src');
        }
    }
    return null;
}

// add, update Form ~
function getAddForm(){
    var modal = new bootstrap.Modal(document.getElementById("projectAddForm"));
    modal.show(); 
}
function getUpdateForm(event){
    event.stopPropagation();

    const buttonClicked = event.target;
    const cardElement = buttonClicked.closest('.card');
    const cardId = cardElement.getAttribute('data-card-id');

    // ☆★☆★ cardID로 Ajax-GET 통신 후, Modal Form에 해당 값 미리 띄워놓기

    var modal = new bootstrap.Modal(document.getElementById("projectUpdateForm"));
    modal.show(); 
}
// ~ add, update Form

// add, update, delete ~
function postProject() {
    const jwtToken = localStorage.getItem('jwtToken'); 

    // 입력 값 (프로젝트명 / 인원 / 시작날짜 / 종료날짜 / 참여역할 / README 주소 / GitHub주소)
    let formData = new FormData(document.getElementById('addForm'));
    formData.delete("postProjectImage");
    formData.delete("postIndividualPerformanceImage");

    // 프로젝트 이미지, 개인 수행 각 Base64 문자열 저장 
    let imageElement = document.getElementById('addImagePreview');
    let projectImgBase64 = imageElement.src;
    let featureImageElement = document.getElementById('addFeatureImagePreview');
    let individualPerformanceBase64 = featureImageElement.src;

    // 이미지 파일 이름과 타입 저장 (S3 전송에 사용)
    let projectImage_Input = document.getElementById('postProjectImage');
    let individualPerformanceImage_Input = document.getElementById('postIndividualPerformanceImage');

    let projectImageName = '';
    let projectImageType = '';
    let individualPerformanceImageName = '';
    let individualPerformanceImageType = '';

    if (projectImage_Input.files && projectImage_Input.files[0]) {
        projectImageName = projectImage_Input.files[0].name;
        projectImageType = projectImage_Input.files[0].type;
    }
    if (individualPerformanceImage_Input.files && individualPerformanceImage_Input.files[0]) {
        individualPerformanceImageName = individualPerformanceImage_Input.files[0].name;
        individualPerformanceImageType = individualPerformanceImage_Input.files[0].type;
    }

    // 이미지 파일인지 체크 후, formData에 Base64 / 이미지 이름 / 이미지 타입 추가 저장
    if (projectImgBase64.startsWith('data:image/') && individualPerformanceBase64.startsWith('data:image/')) {
        formData.append("projectImgBase64", projectImgBase64);
        formData.append("individualPerformanceBase64", individualPerformanceBase64);
        formData.append("projectImageName", projectImageName);
        formData.append("projectImageType", projectImageType);
        formData.append("individualPerformanceImageName", individualPerformanceImageName);
        formData.append("individualPerformanceImageType", individualPerformanceImageType);
    } else {
        alert("이미지 파일을 등록해야 합니다.")
        return
    }
    
    for (let [key, value] of formData.entries()) {
        console.log(key, value);
    }
    let data = {};
    formData.forEach((value, key) => {data[key] = value});

    $.ajax({
        url: "/auth/myproject",
        type: "POST",
        data: JSON.stringify(data),
        contentType: 'application/json',
        headers: {
            'Authorization': jwtToken  
        },
        success: function(response) {
            console.log(response);
            // 폼 초기화
            resetModalForm();
            // 모달 닫기
            $('#projectAddForm').modal('hide');

            let selectedRoles = response.data.selectedRoles;
            let roleString = selectedRoles ? selectedRoles.map((role, index, array) => 
                `${index === 0 ? '&nbsp;' : ''}${role}${index < array.length - 1 ? ' / ' : ''}`
            ).join('') : '';

            let newProjectHTML = `
            <div class="col-lg-3 col-md-6 mb-4" id="project-${response.data.id}" 
                data-readme-url="${response.data.readmeUrl}" 
                data-github-url="${response.data.githubUrl}"
                data-individual-performance-img="${response.data.individualPerformanceImageNameURL}">
                <div class="card card-hover-effect" data-card-id="${response.data.id}" data-members="${response.data.member}" style="height: 380px; overflow: hidden;">
                    <div class="card-body px-4">
                        <div class="text-center mt-2">
                            <span class="project-name" style="font-size: 1.6em;">${response.data.projectName}</span>
                        </div>
                        <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                            <img src="${response.data.projectImgURL}" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                        </div>
                        <div class="card-inner" style="height: 127px;">
                            <div class="ps-3">
                                <div class="mt-3 mb-2">
                                    <span class="member-icons" style="font-size: 1.3em;"></span>
                                </div>
                                <div class="mb-2 ps-1">
                                    &nbsp${response.data.startDate} ~ ${response.data.endDate}
                                </div>
                                <div class="mb-2 ps-1" style="font-size: 15px">
                                ${roleString}
                                </div>
                            </div>
                        </div>
                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: block;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-${response.data.id}')">삭제</button>
                        </div>
                    </div>
                </div>
            </div>`;

            $('#main-container .row').append(newProjectHTML);

            const newCard = $(`#project-${response.data.id} .card`);
            const membersCount = newCard.data('members');
            console.log(membersCount);  
            const iconsForMembers = getMembersIcons(membersCount);
            newCard.find('.member-icons').html("&nbsp;" + iconsForMembers);

        },
        error: function(error) {
            alert(error.responseJSON.data);
        }
    });
}

function getUpdateForm(event){
    event.stopPropagation();

    const buttonClicked = event.target;
    const cardElement = buttonClicked.closest('.card');
    const cardId = cardElement.getAttribute('data-card-id');
    const parentDiv = cardElement.parentElement;

    // 해당 카드 정보 가져오기
    const projectName = document.getElementById(`projectName-${cardId}`).textContent; 
    const readmeUrl = parentDiv.getAttribute('data-readme-url');
    const githubUrl = parentDiv.getAttribute('data-github-url');
    const members = cardElement.getAttribute('data-members');
    const startDate = parentDiv.getAttribute('data-start-date');
    const endDate = parentDiv.getAttribute('data-end-date');
    
    const individualPerformanceURL = parentDiv.getAttribute('data-individual-performance-img');
    const projectImgURL = document.getElementById(`projectImg-${cardId}`).src;
    
    // 가져온 정보로 모달의 input 필드에 저장
    document.getElementById('updateProjectName').value = projectName;
    document.getElementById('updateMembers').value = members;
    document.getElementById('updateStartDate').value = startDate;
    document.getElementById('updateEndDate').value = endDate;
    document.getElementById('updateReadmeUrl').value = readmeUrl;
    document.getElementById('updateGithubUrl').value = githubUrl;
    document.getElementById('updateFeatureImagePreview').value = individualPerformanceURL;
    
    
    // 버튼 활성화
    const roleCodes = parentDiv.getAttribute('data-role-codes');
    const roleArray = roleCodes.replace(/[\[\]]/g, '').split(',').map(role => role.trim());
    const roleButtons = document.querySelectorAll('.role-btn');
    roleButtons.forEach(button => {
      const role = button.getAttribute('data-role');
      if (roleArray.includes(role)) {
        button.classList.remove('btn-outline-primary');
        button.classList.add('btn-primary');
      } else {
        button.classList.remove('btn-primary');
        button.classList.add('btn-outline-primary');
      }
    });

    // 이미지 미리보기
    const imgPreview = document.getElementById('updateImagePreview');
    imgPreview.src = projectImgURL;
    imgPreview.style.display = 'block';

    const featureImagePreview = document.getElementById('updateFeatureImagePreview');
    featureImagePreview.src = individualPerformanceURL;
    featureImagePreview.style.display = 'block';
    
    // 모달창 생성
    var modal = new bootstrap.Modal(document.getElementById("projectUpdateForm"));
    modal.show(); 
}

function updateProject() {
    const jwtToken = localStorage.getItem('jwtToken'); 

    const payload = createPayload();
    console.log(payload)
    $.ajax({
        url: '/auth/myproject',
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': jwtToken 
        },
        data: JSON.stringify(payload),

        success: function(response, textStatus, jqXHR) {

        },
        error: function(jqXHR, textStatus, errorThrown) {

        }
    });
}

function deleteProject(event, id) {
    // id값을 Server에서 보내서 DB 삭제 후 reload or 부분 삭제
    event.stopPropagation();

    $(`#${id}`).fadeOut(function() {
        $(this).remove();
    });
}
// ~ add, update, delete

// 이미지 미리보기 ~
function previewImage(input, previewElementId) {
    const file = input.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const previewElement = document.getElementById(previewElementId);
            previewElement.src = e.target.result;
            previewElement.style.display = "block";
        }
        reader.readAsDataURL(file);
    }
}
// ~ 이미지 미리보기

// 참여역할 버튼 ~
$(document).ready(function() {
    $('.role-btn').click(function() {
        var $this = $(this);
        if ($this.hasClass('btn-outline-primary')) {
            $this.removeClass('btn-outline-primary').addClass('btn-primary');
        } else {
            $this.removeClass('btn-primary').addClass('btn-outline-primary');
        }
        updateSelectedRoles();
    });
});

function updateSelectedRoles() {
    var selectedRoles = [];
    $('.role-btn.btn-primary').each(function() {
        selectedRoles.push($(this).data('role'));
    });
    $('#selectedRoles').val(selectedRoles.join(','));
}
// ~ 참여역할 버튼 

// 모달 초기화 ~
$('#projectAddForm').on('hidden.bs.modal', function () {
    resetModalForm();
});
$('#projectUpdateForm').on('hidden.bs.modal', function () {
    resetModalForm();
});

function resetModalForm() {
    // 모든 input 필드 초기화
    $('#projectAddForm').find('input').val('');
    $('#projectUpdateForm').find('input').val('');

    // 이미지 프리뷰 초기화
    $('#addImagePreview').attr('src', '#').hide();
    $('#updateImagePreview').attr('src', '#').hide();
    $('#addFeatureImagePreview').attr('src', '#').hide();
    $('#updateFeatureImagePreview').attr('src', '#').hide();

    // 참여역할 버튼 초기화
    $('.role-btn.btn-primary').removeClass('btn-primary').addClass('btn-outline-primary');
}
// ~ 모달 초기화

// 이모지 ~
function getMembersIcons(membersCount) {
    const icons = ['🧔', '👦', '🧑', '👩', '👱'];
    return icons.slice(0, membersCount).join('');
}

$(document).ready(function() {
    $('.card').each(function() {
        const card = $(this);
        const membersCount = card.data('members');
        const iconsForMembers = getMembersIcons(membersCount);

        card.find('.member-icons').html("&nbsp;" + iconsForMembers);
    });
});
// ~ 이모지

// 상세정보 모달창 url, 이미지 새창 열기 (★☆★☆★☆코드 정리할 때 상세정보 기능끼리 묶어서 정리)
function openImageInNewWindow(src) {
    window.open(src, 'Image', 'width=800,height=600,left=600,top=50');
}

// 수정하기 버튼 클릭 시 데이터 가져와서 Payload 생성 
function createPayload() {
    const projectName = document.getElementById('updateProjectName').value;
    const members = document.getElementById('updateMembers').value;
    const startDate = document.getElementById('updateStartDate').value;
    const endDate = document.getElementById('updateEndDate').value;
    const readmeUrl = document.getElementById('updateReadmeUrl').value;
    const githubUrl = document.getElementById('updateGithubUrl').value;

    const roleButtons = document.querySelectorAll('.btn-primary.update-role');
    let selectedRoles = [];
    roleButtons.forEach(button => {
        selectedRoles.push(button.getAttribute('data-role'));
    });

    let projectImageDetails = getImageDetails('updateProjectImg', 'updateImagePreview');
    let featureImageDetails = getImageDetails('updateIndividualPerformanceImg', 'updateFeatureImagePreview');

    let payload = {
        projectName: projectName,
        members: members,
        startDate: startDate,
        endDate: endDate,
        readmeUrl: readmeUrl,
        githubUrl: githubUrl,
        selectedRoles: selectedRoles,

        projectImageDetails : projectImageDetails,
        featureImageDetails : featureImageDetails
    };
    return payload;
}

function getImageDetails(inputId, imageId) {
    let input = document.getElementById(inputId);
    let file = input.files[0];
    let imageName = '';
    let contentType = '';
    let imgChangeCheck = false;

    let imageElement = document.getElementById(imageId);
    let imageSrc = imageElement.src;

    let isBase64Image = imageSrc.startsWith('data:image/');

    if (isBase64Image) {
        imageName = file.name;
        contentType = file.type;
        imgChangeCheck = true;
    } else {
        imageSrc = '';
    }

    return {
        imageSrc,
        imageName,
        contentType,
        imgChangeCheck
    };
}
