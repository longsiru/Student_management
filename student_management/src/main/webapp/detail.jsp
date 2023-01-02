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
			<strong>학생${student_no }의 상세정보
			</strong>
		</div>
		<div class="student_add_wrap">
			<form name="frm" method="post" action="insert">
				<div class="student_add">
					<table class="student_add">
						<tr>
							<th>추가일자</th>
							<td>${student.add_date }</td>
						</tr>
						<tr>
							<th>이 름</th>
							<td>${student.student_name }</td>
						</tr>
						<tr>
							<th>성 별</th>
							<td>${student.student_gender }</td>
						</tr>
						<tr>
							<th>전 공</th>
							<td>${student.student_major }</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${student.phone_no }</td>
						</tr>
						<tr>
							<th>주 소</th>
							<td>${student.student_address }</td>
						</tr>
						<tr>
							<th>상세주소</th>
							<td>${student.addr_det }</td>
						</tr>
						<tr>
							<td colspan=2>
								<button class="btn" type="reset" onclick="location.href='list'">목 록</button>
								<button class="btn" type="button" onclick="location.href='./modify?student_no=${student_no}'">수 정</button>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</body>
</html>