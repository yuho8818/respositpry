<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src=""></script>
<style type="text/css">
@import "css/cart.css"
</style>
<title>Information</title>
<script type="text/javascript" src="js/editpasswd.js"></script>
</head>
<body>
  
     <jsp:include page="Top_bar.jsp"></jsp:include>
     
     <div align="center" class="img">
       <img alt="主页面图片" src="img/home.jpg">
     </div> 
  
	<div id="top">
		<center>
			<h1>修改密码</h1>
		</center>
	</div>
	<div align="center">
		<div style="width: 80%; height: 78%;">
			<div id="left" align="left">
				<div style="padding-top: 2px;">
					<div id="title">个人信息</div>
					<ul id="myinf">
						<li><a href="user?action=show">我的信息</a>
							<p>
						<li><a href="user?action=edit">修改基本信息</a>
							<p>
						<li><a href="user/editpasswd.jsp">修改密码</a>
					</ul>
					<p>
					<div id="title">我的购物车</div>
					<ul>
						<li><a href="shoppingcart?action=lookbus">购物车</a>
							<p>
						<li><a href="shoppingcart?action=paid">已购买的宝贝</a>
							<p>
					</ul>
				</div>
			</div>
			<div id="right" align="left" style="width: 80%; height: 100%">
			  <div align="left" style="width: 60%; padding-left: 10%">
			    <fieldset>
				  <legend>修改密码</legend>
				    <form id="editpasswd" action="user" method="post">
					  <div align="left" style="padding-left: 20%">
						<p>
							<label>&nbsp;&nbsp;原密码：</label>
							<input class="required" type="password" name="oldPasswd" maxlength="50">
						<p>
							<label>&nbsp;&nbsp;新密码：</label>
							<input id="passwd1" class="required" type="password" name="passwd1" maxlength="50">
						<p>
							<label>确认密码：</label>
							<input id="passwd2" class="required" type="password" name="passwd2" maxlength="50" minlength="3">
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="hidden" name="action" value="editpasswd">
							<input class="submit" type="submit" value="修&nbsp; 改">
					  </div>
				  </form>
			    </fieldset>	
			  </div>
			</div>
		</div>	
	</div>
</body>
</html>