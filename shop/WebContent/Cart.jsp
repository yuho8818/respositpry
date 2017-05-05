<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function clicked(i){
	
	var tr =  document.getElementById(i);
	var checkbox = document.getElementById("check"+i);
	var td = parseInt(tr.children[5].innerHTML);
	
	var total = parseInt(document.getElementById("totalCost").innerHTML);
	if(checkbox.checked){
		total = total + td;
	}else{
		total = total - td;
	}
	
	
	document.getElementById("totalCost").innerHTML = total;
}
</script>
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
		<form id="bus" name="bus" action="paybus.jsp" method="post">
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
						<div id="title">我的购物车</div>
						<ul>
							<li><a class="top" href="shoppingcart?action=lookbus">购物车</a>
								<p>
							<li><a class="top" href="shoppingcart?action=paid">已购买的宝贝</a>
								<p>
						</ul>
					</div>
				</div>
				<div id="right" align="left" style="width: 80%; height: 100%">
					<div
						style="padding-right: 3%; padding-left: 5%; width: 92%; height: 100%;">
						<div align="center">
							<div id="title" align="left">

								<table width="90%">
									<tr style="text-align: center">
										<td width="10px"></td>
										<td width="100px">图片</td>
										<td width="180px">宝贝详细</td>
										<td width="90px">单价（元）</td>
										<td width="150px">数量</td>
										<td width="100px">总计（元）</td>
										<td colspan="2" width="150px"></td>
									</tr>

									<!-- 商品循环开始 -->
									<%
										ArrayList<Goods> list = (ArrayList) session.getAttribute("list");
										session.setAttribute("list", list);
										for (int i = 0; i < list.size(); i++) {
											Goods goods = list.get(i);
									%>

									<tr id="<%=i%>">
										<td width="10px"><input type="checkbox" id="check<%=i%>"
											onclick="clicked(<%=i%>)" name="item" value="<%=i%>"></td>
										<td width="100px"><a class="top"
											href="details.jsp?id=<%=goods.getId()%>"><img
												src="images/<%=goods.getPicture()%>" width="120" height="90"
												border="1" /></a></td>
										<td width="150px"><center><%=goods.getName()%></center></td>
										<td width="90px"><center><%=goods.getPrice()%></center></td>
										<td width="120px">
											<center>
												<a class="top"
													href="shoppingcart?action=sub&id=<%=goods.getId()%>">-</a>
												<%=goods.getNumber()%>
												<a class="top"
													href="shoppingcart?action=add&id=<%=goods.getId()%>">+</a>
											</center>
										</td>
										<td width="80px"><%=goods.getPrice() * goods.getNumber()%>
										</td>
										<td colspan="4" width="100px"><a class="top"
											href="shoppingcart?action=delete&id=<%=goods.getId()%>">X</a></td>
									</tr>

									<%
										}
									%>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="bottom">
				<span>合计：</span><span id="totalCost">0</span> <a class="top" href="">结算</a>
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>