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

function updateForm(event, container_number) {
    event.preventDefault();
    let section = document.getElementById('content-' + container_number);
        if (container_number % 2 === 0) {
            section.innerHTML = `
                <div class="row">
                    <div class="col-1">
                    </div>
                    <div class="col-5 pt-3">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="postTitle-${container_number}" placeholder="제목을 입력하세요" value="새로운 것을 배우고, 기록하는 것을 좋아하는 개발자">
                        </div>
                        <hr>
                        <div class="mb-3">
                            <textarea class="form-control" id="postContent-${container_number}" rows="5" placeholder="내용을 입력하세요">학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.</textarea>
                        </div>
                    </div>
                    <div class="ms-5 col-5">
                        <div class="mb-2">
                            <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image" id="imageToChange-${container_number}">
                        </div>
                        <input type="file" id="fileInput-${container_number}" onchange="checkImage(${container_number})">
                    </div>
                </div>
                <div class="edit-controls" style="display: none;">
                    <div class="my-3 me-1 d-flex justify-content-end">
                        <a href="#" class="btn btn-outline-secondary me-2">수정하기</a>
                        <a href="#" class="btn btn-outline-danger me-5">삭제하기</a>
                    </div>
                </div>
                <div class="my-3 d-flex justify-content-end">  
                    <button class="btn btn-outline-secondary" onclick="updateImage(${container_number})">수정완료</button>
                </div>
            `;

        } else {
            
            section.innerHTML = `
                <div class="row">
                    <div class="col-5 me-5">
                        <div class="mb-2">
                        <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image" id="imageToChange-${container_number}">
                        </div>
                        <input type="file" id="fileInput-${container_number}" onchange="checkImage(${container_number})">
                    </div>
                    <div class="col-5 pt-3">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="postTitle-${container_number}" placeholder="제목을 입력하세요" value="새로운 것을 배우고, 기록하는 것을 좋아하는 개발자">
                        </div>
                        <hr>
                        <div class="mb-3">
                            <textarea class="form-control" id="postContent-${container_number}" rows="5" placeholder="내용을 입력하세요">학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.</textarea>
                        </div>
                    </div>
                    <div class="col-2">
                    </div>
                </div>
                <div class="my-3 me-5 d-flex justify-content-end">  
                    <button class="btn btn-outline-secondary" onclick="updateImage(${container_number})">수정완료</button>
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


    readFileAsDataURL(input, function(dataURL) {
        let payload = {
            postTitle: postTitle,
            postContent: postContent,
            imageName: file.name,
            contentType: file.type,
            imageData: JSON.stringify(dataURL)
        };

        $.ajax({
            url: '/auth/main',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': jwtToken 
            },
            data: JSON.stringify(payload),  

            success: function(data, textStatus, jqXHR) {
                console.log(data);
            },
            error: function(error) {
                console.error(error);
            }
        });
    });


    // ajax 통신 이 후 추가 (PK값에 따라 사진 배치 다르게)
    inner = `
    
    `
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

function checkImage(container_number) {
    const fileInput = document.getElementById('fileInput-'+container_number);
    const imageToChange = document.getElementById('imageToChange-'+container_number);
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

function updateImage(container_number){
    postPK = `${container_number}`
    postTitle = $(`#postTitle-${container_number}`).val()
    postContent = $(`#postContent-${container_number}`).val()

    let input = document.getElementById(`fileInput-${container_number}`);

    readFileAsDataURL(input, function(dataURL) {
        let imgData = {
            "image": dataURL
        };
        let jsonPayload = JSON.stringify(imgData);
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