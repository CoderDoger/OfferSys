<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>DVR</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;}
		#content{margin:1%;z-index: 1;}
		table{border:solid 1px #169662;border-collapse: collapse;}
		table tr{line-height:30px;}
		table th,td{border:solid 1px #169662;padding-right:20px;padding-left:3px;}
		.tit{font-size:14px;font-weight:bold;}
		a{text-decoration:none;}
		.btn{border:solid 1px #ccc;width:80px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px 20px 0px 0px;color:#fff;}
		#prompt span{color:red;font-size:14px;position: absolute;top: 20%;left: 20%;cursor: pointer;}
		#lightBox{width: 100%;height: 100%;position:fixed;top: 0px;left: 0px;z-index: 2;display: none;}
		#lightBox .mask{z-index: 3;width: 100%;height: 100%;top: 0px;left: 0px;background: #000;opacity: 0.5;filter: alpha(opacity=50);z-index: 10;}
		#lightBox .show{z-index: 4;width: 100%;height: 100%;position:absolute;top: 0px;left: 0px;overflow: auto;}
		#lightBox .show a{z-index: 4;width:30px;height: 30px;line-height:30px;border:solid 1px #fff;background: #f00;color:#fff;display: block;position: absolute;top: 20px;right:20px;border-radius:20px;text-align: center;text-decoration: none;}
		#lightBox .show #bigPic{width:100%;}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
    <div id="content">
   		<table>
   			<thead><th colspan="2">DVR Product Specification</th></thead>
   			 
   			<tr>
   				<td class="tit">ID</td>
   				<td id="prompt" style="position: relative;">
   					<img  alt="img" src="${pageContext.request.contextPath}/uploadFile${dvrDetail.imageId}" width="300">
   					<span >点击我看大图！</span>
   				</td>
   			</tr>
   			
   			<tr><td class="tit">product type:</td><td>${dvrDetail.productType}</td></tr>
   			<tr><td class="tit">MODEL:</td><td>${dvrDetail.model }</td></tr>
   			<tr><td class="tit">CPU:</td><td>${dvrDetail.cpu }</td></tr>
   			<tr><td class="tit">LCD:</td><td>${dvrDetail.lcd }</td></tr>
   			<!-- *********************important****************************** -->
   			<!--  
   			<tr><td rowspan="3" class="tit" name="frontCamera">Front camera:</td><td contenteditable="true">CMOS:2M,SENSOR GC2023/OV2710</td></tr>
   			<tr><td contenteditable="true">CMOS:4M,SENSOR GC4603/OV4689</td></tr>
   			<tr><td contenteditable="true">lens:4G; D=130，H=100，V=80"</td></tr>
   			-->
   			
   			<!--  <tr><td class="tit" name="frontCamera">Front camera</td><td>${dvrDetail.frontCamera}</td></tr>-->
   			
   			<!-- 取 frontCamera 值， 通过分号换行-->
   			<c:set var="frontCamera" value="${dvrDetail.frontCamera}"></c:set>
   			<tr>
   				<td class="tit" name="frontCamera">Front Camera:</td>
   				<td><!-- 以逗号分隔，换行显示 -->
   					<c:forEach items="${fn:split(frontCamera,';')}" varStatus="status" var="val" >
   						${val }</br>
   					</c:forEach>
   				</td>
   			</tr> 
   			
   			
   			<!-- 
   			<tr><td rowspan="2" class="tit">Frame Rate</td><td>"1920*1080 @ 30fps</td></tr>
   			<tr><td>1280*720P @ 30fps"</td></tr>
   			
   			<!-- 取 frameRate 值 -->
   			<c:set var="frameRate" value="${dvrDetail.frameRate}"></c:set>
   			<tr>
   				<td class="tit" name="frameRate">Frame Rate:</td>
   				<td><!-- 以逗号分隔，换行显示 -->
   					<c:forEach items="${fn:split(frameRate,';')}" varStatus="status" var="val" >
   						${val }</br>
   					</c:forEach>
   				</td>
   			</tr> 
   			<tr><td class="tit">Video Format:</td><td>${dvrDetail.videoFormat }</td></tr>
   			
   			<tr><td class="tit">Photo Resolution:</td><td>${dvrDetail.photoResolution }</td></tr>
   			<tr><td class="tit">Photo Format:</td><td>${dvrDetail.photoFormat }</td></tr>
   			<tr><td class="tit">Storage Card:</td><td>${dvrDetail.storageCard }</td></tr>
   			<tr><td class="tit">Card Capacity:</td><td>${dvrDetail.cardCapacity }</td></tr>
   			
   			<!-- 取 Rear Camera 值 -->
   			<c:set var="rearCamera" value="${dvrDetail.rearCamera }"></c:set>
   			<c:set var="rearCameraArr" value="${fn:split(rearCamera,';')}"></c:set>
   			<c:forEach items="${rearCameraArr }" varStatus="status" var="val" >
   				<c:if test="${status.index==0 }">
   					<tr><td rowspan="${fn:length(rearCameraArr) }" class="tit" name="rearCamera">Rear Camera</td><td>${val }</td></tr>
   				</c:if>
   				<c:if test="${status.index>0 }">
   					<tr><td>${val }</td></tr>
   				</c:if>
   			</c:forEach>
   			
   			<tr><td class="tit">G-sensor:</td><td>${dvrDetail.gsensor }</td></tr>
   			<tr><td class="tit">GPS:</td><td>${dvrDetail.gps }</td></tr>
   			<tr><td class="tit">WIFI:</td><td>${dvrDetail.wifi }</td></tr>
   			<tr><td class="tit">TV-OUT:</td><td>${dvrDetail.tvout }</td></tr>
   			<tr><td class="tit">HDMI:</td><td>${dvrDetail.hdmi }</td></tr>
   			<tr><td class="tit">WDR:</td><td>${dvrDetail.wdr }</td></tr>
   			<tr><td class="tit">ADAS:</td><td>${dvrDetail.adas }</td></tr>
   			<tr><td class="tit">USB:</td><td>${dvrDetail.usb }</td></tr>
   			<tr><td class="tit">Power Source:</td><td>${dvrDetail.powerSource }</td></tr>
   			<tr><td class="tit">Battery:</td><td>${dvrDetail.batter }</td></tr>
   			<tr><td class="tit">MIC:</td><td>${dvrDetail.mic }</td></tr>
   			<tr><td class="tit">Speaker:</td><td>${dvrDetail.speaker }</td></tr>
   			<tr><td class="tit">Language:</td><td>${dvrDetail.language }</td></tr>
   			<tr><td class="tit">Operating temperature:</td><td>${dvrDetail.operatingTemperature }</td></tr>
   			<tr><td class="tit">Storage temperature:</td><td>${dvrDetail.storageTemperature }</td></tr>
   			<tr><td class="tit">Weight:</td><td>${dvrDetail.weight }</td></tr>
   			<tr><td class="tit">Dimension:</td><td>${dvrDetail.dimension }</td></tr>
   		</table>
   		<a href="${pageContext.request.contextPath}/servlet/CreateDvrPdfServlet?ctrl=pdf&id=${dvrDetail.id}" class="btn"> 生成PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/CreateDvrExcelServlet?ctrl=excel&id=${dvrDetail.id}" class="btn"> 生成EXCEL</a>
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=DVR&fileType=pdf&fileName=${dvrDetail.model}.pdf" class="btn"> 下载PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=DVR&fileType=excel&fileName=${dvrDetail.model}.xls" class="btn"> 下载EXCEL</a>
    </div>
    <div id="lightBox">
    	<div class="mask"></div>
    	<div class="show">
    		<img id="bigPic" alt="img" src="${pageContext.request.contextPath}/uploadFile${dvrDetail.imageId}">
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
