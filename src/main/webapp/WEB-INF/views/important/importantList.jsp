<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>중요공지 목록</title>
</head>
<body>
<div>
	<h2>중요공지</h2>
		<a herf="">+공지작성</a>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${iList }" var="important" varStatus="status">
				<tr>
					<td>${fn:length(dList ) - status.count + 1}</td>
					<c:url var="iDetail" value="/project/importantDetailsw?projecNo=${project.projectNo} ">
						<c:param name="importantNo" value="${important.importantNo }"></c:param>
					</c:url>
					<td><a href="${iDetail }">${important.importantTitle }</a></td>
					<td>${important.importantDate }</td>
					<td>${important.importantCount }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>