<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head lang="en">
    <meta charset="utf-8"/>
    <title>产品溯源</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>

<style>
    li, ul {
        list-style: none;
        margin: 0;
        padding: 0;
    }

    div.floor-line-con i {
        background-color: #0AA6E8;
        width: 5px;
        height: 18px;
        display: inline-block;
        vertical-align: middle;
    }

    .Bott {
 	min-height: 280px;
	position: relative;
	left:15%;
 }

li, ul {
	list-style: none;
	margin: 0;
	padding: 0;
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

</style>
    
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/search.jsp"%>
<script type="text/javascript" charset="utf-8">
window.onload=function(){
	var t1 = document.getElementById("t1");
	var t2 = document.getElementById("t2");
	var t3 = document.getElementById("t3");
	var t4 = document.getElementById("t4");
	var img1 = document.getElementById("img1");
	var img2 = document.getElementById("img2");
	var img3 = document.getElementById("img3");
	var img4 = document.getElementById("img4");
	t1.onclick=function(){
		t1.style.color="red";
		img1.style.display="block";
		img2.style.display="none";
		img3.style.display="none";
		img4.style.display="none";
	}
	t2.onclick=function(){
		t1.style.color="none";
		t2.style.color="red";
		img1.style.display="none";
		img2.style.display="block";
		img3.style.display="none";
		img4.style.display="none";
	}
	t3.onclick=function(){
		t3.style.color="red";
		img1.style.display="none";
		img2.style.display="none";
		img3.style.display="block";
		img4.style.display="none";
	}
	t4.onclick=function(){
		t4.style.color="red";
		img1.style.display="none";
		img2.style.display="none";
		img3.style.display="none";
		img4.style.display="block";
	}
	
}

</script>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">溯源码溯源</h2></div>
            <div class="dlist">
                <ul class="clearfix" id="pro">
                    <li><a id="t1" color="red">采摘溯源</a></li>
                    <li><a  id="t2">生产加工</a></li>
                    <li><a id="t3">检测报告</a></li>
                    <li><a id="t4">流通环节</a></li>
                </ul>
            </div>
            <div class="sx clearfix">
                <div class="clearfix" id="img1" display="block">
                    <dl class="fl">
                        <dt><a ><img src="img/${code}/采摘溯源.jpg" width="300px"/></a></dt>
                    </dl>
                </div>
                <div class="clearfix" id="img2" display="none">
                    <dl class="fl">
                        <dt><a href="#"><img src="img/${code}/生产加工.png" width="300px"/></a></dt>
                    </dl>
                </div>
                <div class="clearfix" id="img3" display="none">
                    <dl class="fl">
                        <dt><a href="#"><img src="img/${code}/检测报告.jpeg" width="300px"/></a></dt>
                    </dl>
                </div>
                <div class="clearfix" id="img4" display="none">
                    <dl class="fl">
                        <dt><a href="#"><img src="img/${code}/流通环节.jpg" width="300px"/></a></dt>
                    </dl>
                </div>
            </div>
        </div>
     </div>   
</div>
<!--footer-->
<%@include file="include/footer.jsp"%>
