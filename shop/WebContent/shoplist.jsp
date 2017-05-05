<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@import "css/shoplist.css"
</style>
<script type="text/javascript">

 function topage(currentpage) {
  var form = document.forms[1];
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
   <jsp:include page="Search_bar.jsp"></jsp:include>
   
   <div class="shoplist">
   
   <form action="pageServlet" method="post">
   
   
       <input type="hidden" name="currentpage" />
       <table class="shoplist" >
									

									<!-- 商品循环开始 -->
									<%

                                             ArrayList<Goods> list =(ArrayList)request.getAttribute("list");
											 if(list.size()>=8){
									%>
                                    <%for(int i=0;i<2;i++){ %>
									<tr>
									   <%for(int j=0;j<4;j++){ %>
									   
										<td >
										<div class="goods">
										<img alt="" src="img/eg.jpg" >
										<% String names1 = list.get(i*4+j).getName();%>
										<div style="height:25px;"><span class="price"><font ><strong>$<%out.print(list.get(i*4+j).getPrice()); %></strong></font></span>
										<span class="stock"><font>库存<%out.print(list.get(i*4+j).getNumber()); %></font></span> </div>
										<div><%out.print(names1); %></div>
										<div ><span >发货地:<%out.print(list.get(i*4+j).getCity()); %></span>
										<span><a class="button" href="shoppingcart?action=addgoods&id=<%= list.get(i*4+j).getId()%>">加入购物车</a></span></div>
										</div>
										</td>
										<%} %>
																
									</tr>
                                     <%} %>
									<%}else if(list.size()>4){ %>
										<tr>
										 <%for(int j =0;j<4;j++){ %>
										  <td>
										  <img alt="" src="img/eg.jpg" >
										  <div><span>$<%out.print(list.get(j).getPrice()); %></span>
										  <span>库存<%out.print(list.get(j).getNumber()); %></span> </div>
										  <div><%out.print(list.get(j).getName()); %></div>
										  <div>发货地：<%out.print(list.get(j).getCity()); %></div>
										  <a class="button" href="">加入购物车</a>
										  </td>
										  <%} %>		
										</tr>
										<tr>
										<%for(int i=0;i<list.size()-4;i++){ %>									
										   <td>
										  <img alt="" src="img/eg.jpg" >
										  <div><span>$<%out.print(list.get(i).getPrice()); %></span>
										  <span>库存<%out.print(list.get(i).getNumber()); %></span> </div>
										  <div><%out.print(list.get(i).getName()); %></div>
										  <div>发货地：<%out.print(list.get(i).getCity()); %></div>
										  <a class="button" href="">加入购物车</a>
										  </td>			
										<%} %>
										</tr>
									<%}else if(list.size()<=4){ %>
									<tr>
									   <%for(int i=0;i<list.size();i++){ %>
									      <td>
										  <img alt="" src="img/eg.jpg" >
										  <div><span>$<%out.print(list.get(i).getPrice()); %></span>
										  <span>库存<%out.print(list.get(i).getNumber()); %></span> </div>
										  <div><%out.print(list.get(i).getName()); %></div>
										  <div>发货地：<%out.print(list.get(i).getCity()); %></div>
										  <a class="button" href="">加入购物车</a>
										  </td>	
										  <%} %>
								    </tr>
									<%} %>

								</table>
<div align="right" style="width:40%;margin-left:65%;vertical-align:bottom;">
     <c:forEach begin="${pageView.startindex}" end="${pageView.endindex}"
   var="wp">
   <c:if test="${pageView.currentpage==wp}">
    <a class="page" >${wp}</a>
   </c:if>
   <c:if test="${pageView.currentpage!=wp}">
   
    <a class="page" href="javascript:topage('${wp}')">${wp}</a>

   </c:if>
  </c:forEach>
       <div style="float:left;vertical-align:bottom;">  总共${pageView.totalpagenumber}页</div>                      
    </div>					
	</form>		 
   </div>

</body>
</html>