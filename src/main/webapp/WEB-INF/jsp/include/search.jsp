<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%-- 首页搜索栏和logo图标 --%>
<div class="header">
	<div class="headerLayout workArea">

		<%-- 图片logo --%>
		<div class="logo">
			<a href="home"> </a>
			<img src="img/logo.png">
		</div>

		<%-- 搜索框 --%>
		<form class="mallSearch-input" action="searchProduct">
			<input name="keyword" type="text" placeholder="请输入关键词">
			<button type="submit" class="searchButton">搜索</button>
		</form>
		<ul class="hot-query">
			<li class="hot-query-li"><a href="home">首页</a></li>
			<li class="hot-query-li"><a href="showAllProduct">所有商品</a></li>
			<li class="hot-query-li"><a href="showAllTeaGarden">茶旅体验</a></li>
			<li class="hot-query-li"><a href="showAllNewProd">新品尝鲜</a></li>
			<li class="hot-query-li"><a href="showProductTrace">产品溯源</a></li>
		</ul>



	</div>
</div>

<div style="clear: both;" />

