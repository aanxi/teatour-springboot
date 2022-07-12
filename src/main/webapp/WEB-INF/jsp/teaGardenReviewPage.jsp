<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<style>
div.teaGardenReviewDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.teaGardenReviewTeaGardenInfoImg {
	bappointment: 1px solid #E7E7E7;
	width: 464px;
	text-align: center;
	float: left;
}

div.teaGardenReviewTeaGardenInfoRightDiv {
	overflow: hidden;
	bappointment-top: 1px solid #E7E7E7;
	padding: 30px 20px;
}

div.teaGardenReviewTeaGardenInfoRightText {
	color: black;
	font-size: 16px;
	font-weight: bold;
}

table.teaGardenReviewTeaGardenInfoTable {
	margin: 20px 10px;
	font-size: 12px;
}

table.teaGardenReviewTeaGardenInfoTable td {
	padding-bottom: 5px;
	color: #999999;
}

span.teaGardenReviewTeaGardenInfoTablePrice {
	color: #FF0036;
	font-size: 20px;
	font-weight: bold;
}

span.teaGardenReviewTeaGardenInfoTableSellNumber {
	color: #FF0036;
	font-size: 14px;
	font-weight: bold;
}

div.teaGardenReviewTeaGardenInfoRightBelowDiv {
	bappointment: 1px solid #F6F5F3;
	background-color: #FDFBFA;
	height: 166px;
	padding: 16px 0px 16px 81px;
}

span.teaGardenReviewTeaGardenInfoRightBelowImg {
	background-color: white;
	bappointment: 1px solid #E1E1E1;
	display: inline-block;
	width: 23px;
	height: 42px;
	background-image: url(/img/fore/teaGardenReviewLight.png);
	background-repeat: no-repeat;
	padding: 0px;
}

img {
	vertical-align: baseline;
}

span.teaGardenReviewTeaGardenInfoRightBelowText {
	bappointment: 1px solid #EFEFEF;
	display: inline-block;
	width: 200px;
	height: 42px;
	padding: 4px;
	position: relative;
	left: -4px;
	top: -5px;
	color: #666666;
	font-size: 12px;
}

div.teaGardenReviewStasticsDiv {
	margin-top: 20px;
}

div.teaGardenReviewStasticsLeft {
	width: 180px;
	float: left;
}

div.teaGardenReviewStasticsLeftTop {
	background-color: #FF0036;
	height: 6px;
}

div.teaGardenReviewStasticsLeftContent {
	line-height: 29px;
	bappointment-left: 1px solid #D5D4D4;
	bappointment-right: 1px solid #D5D4D4;
	background-color: #F6F5F1;
	text-align: center;
	font-size: 14px;
	color: #363535;
	font-weight: bold;
}

div.teaGardenReviewStasticsLeftFoot {
	height: 6px;
	bappointment-left: 1px solid #D5D4D4;
	bappointment-bottom: 1px solid #D5D4D4;
	background-color: #F6F5F1;
}

span.teaGardenReviewStasticsNumber {
	color: #284CA5;
}

div.teaGardenReviewStasticsRight {
	overflow: hidden;
}

div.teaGardenReviewStasticsRightEmpty {
	height: 35px;
}

div.teaGardenReviewStasticsFoot {
	background-color: #F6F5F1;
	bappointment: 1px solid #D5D4D4;
	bappointment-left-width: 0px;
	height: 6px;
}

div.makeTeaGardenReviewDiv {
	bappointment: 1px solid #D1CCC8;
	margin: 20px 0px;
	background-color: #EFEFEF;
}

div.makeTeaGardenReviewText {
	font-size: 16px;
	color: #333333;
	font-weight: bold;
	margin: 20px 40px;
}

table.makeTeaGardenReviewTable {
	margin: 20px 40px;
	font-size: 12px;
}

table.makeTeaGardenReviewTable td {
	bappointment: 1px solid #E7E7E7;
	padding: 10px;
	background-color: white;
}

table.makeTeaGardenReviewTable textarea {
	bappointment-width: 0px;
	resize: none;
	width: 420px;
	height: 120px;
}

td.makeTeaGardenReviewTableFirstTD {
	background-color: #F6F6F6;
}

div.makeTeaGardenReviewButtonDiv {
	background-color: white;
	text-align: center;
	padding: 15px;
}

