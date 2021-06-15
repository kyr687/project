<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<meta charset="UTF-8">
	<title>상품등록</title>
	<style>
		table {border-collapse:collapse; margin:auto; margin-bottom:10px;} 
		td{border:1px solid black; height:30px; font-size:12px;padding:0px 5px 0px 5px;}
		h2{text-align:center;}
		input[name=image] {display:none;}
	</style>
</head>
<body>
	<h2>[상품등록]</h2>
	<form name="frm" enctype="multipart/form-data">
		<table>
			<tr>
				<td width=100 class="title">상품코드</td>
				<td width=400><input type="text" name="pid" size=3 value="${pid}"/></td>
			</tr>
			<tr>
				<td width=100 class="title">상품이름</td>
				<td width=400><input type="text" name="pname" size=50/></td>
			</tr>
			<tr>
				<td width=100 class="title">상품가격</td>
				<td width=400><input type="text" name="price" size=3 value="0" style="text-align:right;"/>원</td>
			</tr>
			<tr>
				<td width=100 class="title">상품이미지</td>
				<td width=400>
					<input type="file" name="image" size=3 accept="image/*"/>
					<img src="http://placehold.it/150x120" width=150 id="image"/> 				
				</td>
			</tr>
		</table>
		<div style="width:500px;text-align:center;padding:10px;margin:auto;">
			<input type="submit" value="상품등록">
			<input type="reset" value="등록취소">
			<input type="button" value="목록이동" onClick="location.href='list'">
		</div>
	</form>
</body>
<script>
	$(frm).on("submit",function(e){
		e.preventDefault();
		if(!confirm("상품을 등록 하시겠어요?")) return;
		//frm.action="insert";
		frm.method="post";
		frm.submit();
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

