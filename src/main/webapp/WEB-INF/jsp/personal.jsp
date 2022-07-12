<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>

<meta charset="UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/myorder.css" />


<style>
div.Bott {
	min-height:270px;
}
</style>

<div class="Bott">
	<div class="wrapper clearfix">
		<div class="zuo fl">

				<a href="#"><img src="img/tx.png" /></a>
				<p class="clearfix">
					<span class="fl"><c:if test="${!empty sessionScope.user}">
							<span>Hi，${sessionScope.user.name}</span>
							<span class="fr"><a href="logout">退出</a></span>
						</c:if></span>
				</p>

			<div>
				<ul>
					<li class="on">
					<li><a href="bought">我的订单</a></li>
					<li class="on">
					<li><a href="appointed">我的预约</a></li>
				</ul>
			</div>
		</div>
<%@include file="include/footer.jsp"%>

<script src="js/jquery-1.12.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>