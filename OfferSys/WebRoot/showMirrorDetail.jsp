<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>DVR for 3G/4G</title>
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
   			<thead><th colspan="2">DVR for 3G/4G Product Specification</th></thead> 
   			<tr> 
   				<td class="tit" name="imageId">ID</td> 
   				<td id="prompt" style="position: relative;"> 
   					<img width="300" alt="img" src="${pageContext.request.contextPath}/uploadFile${mirrorDetail.imageId}"> 
   					<span>点击我看大图！</span> 
   				</td> 
   			</tr> 
   			<tr><td class="tit" name="productType">product type:</td><td>${mirrorDetail.productType }</td></tr> 
   			<tr><td class="tit" name="model">MODEL:</td><td>${mirrorDetail.model }</td></tr> 
   			<tr><td class="tit" name="os">OS:</td><td>${mirrorDetail.os }</td></tr> 
   			<!--<tr><td class="tit" name="cpu">CPU:</td><td>${mirrorDetail.cpu }</td></tr>  --> 
   			<!-- 取 cpu 值 --> 
   			<c:set var="cpu" value="${mirrorDetail.cpu }"></c:set>
   			<tr> 
   				<td class="tit" name="cpu">CPU:</td> 
   				<td><!-- 以分号 ; 分隔 换行显示  -->
   					<c:forEach items="${fn:split(cpu,';')}"  var="val"> 
   						${val }<br> 
   					</c:forEach> 
   				</td> 
   			</tr>
   			
   			<tr><td class="tit" name="lcd">LCD:</td><td>${mirrorDetail.lcd }</td></tr> 
   			<tr><td class="tit" name="tp">TP:</td><td>${mirrorDetail.tp }</td></tr> 
   			<tr><td class="tit" name="ram">RAM:</td><td>${mirrorDetail.ram }</td></tr> 
   			<tr><td class="tit" name="rom">FLASH ROM:</td><td>${mirrorDetail.rom }</td></tr> 
   			 
			<!-- <tr><td class="tit" name="frontCamera">Front Camera:</td> <td>${mirrorDetail.frontCamera }</td></tr>  -->
			
   			<!-- 取 frontCamera 值 --> 
   			<c:set var="frontCamera" value="${mirrorDetail.frontCamera}"></c:set>
   			<tr> 
   				<td class="tit" name="frontCamera">Front Camera:</td> 
   				<td><!-- 以分号 ; 分隔 换行显示  -->
   					<c:forEach items="${fn:split(frontCamera,';')}"  var="val"> 
   						${val }<br> 
   					</c:forEach> 
   				</td> 
   			</tr>
   			 
   			<!-- <tr><td class="tit" name="realCamera">Real Camera:</td><td>${mirrorDetail.realCamera }</td></tr> --> 
   			 <!-- 取 realCamera 值 --> 
   			<c:set var="realCamera" value="${mirrorDetail.realCamera }"></c:set>
   			<tr> 
   				<td class="tit" name="realCamera">Real Camera:</td> 
   				<td><!-- 以分号 ; 分隔 换行显示  -->
   					<c:forEach items="${fn:split(realCamera,';')}"  var="val"> 
   						${val }<br> 
   					</c:forEach> 
   				</td> 
   			</tr>
   			 
   			<!-- 取 multimedia 值 --> 
   			<c:set var="multimedia" value="${mirrorDetail.multimedia}"></c:set>
   			<tr> 
   				<td class="tit" name="multimedia"><blockquote>Software Feature:</blockquote></td> 
   				<td><!-- 以逗号分隔，换行显示 --> 
   					<blockquote><c:forEach items="${fn:split(multimedia,';')}" var="val"> 
   						${val }<br> 
   					</c:forEach></blockquote>
   					
   				</td> 
   			</tr> 
   			<!--
   			<tr><td class="tit" name="tools"><blockquote>Tools:</blockquote></td><td><blockquote>${mirrorDetail.tools }</blockquote></td></tr> 
   			-->
   			<tr><td class="tit" name="gps"><blockquote>GPS:</blockquote></td><td><blockquote>${mirrorDetail.gps }</blockquote></td></tr> 
   			<!-- 取 bluetooth 值 --> 
   			<c:set var="bluetooth" value="${mirrorDetail.bluetooth}"></c:set>
   			<tr> 
   				<td class="tit" name="bluetooth"><blockquote>BT</blockquote></td> 
   				<td><!-- 以逗号分隔，换行显示 --> 
   					<blockquote><c:forEach items="${fn:split(bluetooth,';')}" var="val"> 
   						${val }<br> 
   					</c:forEach></blockquote> 
   				</td> 
   			</tr> 
   			<tr><td class="tit" name="wifi"><blockquote>Wifi:</blockquote></td><td><blockquote>${mirrorDetail.wifi }</blockquote></td></tr> 
   			<tr><td class="tit" name="fmt"><blockquote>FM transmit:</blockquote></td><td><blockquote>${mirrorDetail.fmt }</blockquote></td></tr> 
   			<tr><td class="tit" name="avin"><blockquote>AV IN:</blockquote></td><td><blockquote>${mirrorDetail.avin }</blockquote></td></tr> 
   			 
   			<!-- 取 band 值 --> 
   			<c:set var="band" value="${mirrorDetail.band}"></c:set>
   			<tr> 
   				<td class="tit" name="band"><blockquote>Band:</blockquote></td> 
   				<td><!-- 以分号 ; 分隔 换行显示 --> 
   					<blockquote><c:forEach items="${fn:split(band,';')}"  var="val"> 
   						${val }<br> 
   					</c:forEach></blockquote> 
   				</td> 
   			</tr> 
   			 
   			<tr><td class="tit" name="gsensor"><blockquote>Gsensor:</blockquote></td><td>${mirrorDetail.gsensor }</td></tr> 
   			<tr><td class="tit" name="speaker">Speaker:</td><td>${mirrorDetail.speaker }</td></tr> 
   			<tr><td class="tit" name="mic">MIC:</td><td>${mirrorDetail.mic }</td></tr> 
   			<tr><td class="tit" name="usb">USB:</td><td>${mirrorDetail.usb }</td></tr> 
   			<tr><td class="tit" name="charger">Charger:</td><td>${mirrorDetail.charger }</td></tr> 
   			<tr><td class="tit" name="battery">Battery:</td><td>${mirrorDetail.battery }</td></tr> 
   			<tr><td class="tit" name="language">Language:</td><td>${mirrorDetail.language }</td></tr> 
   			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td>${mirrorDetail.operatingTemperature }</td></tr> 
   			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td>${mirrorDetail.storageTemperature }</td></tr> 
   			<tr><td class="tit" name="weight">weight:</td><td>${mirrorDetail.weight }</td></tr> 
   			<tr><td class="tit" name="dimension">Dimension:</td><td>${mirrorDetail.dimension }</td></tr> 
   		</table>
   		<a href="${pageContext.request.contextPath}/servlet/CreateMirrorPdfServlet?ctrl=pdf&id=${mirrorDetail.id}" class="btn"> 生成PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/CreateMirrorExcelServlet?ctrl=excel&id=${mirrorDetail.id}" class="btn"> 生成EXCEL</a>
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=Mirror&fileType=pdf&fileName=${mirrorDetail.model}.pdf" class="btn"> 下载PDF</a> 
   		<a href="${pageContext.request.contextPath}/servlet/DownLoadServlet?category=Mirror&fileType=excel&fileName=${mirrorDetail.model}.xls" class="btn"> 下载EXCEL</a>
    </div>
    <div id="lightBox">
    	<div class="mask"></div>
    	<div class="show">
    		<img id="bigPic" alt="img" src="${pageContext.request.contextPath}/uploadFile${mirrorDetail.imageId}">
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
