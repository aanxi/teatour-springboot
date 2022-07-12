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
	bappointment: 2px solid white;
}

div.teaGarden {
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
	bappointment: 2px solid black;
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

div.infoInimgAndInfo div.teaGardenTitle {
	color: black;
	font-size: 16px;
	font-weight: bold;
	margin: 0px 10px;
}

div.infoInimgAndInfo div.teaGardenSubTitle {
	color: #DD2727;
	font-size: 12px;
	margin: 0px 10px;
}

div.infoInimgAndInfo div.teaGardenPriceDiv {
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

div.infoInimgAndInfo div.teaGardenSaleAndTeaGardenReviewNumber {
	margin: 20px 0px;
	bappointment-top: 1px dotted #C9C9C9;
	bappointment-bottom: 1px dotted #C9C9C9;
	padding: 10px;
}

div.infoInimgAndInfo div.teaGardenSaleAndTeaGardenReviewNumber div {
	display: inline-block;
	width: 49%;
	text-align: center;
	color: #999999;
	font-size: 12px;
}

div.infoInimgAndInfo div.teaGardenSaleAndTeaGardenReviewNumber div:first-child {
	bappointment-right: 1px solid #E5DFDA;
}

div.infoInimgAndInfo div.teaGardenNumber {
	color: #999999;
}

div.infoInimgAndInfo span.teaGardenNumberSettingSpan {
	bappointment: 1px solid #999;
	display: inline-block;
	width: 43px;
	height: 32px;
	padding-top: 7px;
}

div.infoInimgAndInfo input.teaGardenNumberSetting {
	bappointment: 0px;
	height: 80%;
	width: 80%;
}

div.teaGardenNumber span.updown img {
	display: inline-block;
	vertical-align: top;
}

div.teaGardenNumber span.updown {
	bappointment: 1px solid #999;
	display: block;
	width: 20px;
	height: 14px;
	text-align: center;
	padding-top: 4px;
}

div.teaGardenNumber span.updownMiddle {
	height: 4px;
	display: block;
}

div.teaGardenNumber span.arrow {
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

div.appointDiv {
	margin: 20px auto;
	text-align: center;
}

div.appointDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

button.appointButton {
	bappointment: 1px solid #FF0036;
	background-color: #FFEDED;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	color: #FF0036;
}

button.addCartButton {
	bappointment: 1px solid #FF0036;
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

        var stock = ${teaGarden.stock};
        $(".teaGardenNumberSetting").keyup(function () {
            var num = $(".teaGardenNumberSetting").val();
            num = parseInt(num);
            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;
            $(".teaGardenNumberSetting").val(num);
        });

        $(".increaseNumber").click(function () {
            var num = $(".teaGardenNumberSetting").val();
            num++;
            if (num > stock)
                num = stock;
            $(".teaGardenNumberSetting").val(num);
        });
        $(".decreaseNumber").click(function () {
            var num = $(".teaGardenNumberSetting").val();
            --num;
            if (num <= 0)
                num = 1;
            $(".teaGardenNumberSetting").val(num);
        });

        $("div.teaGardenTeaGardenReviewDiv").hide();
        $("a.teaGardenDetailTopTeaGardenReviewLink").click(function () {
            $("div.teaGardenTeaGardenReviewDiv").show();
            $("div.teaGardenDetailDiv").hide();
        });
        $("a.teaGardenTeaGardenReviewTopPartSelectedLink").click(function () {
            $("div.teaGardenTeaGardenReviewDiv").hide();
            $("div.teaGardenDetailDiv").show();
        });


        $(".addCartLink").click(function () {
            var page = "checkLogin";
            $.get(
                page,
                function (result) {
                    if ("success" == result) {
                        var teaGarden_id = ${teaGarden.id};
                        var num = $(".teaGardenNumberSetting").val();
                        var addCartpage = "addCart";
                        $.get(
                            addCartpage,
                            {"teaGarden_id": teaGarden_id, "num": num},
                            function (result) {
                                if ("success" == result) {
                                    $(".addCartButton").html("已加入购物车");
                                    $(".addCartButton").attr("disabled", "disabled");
                                    $(".addCartButton").css("background-color", "lightgray");
                                    $(".addCartButton").css("bappointment-color", "lightgray");
                                    $(".addCartButton").css("color", "black");
                                }
                                else {
                                }
                            }
                        );
                    }
                    else {
//                         $("#loginModal").modal('show');
	                        window.location.href="loginPage";
//                         	window.navigate("loginPage");
                    }
                }
            );
            return false;
        });
    });

</script>


<div class="teaGarden">
	<div class="imgAndInfo">
		<div class="imgInimgAndInfo">
			<img class="bigImg" src="img/teaGarden/${teaGarden.id}/1.jpg">
			<div class="smallImageDiv">
				<img class="smallImg" src="img/teaGarden/${teaGarden.id}/1.jpg"
					bigImgURL="img/teaGarden/${teaGarden.id}/1.jpg"> <img
					class="smallImg" src="img/teaGarden/${teaGarden.id}/2.jpg"
					bigImgURL="img/teaGarden/${teaGarden.id}/2.jpg"> <img
					class="smallImg" src="img/teaGarden/${teaGarden.id}/3.jpg"
					bigImgURL="img/teaGarden/${teaGarden.id}/3.jpg"> <img
					class="smallImg" src="img/teaGarden/${teaGarden.id}/4.jpg"
					bigImgURL="img/teaGarden/${teaGarden.id}/4.jpg"> <img
					class="smallImg" src="img/teaGarden/${teaGarden.id}/5.jpg"
					bigImgURL="img/teaGarden/${teaGarden.id}/5.jpg">
				<div class="img4load hidden"></div>
			</div>
		</div>

		<div class="infoInimgAndInfo">
			<div class="teaGardenTitle">${teaGarden.name}</div>
			<div class="teaGardenSubTitle">${teaGarden.sub_title}</div>
			<div class="teaGardenPrice">
				<div class="teaGardenPriceDiv">
					<div class="gouwujuanDiv">
					</div>

					<div class="promotionDiv">
						<span class="promotionPriceDesc">价格/人</span> <span
							class="promotionPriceYuan">¥</span> <span class="promotionPrice">${teaGarden.price}</span>
					</div>
				</div>
			</div>

			<div class="teaGardenSaleAndTeaGardenReviewNumber">
				<div>
					已体验人次<span class="redColor boldWord">${teaGarden.sale}</span>
				</div>
				<div>
					累计评价<span class="redColor boldWord">${teaGarden.teaGardenReviewCount}</span>
				</div>
			</div>
			<div class="teaGardenNumber">
				<span>预约人数</span> <span> <span class="teaGardenNumberSettingSpan">
						<input type="text" id="number" value="1"
						class="teaGardenNumberSetting">
				</span> <span class="arrow"> <a class="increaseNumber"
						href="#nowhere"> <span class="updown"> <img
								src="img/fore/increase.png">
						</span>
					</a> <span class="updownMiddle"> </span> <a class="decreaseNumber"
						href="#nowhere"> <span class="updown"> <img
								src="img/fore/decrease.png">
						</span>
					</a>
				</span> 人
				</span>
<%-- 				 <span>库存${teaGarden.stock}件</span> --%>
			</div>
			<script>
                function appointLink() {
                    window.location = "appointone?teaGarden_id="+${teaGarden.id}+
                    "&number=" + $("#number").val();
                }
            </script>
			<div class="appointDiv">
				<%--<c:set var="number" scope="page" value="${('#number').val()}"--%>
				<a onclick="javascript:appointLink()" class="appointLink">
					<button class="appointButton">立即预约</button>
				</a>
			</div>
		</div>
		<div style="clear: both"></div>
	</div>
</div>
<div style="clear: both;"></div>

<style>
div.teaGardenDetailDiv {
	width: 790px;
	margin: 40px auto;
}

div.teaGardenDetailTopPart {
	bappointment: 1px solid #DFDFDF;
	bappointment-left-width: 0px;
}

a.selected {
	bappointment-left: 1px solid #cfbfb1;
	bappointment-right: 1px solid #cfbfb1;
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
	bappointment-width: 1px;
	bappointment-color: #FF0036;
	bappointment-style: solid;
	width: 90px;
	height: 0;
	position: absolute;
	top: -1px;
	margin-left: -1px;
}

a.selected:after {
	content: "";
	display: block;
	bappointment-color: #FF0036 transparent transparent;
	bappointment-style: solid;
	bappointment-width: 5px;
	width: 0;
	height: 0;
	position: absolute;
	top: -1px;
	left: 50%;
	margin-left: -5px;
}

a.teaGardenDetailTopTeaGardenReviewLink {
	padding: 0px 20px;
	bappointment-right: 1px dotted #D2D2D2;
	color: #333333;
}

span.teaGardenDetailTopTeaGardenReviewLinkNumber {
	color: #3355B9;
}

div.teaGardenParamterPart {
	bappointment: 1px solid #DFDFDF;
	padding: 40px;
}

div.teaGardenParamter {
	color: #999999;
	font-weight: bold;
	margin-bottom: 20px;
}

div.teaGardenParamterList span {
	display: block;
	width: 220px;
	float: left;
	padding: 8px 0px;
	color: #666666;
}

div.teaGardenDetailImagesPart img {
	display: block;
	width: 790px;
	margin: 20px 0px;
}

div.teaGardenTeaGardenReviewDiv {
	width: 790px;
	margin: 40px auto;
}

div.teaGardenTeaGardenReviewTopPart {
	bappointment: 1px solid #DFDFDF;
}

a.teaGardenTeaGardenReviewTopPartSelectedLink {
	padding: 0px 20px;
	color: #333333;
}

div.teaGardenTeaGardenReviewContentPart {
	padding-top: 50px;
}

div.teaGardenTeaGardenReviewItem {
	bappointment-bottom: 1px solid #E3E3E3;
	margin: 10px 0px;
}

div.teaGardenTeaGardenReviewContentPart {
	padding-top: 50px;
}

div.teaGardenTeaGardenReviewItem {
	bappointment-bottom: 1px solid #E3E3E3;
	margin: 10px 0px;
}

div.teaGardenTeaGardenReviewItem div.teaGardenTeaGardenReviewItemDesc {
	width: 80%;
	display: inline-block;
	color: #333333;
	margin: 5px 20px;
	float: left;
}

div.teaGardenTeaGardenReviewItemDate {
	margin: 15px 0px 0px 0px;
	color: #CCCCCC;
}

div.teaGardenTeaGardenReviewItem div.teaGardenTeaGardenReviewItemUserInfo {
	color: #404040;
	margin: 5px 20px;
	padding: 20px 0;
}

span.userInfoGrayPart {
	color: #999999;
}
</style>

<div class="teaGardenDetailDiv" style="display: block;">
	<div class="teaGardenDetailTopPart">
		<a class="teaGardenDetailTopPartSelectedLink selected" href="#nowhere">茶园详情</a>
		<a class="teaGardenDetailTopTeaGardenReviewLink" href="#nowhere">累计评价 <span
			class="teaGardenDetailTopTeaGardenReviewLinkNumber">${teaGarden.teaGardenReviewCount}</span>
		</a>
	</div>

	<div class="teaGardenParamterPart">
		<div class="teaGardenParamter">茶园介绍：</div>
		<div class="teaGardenParamterList">
<%--			<c:forEach items="${propertyValues}" var="pvs">--%>
			<span>${teaGarden.introduction}</span>
<%--			</c:forEach>--%>
		</div>
		<div style="clear: both"></div>
	</div>
	<div class="teaGardenDetailImagesPart">
		<img src="img/teaGardenDetail/8626.jpg">
	</div>
</div>
<div style="clear: both"></div>
<div class="teaGardenTeaGardenReviewDiv" style="display: block;">
	<div class="teaGardenTeaGardenReviewTopPart">
		<div class="teaGardenTeaGardenReviewTopPart">
			<a class="teaGardenTeaGardenReviewTopPartSelectedLink" href="#nowhere">茶园详情</a>
			<a class="selected" href="#nowhere">累计评价 <span
				class="teaGardenTeaGardenReviewTopTeaGardenReviewLinkNumber">${teaGarden.teaGardenReviewCount}</span>
			</a>
		</div>
		<div class="teaGardenTeaGardenReviewContentPart">
			<c:forEach items="${teaGardenReviews}" var="r">
				<div class="teaGardenTeaGardenReviewItem">
					<div class="teaGardenTeaGardenReviewItemDesc">
						<div class="teaGardenTeaGardenReviewItemContent">${r.content}</div>
						<div class="teaGardenTeaGardenReviewItemDate">${r.createDate}</div>
					</div>
					<div class="teaGardenTeaGardenReviewItemUserInfo">
						${r.user.anonymousName}<span class="userInfoGrayPart">（匿名）</span>
					</div>
					<div style="clear: both"></div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<%--<%@include file="teaGardenDetail.jsp" %>--%>

<%@include file="include/footer.jsp"%>