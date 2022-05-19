<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 상세보기</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="../../../resources/css/fileBoard/fileBoardDetail.css">
</head>
<body>
<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<div class="s-menu">
		<div class="s-menu-title">
			<p>자유게시판
				<i class="fa-solid fa-pen-to-square fa-lg"></i>
		</div>
		<div class="s-list-item ${listCondition eq 'community' ? 'active' : ''}"><a href="/community/list.sw?docStatus=전체">자유게시판</a></div>
		<div class="s-list-item ${listCondition eq 'notice' ? 'active' : ''}"><a href="/notice/list.sw?docStatus=전체">공지게시판</a></div>
		<div class="s-list-item ${listCondition eq 'fileBoard' ? 'active' : ''}"><a href="/fileBoard/list.sw?docStatus=전체">자료실</a></div>
	</div>
	<div id="coreDiv">
		<div id="marging">
		</div>
		<div id="position">
			<div id="contents">
				<form action="/fileBoard/modifyView.sw" method="GET" enctype="multipart/form-data" id="upDateForm">
					<div class="WriteDiv">작성자 : ${fileBoard.member.memberName }</div>
					<div class="optionBtnDiv">
						<c:if test="${loginUser.memberNum == fileBoard.memberNum}">
							<c:url var="update" value="/fileBoard/modifyView.sw">
								<c:param name="fileBoardNo" value="${fileBoard.fileBoardNo }"></c:param>
							</c:url>
							<input type="button" id="upload" onclick="location.href='${update}'" value="수정"/>
							<button type="button" id="delete" onclick="deletefileBoard()">삭제</button>
						</c:if>
					</div>
				<div class="dateDiv">작성일 : ${fileBoard.fileBoardDate}</div>
				<div id="file-TileDiv">${fileBoard.fileBoardTitle}</div>
				<div id="file-ContentDiv">${fileBoard.fileBoaedContent}</div>
				<div id="file-downloadDiv"><a href="../../../resources/loadFile/${fileBoard.fileRename}" download="${fileBoard.fileName}">${fileBoard.fileName}</a></div>
				</form>
			</div>
		</div>
	</div>
<script>

function deletefileBoard(){
	var fileBoardNo = "${fileBoard.fileBoardNo}";
	
		$.ajax({
		url: "/fileBoard/deletefile.sw",
		type: "GET",
		data: {"fileBoardNo": fileBoardNo},
		success : function(data) {
			if(data == "success") {
				location.href = '/fileBoard/list.sw';
			}else {
				alert("삭제 실패!");
			}
		},
		error : function() {
			alert("ajax 통신 오류! 관리자에게 문의해주세요.");
		}
	})
};
</script>
</body>
</html>