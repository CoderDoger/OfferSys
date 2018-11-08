<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>Mirror</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;}
		#content{margin:1%;overflow: auto;}
		table{border:solid 1px #169662;border-collapse: collapse;}
		table tr{line-height:30px;}
		#show_disable{display: none;}
		table th,td{border:solid 1px #169662;padding-right:20px;padding-left:3px;}
		.tit{font-size:14px;font-weight:bold;}
		a{text-decoration:none;}
		#pdf,#excel,#confrim,#cancel{border:solid 1px #ccc;width:100px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px;color:#fff;}
		#hiddenForm{display: none;}
	</style>
  </head>
  
  <body>
    <div id="content">
   		<table>
   			<thead><th colspan="2">DVR for 3G/4G Product Specification</th></thead>
   			<tr><td class="tit" name="imageId">ID</td><td id="img"><img id="pic" src="${pageContext.request.contextPath}/uploadFile${mirrorDetail.imageId}" width="300"></td></tr>
   			<tr><td class="tit" name="productType">product type:</td><td contenteditable="true">${mirrorDetail.productType }</td></tr>
   			<tr><td class="tit" name="model">MODEL:</td><td contenteditable="true">${mirrorDetail.model }</td></tr>
   			<tr><td class="tit" name="os">OS:</td><td contenteditable="true">${mirrorDetail.os }</td></tr>
   			<tr><td class="tit" name="cpu">CPU:</td><td contenteditable="true">${mirrorDetail.cpu }</td></tr>
   			<tr><td class="tit" name="lcd">LCD:</td><td contenteditable="true">${mirrorDetail.lcd }</td></tr>
   			<tr><td class="tit" name="tp">TP:</td><td contenteditable="true">${mirrorDetail.tp }</td></tr>
   			<tr><td class="tit" name="ram">RAM:</td><td contenteditable="true">${mirrorDetail.ram }</td></tr>
   			<tr><td class="tit" name="rom">FLASH ROM:</td><td contenteditable="true">${mirrorDetail.rom }</td></tr>
   			<tr><td class="tit" name="dvr">DVR:</td><td contenteditable="true">${mirrorDetail.dvr }</td></tr>
   			<tr><td class="tit" name="frontCamera">Front Camera:</td><td contenteditable="true">${mirrorDetail.frontCamera }</td></tr>
   			<!-- 
   			<!-- 取 frontCameracamera 值 
   			<c:set var="frontCamera" value="${mirrorDetail.frontCamera}"></c:set>
   			<tr>
   				<td class="tit" name="frontCamera">Front Camera:</td>
   				<td contenteditable="true"><!-- 以分号 ; 分隔 换行显示 
   					<c:forEach items="${fn:split(frontCamera,';')}" varStatus="status" var="val" >
   						${val };</br>
   					</c:forEach>
   				</td>
   			</tr>
   			 -->
   			
   			<tr><td class="tit" name="realCamera">Real Camera:</td><td contenteditable="true">${mirrorDetail.realCamera }</td></tr>
   			<tr><td class="tit" name="card">TF Card:</td><td contenteditable="true">${mirrorDetail.card }</td></tr>
   			
   			<tr><td class="tit" name="multimedia">Software Support:</td><td contenteditable="true">${mirrorDetail.multimedia }</td></tr>
   			<!-- 取 multimedia 值 
   			<c:set var="multimedia" value="${mirrorDetail.multimedia}"></c:set>
   			<tr>
   				<td class="tit" name="multimedia">Multimedia</td>
   				<td contenteditable="true"><!-- 以逗号分隔，换行显示
   					<c:forEach items="${fn:split(multimedia,';')}" varStatus="status" var="val" >
   						${val };</br>
   					</c:forEach>
   				</td>
   			</tr> -->
   			<!-- 业务显示屏蔽tools显示 -->
   			<tr id="show_disable"><td class="tit" name="tools">Tools:</td><td contenteditable="true">${mirrorDetail.tools }</td></tr>
   			<tr><td class="tit" name="gps">GPS:</td><td contenteditable="true">${mirrorDetail.gps }</td></tr>
   			<tr><td class="tit" name="wifi">Wifi:</td><td contenteditable="true">${mirrorDetail.wifi }</td></tr>
   			<tr><td class="tit" name="bluetooth">BT:</td><td contenteditable="true">${mirrorDetail.bluetooth }</td></tr>
   			<!-- 取 bluetooth 值 
   			<c:set var="bluetooth" value="${mirrorDetail.bluetooth}"></c:set>
   			<tr>
   				<td class="tit" name="bluetooth">BT</td>
   				<td contenteditable="true"><!-- 以逗号分隔，换行显示
   					<c:forEach items="${fn:split(bluetooth,';')}" varStatus="status" var="val" >
   						${val };</br>
   					</c:forEach>
   				</td>
   			</tr> -->
   			
   			<tr><td class="tit" name="fmt">FM transmit:</td><td contenteditable="true">${mirrorDetail.fmt }</td></tr>
   			<tr><td class="tit" name="avin">AV IN:</td><td contenteditable="true">${mirrorDetail.avin }</td></tr>
			<tr><td class="tit" name="band">Band:</td><td contenteditable="true">${mirrorDetail.band }</td></tr>	
   			<!-- 取 band 值 
   			<c:set var="band" value="${mirrorDetail.band}"></c:set>
   			<tr>
   				<td class="tit" name="band">Band:</td>
   				<td contenteditable="true"><!-- 以分号 ; 分隔 换行显示 
   					<c:forEach items="${fn:split(band,';')}" varStatus="status" var="val" >
   						${val };</br>
   					</c:forEach>
   				</td>
   			</tr>-->
   			
   			<tr><td class="tit" name="gsensor">G-sensor:</td><td contenteditable="true">${mirrorDetail.gsensor }</td></tr>
   			<tr><td class="tit" name="speaker">Speaker:</td><td contenteditable="true">${mirrorDetail.speaker }</td></tr>
   			<tr><td class="tit" name="mic">MIC:</td><td contenteditable="true">${mirrorDetail.mic }</td></tr>
   			<tr><td class="tit" name="usb">USB:</td><td contenteditable="true">${mirrorDetail.usb }</td></tr>
   			<tr><td class="tit" name="charger">Charger:</td><td contenteditable="true">${mirrorDetail.charger }</td></tr>
   			<tr><td class="tit" name="battery">Battery:</td><td contenteditable="true">${mirrorDetail.battery }</td></tr>
   			<tr><td class="tit" name="language">Language:</td><td contenteditable="true">${mirrorDetail.language }</td></tr>
   			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td contenteditable="true">${mirrorDetail.operatingTemperature }</td></tr>
   			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td contenteditable="true">${mirrorDetail.storageTemperature }</td></tr>
   			<tr><td class="tit" name="weight">weight:</td><td contenteditable="true">${mirrorDetail.weight }</td></tr>
   			<tr><td class="tit" name="dimension">Dimension:</td><td contenteditable="true">${mirrorDetail.dimension }</td></tr>
   		</table>
   		<a href="javascript:void(0)" id="confrim"> 提效修改</a><a href="javascript:history.back();" id="cancel"> 放弃修改</a>
    </div>
    <div id="hiddenForm">
    	<form method="post" enctype="multipart/form-data" name="fm" id="fm">
   			<input type='file' id='file'  name='file' />
   			<input type="text" name="id" value="${mirrorDetail.id}"/>
   			<input type="text" name="ctrl" value="upload">
   		</form>
    </div>
  </body>
  <script type="text/javascript">
  	//设置显示大小、
  	$(document).ready(function(){
		var wH = $(window).height();
		//var wW = $(window).width();
	
		$("#content").height(wH-50);
		$("#content").width("98%");
	});
  	//
  	$(document).ready(function(){
  		
  		
  		var key, value,rowspan,tkey,tvalue;
		var offset = 0;	//夸行的末尾标记
		var rowspan = null; //夸行数
		var index = 0;
		var reg = "/(^\s*)|(\s*$)/g"; //匹配空格

		//创建Form表单  给Form填充数据 
  		$("#confrim").click(function(){
	
  		var form = $("<form></form>");
  		//设置Form表单属性
  		form.attr({action:"${pageContext.request.contextPath}/servlet/MirrorControllerServlet?ctrl=modify&id=${mirrorDetail.id}",method:"POST",enctype:"pplication/x-www-form-urlencoded"});
  			$("table tr").each(function(i){
  				if(i==0)
  					return true;
  				//获取rowspan 并判断是否存在
  				var rowspanObj = $(this).find("td").attr("rowspan")?$(this).find("td").attr("rowspan"):rowspan;
  				if(rowspanObj)
  					rowspan = parseInt( rowspanObj);
  				//存在rowspan时
  				if(rowspan>1){
  					
  					if(!tkey){
  						offset = i+rowspan;
  						///console.log("+++++++++++++++++++++++++++++++++++++++");
  						tkey = $(this).find("td").first().attr("name");
  						//console.log("td===>"+$(this).find("td").last().text());
  						tvalue = new Array();
  						tvalue[index] = $(this).find("td").last().text().trim();
  						/*****************重点：数组的传递*****************************/
  						var input = $("<input type='text' name='"+tkey+"' value='"+tvalue[index]+"' />");
  						form.append(input);
  						//console.log("tr="+i+"tkey=>"+tkey+"		tvalue==>"+tvalue);
  						index++;
  						return true;
  					}
  					//console.log("offset="+ offset);
  					if(i<offset){
  						tvalue[index] = $(this).find("td").last().text().trim();
  						/*****************重点：数组的传递*****************************/
  						var input = $("<input type='text' name='"+tkey+"' value='"+tvalue[index]+"' />");
  						form.append(input);
  						index++;
  						//console.log("tr="+i+"tkey=>"+tkey+"		tvalue==>"+tvalue);
  						
  					}else{
  						//重置
  						
  						index = 0;
  						offset = 0;
  						rowspan = null;
  						tkey = null;
  						tvalue = null;
  						
  						//重点：重置时，本次数据还是要取走的
  						key = $(this).find("td").first().attr("name");
	  					value = $(this).find("td").last().text().trim();
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  					}
  					
  				}else{
  					if(i==1){
  						key = $(this).find("td").first().attr("name");
  						var src = $(this).find("td").last().find("img").attr("src");
  						var index = src.lastIndexOf("/");
	  					value = src.substr(index).trim();
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  					}else{
  						key = $(this).find("td").first().attr("name");
	  					value = $(this).find("td").last().text().trim();
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  					}
  				}
  			});
  			//兼容chrome56
  			$("body").append(form);
  			//提交Form表单
	  		form.submit();
	  		return false;
  		});
  		/*****************************************************************/
  		//ID图上传
  		var file = $("#file");
  		
  		$("#img").click(function(){
  			file.value = "";
  			file.click();
  		})
  		file.change(function(){
  			var formData = new FormData($("#fm")[0]);
	  		$.ajax({
  					type:"POST",
  					url:"${pageContext.request.contextPath}/servlet/FileUplaodServlet",
  					data:formData,
  					processData: false,  // 告诉jQuery不要去处理发送的数据
             		contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
          			cache: false,
  					success: function(msg){
  						var objs = eval("("+msg+")");
  						if(objs.status!="ok"){
  							return false;
  						}
  						//document.getElementById("pic").src=objs.src;
  						$("#pic").attr("src",objs.src);
  					}
	  		}); 
  		});
  		
  	});
  </script>
</html>
