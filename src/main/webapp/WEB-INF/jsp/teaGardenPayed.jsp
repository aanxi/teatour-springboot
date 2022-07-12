<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>


<style>
div.teaGardenPayedDiv {
	bappointment: 1px solid #D4D4D4;
	max-width: 1013px;
	margin: 10px auto 20px auto;
}

div.teaGardenPayedTextDiv {
	height: 61px;
	background-color: #ECFFDC;
	padding: 17px 0px 0px 25px;
}

div.teaGardenPayedTextDiv span {
	font-weight: bold;
	font-size: 14px;
	margin-left: 10px;
}

div.teaGardenPayedAddressInfo {
	padding: 26px 35px;
}

div.teaGardenPayedAddressInfo li {
	background-image: url(/img/fore/li_dot.png);
	background-repeat: no-repeat;
	background-color: transparent;
	background-attachment: scroll;
	background-position: 0px 13px;
	list-style-type: none;
	color: #333333;
	padding-left: 15px;
	padding-top: 5px;
}

span.teaGardenPayedInfoPrice {
	color: #B10000;
	font-weight: bold;
	font-size: 14px;
	font-family: arial;
}

div.paedCheckLinkDiv {
	margin-left: 38px;
}

a.teaGardenPayedCheckLink {
	color: #2D8CBA;
}

a.teaGardenPayedCheckLink:hover {
	color: #2D8CBA;
	text-decoration: underline;
}

div.teaGardenPayedSeperateLine {
	bappointment-top: 1px dotted #D4D4D4;
	margin: 0px 31px;
}

div.warningDiv {
	margin: 23px 45px;
	color: black;
}
</style>

<div class="teaGardenPayedDiv">
	<div class="teaGardenPayedTextDiv">
		<img src="img/fore/paySuccess.png"> <span>您已成功付款</span>

	</div>
	<div class="teaGardenPayedAddressInfo">
		<ul>
			<li>预约人：${o.receiver} ${o.mobile }</li>
			<li>实付款：<span class="teaGardenPayedInfoPrice"> ￥${param.total} </li>
			<li>请按预约时间前往体验</li>
		</ul>

		<div class="paedCheckLinkDiv">
			<a class="teaGardenPayedCheckLink" href="appointed">查看预约</a> 
		</div>

	</div>

	<div class="teaGardenPayedSeperateLine"></div>

</div>

