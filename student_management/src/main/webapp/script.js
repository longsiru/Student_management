/**
 * 
 */
 function fn_submit(){
	var f = document.frm;
	if(f.student_no.value == ''){
		alert("학번을 입력해주십시오.");
		return false;
	}
	
	if(f.student_name.value == ''){
		alert("이름을 입력해주십시오.");
		return false;
	}
	
	if(f.student_gender.value == ''){
		alert("성별을 입력해주십시오.");
		return false;
	}
	
	if(f.student_major.value == ''){
		alert("전공을 입력해주십시오.");
		return false;
	}
	
	if(f.phone_no.value == ''){
		alert("전화번호를 입력해주십시오.");
		return false;
	}
	
	if(f.student_address.value == ''){
		alert("주소를 입력해주십시오.");
		return false;
	}
	
	if(f.addr_det.value == ''){
		alert("상세주소를 입력해주십시오.");
		return false;
	}
	
	f.submit();
}
function fnn_submit(){
	var fn = document.frm;
	
	if(fn.student_name.value == ''){
		alert("이름을 입력해주십시오.");
		return false;
	}
	
	if(fn.student_gender.value == ''){
		alert("성별을 입력해주십시오.");
		return false;
	}
	
	if(fn.student_major.value == ''){
		alert("전공을 입력해주십시오.");
		return false;
	}
	
	if(fn.phone_no.value == ''){
		alert("전화번호를 입력해주십시오.");
		return false;
	}
	
	if(fn.student_address.value == ''){
		alert("주소를 입력해주십시오.");
		return false;
	}
	
	if(fn.addr_det.value == ''){
		alert("상세주소를 입력해주십시오.");
		return false;
	}
	
	fn.submit();
}
function chkDelete(student_no) {
	const result = confirm("삭제하시겠습니까?");
		
	if(result) {
		const url = location.origin;
		location.href = url + "/student_management/delete?student_no=" + student_no;
	} else {
		return false;
	}		
}