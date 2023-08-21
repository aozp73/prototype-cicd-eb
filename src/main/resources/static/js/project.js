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
$('.card').on('click', function() {
    const cardId = $(this).data('card-id');
    showModalWithDetails(cardId);
});

function showModalWithDetails(cardId) {
    const title = '테스트 제목';
    const description = '테스트 내용';
    const imageSrc = getImageSrcByCardId(cardId)
    const textFromDB = "기능1\n기능2\n기능3"; 
    const convertedText = textFromDB.replace(/\n/g, '<br>');
    // ☆★☆★ Ajax-GET 통신
    document.getElementById("projectModalResponsibilities").innerHTML = convertedText;
    document.getElementById("projectModalLabel").innerText = title;
    document.getElementById("projectModalImage").setAttribute("src", imageSrc);
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
    let formData = new FormData(document.getElementById('addForm'));
    for (let [key, value] of formData.entries()) {
        console.log(key, value);
    }
    console.log($('#selectedRoles').val())
    
    // ☆★☆★ Ajax-POST 통신

    // 폼 초기화
    resetModalForm();
    // 모달 닫기
    $('#projectAddForm').modal('hide');
}

function updateProject() {
    let formData = new FormData(document.getElementById('updateForm'));
    for (let [key, value] of formData.entries()) {
        console.log(key, value);
    }
    console.log($('#selectedRoles').val())

    // ☆★☆★ Ajax-PUT 통신

    // 폼 초기화
    resetModalForm();
    // 모달 닫기
    $('#projectUpdateForm').modal('hide');
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

        card.find('.member-icons').text(iconsForMembers);
    });
});
// ~ 이모지