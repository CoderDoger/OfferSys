<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>京华车品</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="./tree/loadTree.css" /><!----å¼å¥èªå®ä¹Treeæ ·å¼-->	
	<script type="text/javascript" src="./tree/loadTree.js"></script>
	<script type="text/javascript" src="./tree/Tree.js"></script>
	<script type="text/javascript" src="./js/main.js"></script>
    <style>
    	*{padding:0px;margin:0px;font-size:12px;font-family: "微软雅黑";}
    	/***************************top start****************************/
    	#top{border:solid 1px #ccc;width:100%;text-align: center;color:#0cb36f; background: #eee;}
    	#top h2{font-size:30px;line-height: 60px;display: inline-block;}
    	#top a{float: right;margin: 15px 20px;color:#fff;width: 50px;display: inline-block;line-height: 30px;text-decoration: none;text-align: left;padding: 0px 10px;background: #28b779;}
    	#top a span{vertical-align: middle;}
    	#top a i{    width: 14px;height: 14px;display: inline-block;vertical-align: middle;background: url(./images/ht_icon.png) no-repeat 0 -51px;margin-left: 5px;}
    	/***************************top dend****************************/
    	
    	/***************#menu_bar start****************************/
    	#menu_bar{width:20px;border:solid 1px #ccc;float: left;;margin-top:10px;display: none;}
    	#menu_bar i{display: inline-block;width:20px;height: 20px;margin: 5px 0px;background: url("./images/layout_arrows.png") 2px 18px ;cursor: pointer;}
    	/***************#menu_bar end****************************/
    	
    	/***************************lef start****************************/
    	#left{width:14%;border:solid 1px #ccc;float:left;margin-right:1%;overflow: hidden;margin-top:10px;}
    	#left #menu_tit{width:100%;line-height:30px;border-bottom:solid 1px #ccc;overflow: hidden;background: #eee;}
    	#left #menu_tit i {display: inline-block;width:20px;height: 20px;float: left;margin: 5px 0px;}
    	#left #menu_tit span {display: inline-block;}

    	

    	#left #menu_tit #lef{background: url("./images/ht_icon.png") 1px 1px;}
    	#left #menu_tit #rig {float: right;background: url("./images/layout_arrows.png") 2px 2px ;margin-right: 5px;cursor: pointer;}
    	#left #menu_tit #rig:hover {background: url("./images/layout_arrows.png") 2px 2px ;}
    	/***************************left end****************************/
    	
    	/***************************right start****************************/
    	#right{border:solid 1px #ccc;width:83%;float:left;margin-top:10px; }
    	/***************************right end****************************/
    	
    	#clear{clear: both;}
    </style>
</head>
<body style="overflow-x:hidden;overflow-y:hidden">
	<div id="top">
		<h2>${sessionScope.user.userName },您好！欢迎使用 深圳市京华信息技术有限公司 车载产品事业部 产品管理系统 ^_^ !!</h2>
		<a href="${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=logout">
			<span>退出</span>
			<i></i>
		</a>
	</div>
	<div id="menu_bar">
		<i></i>
	</div>
	<div id="left">
		<div id="menu_tit">
			<i id="lef"></i>
			<span>菜单</span>
			<i id="rig"></i>
		</div>
		<div id="tree" ><ul style="padding-left:10px;"></ul></div>
	</div>
	<div id="right">
		<iframe name="mainFrame" scrolling="no" frameborder="0" src="./dvr.jsp" style="width:100%;height:100%;"></iframe>
	</div>
	<div id="clear"></div>                                                                                         
</body>
<script>
	//è·åæµè§å¨çwidth
	var docH = $(document).height();
	//è·åæµè§å¨çheight
	var docW = $("body").width();
	
	$(document).ready(function(){
		//top height
		var topH = $("#top").height();
		var height = docH - topH;
		$("#left").height(height);
		$("#menu_bar").height(height);
		$("#right").height(height);

		
		$("#rig").click(function(){
			var leftW = $("#left").width();
			var rightW = $("#right").width();
			var barW = $("#menu_bar").width();
			
			$("#left").hide();
			$("#menu_bar").show();
			
			$("#right").width(leftW+rightW-barW);
			
		});
		$("#menu_bar i").click(function(){
			var leftW = $("#left").width();
			var rightW = $("#right").width();
			var barW = $("#menu_bar").width();
			
			$("#menu_bar").hide();
			$("#left").show();
			
			$("#right").width(rightW+barW-leftW);
		});
		
		
	});

</script>
</html>