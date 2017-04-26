<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

 function topage(currentpage) {
  var form = document.forms[0];
  form.currentpage.value = currentpage;
  form.submit();
 }
</script>
<script type="text/javascript" src=""></script>
<style type="text/css">
@import ""
</style>
<title>商品列表</title>
</head>
<body>
   <jsp:include page="Top_bar.jsp"></jsp:include>
   <div class="shoplist">
   <form action="pageServlet" method="post">
       <input type="hidden" name="currentpage" />
       <table width="90%">
									<tr style="text-align: center">
										<td width="10px">状态</td>
										<td width="100px">图片</td>
										<td width="180px">宝贝详细</td>
										<td width="90px">单价（元）</td>
										<td width="150px">数量</td>
										<td width="100px">总计（元）</td>
										<td colspan="2" width="150px">操作</td>
									</tr>

									<!-- 商品循环开始 -->
									<%

                                             ArrayList<Goods> list =(ArrayList)request.getAttribute("list");
											 if(list.size()>=6){
									%>
                                    <%for(int i=0;i<2;i++){ %>
									<tr>
										<td>
										<img alt="" src="img/" style="width:100px;height:100px;">
										<% String names1 = list.get(i*3).getName();%>
										<div><%out.print(names1);%>></div>
										</td>
										<td>
										<img alt="" src="img/" style="width:100px;height:100px;">
										<% String names2 = list.get(i*3+1).getName();%>
										<div><%out.print(names2); %>></div>
										</td>
										<td>
										<img alt="" src="img/" style="width:100px;height:100px;">
										<% String names3 = list.get(i*3+2).getName();%>
										<div><%out.print(names3); %>></div>
										</td>
										
										
									</tr>
                                     <%} %>
									<%}else if(list.size()>3){ %>
										<tr>
										  <td>
										  <img alt="" src="img/" style="width:100px;height:100px;">
										  <div><%out.print(list.get(0).getName()); %></div>
										  </td>
										  <td>
										  <img alt="" src="img/" style="width:100px;height:100px;">
										  <div><%out.print(list.get(1).getName()); %></div>
										  </td>
										  <td>
										  <img alt="" src="img/" style="width:100px;height:100px;">
										  <div><%out.print(list.get(2).getName()); %></div>
										  </td>							
										</tr>
										<tr>
										<%for(int i=0;i<list.size()-3;i++){ %>									
										   <td>
										  <img alt="" src="img/" style="width:100px;height:100px;">
										  <div><%out.print(list.get(i).getName()); %></div>
										  </td>			
										<%} %>
										</tr>
									<%}else if(list.size()<=3){ %>
									<tr>
									   <%for(int i=0;i<list.size();i++){ %>
									      <td>
										  <img alt="" src="img/" style="width:100px;height:100px;">
										  <div><%out.print(list.get(i).getName()); %></div>
										  </td>	
										  <%} %>
								    </tr>
									<%} %>

								</table>
<div align="right" style="width: 80%">
     <c:forEach begin="${pageView.startindex}" end="${pageView.endindex}"
   var="wp">
   <c:if test="${pageView.currentpage==wp}">
    <b>[${wp}]</b>
   </c:if>
   <c:if test="${pageView.currentpage!=wp}">
    <a href="javascript:topage('${wp}')">[${wp}]</a>
   </c:if>
  </c:forEach>
                            总共${pageView.totalpagenumber}页
    </div>					
	</form>		 
   </div>

</body>
</html>