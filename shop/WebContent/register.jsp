<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String path = request.getParameter("path");
    if(path == null){
    	 path = "register_table.jsp" ;
    }
       %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
@import "css/register.css"
</style>
<title>Insert title here</title>
</head>
<body>
  <div class="Top_bar">
    <jsp:include page="Top_bar.jsp"></jsp:include>
  </div>
  <div class="register_table">
    <jsp:include page =<% out.print(path); %> ></jsp:include>
  </div>

</body>
</html>