<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<div class="student_wrap">
		<div class="student_title">
			<strong>학생${student_no } 정보수정</strong>
		</div>
		<div class="student_add_wrap">
			<form name="frm" method="post" action="update?student_no=${student_no}">
				<div class="student_add">
					<table class="student_add">
						<tr>
							<th>이 름</th>
							<td><input type="text" name="student_name"
								value="${student.student_name }"></td>
						</tr>
						<tr>
							<th>성 별</th>
							<td><input type="text" name="student_gender"
								value="${student.student_gender }"></td>
						</tr>
						<tr>
							<th>전 공</th>
							<td><input type="text" name="student_major"
								value="${student.student_major }"></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phone_no"
								value="${student.phone_no }"></td>
						</tr>
						<tr>
							<th>주 소</th>
							<td><input type="text" name="student_address"
								value="${student.student_address }"></td>
						</tr>
						<tr>
							<th>상세주소</th>
							<td><input type="text" name="addr_det"
								value="${student.addr_det }"></td>
						</tr>
						<tr>
							<td colspan=2>
								<button class="btn" type="button" onclick="fnn_submit(); return false;">수 정</button>
								<button class="btn" type="reset"
									onclick="location.href='list'">취 소</button>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</body>
</html>