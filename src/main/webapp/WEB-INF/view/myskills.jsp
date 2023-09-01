<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>     

    <div id="allSkills" data-skills='${allSkills}'>

    </div>

    <div class="py-5" style="background-color: #F9F9F9; position: relative;" id="main-container">    
        <button type="button" class="btn btn-outline-primary skills-btn-fixed edit-controls" style="display: none;" onclick="getUpdateForm(event)">수정하기</button>
        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Back-End</h3>
            <hr>
        </div>

        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Front-End</h3>
            <hr>
        </div>

        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Dev-Ops</h3>
            <hr>
        </div>

        <div class="container container-custom-width" style="margin-bottom: 50px;">
            <h3>ETC</h3>
            <hr>
        </div>

    </div>
       <!-- 수정 Form Modal -->
    <div class="modal fade" id="skillsAddForm" tabindex="-1" role="dialog" aria-labelledby="skillsModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="skillsModalLabel">Skill 정보 수정</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="updateSkillsForm">

                        <div class="mb-5">
                            <h3 class="me-2"style="display:inline">Back-End</h3>
                            <select id="BackEndSelect" onchange="addSkills('BackEnd')" style="width: 20%;">
                                <option selected></option>
                                <option value="Java">Java</option>
                                <option value="Python">Python</option>
                                <option value="Spring">Spring</option>
                                <option value="Spring Security">Spring Security</option>
                                <option value="MySQL">MySQL</option>
                                <option value="JPA">JPA</option>
                                <option value="JUnit5">JUnit5</option>
                                <option value="Postman">Postman</option>
                            </select>
                            <hr>
                            <div id="BackEndSkills" class="mt-2" style="height: 60px;"></div>
                        </div>

                        <div class="mb-5">
                            <h3 class="me-2"style="display:inline">Front-End</h3>
                            <select id="FrontEndSelect" onchange="addSkills('FrontEnd')" style="width: 20%;">
                                <option selected></option>
                                <option value="HTML5">HTML5</option>
                                <option value="CSS3">CSS3</option>
                                <option value="JavaScript">JavaScript</option>
                                <option value="jQuery">jQuery</option>
                            </select>
                            <hr>
                            <div id="FrontEndSkills" class="mt-2"  style="height: 60px;"></div>
                        </div>

                        <div class="mb-5">
                            <h3 class="me-2"style="display:inline">Dev-Ops</h3>
                            <select id="DevOpsSelect" onchange="addSkills('DevOps')" style="width: 20%;">
                                <option selected></option>
                                <option value="Docker">Docker</option>
                                <option value="Kubernetes">Kubernetes</option>
                            </select>
                            <hr>
                            <div id="DevOpsSkills" class="mt-2"  style="height: 60px;"></div>
                        </div>

                        <div class="mb-5">
                            <h3 class="me-2"style="display:inline">ETC</h3>
                            <select id="ETCSelect" onchange="addSkills('ETC')" style="width: 20%;">
                                <option selected></option>
                                <option value="GitHub">GitHub</option>
                                <option value="Notion">Notion</option>
                                <option value="Jira">Jira</option>
                                <option value="VisualStudioCode">VisualStudioCode</option>
                                <option value="Eclipse">Eclipse</option>
                                <option value="AWS">AWS</option>
                                <option value="Firebase">Firebase</option>
                                <option value="AmazonEC2">AmazonEC2</option>
                                <option value="AmazonS3">AmazonS3</option>
                            </select>
                            <hr>
                            <div id="ETCSkills" class="mt-2"  style="height: 60px;"></div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" onclick="updateSkills()">수정하기</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 수정 Form Modal -->


<script src="/js/myskills.js"></script>
    
<%@ include file="layout/footer.jsp" %>