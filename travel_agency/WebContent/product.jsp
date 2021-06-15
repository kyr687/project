<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style type='text/css'>
@import url("style.css");
section {
	width:1200px;
	height: 800px;
	border: solid 1px #FEF4D9;
	margin-left: 50px;
	float: left;
}
</style>

<body>
	<header>
		<div><img src='images/logo.jpg' width="330px" height="100px"></div>
		<div id='top'> <a href="travel_agency/result/logout.jsp">로그아웃</a> | <a href="#">장바구니</a> | <a href="#">고객센터</a> | <a href="#">예약확인</a> </div>
	</header>

	<nav class="navi">
		<ul>
			<li><a href="#"> =메뉴</a></li>
			<li><a href="product.jsp"> 국내여행</a></li>
			<li><a href="product.jsp"> 해외여행</a></li>
			<li><a href="#"> 항공</a></li>
			<li><a href="#"> 호텔</a></li>
		</ul>
	</nav>
	<section>
		
		<%@include file="/productlist.jsp"%>
	</section>
	<ul class="foot">
		 	<li>(주)용인투어네트워크 대표이사 : 김유림 |    사업자등록번호 : 123-45-00000 | yongintour@yiu.ac.kr<br>※ ㈜ 용인투어는 항공사가 제공하는 개별 항공권 및 여행사가 제공하는 일부 여행상품에 대하여 통신판매중개자의 지위를 가지며, 해당 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있습니다.<br>
             ※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
             <img src='images/foot.png' width="1100px" height="50px">
             <br><span>Copyright © Yongin Tour Corp.</span>
     </ul>
</body>	
</html>