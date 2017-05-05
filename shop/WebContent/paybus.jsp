<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
	ArrayList<Goods> list = (ArrayList) session.getAttribute("list");
	String[] item=request.getParameterValues("item");
	int total=0;
	for(int i=0;i<item.length;i++){
		total+=list.get(Integer.parseInt(item[i])).getPrice()*list.get(Integer.parseInt(item[i])).getNumber();
	}
	out.print(total);
%>
</body>
</html>