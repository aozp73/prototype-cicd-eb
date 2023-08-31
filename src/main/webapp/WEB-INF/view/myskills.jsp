<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>     

    <input type="hidden" id="backEndSkills" value="${backEndSkills}"/>
    <input type="hidden" id="frontEndSkills" value="${frontEndSkills}"/>
    <input type="hidden" id="devOpsSkills" value="${devOpsSkills}"/>
    <input type="hidden" id="etcSkills" value="${etcSkills}"/>

    <div class="py-5" style="background-color: #F9F9F9; position: relative;" id="main-container">    
        <button type="button" class="btn btn-outline-primary skills-btn-fixed edit-controls" style="display: none;" onclick="getUpdateForm(event)">수정하기</button>
        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Back-End</h3>
            <hr>
            <img src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=Python&logoColor=white"/>
            <img src="https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white">
            <img src="https://img.shields.io/badge/Spring-%236DB33F.svg?style=flat-square&logo=spring&logoColor=white">
            <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white">
            <br>
            <img src="https://img.shields.io/badge/MySQL-%2300f.svg?style=flat-square&logo=MySQL&logoColor=white">
            <img src="https://img.shields.io/badge/MyBatis-C70D2C.svg?style=flat-square">
            <img src="https://img.shields.io/badge/JPA-A5915F.svg?style=flat-square">
            <img src="https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white">
            <img src="https://img.shields.io/badge/Postman-FF6C37?style=flat-square&logo=postman&logoColor=white">
        </div>

        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Front-End</h3>
            <hr>
            <img src="https://img.shields.io/badge/HTML5-%23E34F26.svg?style=flat-square&logo=html5&logoColor=white">
            <img src="https://img.shields.io/badge/CSS3-%231572B6.svg?style=flat-square&logo=css3&logoColor=white">
            <img src="https://img.shields.io/badge/JavaScript-%23323330.svg?style=flat-square&logo=javascript&logoColor=%23F7DF1E">
            <img src="https://img.shields.io/badge/jQuery-%230769AD.svg?style=flat-square&logo=jquery&logoColor=white">
        </div>

        <div class="container container-custom-width" style="margin-bottom: 53px;">
            <h3>Dev-Ops</h3>
            <hr>
            <img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white"/>
            <img src="https://img.shields.io/badge/Kubernetes-2496ED?style=flat-square&logo=Kubernetes&logoColor=white"/>
        </div>

        <div class="container container-custom-width" style="margin-bottom: 50px;">
            <h3>ETC</h3>
            <hr>
            <img src="https://img.shields.io/badge/GitHub-%23121011.svg?style=flat-square&logo=github&logoColor=white">
            <img src="https://img.shields.io/badge/Notion-000000?style=flat-square&logo=Notion&logoColor=white">
            <img src="https://img.shields.io/badge/Jira-0052CC?style=flat-square&logo=Jira&logoColor=white">
            <img src="https://img.shields.io/badge/VisualStudioCode-007ACC?style=flat-square&logo=VisualStudioCode&logoColor=white">
            <img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=Eclipse&logoColor=white">
            <br>
            <img src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=flat-square&logo=amazon-aws&logoColor=white">
            <img src="https://img.shields.io/badge/Firebase-FF6A00?style=flat-square&logo=firebase&logoColor=white">
            <img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=flat-square&logo=amazonec2&logoColor=white">
            <img src="https://img.shields.io/badge/AmazonS3-569A31?style=flat-square&logo=amazons3&logoColor=white">
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