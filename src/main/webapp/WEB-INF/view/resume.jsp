<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
    <%@ include file="layout/header.jsp" %>    

    <div class="py-5" style="background-color: #F9F9F9" id="main-container">

        <div class="ps-5 pe-1 container">
            <table class="sortableTable" style="width: 80%; margin-left: auto; margin-right: auto;">
                <tbody id="edu-table">

                    <tr class="no-border">
                        <th style="width: 25%"><h4>교육사항</h4></th>
                    </tr>

                    <tr class="table-secondary">
                        <td style="width: 25%">재학기간</td>
                        <td style="width: 13%">졸업여부</td>
                        <td style="width: 27%">학교명</td>
                        <td style="width: 17%">전공</td>
                        <td style="width: 13%">학점</td>
                        <td class="no-border non-secondary" style="width: 4.2%"></td>
                    </tr>
                    <tr id="edu-1">
                        <td class="drag-handle">2015.03.21 ~ 2021.03.01</td>
                        <td>학사졸업</td>
                        <td>자바대학교</td>
                        <td>기계공학과</td>
                        <td>3.74</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="edu-2"> 
                        <td class="drag-handle ">2012.03.21 ~ 2015.03.01</td>
                        <td>졸업</td>
                        <td>AWS 고등학교</td>
                        <td>이과</td>
                        <td>-</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr class="add-row toggleMode" style="display: none;">
                        <td class="no-border add-cell" colspan="5" style="text-align: right;"></td>
                        <td class="no-border"><span class="add-btn">➕</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>

        <div class="ps-5 pe-1 container">
            <table class="sortableTable" style="width: 80%; margin-left: auto; margin-right: auto;">
                <tbody id="etcedu-table">

                    <tr class="table-secondary">
                        <td style="width: 25%">수강기간</td>
                        <td style="width: 13%">수료여부</td>
                        <td style="width: 27%">교육 장소</td>
                        <td style="width: 17%">과정명</td>
                        <td style="width: 13%">기타</td>
                        <td class="no-border non-secondary" style="width: 4.2%"></td>
                    </tr>
                    <tr id="etcedu-2"> 
                        <td class="drag-handle ">2022.11.13 ~ 2023.05.03</td>
                        <td>수료</td>
                        <td>도커 아카데미</td>
                        <td>풀스택 과정</td>
                        <td>-</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr class="add-row toggleMode" style="display: none;">
                        <td class="no-border add-cell" colspan="5" style="text-align: right;"></td>
                        <td class="no-border"><span class="add-btn">➕</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br><br><br>

        <div class="ps-5 pe-1 container">
            <table class="sortableTable" style="width: 80%; margin-left: auto; margin-right: auto;">
                <tbody id="edu-table">

                    <tr class="no-border">
                        <th style="width: 25%"><h4>자격증 / 어학</h4></th>
                    </tr>

                    <tr class="table-secondary">
                        <td style="width: 25%">취득일</td>
                        <td style="width: 13%">종류</td>
                        <td style="width: 27%">자격증명</td>
                        <td style="width: 17%">발급기관</td>
                        <td style="width: 13%">합격여부</td>
                        <td class="no-border non-secondary" style="width: 4.2%"></td>
                    </tr>
                    <tr id="edu-1">
                        <td class="drag-handle">2022.07.10</td>
                        <td>어학</td>
                        <td>TOEIC (830)</td>
                        <td>한국TOEIC위원회</td>
                        <td>최종합격</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="edu-2">
                        <td class="drag-handle">2022.06.19</td>
                        <td>어학</td>
                        <td>TOEIC Speaking (140)</td>
                        <td>한국TOEIC위원회</td>
                        <td>최종합격</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="edu-3">
                        <td class="drag-handle">2023.04.01</td>
                        <td>IT자격증</td>
                        <td>SQLD</td>
                        <td>데이터베이스진흥원</td>
                        <td>최종합격</td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>

                    <tr class="add-row toggleMode" style="display: none;">
                        <td class="no-border add-cell" colspan="5" style="text-align: right;"></td>
                        <td class="no-border"><span class="add-btn">➕</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br><br><br>


        <div class="ps-5 pe-1 container">
            <table class="sortableTable" style="width: 80%; margin-left: auto; margin-right: auto;">
                <tbody id="onlinelecture-table">

                    <tr class="no-border">
                        <th style="width: 25%"><h4>추가 학습</h4></th>
                    </tr>

                    <tr class="table-secondary">
                        <td style="width: 25%">수강일</td>
                        <td style="width: 13%">종류</td>
                        <td style="width: 27%">강의명</td>
                        <td style="width: 17%">수강장소</td>
                        <td style="width: 13%">블로깅</td>
                        <td class="no-border non-secondary" style="width: 4.2%"></td>
                    </tr>
                    <tr id="onlineLecture-1">
                        <td class="drag-handle">2023.05.22</td>
                        <td>CS</td>
                        <td>CS 지식의 정석</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-2">
                        <td class="drag-handle">2023.07.03</td>
                        <td>DB</td>
                        <td>처음하는 MongoDB</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-3">
                        <td class="drag-handle">2023.07.29</td>
                        <td>Tool</td>
                        <td>지옥에서온 Git</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-4">
                        <td class="drag-handle">2023.07.30</td>
                        <td>Tool</td>
                        <td>지옥에서온 관리자 Git</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-5">
                        <td class="drag-handle">2023.07.31</td>
                        <td>OS</td>
                        <td>Linux</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-6">
                        <td class="drag-handle">2023.08.02</td>
                        <td>DevOps</td>
                        <td>도커 입문 강의</td>
                        <td>유튜브</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-7">
                        <td class="drag-handle">2023.08.02</td>
                        <td>DevOps</td>
                        <td>도커와 최신 서버 기술</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>
                    <tr id="onlineLecture-8">
                        <td class="drag-handle">2023.08.07</td>
                        <td>DevOps</td>
                        <td>대세는 쿠버네티스</td>
                        <td>인프런</td>
                        <td><a href="#" style="text-decoration: none">링크</a></td>
                        <td class="no-border"><span class="delete-btn">&#10006;</span></td>
                    </tr>

                    <tr class="add-row toggleMode" style="display: none;">
                        <td class="no-border add-cell" colspan="5" style="text-align: right;"></td>
                        <td class="no-border"><span class="add-btn">➕</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br><br><br>
    </div>

<script src="/js/resume.js"></script>
    
<%@ include file="layout/footer.jsp" %>