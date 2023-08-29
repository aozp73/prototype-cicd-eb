<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>       

    <div class="py-5" style="background-color: #F9F9F9" id="main-container">
        <button type="button" class="btn btn-outline-primary project-btn-fixed edit-controls" style="display: none;" onclick="getAddForm(event)">등록하기</button>

        <div class="mb-4 container">
            <div class="row">    

                <div class="col-lg-3 col-md-6 mb-4" id="project-1">
                    <div class="card card-hover-effect" data-card-id="1" data-members="1" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">포트폴리오 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/포트폴리오.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;"></span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1" style="font-size: 15px">
                                        &nbspBackEnd&nbsp/&nbspFrontEnd&nbsp/&nbspDevOps
                                    </div>
                                </div>
                            </div>
                                       
                        </div>

                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-1')">삭제</button>
                        </div>
                        
                    </div>
                </div>


                <div class="col-lg-3 col-md-6 mb-4" id="project-2">
                    <div class="card card-hover-effect" data-card-id="2" data-members="5" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">공간대여 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/project2.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;"></span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbspBackEnd
                                    </div>
                                </div>
                            </div>
                                       
                        </div>
                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-2')">삭제</button>
                        </div>
                    </div>
                </div>

                
                <div class="col-lg-3 col-md-6 mb-4" id="project-3">
                    <div class="card card-hover-effect" data-card-id="3" data-members="3" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">RestFul 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/RestFul.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;">&nbsp</span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbspBackEnd
                                    </div>
                                </div>
                            </div>
                            <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                                <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                                <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-3')">삭제</button>
                            </div>
                                       
                        </div>
                    </div>
                </div>

                
                <div class="col-lg-3 col-md-6 mb-4" id="project-4">
                    <div class="card card-hover-effect" data-card-id="4" data-members="3" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">구인공고 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/구인공고.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;">&nbsp</span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbspBackEnd & FrontEnd
                                    </div>
                                </div>
                            </div> 

                        </div>
                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-4')">삭제</button>
                        </div>

                    </div>
                </div>

                
                <div class="col-lg-3 col-md-6 mb-4" id="project-5">
                    <div class="card card-hover-effect" data-card-id="5" data-members="1" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">포토그램 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/포토그램.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;"></span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbspBackEnd & FrontEnd
                                    </div>
                                </div>
                            </div>
                                       
                        </div>
                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-5')">삭제</button>
                        </div>
                    </div>
                </div>

                
                <div class="col-lg-3 col-md-6 mb-4" id="project-6">
                    <div class="card card-hover-effect" data-card-id="6" data-members="1" style="height: 380px; overflow: hidden;">
                        <div class="card-body px-4">
                            <div>
                                <div class="text-center mt-2">
                                    <span style="font-size: 1.6em;">블로그 프로젝트</span>
                                </div>
                            </div>
                            
                            <div class="mt-2 mb-3 p-2" style="max-height: 33%; height: 243px; overflow: hidden;">
                                <img src="/image/블로그.png" alt="프로젝트 이미지" style="width: 100%; height: 100%; object-fit: fill; ">
                            </div>

                            <div class="card-inner" style="height: 127px;">
                                <div class="ps-3">
                                    <div class="mt-3 mb-2">
                                        <span class="member-icons" style="font-size: 1.3em;"></span>
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbsp2022-00-00 ~ 2022-00-00 
                                    </div>
                                    <div class="mb-2 ps-1">
                                        &nbspBackEnd & FrontEnd
                                    </div>
                                </div>
                            </div>
                                       
                        </div>
                        <div class="edit-controls" style="position: absolute; right: 10px; bottom: 10px; display: none;">
                            <button class="btn btn-secondary btn-sm" onclick="getUpdateForm(event)">수정</button>
                            <button class="btn btn-danger btn-sm" onclick="deleteProject(event, 'project-6')">삭제</button>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>

    <!-- 상세보기 Modal -->
    <div class="modal fade" id="projectModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" style ="max-width: 38%;">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="projectModalLabel">Project Title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="mb-3 modal-body border-bottom-gray">
                <img id="projectModalImage" src="" alt="Project Image" style="width: 100%; height: auto;">
            </div>
            <div class="ms-4">
                <div>
                    <div class="mb-1">
                        <strong>1. 담당기능</strong>
                    </div>
                    <div class="ms-3">
                        <p id="projectModalResponsibilities">
                        </p>
                    </div>
                </div>
                <div class="mb-4">
                    <div class="mb-1">
                        <strong>2. README (아키텍처, 느낀점, 시연영상 등)</strong>
                    </div>
                    <div class="ms-3">
                        <p id="projectModalREADMELink"><a href="" target="_blank" style="text-decoration: none;">README 링크</a></p>
                    </div>
                </div>
                <div class="mb-4">
                    <div class="mb-1">
                        <strong>3. Github 소스코드</strong>
                    </div>
                    <div class="ms-3">
                        <p id="projectModalGithubLink"><a href="" target="_blank" style="text-decoration: none;">Github 링크</a></p>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
        </div>
    </div>
    <!-- 상세보기 Modal -->

    <!-- 등록 Form Modal -->
    <div class="modal fade" id="projectAddForm" tabindex="-1" role="dialog" aria-labelledby="projectModalLabel" aria-hidden="true">
        <div class="modal-dialog" style ="max-width: 38%;">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="projectModalLabel">프로젝트 정보 입력</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addForm">
                        <div class="form-group mb-3">
                            <label class="mb-1" for="projectName">프로젝트명</label>
                            <input type="text" class="form-control" id="addProjectName" name="projectName" placeholder="프로젝트명을 입력하세요">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="member">인원</label>
                            <input type="number" class="form-control" id="addMembers" name="members" placeholder="인원 수를 입력하세요">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="startDate">시작날짜</label>
                            <input type="date" class="form-control" id="addStartDate" name="startDate" pattern="\d{4}-\d{2}-\d{2}" placeholder="YYYY-MM-DD">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="endDate">종료날짜</label>
                            <input type="date" class="form-control" id="addEndDate" name="endDate" pattern="\d{4}-\d{2}-\d{2}" placeholder="YYYY-MM-DD">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="role">참여역할</label>
                            <div>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="BackEnd">BackEnd</button>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="FrontEnd">FrontEnd</button>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="DevOps">DevOps</button>
                            </div>
                            <input type="hidden" id="selectedRoles" name="selectedRoles">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="readmeUrl">README 주소</label>
                            <input type="url" class="form-control" id="addReadmeUrl" name="readmeUrl" placeholder="README 주소를 입력하세요">
                        </div>
                        <div class="form-group mb-4">
                            <label class="mb-1" for="githubUrl">GitHub 주소</label>
                            <input type="url" class="form-control" id="addGithubUrl" name="githubUrl" placeholder="GitHub 주소를 입력하세요">
                        </div>
                        <div class="form-group mb-5">
                            <label for="image">사진</label>
                            <input type="file" class="form-control-file mb-3" id="postProjectImage" name="postProjectImage" onchange="previewImage(this, 'addImagePreview')">
                            <img id="addImagePreview" src="#" alt="Image Preview" style="width: 100%; height: auto; display: none;">
                        </div>
                        <div class="form-group">
                            <label for="featureImage">담당 기능</label>
                            <input type="file" class="form-control-file mb-3" id="postIndividualPerformanceImage" name="postIndividualPerformanceImage" onchange="previewImage(this, 'addFeatureImagePreview')">
                            <img id="addFeatureImagePreview" src="#" alt="Feature Image Preview" style="width: 100%; height: auto; display: none;">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="postProject()">등록하기</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 등록 Form Modal -->

    <!-- 수정 Form Modal -->
    <div class="modal fade" id="projectUpdateForm" tabindex="-1" role="dialog" aria-labelledby="projectModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="projectModalLabel">프로젝트 정보 수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="updateForm">
                        <div class="form-group mb-3">
                            <label for="projectName">프로젝트명</label>
                            <input type="text" class="form-control" id="updateProjectName" name="projectName">
                        </div>
                        <div class="form-group mb-3">
                            <label for="members">인원</label>
                            <input type="number" class="form-control" id="updateMembers" name="members">
                        </div>
                        <div class="form-group mb-3">
                            <label for="startDate">시작날짜</label>
                            <input type="date" class="form-control" id="updateStartDate" name="startDate" pattern="\d{4}-\d{2}-\d{2}" >
                        </div>
                        <div class="form-group mb-3">
                            <label for="endDate">종료날짜</label>
                            <input type="date" class="form-control" id="updateEndDate" name="endDate" pattern="\d{4}-\d{2}-\d{2}" placeholder="YYYY-MM-DD">
                        </div>
                        <div class="form-group mb-3">
                            <label class="mb-1" for="role">참여역할</label>
                            <div>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="BackEnd">BackEnd</button>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="FrontEnd">FrontEnd</button>
                                <button type="button" class="btn btn-outline-primary btn-sm role-btn" data-role="DevOps">DevOps</button>
                            </div>
                            <input type="hidden" id="selectedRoles" name="selectedRoles">
                        </div>
                        <div class="form-group mb-3">
                            <label for="readmeUrl">README 주소</label>
                            <input type="url" class="form-control" id="updateReadmeUrl" name="readmeUrl">
                        </div>
                        <div class="form-group mb-4">
                            <label for="githubUrl">GitHub 주소</label>
                            <input type="url" class="form-control" id="updateGithubUrl" name="githubUrl">
                        </div>
                        <div class="form-group mb-3">
                            <label for="image">사진</label>
                            <input type="file" class="form-control-file mb-3" id="updateImage" name="image" onchange="previewImage(this, 'updateImagePreview')">
                            <img id="updateImagePreview" src="#" alt="Image Preview" style="width: 100%; height: auto; display: none;">
                        </div>
                        <div class="form-group">
                            <label for="featureImage">담당 기능</label>
                            <input type="file" class="form-control-file mb-3" id="updateFeatureImage" name="featureImage" onchange="previewImage(this, 'updateFeatureImagePreview')">
                            <img id="updateFeatureImagePreview" src="#" alt="Feature Image Preview" style="width: 100%; height: auto; display: none;">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="updateProject()">수정하기</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 수정 Form Modal -->


<script src="/js/myproject.js"></script>
    
<%@ include file="layout/footer.jsp" %>