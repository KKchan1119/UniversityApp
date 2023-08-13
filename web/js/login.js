function fn_checkEmpty() {


    const formLogin = document.formLogin;

    const userId = formLogin.userId.value;
    const password = formLogin.password.value;

    if((userId==="" || password ==="") || (userId.length === 0 || password.length === 0))
    {
        alert("아이디와 비밀번호를 입력해주세요.");
    }
    else
    {
        formLogin.method = "post";
        formLogin.action = "login.do";
        formLogin.submit();
    }
}
