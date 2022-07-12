<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<style>
body, table {
	font-size: 12px;
	font-family: Arial;
}

div.confirmAppointPageDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.confirmAppointImageDiv {
	margin: 5px auto 80px auto;
	width: 900px;
	position: relative;
}

div.confirmAppointImageDiv div {
	color: #999999;
}

div.confirmAppointTime3 {
	position: absolute;
	top: 100px;
	left: 400px;
}

div.confirmAppointTime2 {
	position: absolute;
	top: 100px;
	left: 190px;
}

div.confirmAppointTime1 {
	position: absolute;
	top: 100px;
	left: -20px;
}

div.confirmAppointAppointmentInfoText {
	margin: 10px 10px 0px 10px;
	font-size: 16px;
	font-weight: bold;
	color: black;
	padding-bottom: 15px;
	bappointment-bottom: 1px solid #ADC8E6;
}

div.confirmAppointAppointmentItemDiv {
	margin: 0px 20px;
}

div.confirmAppointAppointmentItemText {
	margin: 20px 10px;
	font-size: 14px;
	font-weight: normal;
	color: black;
}

table.confirmAppointAppointmentItemTable {
	bappointment: 1px solid #DDDDDD;
	width: 100%;
}

table.confirmAppointAppointmentItemTable thead {
	background-color: #E8F2FF;
	height: 33px;
}

table.confirmAppointAppointmentItemTable tr {
	bappointment: 1px solid #DDDDDD;
}

table.confirmAppointAppointmentItemTable th, table.confirmAppointAppointmentItemTable td {
	text-align: center;
}

table.confirmAppointAppointmentItemTable td {
	padding: 20px;
}

td.confirmAppointAppointmentItemTeaGardenLink {
	text-align: left !important;
}

span.conformPayTeaGardenPrice {
	font-size: 18px;
	font-weight: bold;
	color: #666666;
}

span.confirmAppointAppointmentItemSumPrice {
	color: #FF0036;
}

a {
	color: #999;
}

a:hover {
	text-decoration: none;
	color: #FF0036;
}

div.confirmAppointPageDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.confirmAppointAppointmentDetailDiv {
	margin: 40px;
}

table.confirmAppointAppointmentDetailTable {
	width: 100%;
	bappointment-top: 1px solid #DDDDDD;
}

table.confirmAppointAppointmentDetailTable td {
	padding: 8px;
	color: black;
	font-size: 14px;
}

span.confirmAppointAppointmentDetailWangWangGif {
	display: inline-block;
	width: 67px;
	height: 22px;
	background-repeat: no-repeat;
	background-color: transparent;
	position: relative;
	left: 2px;
}

div.confirmAppointButtonDiv {
	bappointment: 1px solid #F58B0F;
	margin: 20px;
}

div.confirmAppointWarning {
	margin: 20px 80px;
	font-size: 18px;
	color: red;
	font-weight: bold;
}

button.confirmAppointButton {
	margin: 20px 80px;
	width: 67px;
	height: 30px;
	bappointment: 1px solid #E67C00;
	background-color: #F4A21D;
	bappointment-radius: 4px;
	color: white;
	font-size: 12px;
}

button.confirmAppointButton:hover {
	background-color: #F6AE30;
}
</style>

<div class="confirmAppointPageDiv">
	<div class="confirmAppointImageDiv">
		<img src="img/fore/comformPayFlow.png">
		<div class="confirmAppointTime1">${appointment.create_date}</div>
		<div class="confirmAppointTime2">${appointment.pay_date}</div>
		<div class="confirmAppointTime3">${appointment.delivery_date}</div>

	</div>
	<div class="confirmAppointAppointmentInfoDiv">
		<div class="confirmAppointAppointmentInfoText">我已收到货，同意支付宝付款</div>
	</div>
	<div class="confirmAppointAppointmentItemDiv">
		<div class="confirmAppointAppointmentItemText">预约信息</div>
		<table class="confirmAppointAppointmentItemTable">
			<thead>
				<th colspan="2">茶园</th>
				<th width="120px">单价</th>
				<th width="120px">数量</th>
				<th width="120px">总价</th>
<%--				<th width="120px">运费</th>--%>
			</thead>
			<c:forEach items="${appointment.appointmentItems}" var="oi">
				<tr>
					<td><img width="50px" src="img/teaGarden/${oi.teaGarden.id}/1.jpg"></td>
					<td class="confirmAppointAppointmentItemTeaGardenLink"><a href="#nowhere">${oi.teaGarden.name}</a>
					</td>
					<td>￥${oi.teaGarden.price}</td>
					<td>1</td>
					<td><span class="conformPayTeaGardenPrice">￥${oi.teaGarden.price}</span></td>
<%--					<td><span>快递 ： 0.00 </span></td>--%>
				</tr>
			</c:forEach>
		</table>

		<div class="confirmAppointAppointmentItemText pull-right">
			实付款： <span class="confirmAppointAppointmentItemSumPrice">￥${appointment.total}</span>
		</div>

	</div>
	<div class="confirmAppointAppointmentDetailDiv">

		<table class="confirmAppointAppointmentDetailTable">
			<tr>
				<td>订单编号：</td>
				<td>${appointment.appointment_code}<img width="23px"
					src="img/fore/confirmAppointmentTmall.png"></td>
			</tr>
			<tr>
				<td>预约人：</td>
				<td>${appointment.receiver}，${appointment.mobile}</td>
			</tr>
			<tr>
				<td>预约日期：</td>
				<td>${appointment.delivery_date}</td>
			</tr>
			<tr>
				<td>成交时间：</td>
				<td>${appointment.create_date}</td>
			</tr>
		</table>

	</div>
	<div class="confirmAppointButtonDiv">
		<div class="confirmAppointWarning">请在预约时间前往体验！</div>
		<a href="appointmentConfirmed?appointment_id=${appointment.id}">
			<button class="confirmAppointButton">确认支付</button>
		</a>
	</div>
</div>


<%@include file="include/footer.jsp"%>