let modeCnt = 0
window.addEventListener('scroll', function() {
    let navbar = document.querySelector('.navbar');
    if (window.scrollY > 50) { 
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

// 편집 모드 (toggle)
function toggleEditMode() {
    modeCnt += 1
    if (modeCnt >= 2) {
        location.reload();
    }

    const controls = document.querySelectorAll('.edit-controls');
    controls.forEach(control => {
        if (control.style.display === 'none') {
            control.style.display = 'block';
        } else {
            control.style.display = 'none';
        }
    });
}

function updateForm(event, pk, postIndex) {

    event.preventDefault();
    let postTitle = $("#postTitle-" + pk).text();
    let postContent = $("#postContent-" + pk).html();
    let postImageSrc = $("#postImage-" + pk).attr('src');

    let section = document.getElementById('content-' + pk);
        if ((postIndex + 1) % 2 !== 0) { 

            section.innerHTML = `
                <div class="row">
                    <div class="col-5 me-5">
                        <div class="mb-2">
                            <img src="${postImageSrc}" alt="Description of Image" class="img-fluid responsive-image" id="postImage-${pk}">
                        </div>
                        <input type="file" id="fileInput-${pk}" onchange="checkImage(${pk})">
                    </div>
                    <div class="col-5 pt-3">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="postTitle-${pk}" placeholder="제목을 입력하세요" value="${postTitle}">
                        </div>
                        <hr>
                        <div class="mb-3">
                            <textarea class="form-control" id="postContent-${pk}" rows="5" placeholder="내용을 입력하세요">${postContent}</textarea>
                        </div>
                    </div>
                    <div class="col-2">
                    </div>
                </div>
                <div class="my-3 me-5 d-flex justify-content-end">  
                    <button class="btn btn-outline-secondary" onclick="updatePost(${pk})">수정완료</button>
                </div>
            `;            

        } else {

            section.innerHTML = `
                <div class="row">
                    <div class="col-1">
                    </div>
                    <div class="col-5 pt-3">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="postTitle-${pk}" placeholder="제목을 입력하세요" value="${postTitle}">
                        </div>
                        <hr>
                        <div class="mb-3">
                            <textarea class="form-control" id="postContent-${pk}" rows="5" placeholder="내용을 입력하세요">${postContent}</textarea>
                        </div>
                    </div>
                    <div class="ms-5 col-5">
                        <div class="mb-2">
                            <img src="${postImageSrc}" alt="Description of Image" class="img-fluid responsive-image" id="postImage-${pk}">
                        </div>
                        <input type="file" id="fileInput-${pk}" onchange="checkImage(${pk})">
                    </div>
                </div>
                <div class="my-3 d-flex justify-content-end">  
                    <button class="btn btn-outline-secondary" onclick="updatePost(${pk})">수정완료</button>
                </div>
            `;

        }                
}

function deletePost(container_number) {


}

function addPost() {
    const jwtToken = localStorage.getItem('jwtToken'); 

    let input = document.getElementById('fileInput-new');
    let file = input.files[0];
    if (!file) {
        alert("파일이 선택되지 않았습니다.");
        return;
    }

    let postTitle = $('#postTitle-new').val();
    let postContent = $('#postContent-new').val();
    postContent = postContent.replace(/\n/g, "<br>");

    readFileAsDataURL(input, function(dataURL) {
        let payload = {
            postTitle: postTitle,
            postContent: postContent,
            imageName: file.name,
            contentType: file.type,
            imageData: JSON.stringify(dataURL)
        };
        console.log(payload)
        $.ajax({
            url: '/auth/main',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': jwtToken 
            },
            data: JSON.stringify(payload),  

            success: function(response, textStatus, jqXHR) {
                console.log(response);
                appendNewPost(response.data);
            },
            error: function(error) {
                console.error(error);
            }
        });
    });
}  

function appendNewPost(postDTO) {
    const index = document.querySelectorAll('.post-container').length;
    console.log(index)
    let newPostHTML = "";
    if (index % 2 === 0) {
        newPostHTML = `
        <div class="container post-container ps-5" style="height:450px" id="content-${postDTO.id}">
            <div class="row">
            <div class="col-5 me-5">
                <img src="${postDTO.imgURL}" alt="Description of Image" id="postImage-${postDTO.id}" class="img-fluid responsive-image">
            </div>
            <div class="col-5 pt-3">
                <h2 id="postTitle-${postDTO.id}">${postDTO.postTitle}</h2><hr>
                <div id="postContent-${postDTO.id}">${postDTO.postContent}</div>
            </div>
            <div class="col-2"></div>
            </div>
            <div class="edit-controls" style="display: none;">
            <div class="my-3 me-5 d-flex justify-content-end">
                <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, ${postDTO.id}, ${index})">수정하기</button>
                <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost(${postDTO.id})">삭제하기</button>
            </div>
            </div>
        </div>`;
    } else {
        // Use the second template
        newPostHTML = `
        <div class="container post-container pe-5" style="height:450px" id="content-${postDTO.id}">
            <div class="row">
            <div class="col-1"></div>
            <div class="col-5 pt-3">
                <h2 id="postTitle-${postDTO.id}">${postDTO.postTitle}</h2><hr>
                <div id="postContent-${postDTO.id}">${postDTO.postContent}</div>
            </div>
            <div class="col-5 ms-5">
                <img src="${postDTO.imgURL}" alt="Description of Image" id="postImage-${postDTO.id}" class="img-fluid responsive-image">
            </div>
            </div>
            <div class="edit-controls" style="display: none;">
            <div class="my-3 me-1 d-flex justify-content-end">
                <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, ${postDTO.id}, ${index})">수정하기</button>
                <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost(${postDTO.id})">삭제하기</button>
            </div>
            </div>
        </div>`;
    }

    $("#postBox").append(newPostHTML);
    const controls = document.querySelectorAll('.edit-controls');
    controls.forEach(control => {
        if (control.style.display === 'none') {
            control.style.display = 'block';
        } 
    });

    resetForm();
}

function resetForm() {
    // 제목, 내용 필드 초기화
    $('#postTitle-new').val('');
    $('#postContent-new').val('');
  
    // 파일 입력 및 이미지 미리보기 초기화
    $('#fileInput-new').val('');
    $('#imagePreview').empty();
}

function previewImage(event) {
    const reader = new FileReader();
    const file = event.target.files[0];

    reader.onloadend = function() {
        const imagePreview = document.querySelector('.blog-image-preview');
        imagePreview.style.backgroundImage = 'url(' + reader.result + ')';
        imagePreview.style.backgroundSize = '100% 100%';
        imagePreview.style.backgroundPosition = 'center center';
        document.querySelector('.plus-icon').style.display = 'none'; // + 모양 숨기기

        imagePreview.classList.remove('blog-image-preview'); // 기존 클래스 제거
        imagePreview.classList.add('blog-image-preview-change'); // 새로운 클래스 추가
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        resetPreview();
    }
}

function checkImage(pk) {
    const fileInput = document.getElementById('fileInput-'+pk);
    const imageToChange = document.getElementById('postImage-'+pk);
    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();
        // 이벤트 큐에 등록. CallBack 함수 작성
        reader.onload = function(e) {
            imageToChange.src = e.target.result;
        }
        // 다 읽고 난 뒤, 위 CallBack 함수 작동
        reader.readAsDataURL(file);
    }
}

function updatePost(pk){   
    const jwtToken = localStorage.getItem('jwtToken'); 
    let input = document.getElementById('fileInput-'+pk);
    let file = input.files[0];
    let imageName = '';
    let contentType = '';
    let imgChangeCheck = false;

    let postImageElement = document.getElementById('postImage-' + pk);
    let postImageSrc = postImageElement.src;

    let isBase64Image = postImageSrc.startsWith('data:image/');

    if (isBase64Image) {
        imageName = file.name;
        contentType = file.type;
        imgChangeCheck = true;
    } else {

    }

    
    postTitle = $(`#postTitle-${pk}`).val()
    postContent = $(`#postContent-${pk}`).val()
    postContent = postContent.replace(/\n/g, "<br>");
    
    console.log("디버깅55")

    let payload = {
        postPK: pk,
        postTitle: postTitle,
        postContent: postContent,
        imageName: imageName,
        contentType: contentType,
        imageData: postImageSrc,
        imgChangeCheck: imgChangeCheck
    };

    $.ajax({
        url: '/auth/main',
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': jwtToken 
        },
        data: JSON.stringify(payload),  

        success: function(response, textStatus, jqXHR) {
            console.log(response);
        },
        error: function(error) {
            console.error(error);
        }
    });


    // ajax 통신 이 후, reload
}

function readFileAsDataURL(input, callback) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
            callback(e.target.result);
        };
        
        reader.readAsDataURL(input.files[0]);
    }
}