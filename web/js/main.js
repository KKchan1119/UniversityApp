// 로그아웃 버튼 클릭 시 이벤트 발생
const logout = document.getElementById("logout");
const logout_box = document.getElementById("logout_box");

logout.addEventListener("click", function(e) {
    e.preventDefault();     // 기본 동작을 실행하지 않도록 지정
    logout_box.style.display = "block";     // logout_box의 스타일을 none에서 block으로 변경

})

// 수강 과목 + 버튼 클릭 시 이벤트 발생
const plus = document.getElementById("plus");
const create_subject_box = document.getElementById("create_subject_box");

plus.addEventListener("click", function(e) {
    e.preventDefault();
    create_subject_box.style.display = "block";     // logout_box의 스타일을 none에서 block으로 변경
})

// 수강 과목 생성에서 생성 버튼 클릭 시 이벤트 발생
const create = document.getElementById("create");                           // 생성 버튼
const subject_container = document.getElementById('subject_container');     // 생성 버튼 클릭 시 ul이 추가될 div
const Ul = subject_container.querySelector('.data');                        // data 클래스 가져오기

create.addEventListener("click", function(e) {
    e.preventDefault();
    const newUl = document.createElement('ul');         // 새로운 ul 태그 생성
    newUl.className = 'data';                           // 새로 생긴 ul 태그는 data 클래스
    const newLi = Ul.cloneNode(true);                   // Ul(data) 노드 복사, true라서 하위 노드까지 모두 복사
    create_subject_box.style.display = "none";
    subject_container.appendChild(newUl);               // subject_container div에 새로운 ul 태그 추가
    newUl.appendChild(newLi);                           // 새로 추가된 ul에 복제된 노드 추가
})


// 설정 버튼 클릭 시 이벤트 발생


// 수정 버튼 클릭 시 이벤트 발생
const update_button = document.getElementById("update_button");
const update_subject_box = document.getElementById("update_subject_box");

update_button.addEventListener("click", function(e) {
    e.preventDefault();
    update_subject_box.style.display = "block";       // update_subject_box의 스타일을 none에서 block으로 변경
})

// 제거 버튼 클릭 시 이벤트 발생
const delete_button = document.getElementById("delete_button");
const delete_box = document.getElementById("delete_box");

delete_button.addEventListener("click", function(e) {
    e.preventDefault();
    delete_box.style.display = "block";
})


// 로그아웃 취소, 수강 과목 생성 취소 버튼 클릭 시 이벤트 발생
let cancel = document.querySelectorAll(".cancel");

cancel.forEach((Element) => {
    Element.addEventListener("click", function(e) {
        e.preventDefault();
        logout_box.style.display = "none";
        create_subject_box.style.display = "none";
        update_subject_box.style.display = "none";
        delete_box.style.display = "none";
    })
})


// 수강 과목
const subject = {
    "data" : [
        {
            "subjectName" : "영양갱 경제학",
            "professor" : "왕찬현",
            "credit" : "3",
            "subjectType" : "교양"
        },
        {
            "subjectName" : "피카츄 백만볼트",
            "professor" : "박소희",
            "credit" : "3",
            "subjectType" : "전공"
        },
        {
            "subjectName" : "침팬치의 하루",
            "professor" : "전진우",
            "credit" : "3",
            "subjectType" : "전공"
        },
        {
            "subjectName" : "부팀장이란 무엇인가",
            "professor" : "옥승철",
            "credit" : "3",
            "subjectType" : "교양"
        },
        {
            "subjectName" : "알파메일의 삶",
            "professor" : "김유범",
            "credit" : "3",
            "subjectType" : "싸패"
        },
    ]
}