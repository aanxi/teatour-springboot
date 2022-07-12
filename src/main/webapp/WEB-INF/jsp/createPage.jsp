<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>


<style>
div.buyPageDiv {
	margin: 20px auto;
	max-width: 1013px;
}

div.buyPageDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.buyDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.address {
	margin: 20px 5px;
	text-align: left;
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
	border: 1px solid #AFAFAF;
	width: 200px;
}

table.addressTable td textarea {
	border: 1px solid #AFAFAF;
	margin-bottom: 10px;
	width: 400px;
}

table.productListTable th {
	color: #999999;
	font-weight: normal;
	font-size: 12px;
	text-align: center;
	padding-bottom: 5px;
}

table.productListTable tr.rowborder td {
	background-color: #b2d1ff;
	border-right: 2px solid #fff;
	height: 3px;
}

tr.orderItemTR td {
	padding: 10px 0px;
}

td.orderItemProductInfo img {
	height: 16px;
}

tr.orderItemTR td {
	border-bottom: 1px solid #E5E5E5;
}

tbody.productListTableTbody td {
	text-align: center;
	font-size: 12px;
}

div.orderItemSumDiv span {
	color: #999999;
}

div.orderItemTotalSumDiv span {
	color: #999999;
}

div.submitOrderDiv {
	height: 40px;
	margin: 20px 0px;
}

button.submitOrderButton {
	border: 1px solid #C40000;
	background-color: #C40000;
	text-align: center;
	line-height: 40px;
	font-size: 14px;
	font-weight: 700;
	color: white;
	float: right;
}
span.redStar {
	color: red;
	font-size: 8px;
}

table.addressTable td textarea {
	border: 1px solid #AFAFAF;
	margin-bottom: 10px;
	width: 500px;
}

textarea {
	border: 1px solid #FFAD35;
	width: 700px;
	height: 100px;
	resize: vertical;
}


div.submitOrderDiv {
	height: 40px;
	margin: 20px 0px;
}

button.submitOrderButton {
	border: 1px solid #C40000;
	background-color: #C40000;
	text-align: center;
	line-height: 40px;
	font-size: 14px;
	font-weight: 700;
	color: white;
	float: center;
}
.buyPageDiv {
 	min-height: 680px;
 } 
</style>

<script>
    $(function () {
            <c:if test="${!empty msg}">
            $("span.errorMessage").html("${msg}");
            $("div.registerErrorMessageDiv").show();
            </c:if>

        $("div.submitOrderDiv").click(function () {
			if (0 == $("#name").val().length) {
				$("span.errorMessage").html("请上传新品图片");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
            if (0 == $("#name").val().length) {
                $("span.errorMessage").html("请输入新品名称");
                $("div.registerErrorMessageDiv").show();
                return false;
            }
            if (0 == $("#sub_title").val().length) {
                $("span.errorMessage").html("请输入新品描述");
                $("div.registerErrorMessageDiv").show();
                return false;
            }
            if (0 == $("#price").val().length) {
                $("span.errorMessage").html("请输入新品价格");
                $("div.registerErrorMessageDiv").show();
                return false;
            }
            alert("创建新品成功！");
            return true;          
        });
        $("form.registerFrom input").keyup(function () {
            $("div.registerErrorMessageDiv").hide();
        });
    });

	<%--function uploadFile() {--%>
	<%--	//formData里面存储的数据形式，一对key/value组成一条数据，key是唯一的，一个key可能对应多个value--%>
	<%--	var myform = new FormData();--%>
	<%--	// 此时可以调用append()方法来添加数据--%>
	<%--	myform.append('file', $("#img")[0].files[0]);--%>
	<%--	//验证不为空--%>
	<%--	var file = $("#img")[0].files[0];--%>
	<%--	if (file == null) {--%>
	<%--		alert("请选择文件");--%>
	<%--		return false;--%>
	<%--	} else {--%>
	<%--		$.ajax({--%>
	<%--			url: "/user/upLoad",--%>
	<%--			type: "POST",--%>
	<%--			data: myform,--%>
	<%--			async: false,--%>
	<%--			contentType: false,--%>
	<%--			processData: false,--%>
	<%--			success: function (result) {--%>
	<%--				console.log(result);--%>
	<%--				alert("上传成功！");--%>
	<%--				$("#div_show_img").html("<img id='input_img' src='img/newProd/${newProd.id}.jpg'>");--%>
	<%--				$("#imgPath").attr("value", result);--%>
	<%--				$("#div_upload").removeClass("show");--%>
	<%--			},--%>
	<%--		});--%>
	<%--	}--%>
	<%--}--%>

</script>
<div class="buyPageDiv">
	<form action="createNewProd" method="post" enctype="multipart/form-data">
		<div class="address">
			<div class="addressTip">输入新品信息</div>
				<table class="addressTable">
					<tr>
						<td class="firstColumn">新品图片<span class="redStar">*</span></td>
						<td>
							<input type="file" name="file">
						</td>
					</tr>
					<tr>
						<td class="firstColumn">新品名称<span class="redStar">*</span></td>

						<td><textarea name="name" placeholder="新品名称"></textarea></td>
					</tr>
					<tr>
						<td class="firstColumn">新品描述<span class="redStar">*</span></td>

						<td><textarea name="sub_title" placeholder="新品详细描述"></textarea></td>
					</tr>
					<tr>
						<td class="firstColumn">价格建议<span class="redStar">*</span></td>
						<td><textarea name="price" placeholder="价格区间"></textarea></td>
					</tr>
				</table>
		</div>
		<div class="submitOrderDiv">
			<button type="submit" class="submitOrderButton">提交新品建议</button>
		</div>
	</form>
</div>
<%@include file="include/footer.jsp"%>
