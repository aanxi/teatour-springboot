<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>


<style>
div.appointPageDiv {
	margin: 20px auto;
	max-width: 1013px;
}

div.appointPageDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.appointDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.address {
	margin: 20px 5px;
	text-align: left;
}

div.addressTip, div.teaGardenListTip {
	color: #333333;
	font-size: 16px;
	font-weight: bold;
	text-align: left;
	margin-bottom: 30px;
}

table.addressTable {
	margin: 20px 20px;
	width: 600px;
}

table.addressTable td.firstColumn {
	width: 100px;
}

table.addressTable td {
	color: #333333;
	text-align: right;
	vertical-align: top;
	padding-right: 5px;
	text-align: left;
	height: 30px;
	font-size: 12px;
}

span.redStar {
	color: red;
	font-size: 8px;
}

table.addressTable td input {
	bappointment: 1px solid #AFAFAF;
	width: 200px;
}

table.addressTable td textarea {
	bappointment: 1px solid #AFAFAF;
	margin-bottom: 10px;
	width: 400px;
}

img.tmallappoint {
	width: 15px;
}

a.marketLink {
	color: black;
	font-size: 12px;
	font-weight: normal;
}

a.marketLink:hover {
	color: black;
	font-size: 12px;
	text-decoration: underline;
	font-weight: normal;
}

span.wangwangGif {
	display: inline-block;
	width: 25px;
	height: 25px;
	background-repeat: no-repeat;
	background-color: transparent;
	background-attachment: scroll;
	background-position: -83px -0px;
	position: relative;
	top: 8px;
	left: 2px;
}

table.teaGardenListTable {
	width: 100%;
	bappointment-collapse: separate;
}

table.teaGardenListTable th {
	color: #999999;
	font-weight: normal;
	font-size: 12px;
	text-align: center;
	padding-bottom: 5px;
}

th.teaGardenListTableFirstColumn {
	text-align: left !important;
}

table.teaGardenListTable tr.rowbappointment td {
	background-color: #b2d1ff;
	bappointment-right: 2px solid #fff;
	height: 3px;
}

img.appointmentItemImg {
	width: 50px;
	height: 50px;
	bappointment: 1px solid #E9E9E9;
}

tr.appointmentItemTR td {
	padding: 10px 0px;
}

a.appointmentItemTeaGardenLink {
	color: #666666;
	display: block;
}

a.appointmentItemTeaGardenLink:hover {
	color: #666666;
	text-decoration: underline;
}

td.appointmentItemTeaGardenInfo {
	text-align: left;
}

td.appointmentItemTeaGardenInfo img {
	height: 16px;
}

span.appointmentItemTeaGardenNumber {
	color: #000000;
}

tr.appointmentItemTR td {
	bappointment-bottom: 1px solid #E5E5E5;
}

tbody.teaGardenListTableTbody td {
	text-align: center;
	font-size: 12px;
}

tbody.teaGardenListTableTbody td.appointmentItemFirstTD {
	text-align: left;
}

tbody.teaGardenListTableTbody td.appointmentItemTeaGardenInfo {
	text-align: left;
}

td.appointmentItemFirstTD, td.appointmentItemLastTD {
	bappointment-bottom: 0px solid black !important;
}

label.appointmentItemDeliveryLabel {
	color: #666666;
	font-size: 12px;
	font-weight: normal;
}

div.appointmentItemSumDiv span {
	color: #999999;
}

div.appointmentItemSumDiv {
	padding: 20px;
	bappointment-top: 2px solid #B4D0FF;
	background-color: #F2F6FF;
	height: 50px;
}

textarea.leaveMessageTextarea {
	bappointment: 1px solid #FFAD35;
	width: 250px;
	height: 60px;
	resize: none;
}

span.leaveMessageText {
	display: inilne-block;
	margin-right: 10px;
	float: left;
}

span.leaveMessageTextareaSpan {
	display: inilne-block;
}

div.appointmentItemTotalSumDiv {
	margin: 40px;
	height: 40px;
}

div.appointmentItemTotalSumDiv span {
	color: #999999;
}

span.appointmentItemTotalSumSpan {
	color: #C40000 !important;
	font-size: 22px;
	font-weight: bold;
	bappointment-bottom: 1px dotted #F2F6FF;
}

div.submitAppointmentDiv {
	height: 40px;
	margin: 20px 0px;
}

button.submitAppointmentButton {
	bappointment: 1px solid #C40000;
	background-color: #C40000;
	text-align: center;
	line-height: 40px;
	font-size: 14px;
	font-weight: 700;
	color: white;
	float: right;
}
</style>

