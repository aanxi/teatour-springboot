<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="modal.jsp"%>

<style>
div.footer {
	margin: 0px 0px;
	border-top: 1px solid #D1D1DC;
	text-align: center;
	bottom:0px;
}

a:hover {
	text-decoration: none;
}

div.teatour-ensure {
	margin-top: 24px;
	margin-bottom: 24px;
	text-align: center;
}

div.teatour-footer {
	border-top: 1px solid #ededed;
	padding-top: 22px;
	margin: auto;
	height: 190px;
	width: 1190px;
	text-align: center;
}

div.teatour-desc dl a {
	width: 100px;
	overflow: hidden;
	text-align: left;
	height: 20px;
	line-height: 20px;
	color: #8b8b8b;
}

div.teatour-desc dl {
	float: left;
	width: 20%;
	padding-left: 52px;
}

div.teatour-desc clearfix {
	color: #646464;
	font-size: 16px;
	font-weight: 700;
	height: 30px;
	line-height: 30px;
	text-align: left;
}

div.teatour-copyright {
	background-color: black;
	border-top: 2px solid #FF0036;
	text-align: center;
}

div.teatour-copyright span.slash {
	color: white;
}

div.footer div.teatour-copyright div.footer-teatourinfo a {
	color: white;
	padding: 0px 3px;
}

div.footer div.teatour-copyright div.footer-teatourinfo {
	padding: 10px 0px;
	margin-left: 10px;
}

div.footer-copyright {
	margin-left: 10px;
	padding-bottom: 30px;
	line-height: 35px;
	color: #A4A4A4;
}

div.footer-copyright span {
	color: #A4A4A4;
}

div.footer-copyright a {
	margin-right: 65px;
}

div.footer-copyright a:hover {
	color: #A4A4A4;
}

div.footer-copyright div.copyRightYear {
	margin: 5px 0px;
	color: #686868;
}

img.teatour-cat {
	margin-left: 20px;
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

<div id="footer" class="footer" style="display: block;">

	<div class="workArea">
		<div class="teatour-ensure">
			<a href="#nowhere"> <img src="img/foot1.png" /> <span class="fl">7天无理由退货</span>
				<img src="img/foot2.png" /> <span class="fl">15天免费换货</span> <img
				src="img/foot3.png" /> <span class="fl">满599包邮</span> <img
				src="img/foot4.png" /><span class="fl">手机特色服务</span>
			</a>
		</div>
		<div style="clear: both"></div>
	</div>


	<div class="teatour-copyright">
		<div class="workArea">
			<div class="mui-global-fragment-load">
				<div class="footer-copyright">
					粤茶旅&copy;2021-2027公司版权所有 京ICP备080100-44备0000111000号<br />
					违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
				</div>
			</div>

		</div>

	</div>
</div>
</body>
</html>