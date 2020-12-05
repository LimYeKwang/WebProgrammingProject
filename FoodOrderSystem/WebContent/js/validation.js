function CheckRegister(){
	var id = document.getElementById("id");
	var pw = document.getElementById("password");
	var name = document.getElementById("name");
	var phone = document.getElementById("phone");
	
	if(id.value.length < 4 || name.value.length > 12){
		alert("[아이디]\n최소 5자에서 12자까지 입력하세요");
		name.select();
		name.focuse();
		return false;
	}
	
	if(!check(/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/, pw, "[pw]\n올바른 비밀번호를 입력하시오.\n 최소 8자, 영문과 숫자를 조합하시오")){
		return false;
	}
	if(name.value.length < 2 || name.value.length > 6){
		alert("[이름]\n최소 2자에서 6자까지 입력하세요");
		name.select();
		name.focuse();
		return false;
	}
	if(!check(/^\d{3}-\d{3,4}-\d{4}$/, phone, "[도서코드]\n올바른 전화번호를 입력하시오.\n 000-0000-0000 형식으로 입력하시오")){
		return false;
	}
	
	function check(regExp, e, msg) {
		if(regExp.test(e.value)){
			return true;
		}
		alert(msg);
		e.select();
		e.focus();
		return false;
	}
	
	document.register.submit();
	
}