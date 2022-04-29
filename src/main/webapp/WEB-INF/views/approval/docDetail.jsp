<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안 문서 상세</title>
</head>
<body>
	<jsp:include page="appMenu.jsp"></jsp:include> <!-- 메뉴 + 소메뉴 -->
	<div class="s-container">
		<h1 id="h-title">${appDoc.formName }</h1>
		<table border="1" id="table">
			<tr>
				<td>문서번호</td>
				<td>${appDoc.docNo }</td>
				<td rowspan="3" style="writing-mode: vertical-rl;">결재</td>
				<td>담당</td>
				<td id="d-app0">${aList[0].division }</td>
				<td id="d-app1">${aList[1].division }</td>
				<td id="d-app2">${aList[2].division }</td>
			</tr>
			<tr>
				<td>기안일</td>
				<td>${appDoc.docDate }</td>
				<td>${appDoc.docDate }</td>
				<td>${aList[0].appDate }</td>
				<td>${aList[1].appDate }</td>
				<td>${aList[2].appDate }</td>
			</tr>
			<tr>
				<td>기안자</td>
				<td>${appDoc.memName }</td>
				<td>${appDoc.memName }</td>
				<td id="name-app0">${aList[0].memberName }</td>
				<td id="name-app1">${aList[1].memberName }</td>
				<td id="name-app2">${aList[2].memberName }</td>
			</tr>
			<tr>
				<td>참조자</td>
				<td colspan="6" id="ref-list">
					<c:forEach items="${rList }" var="appRef" varStatus="index">
						<c:choose>
							<c:when test="${!index.last}">
								${appRef.division } ${appRef.memberName } ${appRef.rank },
							</c:when>
							<c:when test="${index.last}">
								${appRef.division } ${appRef.memberName } ${appRef.rank }
							</c:when>
    					</c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr id="tr-title">
				<td>제목</td>
				<td colspan="6">${appDoc.docTitle }</td>
			</tr>
			<c:set var="formName" value="${appDoc.formName}" />
			<c:if test="${formName eq '휴가신청서'}">
                <tr>
                    <td>휴가 종류</td>
                    <td colspan="6">
                        ${appDoc.leaveType }
                    </td>
                </tr>
                <tr>
                    <td>휴가 기간</td>
                    <td colspan="6" id="td-leave-date">
                        ${appDoc.leaveStart }~${appDoc.leaveEnd }
                        <c:if test="${appDoc.leaveType eq '반차'}">
                        	${appDoc.leaveTime }
                        </c:if>
                        	휴가 일수 : ${appDoc.leaveDay }
                    </td>
                </tr>
                <tr>
                    <td>연차 일수</td>
                    <td colspan="6" id="td-leave-day">
                        	잔여 연차 : <c:if test="${appDoc.leaveLeft != null}">${appDoc.leaveLeft}</c:if><c:if test="${appDoc.leaveLeft == null}">0</c:if>
                        	신청 연차 : <c:if test="${appDoc.leaveApply != null}">${appDoc.leaveApply}</c:if><c:if test="${appDoc.leaveApply == null}">0</c:if>
                    </td>
                </tr>
                <tr>
                    <td>휴가 사유</td>
                    <td colspan="6" id="td-leave-reason">${appDoc.docContent}</td>
                </tr>
			</c:if>
			<c:if test="${appDoc.formName ne '휴가신청서'}">
				<tr>
					<td colspan="7">
						${appDoc.docContent }
					</td>
				</tr>
			</c:if>
		</table>
		<p>파일 첨부
		<input type="file" id="file-input" name="uploadFile">
		<input type="button" id="btn-cancel" value="상신 취소">
		<input type="button" value="목록" onclick="location.href='/approval/draftListView.sw'">
	</div>
	<script>
		
	</script>
</body>
</html>