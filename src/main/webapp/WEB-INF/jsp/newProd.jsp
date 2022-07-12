<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>

<style>
.bigImg {
	width: 418px;
	height: 418px;
}

.smallImg {
	width: 56px !important;
	height: 56px;
	border: 2px solid white;
}

div.newProd {
	margin-top: 90px;
	/*	margin-left: 25%;*/
	/*margin-right: auto;
        margin-left: auto;*/
	position: relative;
	float: left;
	left: 50%;
}

div.imgAndInfo div.smallImageDiv {
	width: 80%;
	margin: 20px auto;
}

div.imgAndInfo img.smallImg:hover {
	border: 2px solid black;
}

div.imgAndInfo {
	width: 980px;
	height: 550px;
	display: inline-flex;
	position: relative;
	float: left;
	left: -50%;
}

div.imgInimgAndInfo {
	width: 420px;
	float: center;
}

div.imgInimgAndInfo img {
	width: 420px;
}

div.infoInimgAndInfo {
	padding: 0px 20px;
	overflow: hidden;
	width: 560px;
}

div.infoInimgAndInfo div.newProdTitle {
	color: black;
	font-size: 16px;
	font-weight: bold;
	margin: 0px 10px;
}

div.infoInimgAndInfo div.newProdSubTitle {
	color: #DD2727;
	font-size: 16px;
	margin: 0px 10px;
}

div.infoInimgAndInfo div.newProdPriceDiv {
	background-image: url(/img/fore/priceBackground.png);
	height: 85px;
	padding: 10px;
	color: #666666;
}

div.infoInimgAndInfo div.gouwujuanDiv {
	margin-top: 5px;
}

div.infoInimgAndInfo span.promotionPriceYuan {
	font-family: Arial;
	font-size: 18px;
	color: #FF0036;
}

div.infoInimgAndInfo span.promotionPrice {
	color: #FF0036;
	font-family: Arial;
	font-size: 30px;
	font-weight: bold;
}

div.infoInimgAndInfo span.promotionPriceDesc {
	color: #999999;
	display: inline-block;
	width: 68px;
	position: relative;
	left: 0px;
	top: -10px;
}

div.infoInimgAndInfo div.newProdSaleAndNewProdRevNumber {
	margin: 20px 0px;
	border-top: 1px dotted #C9C9C9;
	border-bottom: 1px dotted #C9C9C9;
	padding: 10px;
}

div.infoInimgAndInfo div.newProdSaleAndNewProdRevNumber div {
	display: inline-block;
	width: 49%;
	text-align: center;
	color: #999999;
	font-size: 12px;
}

div.infoInimgAndInfo div.newProdSaleAndNewProdRevNumber div:first-child {
	border-right: 1px solid #E5DFDA;
}

div.infoInimgAndInfo div.newProdNumber {
	color: #999999;
}

div.infoInimgAndInfo span.newProdNumberSettingSpan {
	border: 1px solid #999;
	display: inline-block;
	width: 43px;
	height: 32px;
	padding-top: 7px;
}

div.infoInimgAndInfo input.newProdNumberSetting {
	border: 0px;
	height: 80%;
	width: 80%;
}

div.newProdNumber span.updown img {
	display: inline-block;
	vertical-align: top;
}

div.newProdNumber span.updown {
	border: 1px solid #999;
	display: block;
	width: 20px;
	height: 14px;
	text-align: center;
	padding-top: 4px;
}

div.newProdNumber span.updownMiddle {
	height: 4px;
	display: block;
}

div.newProdNumber span.arrow {
	display: inline-block;
	width: 22px;
	height: 32px;
	vertical-align: top;
}

div.serviceCommitment {
	margin: 20px 0px;
}

div.infoInimgAndInfo span.serviceCommitmentDesc {
	color: #999999;
}

div.infoInimgAndInfo span.serviceCommitmentLink a {
	color: #666666;
}

div.buyDiv {
	margin: 20px auto;
	text-align: center;
}

div.buyDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

button.buyButton {
	border: 1px solid #FF0036;
	background-color: #FFEDED;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	color: #FF0036;
}

button.addCartButton {
	border: 1px solid #FF0036;
	background-color: #FF0036;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	color: white;
}

button.addCartButton span.glyphicon {
	font-size: 12px;
	margin-right: 8px;
}
</style>

<script>
    $(function () {
        $("img.smallImg").mouseenter(function () {
            var bigImgURL = $(this).attr("bigImgURL");
            $("img.bigImg").attr("src", bigImgURL);
        });
        
//         $("div.newProdNewProdRevDiv").hide();
//         $("a.newProdDetailTopNewProdRevLink").click(function () {
//             $("div.newProdNewProdRevDiv").show();
//             $("div.newProdDetailDiv").hide();
//         });
        $("a.newProdNewProdRevTopPartSelectedLink").click(function () {
            $("div.newProdNewProdRevDiv").hide();
            $("div.newProdDetailDiv").show();
        });
    });

</script>


