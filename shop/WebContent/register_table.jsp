<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
@import "css/register_table.css"
</style>
<title>Insert title here</title>
</head>
<body>
    
    <div class="Top_bar">
    <jsp:include page="Top_bar.jsp"></jsp:include>
    </div>
    
   <div class="title"><img src="img/logo.jpg"/>用户注册</div>
    
   <div class="line"></div>
   
   <div class="middle">
   <form id="register_form" action="RegisterServlet" method="post">
    <table class="register_imformation">
    <tr>
    <td class="text">用户名：&nbsp; </td>
    <td><input type="text" name="username" class="username" id="username"  /></td>
    </tr>
    
    <tr>
    <td class="text">密 &nbsp;&nbsp;码： </td>
    <td><input type="password" name="password" class="password" id="password"/></td>
    </tr>
    
    
    <tr>
    <td class="text">手机号：&nbsp; </td>
    <td><input type="text" name="phone" class="phone" id="phone"/></td>
    </tr>   
    </table>
    
      <!--  <button class="register">注册</button>-->
      <div style="margin-top:30px;">
      <a class="button" href="javascript:document:register_form.submit();">注册</a>
      </div>
  </form>
   </div>
</body>
</html>