<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="pojo.Goods"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src=""></script>
<style type="text/css">
@import "css/cart.css"
</style>
<title>Information</title>

<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
		<title>个人资料</title>
        <script type="text/javascript" src="js/editpasswd.js"></script>
		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/stepstyle.css" rel="stylesheet" type="text/css">
        <link href="css/infstyle.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>	
	</head>

	<body>
		<jsp:include page="Top_bar.jsp"></jsp:include>
        <jsp:include page="Search_bar.jsp"></jsp:include>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="home.jsp">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>抠搜尽享更多福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong> / <small>Password</small></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="user-infoPic">

							<div class="filePic">
								<img class="am-circle am-img-thumbnail" src="img/getAvatar.do.jpg" alt="" />
							</div>

							<p class="am-form-help">头像</p>

							<div class="info-m">
								<div><b>用户名：<i>小叮当</i></b></div>
                                <div class="safeText">
                                  	<a href="safety.html">账户安全:<em id="safe1" style="margin-left:20px ;"></em>分</a>
									<div class="progressBar"><span style="left: -95px;" class="progress"></span></div>
								</div>
							</div>
					</div>
					<script type="text/javascript">	
		              function safety(){
		    	       var passwd1=document.getElementById("passwd2");
		    	       int sizePasswd1=passwd1.value.length;
		    	       int score=sizepasswd1*10;
		    	       document.getElementById("safe1").value=score;
		    	alert("密码长度必须大于六位！");
		    }
		</script>	
					<form id="editpasswd" action="user" method="post" class="am-form am-form-horizontal" name="safeForm">
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">原密码</label>
							<div class="am-form-content">
								<input class="required" type="password" name="oldPasswd" maxlength="50" id="user-old-password" placeholder="请输入原登录密码">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">新密码</label>
							<div class="am-form-content">
								<input id="passwd1" class="required" type="password" name="passwd1" maxlength="50" placeholder="由数字、字母组合">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							<div class="am-form-content">
								<input id="passwd2" class="required" type="password" name="passwd2" maxlength="50" placeholder="请再次输入上面的密码" onkeyup="safety()">
							</div>
						</div>
						<div class="info-btn">
							<input type="hidden" name="action" value="editpasswd">
							<input class="am-btn am-btn-danger" type="submit" value="保存修改">
						</div>

					</form>

				</div>
			</div>

			<aside class="menu">
				<ul>
					<li class="person active">
						<a href="index.html"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="showinf.jsp">个人信息</a></li>
							<li> <a href="editinf.jsp">修改信息</a></li>
							<li> <a href="editpasswd.jsp">修改密码</a></li>
							<li> <a href="editAddress.jsp">地址管理</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="order.html">订单管理</a></li>
							<li> <a href="change.html">退款售后</a></li>
							<li> <a href="comment.html">评价商品</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-dollar"></i>我的资产</p>
						<ul>
							<li> <a href="points.html">我的积分</a></li>
							<li> <a href="coupon.html">优惠券 </a></li>
							<li> <a href="bonus.html">红包</a></li>
							<li> <a href="walletlist.html">账户余额</a></li>
							<li> <a href="bill.html">账单明细</a></li>
						</ul>
					</li>

					<li class="person">
						<p><i class="am-icon-tags"></i>我的收藏</p>
						<ul>
							<li> <a href="collection.html">收藏</a></li>
							<li> <a href="foot.html">足迹</a></li>														
						</ul>
					</li>

					<li class="person">
						<p><i class="am-icon-qq"></i>在线客服</p>
						<ul>
							<li> <a href="consultation.html">商品咨询</a></li>
							<li> <a href="suggest.html">意见反馈</a></li>							
							
							<li> <a href="news.html">我的消息</a></li>
						</ul>
					</li>
				</ul>

			</aside>
		</div>

	</body>

</html>