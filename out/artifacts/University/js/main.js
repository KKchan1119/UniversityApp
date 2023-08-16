const subjectBody = document.querySelector('.subject-tbody');
const subjectAddBtn = document.querySelector('.subject-add-btn');
const subjectContent = document.querySelector('.subject .subject-content');
const subjectCreateBtn = document.querySelector(
    '.modal-wrapper .subject-create-btn'
);

const subjectCancelBtn = document.querySelector(
    '.modal-wrapper .subject-cancel-btn'
);
const subjectUpdateBtn = document.querySelector(
    '.modal-update-wrapper .subject-update-btn'
);
const subjectUpdateCancelBtn = document.querySelector(
    '.modal-update-wrapper .subject-cancel-btn'
);

document.addEventListener('DOMContentLoaded', () => readSubjects());

subjectAddBtn.addEventListener('click', () => {
    showCreateModal();
});
let updateId = 0;
subjectBody.addEventListener('click', async (e) => {
    const [type, id] = e.target.dataset.role.split('-');
    if (type === 'update') {
        showUpdateModal();
        readSubject(id);

        updateId = id;
    }
});
function fn_doLogout(){
    const logoutRq = document.infoPage;
    logoutRq.method="post";
    logoutRq.action="main.do";
    logoutRq.submit();
}

subjectUpdateCancelBtn.addEventListener('click', () => {
    const modalUpdateWrapper = document.querySelector('.modal-update-wrapper');
    modalUpdateWrapper.querySelector('.backdrop').style.display = 'none';
    document.body.style.overflow = 'auto';
});

subjectCreateBtn.addEventListener('click', () => {
    createSubject();
});

subjectCancelBtn.addEventListener('click', () => {
    const modalWrapper = document.querySelector('.modal-wrapper');
    modalWrapper.querySelector('.backdrop').style.display = 'none';
    document.body.style.overflow = 'auto';
});

function showCreateModal() {
    const modalWrapper = document.querySelector('.modal-wrapper');
    modalWrapper.querySelector('.backdrop').style.display = 'flex';
    document.body.style.overflow = 'hidden';
}

function showUpdateModal() {
    const modalWrapper = document.querySelector('.modal-update-wrapper');
    modalWrapper.querySelector('.modal-update-wrapper .backdrop').style.display =
        'flex';
    document.body.style.overflow = 'hidden';
}

async function createSubject() {
    const subjectNameInput = document.querySelector('.subject-name-input');
    const subjectProfessorInput = document.querySelector(
        '.subject-professor-input'
    );
    const subjectGradeInput = document.querySelector('.subject-grade-input');
    const subjectTypeInput = document.querySelector('.subject-type-input');

    await fetch('http://localhost:5000/subjects', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            title: subjectNameInput.value,
            professor: subjectProfessorInput.value,
            credit: subjectGradeInput.value,
            type: subjectTypeInput.value,
        }),
    });
}

async function readSubjects() {
    const res = await fetch('http://localhost:5000/subjects');
    const data = await res.json();

    data.forEach((subject) => {
        subjectContent.scrollTop = subjectContent.scrollHeight;
        subjectBody.insertAdjacentHTML(
            'beforeend',
            `<tr class='subject-table-row' data-id='${subject.id}'>
        <td class='subject-table-column subject-table-column-subject-name'>
          ${subject.title}
        </td>
        <td class='subject-table-column'>${subject.professor}</td>
        <td class='subject-table-column'>${subject.credit}</td>
        <td class='subject-table-column'>${subject.type}</td>
        <td class='subject-table-column subject-option-column'>
          <button type='button' class='subject-option-btn' data-role="option-${subject.id}" data-id="${subject.id}">
            설정
          </button>
          <div class="menu menu-${subject.id}">
            <ul>
              <li><button type="button" data-role="update-${subject.id}" data-id="${subject.id}" class="update-btn">수정</button></li>
              <li><button type="button" data-role="remove-${subject.id}" data-id="${subject.id}" class="remove-btn">삭제</button></li>
              <li><button type="button" data-role="close-${subject.id}" data-id="${subject.id}" class="close-btn">닫기</button></li>
            </ul>
          </div>
        </td>
      </tr>`
        );
    });
}

async function deleteSubject(id) {
    await fetch(`http://localhost:5000/subjects/${id}`, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
    });
}

subjectBody.addEventListener('click', (e) => {
    if (e.target.dataset.role === `close-${e.target.dataset.id}`) {
        subjectBody.querySelector(`.menu-${e.target.dataset.id}`).style.display =
            'none';
    } else if (e.target.dataset.role === `option-${e.target.dataset.id}`) {
        subjectBody.querySelector(`.menu-${e.target.dataset.id}`).style.display =
            'block';
    } else if (e.target.dataset.role === `remove-${e.target.dataset.id}`) {
        deleteSubject(e.target.dataset.id);
    }
});