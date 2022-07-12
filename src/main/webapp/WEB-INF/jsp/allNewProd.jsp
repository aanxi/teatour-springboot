<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>

<style>
div.orderType div {
	border-bottom: 2px solid #E8E8E8;
	float: left;
}

div.orderType a {
	border-right: 1px solid #E8E8E8;
	display: inline-block;
	font-size: 16px;
	font-weight: bold;
	color: black;
	margin-bottom: 10px;
	padding: 0px 20px;
	text-decoration: none;
}

div.orderType a:hover {
	color: #FF0036;
	text-decoration: none;
}

div.orderType div.selectedOrderType {
	border-bottom: 2px solid #FF0036;
}

div.orderType div.selectedOrderType a {
	color: #FF0036;
}

div.orderTypeLastOne {
	overflow: hidden;
	float: none !important;
	border-bottom: 2px solid #E8E8E8;
	height: 35px;
}

a.noRightborder {
	border-right-width: 0px !important;
}

table.orderListTitleTable {
	border: 1px solid #E8E8E8;
	width: 100%;
	margin: 20px 0px;
	background-color: #F5F5F5;
	text-align: center;
	font-size: 12px;
}

table.orderListTitleTable td {
	padding: 12px 0px;
}

div.boughtDiv {
	max-width: 1013px;
	margin: 10px auto;
}

table.orderListItemTable {
	border: 2px solid #ECECEC;
	width: 100%;
	margin: 20px 0px;
	font-size: 12px;
}

table.orderListItemTable:hover {
	border: 2px solid #aaa !important;
}

table.orderListItemTable td {
	padding: 8px 10px;
}

tr.orderListItemFirstTR {
	background-color: #F1F1F1;
}

div.orderItemWangWangGif {
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

div.orderListItemProductLinkOutDiv {
	position: relative;
	height: 80px;
}

a {
	color: #999;
}

a:hover {
	text-decoration: none;
	color: #FF0036;
}

div.orderType div.selectedOrderType {
	border-bottom: 2px solid #FF0036;
}

div.orderType div.selectedOrderType a {
	color: #FF0036;
}
</style>

<script>
	var deleteOrder = false;
	var deleteOrderid = 0;

	$(function() {
		$("a[newProdCate_id]").click(function() {
			var newProdCate_id = $(this).attr("newProdCate_id");
			if ('all' == newProdCate_id) {
				$("table[newProdCate_id]").show();
			} else {
			$("table[newProdCate_id]").hide();
			$("table[newProdCate_id=" + newProdCate_id + "]").show();
			}

			$("div.orderType div").removeClass("selectedOrderType");
			$(this).parent("div").addClass("selectedOrderType");
		});
	});
</script>

<div class="boughtDiv">
	<div class="orderType">
		<div class="selectedOrderType">
			<a newProdCate_id="all">所有新品</a>
		</div>
		<div>
			<a newProdCate_id="1" href="#nowhere">待投票</a>
		</div>
		<div>
			<a newProdCate_id="2" href="#nowhere">未上线</a>
		</div>
		<div>
			<a newProdCate_id="3" href="#nowhere">已上线</a>
		</div>
		<div>
			<a href="createPage">我的新品建议</a>
		</div
		<div class="orderTypeLastOne">
			<a class="noRightborder"> </a>
		</div>
	</div>
	<div style="clear: both"></div>

		<div class="workArea" class="orderListItem">
				<c:forEach items="${newProds}" var="p">
					<table class="orderListItemTable" newProdCate_id="${p.newProdCate_id}">
						<%-- 该分类下有产品才能显示 --%>
						<tr class="orderItemProductInfoPartTR">
							<td class="orderItemProductInfoPartTD"><img width="80"
							height="80" src="img/newProd/${p.id}.jpg"></td>
						<td class="orderItemProductInfoPartTD">
							<div class="orderListItemProductLinkOutDiv">
								<a href="showNewProd?newProd_id=${p.id}">${p.name}</a>
							</div>
						</td>
						</tr>
						<div style="clear: both;"></div>
					</table>
				</c:forEach>
			</div>
		</div>		


<%@include file="include/footer.jsp"%>
