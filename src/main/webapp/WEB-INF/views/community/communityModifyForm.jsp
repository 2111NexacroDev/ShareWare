<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>

<h1>수정 페이지</h1>

	
		
	
	<span>작성일 : ${community.comDate}</span>
	<form action="/community/update.sw" method="POST" enctype="multipart/form-data" id="updateForm">  
		<button type="button" id="delete">삭제</button>
		<button type="button" id="update"> 등록</button>
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="comTitle" value="${community.comTitle}"></td>
			
		</tr>
		<tr>
			<td>본문</td>
			<td>
 				<!-- <div contentEditable="true" id="comContent" style="height:500px;">  -->
				<input type="text" id="comContent" value="${community.comContent}">
					<div>
						<img id ="img" />
					</div>
			
				<div id="vote-body-div">
					<div id="vote-textbox-div">
						<div id="vote-textbox1-div">
							<input id="vote-input1" type="text" value="${communityVote.cVoteText1}">
						</div>
						<div id="vote-textbox2-div">
							<input id="vote-input2" type="text" value="${communityVote.cVoteText2}">	
						</div>
						<div id="vote-textbox3-div">
							<input id="vote-input3" type="text" value= "${communityVote.cVoteText3}">
							<button type="button" id="btn-delete1" >-</button>
						</div>
						<div id="vote-textbox4-div">
							<input id="vote-input4" type="text" value= "${communityVote.cVoteText4}">
							<button type="button" id="btn-delete2">-</button>
						</div>
					</div>
						<div id="button-box">
							<button type="button" id="voteDelete">삭제</button>
							<button type="button" id="voteInputAdd">+</button>
						</div>
					</div>
		
				<!--</div>  -->
				
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" accept=".jpg,.pdf,.bmp,.png,.jpeg" id="comImgName" onchange="loadImg(this);" ></td>
			<!--onchange="loadImg(this)주기->function loadImg(obj)받기-->
		</tr>
		<tr>
			<td>
				<button type="button" id="comInsert">등록</button>
				<button>취소</button>
				<button type="button" id="comVoteInsert">투표등록</button>
			</td>
		</tr>
	</table>
	</form>
	
	<script>
	
	
	
	const voteBodyDiv =document.getElementById('vote-body-div');
	var voteResult = "${communityVote.comVoteNo}";
	
	//투표가 있을 때는 투표가 보이고 투표가 없을 때 화면을 부르면 투표가 안보이게
	if(voteResult != ""){ //투표 번호가 없으면 투표 보이기
		voteBodyDiv.style.display = 'block';
		}else{ // 아니면 안보이게
			voteBodyDiv.style.display = 'none';
		}
	//투표 등록 버튼을 눌렀을 때 투표가 화면에 없으면 보이게 
	$("#comVoteInsert").on("click",function(){
 
		
		if(voteBodyDiv.style.display == 'none'){  //만약 화면에 없으면
			voteBodyDiv.style.display = 'block'; //화면에 보이게
		}

	});
	
	//투표 삭제 버튼을 누르면 안보이게
	$("#voteDelete").on("click",function(){
	
	
			if(voteBodyDiv.style.display === 'block'){
				voteBodyDiv.style.display = 'none';
			}
	
		});

	</script>

</body>
</html>