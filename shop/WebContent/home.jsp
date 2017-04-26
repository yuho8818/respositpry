 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src=""></script>
<style type="text/css">
@import "css/home.css"
</style>
<title>主页</title>
</head>
<body>
  
    <jsp:include page="Top_bar.jsp"></jsp:include>
  
  
    <div class="img">
       <img alt="主页面图片" src="img/home.jpg">
    </div>
    
  <div class="Search_bar" >
    <jsp:include page="Search_bar.jsp"></jsp:include>
  </div>
  

   <jsp:include page="login.jsp"></jsp:include>

  
  
</body>
</html>