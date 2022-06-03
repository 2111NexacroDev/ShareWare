<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#bmk {
	float: left;
	width: 40%;
}

#read {
	width: 50%;
}

#file {
	float: left;
	width: 40%;
}

.mailHeader {
	padding-bottom: 210px;
	/* border-bottom: 1px lightgray solid; */
}

.mailWriteMenu {
	float: right;
	margin-top: 12%;
	margin-right: 37%;
}

.btn-mail {
	display: inline-block;
	width: 85px;
	height: 40px;
	background-color: white;
	border: 1px solid rgb(51, 51, 51);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}

#rMail {
	width: 1300px;
	margin: 20px 0;
	font-size: 14px;
	text-align: center;
	border-collapse: collapse;
	border-top: 1px solid rgb(200, 200, 200);
	border-bottom: 2px solid rgb(200, 200, 200);
}
#rMail tr {
	height: 45px;
}
#rMail tr:hover {
background-color: rgb(250, 250, 250);
}
#rMail th{
background-color: rgb(240, 240, 240);
border-top: 2px solid rgb(200, 200, 200);
}
#rMail td {

border-bottom: 1px solid lightgray;
}
#rMail a {
	text-decoration: none;
	color: black;
	cursor: pointer;
}

#mailRList {
	float: left;
	margin-top: 120px;
	margin-left: 480px;
	}
.l-search {
	float: left;
	display: inline-block;
	width: 100px;
	height: 37px;
	background-color: white;
	border: none;
	border-left: 2px solid rgb(190, 190, 190);
	border-radius: 4px;
	font-size: 15px;
	cursor: pointer;
}
.l-search form{
	display: inline-flex;
}
.l-select {
	height: 40px;
	width: 80px;
	border-radius: 4px;
	border: solid 2px rgb(190, 190, 190);
	margin-right: 7px;
	text-align: center;
	float:left;
}
.l-input {
	display: flex;
	height: 37px;
	width: 190px;
	border-radius: 4px;
	border: solid 2px rgb(190, 190, 190);
}
.l-text {
	display: inline-flex;
	width: 137px;
	border: none;
	
}
#delete {
	float:left;
	border: solid 2px rgb(190, 190, 190);
}
#fileBox {
margin-left: 30px;

}
#fMailDiv {
	border: solid 1px rgb(190, 190, 190);
	 display: inline-block;
	   box-sizing: border-box;
    text-align: center;
    padding-top: 10px;
     flex: 1;
     height: 310px;
     float: left;
     width:30%;
     margin-left: 30px;
  	margin-bottom: 20px;
  	  justify-content : center;
}
#fileBox {
	background: rgb(240, 240, 240);
}
#fMailIcon {
	border-bottom: solid 1px rgb(190, 190, 190);
	box-sizing: border-box;
	padding-bottom: 10px;
}
#mailTop {
padding-bottom: 20px;
	border-bottom: 2px solid rgb(190, 190, 190);
	
}
a {
	text-decoration: none;
}
</style>
</head>


