<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("a hh:mm:ss");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태관리</title>
<link href="/resources/css/approval/appList-style.css" rel="stylesheet">
	<style type="text/css">
	.stats-List{
	width: 500px;
	margin: 20px 0;
	font-size: 14px;
	text-align: center;
	border-collapse: collapse;
	border-top: 2px solid rgb(200, 200, 200);
	border-bottom: 2px solid rgb(200, 200, 200);
	}
	.stats-List tr {
		border-top: 1px solid rgb(200, 200, 200);
		height: 45px;
	}
	.stats-List tr:hover {
		background-color: rgb(250, 250, 250);
	}
	.stats-List th {
		background-color: rgb(240, 240, 240);
	}
	.stats-List .th-1 {
		width: 180px;
	}
	.stats-List .th-2 {
		width: 630px;
	}
	.stats-List .th-3 {
		width: 810px;
	}
	.stats-List a {
		text-decoration: none;
		color: black;
		cursor: pointer;
	}
	.stats-List span {
		padding: 5px 10px;
		border-radius: 4px;
		border: 1px;
		color: white;
	}
	</style>

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
</head>
<body>
<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	
	<div class="s-container">
	<h2 id="h-title">근태관리</h2><br>
	
	<%= sf.format(nowTime) %><br>
	
	<div>
		<form action="/attendance/registerAtt.sw" method="post">
			<input type="submit" id="button1" value="출근">
		</form>
		<form action="/attendance/modifyAtt.sw" method="post">
			<input type="submit" id="button2" value="퇴근">
			 <br>
		</form>		
	</div>
	
	<!-- 검색일<input type="text" id="searchDate">  -->
	<form action="/attendance/searchDate.sw" method="post">
    	<div>
	      <input type="month" value="Sysdate" name="date">
	      <input type="submit" value="검색">
    	</div>
    
    	<br>
    	<div>
			<table class="stats-List">
				<tr><th>통계</th></tr>
				<tr>
					<th class="th-1">지각</th>
					<th class="th-1">조퇴</th>
					<th class="th-1">출근</th>
				</tr>
				<c:if test="${sessionScope.memNum eq member.memNum }">
				<tr>
					<c:forEach items="${sList }" var="attStats">
								<td>${attStats.attCount}</td>
					</c:forEach>
				</tr>	
				</c:if>
			</table>
		</div>
    </form>
  	<br>
		
		<div>
			<table class="t-List">
				<tr>
					<th class="th-1">날짜</th>
					<th class="th-1">출근시간</th>
					<th class="th-1">퇴근시간</th>
					<th class="th-1">무시간</th>
					<th class="th-1">근무상태</th>
				</tr>
				<c:forEach items="${aList }" var="attendance">
				<c:if test="${sessionScope.memNum eq member.memNum }">
				<tr>
					<td>${attendance.attDate }</td>
					<td>${attendance.attStrTime }</td>
					<td>${attendance.attFinTime }</td>
					<td>${attendance.attTotalTime }</td>
					<td>${attendance.attStatus }</td>
				</tr>
				</c:if>
				</c:forEach>
			</table>
			<br>
			<div id="page" align="center">
				<c:forEach var="p" begin="${pi.startNavi }"
					end="${pi.endNavi }">
					<c:url var="pagination" value="/attendance/attListViewEmp.sw">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<a href="${pagination }">${p }</a>&nbsp;
				</c:forEach>
			</div>
		</div>
</div>
	
</body>
</html>