<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>     

        <div class="py-5" style="background-color: #F9F9F9" id="main-container">
        
            <div class="container" id="container-1" style="padding-left: 150px; padding-right: 150px; margin-top: 20px;">
                <div class="mb-4" id="heading-1">
                    <h3>제목1</h3>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-5">
                        <div class="blog-image-preview-change mb-3" style="height: 261px; background-image: url('/image/blogpage-sample.jpg'); background-size: 100% 100%;">
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="mb-4" id="subheading-1">
                            <h4>소제목</h4>
                        </div>
                        <div class="mb-3" id="content-1">
                            <p>
                               내용<br>
                               내용<br>
                               내용<br>
                               내용<br>
                               내용<br>
                            </p>
                        </div>
                    </div>
                </div>
                <div style="height: 80px;">
                    <div class="edit-controls" style="display: none; ">
                        <div class="d-flex justify-content-end">
                            <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 1)">수정하기</button>
                            <button type="button" class="btn btn-outline-danger" onclick="deletePost(1)">삭제하기</button>
                        </div>
                    </div>
                </div>
            </div>
 

            <div class="container" id="container-2" style="padding-left: 150px; padding-right: 150px; margin-top: 20px;">
                <div class="mb-4" id="heading-2">
                    <h3>제목2</h3>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-5">
                        <div class="blog-image-preview-change mb-3" style="height: 261px; background-image: url('/image/blogpage-sample.jpg'); background-size: 100% 100%;">
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="mb-4" id="subheading-2">
                            <h4>소제목</h4>
                        </div>
                        <div class="mb-3" id="content-2">
                            <p>
                               내용<br>
                               내용<br>
                               내용<br>
                               내용<br>
                               내용<br>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="edit-controls" style="display: none;">
                    <div class="mt-3 d-flex justify-content-end">
                        <button type="button" class="btn btn-outline-secondary me-2" onclick="updateForm(event, 2)">수정하기</button>
                        <button type="button" class="btn btn-outline-danger" onclick="deletePost(2)">삭제하기</button>
                    </div>
                </div>
            </div>
            <br><br>



            <br><br>
            <div class="edit-controls container" style="padding-left: 150px; padding-right: 150px; display: none;">

                <div class="mb-4">
                    <div class="ms-2 mb-4">
                        <h2>새 글쓰기</h2>
                    </div>
                    <div>
                        <input type="text" class="form-control" id="postTitle-new" placeholder="제목을 입력하세요">
                    </div>
                </div>
                <div class="row">

                    <div class="col-5">
                        <div class="blog-image-preview mb-3" id="image-preview-new" style="height: 261px;" onclick="document.getElementById('imageInput').click();">
                            <input type="file" id="imageInput" style="display: none;" onchange="previewImage(event, 'new')">
                            <div class="plus-icon">+</div>
                        </div>
                    </div>

                    <div class="col-7">
                        <form id="postForm">
                            <div class="mb-3">
                                <input type="text" class="form-control" id="postSubTitle-new" placeholder="소제목을 입력하세요">
                            </div>
                            <div class="mb-3">
                                <textarea class="form-control" id="postContent-new" rows="8" placeholder="내용을 입력하세요"></textarea>
                            </div>
                        </form>
                        <div class="my-3 d-flex justify-content-end">
                            <button type="button" class="btn btn-primary" onclick="addPost()">글 등록하기</button>
                        </div>
                    </div>

                </div>


            </div>
        </div>
        

<script src="/js/blog.js"></script>
    
<%@ include file="layout/footer.jsp" %>