<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>

<style>
div.appointedDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.appointmentType div {
	bappointment-bottom: 2px solid #E8E8E8;
	float: left;
}

div.appointmentType a {
	bappointment-right: 1px solid #E8E8E8;
	display: inline-block;
	font-size: 16px;
	font-weight: bold;
	color: black;
	margin-bottom: 10px;
	padding: 0px 20px;
	text-decoration: none;
}

div.appointmentType a:hover {
	color: #FF0036;
	text-decoration: none;
}

div.appointmentType div.selectedAppointmentType {
	bappointment-bottom: 2px solid #FF0036;
}

div.appointmentType div.selectedAppointmentType a {
	color: #FF0036;
}

div.appointmentTypeLastOne {
	overflow: hidden;
	float: none !important;
	bappointment-bottom: 2px solid #E8E8E8;
	height: 35px;
}

a.noRightbappointment {
	bappointment-right-width: 0px !important;
}

table.appointmentListTitleTable {
	bappointment: 1px solid #E8E8E8;
	width: 100%;
	margin: 20px 0px;
	background-color: #F5F5F5;
	text-align: center;
	font-size: 12px;
}

table.appointmentListTitleTable td {
	padding: 12px 0px;
}

div.appointedDiv {
	max-width: 1013px;
	margin: 10px auto;
}

table.appointmentListItemTable {
	bappointment: 2px solid #ECECEC;
	width: 100%;
	margin: 20px 0px;
	font-size: 12px;
}

table.appointmentListItemTable:hover {
	bappointment: 2px solid #aaa !important;
}

table.appointmentListItemTable td {
	padding: 8px 10px;
}

tr.appointmentListItemFirstTR {
	background-color: #F1F1F1;
}

div.appointmentItemWangWangGif {
	display: inline-block;
	width: 67px;
	height: 22px;
	background-repeat: no-repeat;
	background-color: transparent;
	background-attachment: scroll;
	background-position: -0px -0px;
	position: relative;
	top: 0px;
	left: 2px;
}

td.appointmentItemDeleteTD {
	text-align: right;
}

span.appointmentListItemDelete {
	display: inline-block;
	margin: 0px 10px;
	color: #999999;
	font-size: 16px;
}

div.appointmentListItemTeaGardenLinkOutDiv {
	position: relative;
	height: 80px;
}

div.appointmentListItemTeaGardenLinkInnerDiv {
	position: absolute;
	bottom: 0px;
}

div.appointmentListItemTeaGardenOriginalPrice {
	color: #999999;
	font-size: 14px;
}

div.appointmentListItemTeaGardenPrice {
	color: #3C3C3C;
	font-size: 14px;
}

td.appointmentListItemNumberTD {
	text-align: center;
}

td.appointmentItemAppointmentInfoPartTD {
	bappointment: solid 1px #ECECEC;
}

span.appointmentListItemNumber {
	color: #3C3C3C;
}

td.appointmentListItemTeaGardenRealPriceTD {
	text-align: center;
}

div.appointmentListItemTeaGardenRealPrice {
	color: #3C3C3C;
	font-size: 14px;
	font-weight: bold;
}

div.appointmentListItemPriceWithTransport {
	color: #6C6C6C;
	font-size: 12px;
}

td.appointmentListItemButtonTD {
	text-align: center;
}

button.appointmentListItemTeaGardenReview {
	bappointment: 1px solid #DCDCDC;
	background-color: #fff;
	bappointment-radius: 2px;
	color: #3C3C3C;
	font-size: 12px;
	font-weight: bold;
	padding: 6px 12px;
}

button.appointmentListItemTeaGardenReview:hover {
	bappointment-color: #C40000;
	color: #C40000;
}

button.appointmentListItemConfirm {
	background-color: #66B6FF;
	bappointment-radius: 2px;
	color: white;
	font-size: 12px;
	font-weight: bold;
	bappointment-width: 0px;
	padding: 6px 12px;
}

button.appointmentListItemConfirm:hover {
	background-color: #118ADB;
}

a {
	color: #999;
}

a:hover {
	text-decoration: none;
	color: #FF0036;
}
</style>

<script>
    var deleteAppointment = false;
    var deleteAppointmentid = 0;

    $(function () {
        $("a[appointmentStatus]").click(function () {
            var appointmentStatus = $(this).attr("appointmentStatus");
            if ('all' == appointmentStatus) {
                $("table[appointmentStatus]").show();
            }
            else {
                $("table[appointmentStatus]").hide();
                $("table[appointmentStatus=" + appointmentStatus + "]").show();
            }

            $("div.appointmentType div").removeClass("selectedAppointmentType");
            $(this).parent("div").addClass("selectedAppointmentType");
        });

        $("a.deleteAppointmentLink").click(function () {
            deleteAppointmentid = $(this).attr("oid");
            deleteAppointment = false;
            $("#deleteConfirmModal").modal("show");
        });

        $("button.deleteConfirmButton").click(function () {
            deleteAppointment = true;
            $("#deleteConfirmModal").modal('hide');
        });

        $('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
            if (deleteAppointment) {
                var page = "deleteAppointment";
                $.post(
                    page,
                    {"appointment_id": deleteAppointmentid},
                    function (result) {
                        if ("success" == result) {
                            $("table.appointmentListItemTable[oid=" + deleteAppointmentid + "]").hide();
                        }
                        else {
                            location.href = "login.jsp";
                        }
                    }
                );

            }
        })

        $(".ask2delivery").click(function () {
            var link = $(this).attr("link");
            $(this).hide();
            page = link;
            $.ajax({
                url: page,
                success: function (result) {
                    alert("卖家已秒发，刷新当前页面，即可进行确认收货")
                }
            });

        });
    });

