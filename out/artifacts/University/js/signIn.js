function fn_checkEmptyInfo() {


    const signInForm = document.signInForm;

    const formFields = [
        signInForm.userId.value,
        signInForm.password.value,
        signInForm.name.value,
        signInForm.birth.value,
        signInForm.address.value,
        signInForm.majorId.value,
        signInForm.status.value,
        signInForm.role.value
    ];

    if (formFields.some(field => field === "" || field.length === 0)) {
        alert("정보를 모두 입력해주세요.");
    } else
    {
        signInForm.method = "post";
        signInForm.action = "insertUser.do";
        signInForm.submit();
    }
}
function goToLoginPage(){
    window.location.href="/University";
}