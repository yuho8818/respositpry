<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
</script>
<!-- 

 -->
<style type="text/css">
@import
"css/cart.css"
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
							<li><a class="top" href="user?action=show">我的信息</a>
								<p>
							<li><a class="top" href="user?action=edit">修改基本信息</a>
								<p>
							<li><a class="top" href="user/editpasswd.jsp">修改密码</a>
						</ul>
						<p>
						<div id="title">购物车</div>
						<ul>
							<li><a class="top" href="shoppingcart?action=lookbus">购物车</a>
								<p>
							<li><a class="top" href="shoppingcart?action=lookpaied">已购买的宝贝</a>
								<p>
						</ul>
					</div>
				</div>
				<div id="right" align="left" style="width: 80%; height: 100%">
					<div
						style="padding-right: 3%; padding-left: 5%; width: 92%; height: 100%;">
						<div align="center">
							<div id="title" align="left">
								<%
									ArrayList<Goods> paied = (ArrayList) session.getAttribute("paied");
									if (paied.size()!=0) {
								%>
								<table width="90%">

									<tr style="text-align: center">
										<td width="100px">图片</td>
										<td width="180px">宝贝详细</td>
										<td width="90px">单价（元）</td>
										<td width="150px">数量</td>
										<td width="100px">总计（元）</td>
									</tr>


									<%
										for (int i = 0; i < paied.size(); i++) {
												Goods goods = paied.get(i);
									%>

									<tr>
										<td width="100px"><a class="top"
											href="details.jsp?id=<%=goods.getId()%>"><img
												src="images/<%=goods.getPicture()%>" width="120" height="90"
												border="1" /></a></td>
										<td width="150px"><center><%=goods.getName()%></center></td>
										<td width="90px"><center><%=goods.getPrice()%></center></td>
										<td width="120px">
											<center>
											<%=goods.getNumber()%>
											</center>
										</td>
										<td width="80px"><%=goods.getPrice() * goods.getNumber()%>
										</td>
										
									</tr>

									<%
										}
									%>
								</table>

								<%
									} else {
										out.print("<center><h1>未购买任何物品！</h1></center>");
									}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</body>
</html>