</script>

<div class="appointedDiv">
	<div class="appointmentType">
		<div class="selectedAppointmentType">
			<a appointmentStatus="all" href="#nowhere">所有预约</a>
		</div>
		<div>
			<a appointmentStatus="waitPay" href="#nowhere">待付款</a>
		</div>
		<div>
			<a appointmentStatus="waitDelivery" href="#nowhere">待使用</a>
		</div>
		<div>
			<a appointmentStatus="waitConfirm" href="#nowhere">待确认</a>
		</div>
		<div>
			<a appointmentStatus="waitTeaGardenReview" href="#nowhere" class="noRightbappointment">待评价
			</a>
		</div>
		<div>
			<a appointmentStatus="finish" href="#nowhere" class="noRightbappointment">已完成
			</a>
		</div>
		<div class="appointmentTypeLastOne">
			<a class="noRightbappointment"> </a>
		</div>
	</div>
	<div style="clear: both"></div>
	<div class="appointmentListTitle">
		<table class="appointmentListTitleTable">
			<tr>
				<td>茶园</td>
				<td width="121px">单价</td>
				<td width="100px">预约人数</td>
				<td width="121px">预约日期</td>
				<td width="141px">实付款</td>
				<td width="121px">预约状态</td>
			</tr>
		</table>

	</div>

	<div class="appointmentListItem">
		<c:forEach items="${appointments}" var="o">
			<table class="appointmentListItemTable" appointmentStatus="${o.status}"
				oid="${o.id}">
				<tr class="appointmentListItemFirstTR">
					<td colspan="2"><b>${o.create_date}</b> <span>订单号:
							${o.appointment_code} </span></td>
					<td colspan="2">粤茶旅</td>
					<td colspan="1"><a class="wangwanglink" href="#nowhere">
							<div class="appointmentItemWangWangGif"></div>
					</a></td>
					<td class="appointmentItemDeleteTD"><a class="deleteAppointmentLink"
						oid="${o.id}" href="#nowhere"> <span
							class="appointmentListItemDelete glyphicon glyphicon-trash"></span>
					</a></td>
				</tr>
				<c:forEach items="${o.appointmentItems}" var="oi" varStatus="st">
					<tr class="appointmentItemTeaGardenInfoPartTR">
						<td class="appointmentItemTeaGardenInfoPartTD"><img width="80"
							height="80" src="img/teaGarden/${oi.teaGarden.id}/1.jpg"></td>
						<td class="appointmentItemTeaGardenInfoPartTD">
							<div class="appointmentListItemTeaGardenLinkOutDiv">
								<a href="showTeaGarden?teaGarden_id=${oi.teaGarden.id}">${oi.teaGarden.name}</a>
								<div class="appointmentListItemTeaGardenLinkInnerDiv">
									<img src="img/fore/creditcard.png" title="支持信用卡支付"><img
										src="img/fore/promise.png" title="消费者保障服务,承诺如实描述">
								</div>
							</div>
						</td>
						
						<td class="appointmentItemTeaGardenInfoPartTD" width="100px">

							<div class="appointmentListItemTeaGardenOriginalPrice">￥${oi.teaGarden.price}</div>
							<div class="appointmentListItemTeaGardenPrice">￥${oi.teaGarden.price}</div>

						</td>

						<c:if test="${st.count==1}">

							<td valign="top" rowspan="${fn:length(o.appointmentItems)}"
								class="appointmentListItemNumberTD appointmentItemAppointmentInfoPartTD"
								width="100px"><span class="appointmentListItemNumber">${o.totalNumber}</span>
							</td>
							<td valign="top" rowspan="${fn:length(o.appointmentItems)}"
								width="100px"
								class="appointmentListItemTeaGardenRealPriceTD appointmentItemAppointmentInfoPartTD">
								<div class="appointmentListItemTeaGardenRealPrice">${o.delivery_date}</div>
							</td>
							<td valign="top" rowspan="${fn:length(o.appointmentItems)}"
								width="100px"
								class="appointmentListItemTeaGardenRealPriceTD appointmentItemAppointmentInfoPartTD">
								<div class="appointmentListItemTeaGardenRealPrice">￥${o.total}</div>
							</td>

							<td valign="top" rowspan="${fn:length(o.appointmentItems)}"
								class="appointmentListItemButtonTD appointmentItemAppointmentInfoPartTD"
								width="100px"><c:if test="${o.status=='waitConfirm' }">
									<a href="confirmAppoint?appointment_id=${o.id}">
										<button class="appointmentListItemConfirm">确认完成</button>
									</a>
								</c:if> <c:if test="${o.status=='waitPay' }">
									<a href="alipay.jsp?appointment_id=${o.id}&total=${o.total}">
										<button class="appointmentListItemConfirm">付款</button>
									</a>
								</c:if> <c:if test="${o.status=='waitDelivery' }">
									<span>待使用</span>
									<%--                                     <button class="btn btn-info btn-sm ask2delivery" link="admin_appointment_delivery?id=${o.id}">催卖家发货</button> --%>

								</c:if> <c:if test="${o.status=='waitTeaGardenReview' }">
									<a href="teaGardenReview?appointment_id=${o.id}">
										<button class="appointmentListItemTeaGardenReview">评价</button>
									</a>
								</c:if></td>
						</c:if>
					</tr>
				</c:forEach>

			</table>
		</c:forEach>

	</div>

</div>


<%@include file="include/footer.jsp"%>