<div class="newProd">
	<div class="imgAndInfo">
		<div class="imgInimgAndInfo">
			<img class="bigImg" src="img/newProd/${newProd.id}.jpg">
			<div class="smallImageDiv">
				<img class="smallImg" src="img/newProd/${newProd.id}.jpg"
					bigImgURL="img/newProd/${newProd.id}.jpg">
				<div class="img4load hidden"></div>
			</div>
		</div>

		<div class="infoInimgAndInfo">
			<div class="newProdTitle">${newProd.name}</div>
			<div class="newProdSubTitle">具体描述:<br>${newProd.sub_title}</div>
			<div class="newProdPrice">
				<div class="newProdPriceDiv">
					<div class="promotionDiv">
						<span class="promotionPriceDesc">价格建议</span> <span
							class="promotionPriceYuan">¥</span> <span class="promotionPrice">${newProd.price}</span>
					</div>
				</div>
			</div>
			<div class="newProdSaleAndNewProdRevNumber">
				<div>
					累计投票<span class="redColor boldWord">${newProd.newProdRevCount}</span>
				</div>
				<div>
					<span class="redColor boldWord" id="message">${message}</span>
				</div>
			</div>
			<script>
                function buyLink() {
					const check = $("#message").text();
					if(check == '您还未评价该新品') {
						window.location = "newProdRev?newProd_id="+${newProd.id};
					}
					else {
						window.alert(check);
						window.location = "showNewProd?newProd_id="+${newProd.id};
					}
                }
            </script>
			<div class="buyDiv">
				<a onclick="javascript:buyLink()" class="buyLink">
					<button class="buyButton">我来投票</button>
				</a>
			</div>
		</div>
		<div style="clear: both"></div>
	</div>
</div>
<div style="clear: both;"></div>

<style>

	a.selected {
	border-left: 1px solid #cfbfb1;
	border-right: 1px solid #cfbfb1;
	color: #FF0036;
	display: inline-block;
	font-weight: bold;
	line-height: 46px;
	width: 90px;
	text-align: center;
	position: relative;
}

a.selected:before {
	content: "";
	display: block;
	border-width: 1px;
	border-color: #FF0036;
	border-style: solid;
	width: 90px;
	height: 0;
	position: absolute;
	top: -1px;
	margin-left: -1px;
}

a.selected:after {
	content: "";
	display: block;
	border-color: #FF0036 transparent transparent;
	border-style: solid;
	border-width: 5px;
	width: 0;
	height: 0;
	position: absolute;
	top: -1px;
	left: 50%;
	margin-left: -5px;
}
	div.newProdParamterList span {
	display: block;
	width: 220px;
	float: left;
	padding: 8px 0px;
	color: #666666;
}

div.newProdDetailImagesPart img {
	display: block;
	width: 790px;
	margin: 20px 0px;
}

div.newProdNewProdRevDiv {
	width: 790px;
	margin: 40px auto;
}

div.newProdNewProdRevTopPart {
	border: 1px solid #DFDFDF;
}

a.newProdNewProdRevTopPartSelectedLink {
	padding: 0px 20px;
	color: #333333;
}

div.newProdNewProdRevContentPart {
	padding-top: 50px;
}

div.newProdNewProdRevItem {
	border-bottom: 1px solid #E3E3E3;
	margin: 10px 0px;
}

div.newProdNewProdRevContentPart {
	padding-top: 50px;
}

div.newProdNewProdRevItem {
	border-bottom: 1px solid #E3E3E3;
	margin: 10px 0px;
}

div.newProdNewProdRevItem div.newProdNewProdRevItemDesc {
	width: 80%;
	display: inline-block;
	color: #333333;
	margin: 5px 20px;
	float: left;
}

div.newProdNewProdRevItemDate {
	margin: 15px 0px 0px 0px;
	color: #CCCCCC;
}

div.newProdNewProdRevItem div.newProdNewProdRevItemUserInfo {
	color: #404040;
	margin: 5px 20px;
	padding: 20px 0;
}

span.userInfoGrayPart {
	color: #999999;
}
</style>

<div style="clear: both"></div>
<div class="newProdNewProdRevDiv" style="display: block;">
	<div class="newProdNewProdRevTopPart">
		<div class="newProdNewProdRevTopPart">
<%--			<a class="newProdNewProdRevTopPartSelectedLink" href="#nowhere">商品详情</a>--%>
			<a class="selected" href="#nowhere">累计评价 <span
				class="newProdNewProdRevTopNewProdRevLinkNumber">${newProd.newProdRevCount}</span>
			</a>
		</div>
		<div class="newProdNewProdRevContentPart">
			<c:forEach items="${newProdRevs}" var="r">
				<div class="newProdNewProdRevItem">
					<div class="newProdNewProdRevItemDesc">
						<div class="newProdNewProdRevItemContent">${r.content}</div>
						<div class="newProdNewProdRevItemDate">${r.createDate}</div>
					</div>
					<div class="newProdNewProdRevItemUserInfo">
						${r.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
					</div>
					<div style="clear: both"></div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>


<%@include file="include/footer.jsp"%>