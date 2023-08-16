<%@ page import="com.us.entity.DTO.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-08-12
  Time: 오후 5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% StudentDTO student = (StudentDTO) request.getAttribute("student");  %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>학생정보</title>
    <link rel="stylesheet" href="./css/main.css" />
    <link rel="stylesheet" href="./css/reset.css" />
    <link
            rel="stylesheet"
            as="style"
            crossorigin
            href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/static/pretendard.css"
    />
    <script src="./js/main.js" defer></script>
</head>
<body>
<form action="main.do" method="post" name="infoPage">
    <main class="container">
        <header class="header">
            <div class="header-top">
                <h1 class="title">메가대학교</h1>
                <button class="logout-btn" type="button" onclick="fn_doLogout()">로그아웃</button>
            </div>
            <div class="header-bottom">
                <h2 class="greeting">
                    <strong class="user-name" name="name"><%= student.getName()%></strong>님 환영합니다.
                </h2>
            </div>
        </header>
        <section class="content-top">
            <div class="profile">
                <div class="profile-img-wrapper">
                    <img src="./image.png" alt="user-img" class="profile-img" />
                </div>
                <div class="profile-info">
                    <div class="profile-basic-info">
                        <div class="name-wrapper">
                            <h3 class="name"name="name">${student.getName()}</h3>
                            <p class="role"name="role">${student.getRole()}</p>
                        </div>
                        <p class="department">게임공학과</p>
                        <p class="grade">3.88 / 4.5</p>
                    </div>
                    <div class="profile-detail-info">
                        <div class="detail-info-top">
                            <ul class="info-list">
                                <li class="info-item">
                                    <h3 class="info-item-title">학번</h3>
                                    <p class="info-item-desc" name="studentId"><%=student.getStudentId()%></p>
                                </li>
                                <li class="info-item">
                                    <h3 class="info-item-title">생년월일</h3>
                                    <p class="info-item-desc" name="birth"><%=student.getBirth()%></p>
                                </li>
                                <li class="info-item">
                                    <h3 class="info-item-title">나이</h3>
                                    <p class="info-item-desc">만 22세</p>
                                </li>
                            </ul>
                        </div>
                        <div class="detail-info-bottom">
                            <ul class="info-list">
                                <li class="info-item">
                                    <h3 class="info-item-title">지도교수</h3>
                                    <p class="info-item-desc" name="advisor">${student.getAdvisor()}교수</p>
                                </li>
                                <li class="info-item">
                                    <h3 class="info-item-title">재적 상태</h3>
                                    <p class="info-item-desc" name="status">${student.getStatus()}</p>
                                </li>
                                <li class="info-item">
                                    <h3 class="info-item-title">주소</h3>
                                    <p class="info-item-desc" name="address">
                                        ${student.address}
                                    </p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="content-bottom">
            <section class="subject">
                <header class="subject-header">
                    <h2 class="subject-title">수강 과목</h2>
                    <button type="button" class="subject-add-btn">
                        <img src="./add-icon.svg" alt="subject-add subject-add-btn" />
                    </button>
                </header>
                <div class="subject-content">
                    <table class="subject-table">
                        <thead>
                        <tr class="subject-table-row">
                            <th
                                    class="subject-table-column subject-table-column-subject-name"
                            >
                                교과목명
                            </th>
                            <th class="subject-table-column">담당 교수</th>
                            <th class="subject-table-column">학점</th>
                            <th class="subject-table-column">전공/교양</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody class="subject-tbody"></tbody>
                    </table>
                </div>
            </section>
            <section class="student-study-info">
                <div class="grade">
                    <header class="grade-header">
                        <h2 class="grade-title">이수 학점</h2>
                    </header>
                    <div class="grade-content">
                        <table class="grade-table">
                            <thead>
                            <tr class="grade-table-row">
                                <th class="grade-table-column">총 이수학점</th>
                                <th class="grade-table-column">전공</th>
                                <th class="grade-table-column">교양</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="grade-table-row">
                                <td class="grade-table-column">60 / 120</td>
                                <td class="grade-table-column">24 / 80</td>
                                <td class="grade-table-column">36 / 40</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="time">
                    <header class="time-table-header">
                        <h2 class="time-table-title">시간표</h2>
                    </header>
                    <div class="time-table-content">
                        <table class="time-table">
                            <thead>
                            <tr class="time-table-row">
                                <th></th>
                                <th class="time-table-column">월</th>
                                <th class="time-table-column">화</th>
                                <th class="time-table-column">수</th>
                                <th class="time-table-column">목</th>
                                <th class="time-table-column">금</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="time-table-row">
                                <td class="time-table-column">1</td>
                                <td class="time-table-column">영양갱 경제학</td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column">영양갱 경제학</td>
                                <td class="time-table-column">부팀장이란 무엇인가</td>
                                <td class="time-table-column"></td>
                            </tr>
                            <tr class="time-table-row">
                                <td class="time-table-column">2</td>
                                <td class="time-table-column">피카츄 백만볼트</td>
                                <td class="time-table-column">피카츄 백만볼트</td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column">피카츄 백만볼트</td>
                                <td class="time-table-column"></td>
                            </tr>
                            <tr class="time-table-row">
                                <td class="time-table-column">3</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr class="time-table-row">
                                <td class="time-table-column">4</td>
                                <td class="time-table-column">침팬치의 하루</td>
                                <td class="time-table-column">침팬치의 하루</td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column"></td>
                            </tr>
                            <tr class="time-table-row">
                                <td class="time-table-column">5</td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column">부팀장이란 무엇인가</td>
                                <td class="time-table-column"></td>
                                <td class="time-table-column"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </section>
    </main>
    <div class="modal-wrapper">
        <div class="backdrop">
            <div class="modal">
                <header class="modal-header">
                    <p class="univ">메가대학교</p>
                    <h3 class="title">수강 과목 생성</h3>
                    <p class="desc">수강 과목 정보를 입력해주세요.</p>
                </header>
                <div class="modal-input-wrapper">
                    <input
                            type="text"
                            placeholder="교과목명"
                            class="modal-input subject-name-input"
                    />
                    <input
                            type="text"
                            placeholder="담당교수"
                            class="modal-input subject-professor-input"
                    />
                    <input
                            type="text"
                            placeholder="학점"
                            class="modal-input subject-grade-input"
                    />
                    <input
                            type="text"
                            placeholder="전공 / 교양"
                            class="modal-input subject-type-input"
                    />
                </div>
                <footer class="modal-footer">
                    <button type="button" class="subject-create-btn subject-btn">
                        생성
                    </button>
                    <button type="button" class="subject-cancel-btn subject-btn">
                        취소
                    </button>
                </footer>
            </div>
        </div>
    </div>
    <div class="modal-update-wrapper">
        <div class="backdrop">
            <div class="modalupdate">
                <header class="modalupdate-header">
                    <p class="univ">메가대학교</p>
                    <h3 class="title">수강 과목 수정</h3>
                    <p class="desc">수강 과목 정보를 입력해주세요.</p>
                </header>
                <div class="modalupdate-input-wrapper">
                    <input
                            type="text"
                            placeholder="교과목명"
                            class="modalupdate-input subject-update-name-input"
                    />
                    <input
                            type="text"
                            placeholder="담당교수"
                            class="modalupdate-input subject-update-professor-input"
                    />
                    <input
                            type="text"
                            placeholder="학점"
                            class="modalupdate-input subject-update-grade-input"
                    />
                    <input
                            type="text"
                            placeholder="전공 / 교양"
                            class="modalupdate-input subject-update-type-input"
                    />
                </div>
                <footer class="modalupdate-footer">
                    <button type="button" class="subject-update-btn subject-btn">
                        수정
                    </button>
                    <button type="button" class="subject-cancel-btn subject-btn">
                        취소
                    </button>
                </footer>
            </div>
        </div>
    </div>
</form>
</body>
</html>