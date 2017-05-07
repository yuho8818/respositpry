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
<title>购物车</title>
</head>
<body>
  
     <jsp:include page="Top_bar.jsp"></jsp:include>
  
	<div id="top">
		<center>
			<h1>购物车</h1>
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
				<div
					style="padding-right: 3%; padding-left: 5%; width: 92%; height: 100%;">
					<div align="center">
						<div id="title" align="left">
							<table width="90%" >
							</table>
							<form method="post" name="forwarder" id="forwarder">
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

                                             ArrayList<Goods> list =(ArrayList)session.getAttribute("list");
											for (int i = 0; i < list.size(); i++) {
												Goods goods = list.get(i);
									%>

									<tr>
										<td width="10px" id="click<%=i%>"><input type="checkbox" click="clicked()" name=item></td>
										<td width="100px"><a
											href="details.jsp?id=<%=goods.getId()%>"><img
												src="images/<%=goods.getPicture()%>" width="120" height="90"
												border="1" /></a></td>
										<td width="180px"><center><%=goods.getName()%></center></td>
										<td width="90px"><center><%=goods.getPrice()%></center></td>
										<td width="150px"><center>
												<input type="text" size="2" value=<%=goods.getNumber()%>>
											</center></td>
										<td width="100px"><center><%=goods.getPrice() * goods.getNumber()%></center></td>
										<td colspan="2" width="150px"><a
											href="shoppingcart?action=deleteall">删除全部</a></td>
									</tr>

									<%
										}
										
									%>
								</table>
								<input type=Submit value="结算">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="bottom">
			
			<a href=""></a>
		</div>
		<div align="center">
			<hr>
			<font size="2" color="black"> <linl:copyright startY="2014"
					user="linl" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="swarding99@163.com">联系我们</a>
			</font>
		</div>
	</div>
</body>
</html>