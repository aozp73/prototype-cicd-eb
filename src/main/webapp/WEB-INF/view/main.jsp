<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>


    <div class="py-5" style="background-color: #F9F9F9" id="main-container">


        <div class="container ps-5" style="height:450px" id="content-1">
            <div class="row">
                <div class="col-5 me-5">
                    <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image">
                </div>
                <div class="col-5 pt-3">
                    <h2>새로운 것을 배우고, 기록하는 것을 좋아하는 개발자</h2><hr>
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                </div>
                <div class="col-2">
                </div>
            </div>
            <div class="edit-controls" style="display: none;">
                <div class="my-3 me-5 d-flex justify-content-end">  
                    <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 1)">수정하기</button>
                    <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost()">삭제하기</button>
                </div>
            </div>
        </div>

        <div class="container pe-5" style="height:450px" id="content-2">
            <div class="row">
                <div class="col-1">
                </div>
                <div class="col-5 pt-3">
                    <h2>새로운 것을 배우고, 기록하는 것을 좋아하는 개발자</h2><hr>
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                </div>
                <div class="ms-5 col-5">
                    <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image">
                </div>
            </div>
            <div class="edit-controls" style="display: none;">
                <div class="my-3 me-1 d-flex justify-content-end">
                    <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 2)">수정하기</button>
                    <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost()">삭제하기</button>
                </div>
            </div>
        </div>


        <div class="container ps-5" style="height:450px" id="content-3">
            <div class="row">
                <div class="col-5 me-5">
                    <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image">
                </div>
                <div class="col-5 pt-3">
                    <h2>새로운 것을 배우고, 기록하는 것을 좋아하는 개발자</h2><hr>
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                </div>
                <div class="col-2">
                </div>
            </div>
            <div class="edit-controls" style="display: none;">
                <div class="my-3 me-5 d-flex justify-content-end">  
                    <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 3)">수정하기</button>
                    <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost()">삭제하기</button>
                </div>
            </div>
        </div>


        <div class="container pe-5" style="height:450px" id="content-4">
            <div class="row">
                <div class="col-1">
                </div>
                <div class="col-5 pt-3">
                    <h2>새로운 것을 배우고, 기록하는 것을 좋아하는 개발자</h2><hr>
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                    학습한 내용을 기록하며, 프로젝트 진행간 기술 블로그 작성을 즐겨합니다.
                </div>
                <div class="ms-5 col-5">
                    <img src="image/mainpage-sample.png" alt="Description of Image" class="img-fluid responsive-image">
                </div>
            </div>
            <div class="edit-controls" style="display: none;">
                <div class="my-3 me-1 d-flex justify-content-end">
                    <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 4)">수정하기</button>
                    <button type="button" class="btn btn-outline-danger me-5" onclick="deletePost()">삭제하기</button>
                </div>
            </div>
        </div>

        <!-- 새 글 쓰기 -->
        <div class="edit-controls" style="display: none;">
            <div class="container mt-5">

                <form id="postForm">
                    <div class="mb-3">
                        <label for="postTitle" class="form-label">제목</label>
                        <input type="text" class="form-control" id="postTitle-new" placeholder="제목을 입력하세요">
                    </div>
                    <div class="mb-3">
                        <label for="postContent" class="form-label">내용</label>
                        <textarea class="form-control" id="postContent-new" rows="5" placeholder="내용을 입력하세요"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="postImage" class="form-label">사진 업로드</label>
                        <input type="file" id="fileInput-new">
                        <div id="imagePreview" class="mt-3"></div> 
                    </div>
                    <div class="my-3 d-flex justify-content-end">
                        <button type="button" class="btn btn-primary" onclick="addPost()">글 등록하기</button>
                    </div>
                </form>
            </div>
        </div>
         <!-- 새 글 쓰기 -->



<script src="/js/main.js"></script>
    
<%@ include file="layout/footer.jsp" %>