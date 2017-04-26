<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import "css/User.css"
</style>
<title>用户</title>
</head>
<body>
    
    <jsp:include page="Top_bar.jsp"></jsp:include>
    

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
           
          <div id="right" >
             <form action="user" method="post">
             <div>原密码：<input name="oldPassword" id="oldPassword"/></div> 
              <div>新密码：<input name="newPassword" id="newPassword"/></div>
              <div>确认密码：<input id="newPassword1"/></div>
              <%System.out.println(session.getAttribute("username"));%>
              <input type="hidden" name="action" value="editpasswd">
							<input class="submit" type="submit" value="修&nbsp; 改">                          
             </form>
          </div>
</body>
</html>