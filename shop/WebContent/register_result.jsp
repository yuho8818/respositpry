<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String status = (String)request.getAttribute("status"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import "css/register_result.css"
</style>
<title>Insert title here</title>
</head>
<body>

   <div class="Top_bar">
    <jsp:include page="Top_bar.jsp"></jsp:include>
   </div>
   
   <div class="title">用户注册</div>
    
   <div class="line"></div>
   
   
   <div class="middle">
   <div class="imformation">
        <div>
        <img alt="" src="">
       <h2> <%out.println(status); %></h2>
        </div>
        <a href="home.jsp">跳转到主页</a>
   </div>
   </div>
</body>
</html>