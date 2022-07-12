<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>

<style>

	li, ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

	div.floor-line-con {
	margin-top: 20px;
	height: 330px;
	/*position: relative;*/
	float: left;
	overflow: hidden;
}

div.floor-line-con i {
	background-color: #0AA6E8;
	width: 5px;
	height: 18px;
	display: inline-block;
	vertical-align: middle;
}

.floor-name {
	margin-left: 10px;
	display: inline-block;
	font-size: 18px;
	color: #000000;
	height: 28px;
	vertical-align: middle;
}

.grid {
	margin-left: 13px;
	text-align: center;
}

.productItem {
	display: block;
	float: left;
	width: 233px;
	height: 300px;
	border: 1px solid #FFFFFF;
}

.productItem:hover {
	border: 1px solid #FF0036;
}

.floor-item-img {
	margin-top: 20px;
	position: relative;
	width: 185px;
	height: 185px;
}

.floor-item-title {
	width: 135px;
	height: 40px;
	font-size: 14px;
	color: #333333;
	line-height: 20px;
	overflow: hidden;
	margin: 8px auto;
}

.floor-price {
	font-size: 18px;
	color: #FF0036;
	line-height: 18px;
	margin: 10px auto;
}

</style>

<%-- 轮播 --%>
<div class="category-con">
	<div class="workArea">

		<div style="clear: both;"></div>

		<div data-ride="carousel" class="carousel-of-product carousel"
			id="carousel-of-product">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li class="active" data-slide-to="0"
					data-target="#carousel-of-product"></li>
				<li data-slide-to="1" data-target="#carousel-of-product" class=""></li>
				<li data-slide-to="2" data-target="#carousel-of-product" class=""></li>

			</ol>
			<!-- Wrapper for slides -->
			<div role="listbox" class="carousel-inner">
				<div class="item active">
					<img src="img/fore/carousel1.jpg" class="carousel carouselImage" height="748" width="2000">
				</div>
				<div class="item">
					<img src="img/fore/carousel2.jpg" class="carouselImage" height="748" width="2000">
				</div>
				<div class="item">
					<img src="img/fore/carousel3.jpg" class="carouselImage" height="748" width="2000">
				</div>
			</div>
		</div>
	</div>
</div>
<div style="clear: both;"></div>

<div class="new-floor-con">
	<div class="workArea">
		<c:forEach items="${categories}" var="c" varStatus="sts">

			<%-- 该分类下有产品才能显示 --%>
			<c:if test="${!empty c.products}">
				<c:if test="${sts.count<=100}">
					<div class="floor-line-con">
						<i class="color-mark"></i>
						<div class="floor-name">${c.name}</div>
						<br>
						<c:forEach items="${c.products}" var="p" varStatus="st">
							<c:if test="${st.count<=100}">
								<a class="grid" href="showProduct?product_id=${p.id}">
									<div class="productItem">
										<img class="floor-item-img" src="img/product/${p.id}/1.jpg">
										<div class="floor-item-title">${p.name}</div>
										<div class="floor-price">${p.price}</div>
									</div>
								</a>
							</c:if>
						</c:forEach>

					</div>
					<div style="clear: both;"></div>
				</c:if>
			</c:if>
		</c:forEach>
	</div>
</div>
<div style="clear: both;"></div>


<%@include file="include/footer.jsp"%>