<body>
	<jsp:include page="../common/menuBar.jsp"></jsp:include>
	<jsp:include page="../mail/mailMenu.jsp"></jsp:include>
	<script type="text/javascript">
	$(function() {
		$("#allCheck").click(function() {
			var chk_listArr = $("input[name='RowCheck']");
			for (var i=0; i<chk_listArr.length; i++) {
				chk_listArr[i].checked = this.checked;
			}
		});			
		
	});
	
	

	function deleteValue() {
		var mailCategory = document.querySelector("#mailCategory").value;
		var paramArr = new Array();
		var list = $("input[name='RowCheck']");
		for (var i = 0; i < list.length; i++) {
			var paramObj = {};
			if (list[i].checked) {
				var paramData = list[i].value.split("/");
				paramObj.mailNo = paramData[0];
				paramObj.rNo = paramData[1]; 
				paramObj.refYn = paramData[2];
				paramObj.mailCate = paramData[3];
				paramObj.mailType = paramData[4];
				paramArr.push(paramObj);
			}
		}
		console.log(paramArr);
		if (paramArr.length == 0) {
			alert("선택된 메일이 없습니다.")
		} else {
			var chk = confirm("정말 삭제하시겠습니까?");

			$.ajax({
				url : '/mail/chkMailDelete.sw',
				type : 'get',
				traditional : true,
				data : { "paramArr" : JSON.stringify(paramArr) },
				success : function(data) {
					if (data == "success") {
						alert("삭제되었습니다.");
						location.href="/mail/mailIListView.sw"
					} else {
						alert("실패했습니다.")
					}
				}
			});
		}
	}
	function impCancel(obj) {
		var mailCategory = document.querySelector("#mailCategory").value;
		var inputTag = $(obj).prev();
		var paramObj = {};
		var paramData = inputTag[0].value.split("/");
		paramObj.mailNo = paramData[0];
		paramObj.rNo = paramData[1]; 
		paramObj.refYn = paramData[2];
		paramObj.mailCate = paramData[3];
		paramObj.mailType = paramData[4];
			
		console.log(paramObj);
		$.ajax({				
			url : '/mail/cancelI.sw',
			type : 'get',
			traditional : true,
			data : { "paramObj" : JSON.stringify(paramObj) },
			success : function(data) {
				if (data == "success") {
					alert("중요메일함에서 삭제되었습니다.");
					location.href="/mail/mailIListView.sw"
				} else {
					alert("실패했습니다.");
				}
			}
		});
	}
	</script>
	
	
	<div id="mailRList">
		<div id="mailTop">
			<div style="width:1300px ; padding-bottom: 15px; margin-bottom: -20px;">
				<input style="zoom:1.5; margin-left: 10px; margin-top: 5px; float:left; " name="allCheck" type="checkbox" id="allCheck" />
			</div>
	<button type="submit" class="btn-mail" id="delete" style="margin-left: 15px;" onclick="deleteValue();"><i class="fa-solid fa-trash" style=" color:rgb(190, 190, 190);"></i>&nbsp;삭제하기</button>
	<form action="/mail/AmailSearch.sw" method="get">
				<select class= "l-select" id="s-condition" name="searchCondition" style="text-align: left; width:80px; margin-left:15px; ">
					<option value="all">전체</option>
					<option value="receiver">수신인</option>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select>
			<div class="l-input" style="margin-top: 5px;">
			<input type="text" id="s-value" name="searchValue" class="l-text" >
			<input type="submit" id="btn-search" value="검색" class="l-search">
			</div>	
	</form> 
	</div>
			<input type="hidden" id="mailCategory" value="${mailCategory }">
			<table id="rMail" border="0">
			<c:forEach items="${iList }" var="mail">
				<tr>
					<c:url var="mDetail" value="/mail/mailIDetailView.sw">
						<c:param name="mailNo" value="${mail.mailNo}"></c:param> 
					</c:url> 
					<td width="30px;"><input name="RowCheck" type="checkbox"
						value="${mail.mailNo}/${mail.recNo}/${mail.refYn }/${mailCategory}/${mail.mailType}" /></td>
					<td width="30px;">
						<span>
							<input name="m-value" type="hidden" value="${mail.mailNo}/${mail.recNo}/${mail.refYn }/${mailCategory}/${mail.mailType}" />
							<c:if test="${mail.iStatus eq '1'}">
								<a href="javascript:void(0)" onclick="impCancel(this);" id="m-value"><i class="fa-solid fa-star"></i></a>
							</c:if>
						</span>	
					</td>
					<td width="30px;"><c:if test="${mail.readType eq '0'}"><i class="fa-regular fa-envelope"></i></c:if>
					<c:if test="${mail.readType eq '1'}"><i class="fa-solid fa-envelope-open-text"></i></c:if>
					</td>
					<td width="30px;"><c:if test="${mail.fStatus eq '0' }"></c:if>
					<c:if test="${mail.fStatus eq '1' }"><i class="fa-regular fa-file"></i></c:if>
					</td>
					<td width="200px;">${mail.mailSender }</td>
					<td width="80px;"><c:if test="${mail.mailType eq 'S' && mail.refYn ne 'R'}">[받은 메일함]</c:if>
						<c:if test="${mail.mailType eq 'S' && mail.refYn eq 'R'}">[보낸 메일함] </c:if>
						<c:if test="${mail.mailType eq 'F' }">[내게 쓴 메일함]</c:if>
					</td>
					<td><a href="${mDetail}">${mail.mailSubject }</a></td>
					<td width="200px;"><fmt:formatDate
							value="${mail.mailFromDate }" pattern="yyyy/MM/dd/HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="mailPaging.jsp"></jsp:include>
	</div>
	
</body>
</html>