<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div class="wrap">
		<table class="student_list">
			<caption>
				<h1>확생 정보 관리</h1>
			</caption>
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>성별</th>
					<th>전공</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>작성일자</th>
					<th>처리사항</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="student" items="${studentList}" varStatus="status">
				<tr>
				
						<td>${student.student_no}</td>
						<td>${student.student_name }</td>
						<td>${student.student_gender }</td>
						<td>${student.student_major }</td>
						<td>${student.phone_no }</td>
						<td>${student.student_address }</td>
						<td>${student.add_date }</td>
						<td colspan="2">
							<button class="btn" type="button" onclick="chkDelete(${student.student_no}); return false;">삭제</button>
							<button class="btn" type="submit" onclick="location.href='./detail?student_no=${student.student_no}'">상세</button>
						</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
		<div class="bt_wrap bt_list">
			<button class="btn"><a href="add">학생 추가</a></button>
		</div>
		<div class="student_page">
			<a href="#" class="bt first">&lt;&lt;</a> <a href="#" class="bt prev">&lt;</a>
			<a href="#" class="num on">1</a> <a href="#" class="num">2</a> <a
				href="#" class="num">3</a> <a href="#" class="num">4</a> <a href="#"
				class="num">5</a> <a href="#" class="bt next">&gt;</a> <a href="#"
				class="bt last">&gt;&gt;</a>
		</div>
	</div>
	<script>
	  <c:if test="${error != null}">
	    alert("${error}");
	  </c:if>
	</script>
	<script type="text/javascript" src="script.js"></script>
</body>
</html>