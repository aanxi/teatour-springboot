<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<style>
div.newProdRevDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.newProdRevNewProdInfoImg {
	border: 1px solid #E7E7E7;
	width: 464px;
	text-align: center;
	float: left;
}

div.newProdRevNewProdInfoRightDiv {
	overflow: hidden;
	border-top: 1px solid #E7E7E7;
	padding: 30px 20px;
}

div.newProdRevNewProdInfoRightText {
	color: black;
	font-size: 16px;
	font-weight: bold;
}

table.newProdRevNewProdInfoTable {
	margin: 20px 10px;
	font-size: 12px;
}

table.newProdRevNewProdInfoTable td {
	padding-bottom: 5px;
	color: #999999;
}

span.newProdRevNewProdInfoTablePrice {
	color: #FF0036;
	font-size: 20px;
	font-weight: bold;
}

span.newProdRevNewProdInfoTableSellNumber {
	color: #FF0036;
	font-size: 14px;
	font-weight: bold;
}

div.newProdRevNewProdInfoRightBelowDiv {
	border: 1px solid #F6F5F3;
	background-color: #FDFBFA;
	height: 166px;
	padding: 16px 0px 16px 81px;
}

span.newProdRevNewProdInfoRightBelowImg {
	background-color: white;
	border: 1px solid #E1E1E1;
	display: inline-block;
	width: 23px;
	height: 42px;
	background-image: url(/img/fore/newProdRevLight.png);
	background-repeat: no-repeat;
	padding: 0px;
}

img {
	vertical-align: baseline;
}

span.newProdRevNewProdInfoRightBelowText {
	border: 1px solid #EFEFEF;
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

div.newProdRevStasticsDiv {
	margin-top: 20px;
}

div.newProdRevStasticsLeft {
	width: 180px;
	float: left;
}

div.newProdRevStasticsLeftTop {
	background-color: #FF0036;
	height: 6px;
}

div.newProdRevStasticsLeftContent {
	line-height: 29px;
	border-left: 1px solid #D5D4D4;
	border-right: 1px solid #D5D4D4;
	background-color: #F6F5F1;
	text-align: center;
	font-size: 14px;
	color: #363535;
	font-weight: bold;
}

div.newProdRevStasticsLeftFoot {
	height: 6px;
	border-left: 1px solid #D5D4D4;
	border-bottom: 1px solid #D5D4D4;
	background-color: #F6F5F1;
}

span.newProdRevStasticsNumber {
	color: #284CA5;
}

div.newProdRevStasticsRight {
	overflow: hidden;
}

div.newProdRevStasticsRightEmpty {
	height: 35px;
}

div.newProdRevStasticsFoot {
	background-color: #F6F5F1;
	border: 1px solid #D5D4D4;
	border-left-width: 0px;
	height: 6px;
}

div.makeNewProdRevDiv {
	border: 1px solid #D1CCC8;
	margin: 20px 0px;
	background-color: #EFEFEF;
}

div.makeNewProdRevText {
	font-size: 16px;
	color: #333333;
	font-weight: bold;
	margin: 20px 40px;
}

table.makeNewProdRevTable {
	margin: 20px 40px;
	font-size: 12px;
}

table.makeNewProdRevTable td {
	border: 1px solid #E7E7E7;
	padding: 10px;
	background-color: white;
}

table.makeNewProdRevTable textarea {
	border-width: 0px;
	resize: none;
	width: 420px;
	height: 120px;
}

td.makeNewProdRevTableFirstTD {
	background-color: #F6F6F6;
}

div.makeNewProdRevButtonDiv {
	background-color: white;
	text-align: center;
	padding: 15px;
}

div.makeNewProdRevButtonDiv button {
	width: 72px;
	height: 26px;
	border-radius: 2px;
	background-color: #FF0036;
	color: white;
	border-width: 0px;
	font-weight: bold;
}

div.newProdRevDate {
	width: 100px;
}

div.newProdRevDivlistNewProdRevsEach div {
	display: inline-block;
}

div.newProdRevDate {
	color: #CCCCDD;
}

div.newProdRevContent {
	color: #333333;
	width: 698px;
}

div.newProdRevUserInfo {
	color: #333333;
}

div.newProdRevDivlistNewProdRevsEach {
	padding: 20px;
	border-bottom: 1px solid #ECECEC;
}
div.infoInimgAndInfo div.newProdSubTitle {
	color: #DD2727;
	font-size: 16px;
	margin: 0px 10px;
}

span.newProdRevUserInfoAnonymous {
	color: #CCCCDD;
	margin-left: 5px;
}
</style>

<div class="newProdRevDiv">
	<div class="newProdRevNewProdInfoDiv">
		<div class="newProdRevNewProdInfoImg">
			<img width="400px" height="400px"
				src="img/newProd/${newProd.id}.jpg">
		</div>
		<div class="newProdRevNewProdInfoRightDiv">
			<div class="newProdRevNewProdInfoRightText">${newProd.name}</div>
			<div class="newProdSubTitle">具体描述:<br>${newProd.sub_title}</div>
			<table class="newProdRevNewProdInfoTable">
				<tr>
					<td width="75px">价格:</td>
					<td><span class="newProdRevNewProdInfoTablePrice">￥${newProd.price}</span>
						元</td>
				</tr>
			</table>
		</div>
		<div style="clear: both"></div>
	</div>
	<div class="newProdRevStasticsDiv">
		<div class="newProdRevStasticsLeft">
			<div class="newProdRevStasticsLeftTop"></div>
			<div class="newProdRevStasticsLeftContent">
				已有<span class="newProdRevStasticsNumber">
					${newProd.newProdRevCount}</span>人为此新品投票
			</div>
			<div class="newProdRevStasticsLeftFoot"></div>
		</div>
		<div class="newProdRevStasticsRight">
			<div class="newProdRevStasticsRightEmpty"></div>
			<div class="newProdRevStasticsFoot"></div>
		</div>
	</div>

	<c:if test="${param.showonly==true}">
		<div class="newProdRevDivlistNewProdRevs">
			<c:forEach items="${newProdRevs}" var="r">
				<div class="newProdRevDivlistNewProdRevsEach">
					<div class="newProdRevDate">${r.createDate}</div>
					<div class="newProdRevContent">${r.content}</div>
					<div class="newProdRevUserInfo pull-right">${r.user.anonymousName}<span
							class="newProdRevUserInfoAnonymous">(匿名)</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<c:if test="${param.showonly!=true}">
		<div class="makeNewProdRevDiv">
			<form method="post" action="donewProdRev">
				<div class="makeNewProdRevText">这个新品非常需要你的建议！</div>
				<table class="makeNewProdRevTable">
					<tr>
						<td class="makeNewProdRevTableFirstTD">为新品打分并写下你的建议</td>
						<td><textarea name="content"></textarea></td>
					</tr>
				</table>
				<div class="makeNewProdRevButtonDiv">
					<input type="hidden" name="order_id" value="${order.id}"> <input
						type="hidden" name="newProd_id" value="${newProd.id}">
					<button type="submit">提交</button>
				</div>
			</form>
		</div>
	</c:if>
</div>

<%@include file="include/footer.jsp"%>