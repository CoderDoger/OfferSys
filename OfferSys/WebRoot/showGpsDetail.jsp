<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>GPS</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;}
		#content{margin:1%;float:left;}
		#idImage{float: left;margin-top:1%;margin-left:-20px;}
		#idImage img{border:solid 1px #169662;}
		table{border:solid 1px #169662;border-collapse: collapse;}
		table tr{line-height:30px;}
		table th,td{border:solid 1px #169662;padding-right:20px;padding-left:3px;}
		.tit{font-size:14px;font-weight:bold;}
		a{text-decoration:none;}
		.btn{border:solid 1px #ccc;width:85px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px;color:#fff;}
		
		#prompt span{color:red;font-size:14px;position: absolute;top: 20%;left: 20%;cursor: pointer;}
		#lightBox{width: 100%;height: 100%;position:fixed;top: 0px;left: 0px;z-index: 2;display: none;}
		#lightBox .mask{z-index: 3;width: 100%;height: 100%;top: 0px;left: 0px;background: #000;opacity: 0.5;filter: alpha(opacity=50);z-index: 10;}
		#lightBox .show{z-index: 4;width: 100%;height: 100%;position:absolute;top: 0px;left: 0px;overflow: auto;}
		#lightBox .show a{z-index: 4;width:30px;height: 30px;line-height:30px;border:solid 1px #fff;background: #f00;color:#fff;display: block;position: absolute;top: 20px;right:20px;border-radius:20px;text-align: center;text-decoration: none;}
		#lightBox .show #bigPic{width:100%;}
		
	</style>
  </head>
  
  <body>
    <div id="content">
   		<table>
   			<thead><th colspan="2">GPS Product Specification</th></thead>
   			<tr>
   				<td class="tit" name="imageId">ID</td>
   				<td id="prompt" style="position: relative;">
   					<img alt="img" src="${pageContext.request.contextPath}/uploadFile${gpsDetail.imageId}" width="300">
   					<span >点击我看大图！</span>
   				</td>
   			</tr>
   			<tr><td class="tit" name="productType">product type:</td><td>${gpsDetail.productType }</td></tr>
   			<tr><td class="tit" name="model">MODEL:</td><td>${gpsDetail.model }</td></tr>
   			<tr><td class="tit" name="os">OS:</td><td>${gpsDetail.os }</td></tr>
   			<tr><td class="tit" name="cpu">CPU:</td><td>${gpsDetail.cpu }</td></tr>
   			<tr><td class="tit" name="lcd">LCD:</td><td>${gpsDetail.lcd }</td></tr>
   			<tr><td class="tit" name="tp">TP:</td><td>${gpsDetail.tp }</td></tr>
   			<tr><td class="tit" name="ram">RAM:</td><td>${gpsDetail.ram }</td></tr>
   			<tr><td class="tit" name="rom">FLASH ROM:</td><td>${gpsDetail.rom }</td></tr>
   			<tr><td class="tit" name="dvr">DVR:</td><td>${gpsDetail.dvr }</td></tr>
   			
   			
   			<!-- <tr><td class="tit" name="camera">Front Camera:</td><td>${gpsDetail.camera }</td></tr> -->
   			<!-- 取 frontCamera 值 -->
   			<c:set var="camera" value="${gpsDetail.camera }"></c:set>
   			<tr>
   				<td class="tit" name="camera">Front Camera:</td>
   				<td><!-- 以逗号分隔，换行显示 -->
   					<c:forEach items="${fn:split(camera,';')}" varStatus="status" var="val" >
   						${val }</br>
   					</c:forEach>
   				</td>
   			</tr>
   			
   			<tr><td class="tit" name="card">TF Card:</td><td>${gpsDetail.card }</td></tr>
   			
   			
   			<!-- 取 multimedia 值 -->
   			<c:set var="multimedia" value="${gpsDetail.multimedia}"></c:set>
   			<tr>
   				<td class="tit" name="multimedia">Software Feature:</td>
   				<td><!-- 以逗号分隔，换行显示 -->
   					<c:forEach items="${fn:split(multimedia,';')}" varStatus="status" var="val" >
   						${val }</br>
   					</c:forEach>
   				</td>
   			</tr>
   			<tr><td class="tit" name="tools">Tools:</td><td>${gpsDetail.tools }</td></tr>
   			
   			<!-- 取 bluetooth 值 -->
   			<c:set var="bluetooth" value="${gpsDetail.bluetooth}"></c:set>
   			<tr>
   				<td class="tit" name="bluetooth">BT:</td>
   				<td><!-- 以逗号分隔，换行显示 -->
   					<c:forEach items="${fn:split(bluetooth,';')}" varStatus="status" var="val" >
   						${val }</br>
   					</c:forEach>
   				</td>
   			</tr>
   			<tr><td class="tit" name="fmt">FM transmit:</td><td>${gpsDetail.fmt }</td></tr>
   			<tr><td class="tit" name="avin">AV IN:</td><td>${gpsDetail.avin }</td></tr>
   			<tr><td class="tit" name="tv">Digital TV:</td><td>${gpsDetail.tv }</td></tr>
   			<tr><td class="tit" name="speaker">Speaker:</td><td>${gpsDetail.speaker }</td></tr>
   			<tr><td class="tit" name="mic">MIC:</td><td>${gpsDetail.mic }</td></tr>
   			<tr><td class="tit" name="usb">USB:</td><td>${gpsDetail.usb }</td></tr>
   			<tr><td class="tit" name="charger">Charger:</td><td>${gpsDetail.charger }</td></tr>
   			<tr><td class="tit" name="battery">Battery:</td><td>${gpsDetail.battery }</td></tr>
   			<tr><td class="tit" name="language">Language:</td><td>${gpsDetail.language }</td></tr>
   			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td>${gpsDetail.operatingTemperature }</td></tr>
   			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td>${gpsDetail.storageTemperature }</td></tr>
   			<tr><td class="tit" name="weight">weight:</td><td>${gpsDetail.weight }</td></tr>
   			<tr><td class="tit" name="dimension">Dimension:</td><td>${gpsDetail.dimension }</td></tr>
   		</table>
   		<a href="${pageContext.request.contextPath}/servlet/CreateGpsPdfServlet?ctrl=pdf&id=${gpsDetail.id}" class="btn"> 生成PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/CreateGpsExcelServlet?ctrl=excel&id=${gpsDetail.id}" class="btn"> 生成EXCEL</a>
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=GPS&fileType=pdf&fileName=${gpsDetail.model}.pdf" class="btn"> 下载PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=GPS&fileType=excel&fileName=${gpsDetail.model}.xls" class="btn"> 下载EXCEL</a>
    </div>
    <div id="lightBox">
    	<div class="mask"></div>
    	<div class="show">
    		<img id="bigPic" alt="img" src="${pageContext.request.contextPath}/uploadFile${gpsDetail.imageId}">
    		<a href="#" id="close">X</a>
    	</div>
    </div>
  </body>
   <script type="text/javascript">
  	$(document).ready(function(){
  		$("#prompt").click(function(){
  
  			$("#lightBox").show("slow");
  		});
  		$("#lightBox .show a").click(function(){
  			$("#lightBox").hide("slow");
  		});
  	})  ;
  
  </script>
</html>
