<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<meta charset="UTF-8">
	<title>상품정보</title>
	<style>
		@import url("style.css");
		section {
			width:1200px;
			height: 600px;
			border: solid 1px #FEF4D9;
			margin-left: 50px;
			float: left;
				}
		table {border-collapse:collapse; margin:auto; margin-top:10px;} 
		td{border:1px solid black; height:30px; font-size:12px;padding:0px 5px 0px 5px;}
		h2{text-align:center; color:#FF5E00;}
		input[name=image] {display:none;}
		
	</style>
</head>
<body>
	<header>
		<div><img src='images/logo.jpg' width="330px" height="100px"></div>
		<div id='top'> <a href="travel_agency/result/logout.jsp">로그아웃</a> | <a href="#">장바구니</a> | <a href="#">고객센터</a> | <a href="#">예약확인</a> </div>
	</header>

	<nav class="navi">
		<ul>
			<li><a href="#"> =메뉴</a></li>
			<li><a href="nproduct.jsp"> 국내여행</a></li>
			<li><a href="product.jsp"> 해외여행</a></li>
			<li><a href="#"> 항공</a></li>
			<li><a href="#"> 호텔</a></li>
		</ul>
	</nav>
	<section>
	<h2>[상품정보]</h2>
	<form name="frm" enctype="multipart/form-data">
		<table>
			<tr>
				<td width=100 class="title">상품코드</td>
				<td width=400><input type="text" name="pcode" size=3 value="${vo.pid}"/></td>
			</tr>
			<tr>
				<td width=100 class="title">상품이름</td>
				<td width=400><input type="text" name="pname" size=50 value="${vo.pname}"/></td>
			</tr>
			<tr>
				<td width=100 class="title">상품가격</td>
				<td width=400><input type="text" name="price" size=3 value="${vo.price}" style="text-align:right;"/>원</td>
			</tr>
			<tr>
				<td width=100 class="title">상품이미지</td>
				<td width=400>
					<input type="file" name="image" size=3 accept="image/*"/>
					<c:if test="${vo.image==null}">
						<img src="http://placehold.it/150x120" width=150 id="image"/>
					</c:if>
					<c:if test="${vo.image!=null}">
						<img src="/product1/img/${vo.image}" width=150 id="image"/>
					</c:if>		
				</td>
			</tr>
		</table>
		<div style="width:500px;text-align:center;padding:10px;margin:auto;">
			<input type="submit" value="상품수정">
			<input type="reset" value="수정취소">
			<input type="button" value="상품삭제" id="btnDelete">
			<input type="button" value="목록이동" onClick="location.href='list'">
		</div>
	</form>
</section>
<ul class="foot">
		 	<li>(주)용인투어네트워크 대표이사 : 김유림 |    사업자등록번호 : 123-45-00000 | yongintour@yiu.ac.kr<br>※ ㈜ 용인투어는 항공사가 제공하는 개별 항공권 및 여행사가 제공하는 일부 여행상품에 대하여 통신판매중개자의 지위를 가지며, 해당 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있습니다.<br>
             ※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
             <img src='images/foot.png' width="1100px" height="50px">
             <br><span>Copyright © Yongin Tour Corp.</span>
     </ul>
</body>
<script>
	$("#btnDelete").on("click",function(){
		var pcode="${vo.pid}";
		if(!confirm(pid + "를(을) 삭제하시겠습니까?")) return;
		location.href="delete?pcode="+pcode;
	});
	
	$("#image").on("click",function(){
		$(frm.image).click();
	});
	$(frm.image).on("change",function(e){
		var reader=new FileReader();
		reader.onload=function(e){
			$("#image").attr("src", e.target.result);
		}
		reader.readAsDataURL(this.files[0]);
	});
</script>

</html>

