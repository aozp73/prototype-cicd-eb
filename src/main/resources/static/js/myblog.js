let modeCnt = 0

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

// 사진 미리보기 ~
function previewImage(event, container_number) {
    const reader = new FileReader();
    const file = event.target.files[0];
    
    reader.onloadend = function() {
        const imagePreview = document.querySelector('#image-preview-' + container_number);
        imagePreview.classList.remove('blog-image-preview'); 
        imagePreview.classList.add('blog-image-preview-change');
        imagePreview.style.backgroundImage = 'url(' + reader.result + ')';
        imagePreview.style.backgroundSize = '100% 100%';
       
        if (container_number === 'new') {
             document.querySelector('.plus-icon').style.display = 'none'; 
        }
    }
    
    if (file) {
        reader.readAsDataURL(file);
    } else {
        resetPreview();
    }
}
// ~ 사진 미리보기

function resetPreview() {
    const imagePreview = document.querySelector('.blog-image-preview');
    imagePreview.style.backgroundImage = 'none';
    document.querySelector('.plus-icon').style.display = 'block';
}

// update ~
function updateForm(event, container_number) {
    let section = document.getElementById('container-' + container_number);
    let heading = section.querySelector('#heading-' + container_number + ' h3').innerText;
    let subheading = section.querySelector('#subheading-' + container_number + ' h4').innerText;
    let content = section.querySelector('#content-' + container_number + ' p').innerText;

    let backgroundImage = section.querySelector('.blog-image-preview-change').style.backgroundImage.slice(5, -2);
    
    section.innerHTML = `
        <div class="mb-4">
            <div class="mb-4">
                <input type="text" class="form-control" id="postTitle-${container_number}" value="${heading}">
            </div>
        </div>
        <div class="row">
            <div class="col-5">
                <div class="blog-image-preview-change mb-3" id="image-preview-${container_number}" style="height: 261px; background-image: url('${backgroundImage}'); background-size: 100% 100%;" onclick="document.getElementById('imageInput-${container_number}').click();">
                    <input type="file" id="imageInput-${container_number}" style="display: none;" onchange="previewImage(event, ${container_number})">
                </div>
            </div>
            <div class="col-7">
                <form id="postForm-${container_number}">
                    <div class="mb-3">
                        <input type="text" class="form-control" id="postSubTitle-${container_number}" value="${subheading}">
                    </div>
                    <div class="mb-3">
                        <textarea class="form-control" id="postContent-${container_number}" rows="8">${content}</textarea>
                    </div>
                </form>
                <div class="my-3 d-flex justify-content-end">
                    <button type="button" class="btn btn-primary" onclick="updatePost(${container_number})">수정완료</button>
                </div>
            </div>
        </div>
    `;
}

function updatePost(container_number) {
    let postTitle = document.getElementById('postTitle-' + container_number).value;
    let postSubTitle = document.getElementById('postSubTitle-' + container_number).value;
    let postContent = document.getElementById('postContent-' + container_number).value;

    let backgroundImage = document.getElementById('image-preview-' + container_number).style.backgroundImage.slice(5, -2);
    console.log("PK:",container_number)
    console.log("Title:", postTitle);
    console.log("Subtitle:", postSubTitle);
    console.log("Content:", postContent);
    console.log("Background Image URL:", backgroundImage);
}
// ~ update

// add ~ 
function addPost() {
    const jwtToken = localStorage.getItem('jwtToken'); 
    
    const imagePreview = document.getElementById('image-preview-new');
    const backgroundImage = imagePreview.style.backgroundImage.slice(5, -2); 
    
    if (!backgroundImage || !backgroundImage.startsWith('data:image')) {
        alert("이미지를 등록해야 합니다.")
        return;
    }
    
    const file = imageInput.files[0]
    const postTitle = $("#postTitle-new").val();
    const postSubTitle = $("#postSubTitle-new").val();
    const postContent = $("#postContent-new").val();

    const postData = {
        imageData: backgroundImage,
        imageName: file.name,
        contentType: file.type,

        mainTitle: postTitle,
        content: postContent,
        subTitle: postSubTitle
    };

    $.ajax({
        url: '/auth/blog',
        type: 'POST',
        data: JSON.stringify(postData),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        headers: {
            'Authorization': jwtToken 
        },

        success: function(response, textStatus, jqXHR) {
            const el = `
                <div class="container" id="container-${response.data.id}" style="padding-left: 150px; padding-right: 150px; margin-top: 20px;">
                <div class="mb-4" id="heading-${response.data.id}">
                    <h3>${response.data.postTitle}</h3>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-5">
                        <div class="blog-image-preview-change mb-3" style="height: 261px; background-image: url('${response.data.imgURL}'); background-size: 100% 100%;">
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="mb-4" id="subheading-${response.data.id}">
                            <h4>${response.data.postSubTitle}</h4>
                        </div>
                        <div class="mb-3" id="content-${response.data.id}">
                            <p>
                            ${response.data.postContent}
                            </p>
                        </div>
                    </div>
                </div>
                <div style="height: 80px;">
                    <div class="edit-controls" style="display: block; ">
                        <div class="d-flex justify-content-end">
                            <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, ${response.data.id})">수정하기</button>
                            <button type="button" class="btn btn-outline-danger" onclick="deletePost(${response.data.id})">삭제하기</button>
                        </div>
                    </div>
                </div>
            </div>
            `

            $(el).insertBefore('#main-container > :last-child');

        },
        error: function(error) {
            alert(error.responseJSON.data);
        }
    });
}
// ~ add 

// delete ~ 
function deletePost(container_number) {
    console.log(container_number);
}
// ~ delete 