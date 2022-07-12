<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<!-- <head lang="en"> -->
<!--     <meta charset="utf-8"/> -->
<!--     <title>产品溯源</title> -->
<!--     <link rel="stylesheet" type="text/css" href="css/public.css"/> -->
<!--     <link rel="stylesheet" type="text/css" href="css/myorder.css"/> -->
<!-- </head> -->

<style>
.Bott {
 	min-height: 280px;
/* 	position: relative; */
/* 	left:20%; */
 } 

.category-tab-content {
	position: relative;
}

.normal-nav {
	background-color: rgba(0, 0, 0, .55);
	width: 200px;
	height: 500px;
	position: absolute;
	z-index: 11;
}

.nav-item {
	padding-left: 30px;
	positon: relative;
	line-height: 31.2px;
	width: 200px;
	color: #FFFFFF;
	font-size: 14px;
}

.normal-nav .nav-item:hover {
	background-color: #FFFFFF;
	color: #e54077;
}

li, ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

.seprate {
	margin-top: 42px;
	border-bottom: 1px dashed rgba(0, 0, 0, .1);
}

div.floor-line-con {
	margin-top: 20px;
	height: 330px;
	/*position: relative;*/
	float: left;
	overflow: hidden;
}

div.floor-line-con i {
	background-color: #0AA6E8;
	width: 5px;
	height: 18px;
	display: inline-block;
	vertical-align: middle;
}

.floor-name {
	margin-left: 10px;
	display: inline-block;
	font-size: 18px;
	color: #000000;
	height: 28px;
	vertical-align: middle;
}

.grid {
	margin-left: 13px;
	text-align: center;
}

.productItem {
	display: block;
	float: left;
	width: 233px;
	height: 300px;
	border: 1px solid #FFFFFF;
}

.productItem:hover {
	border: 1px solid #FF0036;
}

.floor-item-img {
	margin-top: 20px;
	position: relative;
	width: 185px;
	height: 185px;
}

.floor-item-title {
	width: 135px;
	height: 40px;
	font-size: 14px;
	color: #333333;
	line-height: 20px;
	overflow: hidden;
	margin: 8px auto;
}

.floor-price {
	font-size: 18px;
	color: #FF0036;
	line-height: 18px;
	margin: 10px auto;
}

.tm-end {
	/*display: block;*/
	position: relative;
	text-align: center;
	width: 80px;
	height: 45px;
	margin: 0 auto;
	-webkit-background-size: cover;
	background-size: cover;
	z-index: 9;
}
</style>

<!------------------------------idea------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
            <div>              
                <form action="traceByCode">
  					<table align="center" width="450">
					<tr>
						<td align="right">&nbsp</td>
					</tr>		
					<tr>
						<td align="right">请输入产品包装上的溯源码：</td>
						<td><input type="text" name="code" id="code" boder="2px"/></td>
						</br>
						</br>
					</tr>
					<tr>
						<td align="right">&nbsp</td>
						</br>
						</br>
					</tr>					
					<tr>
						<td align="right">
							<input type="submit" value="查询">
					</td>
					</tr>
  					</table>
				</form>
        </div>
     </div>   
</div>

<%@include file="include/footer.jsp"%>