<script>
    $(function () {
        $("a.teaGardenDetailTopTeaGardenReviewLink").click(function () {
            $("div.teaGardenTeaGardenReviewDiv").show();
            $("div.teaGardenDetailDiv").hide();
        });
        $("a.teaGardenTeaGardenReviewTopPartSelectedLink").click(function () {
            $("div.teaGardenTeaGardenReviewDiv").hide();
            $("div.teaGardenDetailDiv").show();
        });

        $("span.leaveMessageTextareaSpan").hide();
        $("img.leaveMessageImg").click(function () {

            $(this).hide();
            $("span.leaveMessageTextareaSpan").show();
            $("div.appointmentItemSumDiv").css("height", "100px");
        });

        $("div#footer a[href$=#nowhere]").click(function () {
            alert("并没有跳转到实际的页面");
        });


        $("a.wangwanglink").click(function () {
            alert("并不会打开");
        });
        $("a.notImplementLink").click(function () {
            alert("这个功能没做~");
        });

		$('#delevery_date').datetimepicker({
			minView: "month", //选择日期后，不会再跳转去选择时分秒
			language: 'zh-CN',
			format: 'yyyy-mm-dd',
			todayBtn: 0,
			autoclose: 1,
			startView: 2,
			minView: 3,
			startDate: new Date(),
			// endDate: new Date(),
		});
    });



</script>
<div class="appointPageDiv">
	<form action="createAppointment" method="post">
		<div class="appointFlow">
			<img class="pull-left" src="img/logo.png"> 
			<div style="clear: both"></div>
		</div>
		<div class="address">
			<div class="addressTip">预约信息</div>
			<div>

				<table class="addressTable">
					<tr>
						<td>姓名<span class="redStar">*</span></td>
						<td><input name="receiver" placeholder="填写预约人姓名"
							type="text"></td>
					</tr>
					<tr>
						<td>手机号码 <span class="redStar">*</span></td>
						<td><input name="mobile" placeholder="请输入11位手机号码" type="text"></td>
					</tr>
					<tr>
						<td>预约日期<span class="redStar">*</span></td>
						<td><input name="delivery_date" id = "delivery_date" type="date" placeholder="选择预约日期"></td>
					</tr>
				</table>

			</div>

		</div>
		<div class="teaGardenList">
			<div class="teaGardenListTip">确认预约信息</div>


			<table class="teaGardenListTable">
				<thead>
					<tr>
						<th colspan="2" class="teaGardenListTableFirstColumn"> <a
							class="marketLink" href="#nowhere">  </a> <a
							class="wangwanglink" href="#nowhere"> <span
								class="wangwangGif"></span></a></th>
						<th>单价</th>
						<th>预约人数</th>
						<th>小计</th>

					</tr>
					<tr class="rowbappointment">
						<td colspan="2"></td>
						<td></td>
						<td></td>
						<td></td>

					</tr>
				</thead>
				<tbody class="teaGardenListTableTbody">
					<c:forEach items="${appointmentItems}" var="oi" varStatus="st">
						<tr class="appointmentItemTR">
							<td class="appointmentItemFirstTD"><img class="appointmentItemImg"
								src="img/teaGarden/${oi.teaGarden_id}/1.jpg"></td>
							<td class="appointmentItemTeaGardenInfo"><a
								href="teaGarden?pid=${oi.teaGarden_id}"
								class="appointmentItemTeaGardenLink"> ${oi.teaGarden.name} </a> <img
								src="img/fore/creditcard.png" title="支持信用卡支付"> <img
								src="img/fore/promise.png" title="消费者保障服务,承诺如实描述"></td>
							<td>
								<span>${oi.teaGarden.price}</span>
							</td>
							<td><span class="appointmentItemTeaGardenNumber">${oi.number}</span>
							</td>
							<td>
								<%--<span class="appointmentItemUnitSum">--%> <%--￥<fmt:formatNumber type="number" value="${oi.teaGarden.price*oi.number}"--%>
								<%--minFractionDigits="2"/>--%> <%--</span>--%> <span>${oi.teaGarden.price*oi.number}</span>
							</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
			<div class="appointmentItemSumDiv">
				<span class="pull-right">合计: ￥${total}</span>
			</div>


		</div>

		<div class="appointmentItemTotalSumDiv">
			<div class="pull-right">
				<span>实付款：</span> <span class="appointmentItemTotalSumSpan">￥${total}</span>
			</div>
		</div>

		<div class="submitAppointmentDiv">
			<button type="submit" class="submitAppointmentButton">确认预约</button>
		</div>
	</form>
</div>

<%@include file="include/footer.jsp"%>