div.makeTeaGardenReviewButtonDiv button {
	width: 72px;
	height: 26px;
	bappointment-radius: 2px;
	background-color: #FF0036;
	color: white;
	bappointment-width: 0px;
	font-weight: bold;
}

div.teaGardenReviewDate {
	width: 100px;
}

div.teaGardenReviewDivlistTeaGardenReviewsEach div {
	display: inline-block;
}

div.teaGardenReviewDate {
	color: #CCCCDD;
}

div.teaGardenReviewContent {
	color: #333333;
	width: 698px;
}

div.teaGardenReviewUserInfo {
	color: #333333;
}

div.teaGardenReviewDivlistTeaGardenReviewsEach {
	padding: 20px;
	bappointment-bottom: 1px solid #ECECEC;
}

span.teaGardenReviewUserInfoAnonymous {
	color: #CCCCDD;
	margin-left: 5px;
}
</style>

<div class="teaGardenReviewDiv">
	<div class="teaGardenReviewTeaGardenInfoDiv">
		<div class="teaGardenReviewTeaGardenInfoImg">
			<img width="400px" height="400px"
				src="img/teaGarden/${teaGarden.id}/1.jpg">
		</div>
		<div class="teaGardenReviewTeaGardenInfoRightDiv">
			<div class="teaGardenReviewTeaGardenInfoRightText">${teaGarden.name}</div>
			<table class="teaGardenReviewTeaGardenInfoTable">
				<tr>
					<td width="75px">价格:</td>
					<td><span class="teaGardenReviewTeaGardenInfoTablePrice">￥${teaGarden.price}</span>
						元</td>
				</tr>
				<tr>
<%--					<td>配送</td>--%>
<%--					<td>快递: 0.00</td>--%>
				</tr>
				<tr>
					<td>本月累计体验:</td>
					<td><span class="teaGardenReviewTeaGardenInfoTableSellNumber">${teaGarden.sale}</span>
						人次</td>
				</tr>
			</table>

			<div class="teaGardenReviewTeaGardenInfoRightBelowDiv">
				<span class="teaGardenReviewTeaGardenInfoRightBelowImg"><img
					src="img/fore/teaGardenReviewLight.png"></span> <span
					class="teaGardenReviewTeaGardenInfoRightBelowText" style="margin-top: 2px;">
					您所预约茶旅的信息于${appointment.create_date}下单预约了此次茶旅体验 </span>
			</div>
		</div>
		<div style="clear: both"></div>
	</div>
	<div class="teaGardenReviewStasticsDiv">
		<div class="teaGardenReviewStasticsLeft">
			<div class="teaGardenReviewStasticsLeftTop"></div>
			<div class="teaGardenReviewStasticsLeftContent">
				累计评价 <span class="teaGardenReviewStasticsNumber">
					${teaGarden.teaGardenReviewCount}</span>
			</div>
			<div class="teaGardenReviewStasticsLeftFoot"></div>
		</div>
		<div class="teaGardenReviewStasticsRight">
			<div class="teaGardenReviewStasticsRightEmpty"></div>
			<div class="teaGardenReviewStasticsFoot"></div>
		</div>
	</div>

	<c:if test="${param.showonly==true}">
		<div class="teaGardenReviewDivlistTeaGardenReviews">
			<c:forEach items="${teaGardenReviews}" var="r">
				<div class="teaGardenReviewDivlistTeaGardenReviewsEach">
					<div class="teaGardenReviewDate">${r.createDate}</div>
					<div class="teaGardenReviewContent">${r.content}</div>
					<div class="teaGardenReviewUserInfo pull-right">${r.user.anonymousName}<span
							class="teaGardenReviewUserInfoAnonymous">(匿名)</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<c:if test="${param.showonly!=true}">
		<div class="makeTeaGardenReviewDiv">
			<form method="post" action="doteaGardenReview">
				<div class="makeTeaGardenReviewText">我们需要你的建议哦！</div>
				<table class="makeTeaGardenReviewTable">
					<tr>
						<td class="makeTeaGardenReviewTableFirstTD">评价本次茶旅体验</td>
						<td><textarea name="content"></textarea></td>
					</tr>
				</table>
				<div class="makeTeaGardenReviewButtonDiv">
					<input type="hidden" name="appointment_id" value="${appointment.id}"> <input
						type="hidden" name="teaGarden_id" value="${teaGarden.id}">
					<button type="submit">提交评价</button>
				</div>
			</form>
		</div>
	</c:if>
</div>

<%@include file="include/footer.jsp"%>