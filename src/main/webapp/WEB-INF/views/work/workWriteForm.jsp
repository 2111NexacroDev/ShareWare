<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업무현황 작성페이지</title>
</head>
<body>
<jsp:include page="../project/projectMainMenu.jsp"></jsp:include>
	<div class="s-container">
		<form action="/project/workRegister.sw" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${projectNo }" name="projectNo">
			<input type="hidden" value="${nowTime }" name="workDate">
			<table border="1">
				<tr>
					<td>제목</td>
					<td><input type="text" name="workTitle"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="hidden" value="${loginUser.memberName}" name="workWriter">${loginUser.memberName}</td>
					<input type="hidden" value="${loginUser.memberNum}" name="memNum">
				</tr>
				<tr>
					<td>파일첨부</td>
					<td><input type="file" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan="4"><textarea name="workContent"></textarea></td>
				</tr>
			</table>
				<input type="reset" value="취소">
				<input type="submit" value="등록">
		</form>
	</div>
</body>
</html>