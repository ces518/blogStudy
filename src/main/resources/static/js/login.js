function login(){
    var frm = document.querySelector('#frm');
    if(frmCheck(frm)){
        var id = frm.id.value;
        frm.action = `/login/${id}`;
        frm.submit();
    }
}

function frmCheck(frm){
    if(frm.id.value == ''){
        alert('아이디를 입력해주세요.');
        return false;
    }
    if(frm.password.value == ''){
        alert('비밀번호를 입력해주세요.');
        return false;
    }
}
