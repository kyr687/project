<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,travel.*,travel_agency.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<style>
	h2{color: #FF8200; text-align: center;}
	.prod-list li {

  margin-top: 10px;
  margin-bottom: 20px;
  overflow: hidden;
  position: relative;
}
</style>
<head>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<meta charset="UTF-8">
	<style>
		#divContent{overflow:hidden;width:800px;}
		.box{float:left;width:180px;margin:5px;padding:5px;background:white;}
		image{cursor:pointer;}
	</style>
</head>
<body>
	<h2>[상품목록]</h2>
	<a href="insert">상품등록</a>
	
	<div id="divContent">
		<c:forEach items="${list}" var="vo">
			<div class="box">
				<c:if test="${vo.image==null}">
					<img src="http://placehold.it/150x120" width=150/>
				</c:if>
				<c:if test="${vo.image!=null}">
					<img src="/travel/${vo.image}" width=150/>
				</c:if>
				<div class="pid">${vo.pid}</div>
				<div>${vo.pname}</div>				
				<div>${vo.price}</div>
			</div>
		</c:forEach>
	</div>
	<section>
		<div id="container">
		<ul class="prod-list">
			<li><img src='images/01.jpg'  width="200px" height="190px" >
				<div class="caption">
          		<h1>베트남</h1>
          		<p>다낭 3박 4일<br>[특가] 949900원~</p>
        		</div>
       		 </li>
			<li><img src='images/02.jpg' width="200px" height="190px">
				<div class="caption">
         		 <h1>대만</h1>
        	 	 <p>타이베이 3박 4일<br>[특가] 699900원~</p>
       		 </div>
    		</li>
			<li><img src='images/03.jpeg' width="200px" height="190px">
				<div class="caption">
          		<h1>태국</h1>
          		<p>방콕 2박 3일<br>[특가] 949900원~</p>
      			 </div>
      		</li>
    		<li><img src='images/04.jpg' width="200px" height="190px">
				<div class="caption">
          		<h1>브루나이</h1>
          		<p>브루나이 3박 4일<br>[특가] 1499900원~</p>
      			 </div>
    		</li>
    		<li><img src='images/05.jpg' width="200px" height="190px">
				<div class="caption">
          		<h1>스위스</h1>
          		<p>융프라우 9박 11일<br>[특가] 2560000원~</p>
      			 </div>
    		</li>
    		<li><img src='images/06.jpg' width="200px" height="190px">
				<div class="caption">
          		<h1>서유럽</h1>
          		<p>4개국 7박 9일<br>[특가] 3670000원~</p>
      			 </div>
    		</li>
    		<li><img src='images/07.jpg' width="200px" height="190px">
				<div class="caption">
          		<h1>동유럽</h1>
          		<p>3개국 9박 11일<br>[특가] 3669000원~</p>
      			 </div>
    		</li>
    		<li><img src='images/08.jpg' width="200px" height="190px">
				<div class="caption">
          		<h1>터키</h1>
          		<p>터키일주 7박 9일<br>[특가] 3543000원~</p>
      			 </div>
    		</li>
		</ul>
	</div>
	<a href="purchase">상품구매</a>
	</section>
</body>
<script>
	$("#divContent").on("click",".box img",function(){
		var pid=$(this).parent().find(".pid").html();
		location.href="read?pid="+pid;
	});
</script>
</html>
