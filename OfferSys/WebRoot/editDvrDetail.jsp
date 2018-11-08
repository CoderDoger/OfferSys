<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>DVR</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;}
		#content{margin:1%;overflow: auto;}
		table{border:solid 1px #169662;border-collapse: collapse;}
		table tr{line-height:30px;}
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
   			<thead><th colspan="2">DVR Product Specification</th></thead>
   			<tr><td class="tit" name="imageId">ID</td><td id="img"><img id="pic" alt="img" src="${pageContext.request.contextPath }/uploadFile/${dvrDetail.imageId}" width="300"></td></tr>
   			<tr><td class="tit" name="productType">product type:</td><td contenteditable="true">${dvrDetail.productType}</td></tr>
   			<tr><td class="tit" name="model">MODEL:</td><td contenteditable="true">${dvrDetail.model }</td></tr>
   			<tr><td class="tit" name="cpu">CPU:</td><td contenteditable="true">${dvrDetail.cpu }</td></tr>
   			<tr><td class="tit" name="lcd">LCD:</td><td contenteditable="true">${dvrDetail.lcd }</td></tr>
   			<tr><td class="tit" name="frontCamera">Front camera:</td><td contenteditable="true">${dvrDetail.frontCamera}</td></tr>
   			<tr><td class="tit" name="videoFormat">Video Format:</td><td contenteditable="true">${dvrDetail.videoFormat }</td></tr>
   			<tr><td class="tit" name="frameRate">Frame Rate:</td><td contenteditable="true">${dvrDetail.frameRate }</td></tr>
   			<tr><td class="tit" name="photoResolution">Photo Resolution:</td><td contenteditable="true">${dvrDetail.photoResolution }</td></tr>
   			<tr><td class="tit" name="photoFormat">Photo Format:</td><td contenteditable="true">${dvrDetail.photoFormat }</td></tr>
   			<tr><td class="tit" name="storageCard">Storage Card:</td><td contenteditable="true">${dvrDetail.storageCard }</td></tr>
   			<tr><td class="tit" name="cardCapacity">Card Capacity:</td><td contenteditable="true">${dvrDetail.cardCapacity }</td></tr>
   			<tr><td class="tit" name="rearCamera">Rear Camera:</td><td contenteditable="true">${dvrDetail.rearCamera }</td></tr>
   			<tr><td class="tit" name="gsensor">G-sensor:</td><td contenteditable="true">${dvrDetail.gsensor }</td></tr>
   			<tr><td class="tit" name="gps">GPS:</td><td contenteditable="true">${dvrDetail.gps }</td></tr>
   			<tr><td class="tit" name="wifi">WIFI:</td><td contenteditable="true">${dvrDetail.wifi }</td></tr>
   			<tr><td class="tit" name="tvout">TV-OUT:</td><td contenteditable="true">${dvrDetail.tvout }</td></tr>
   			<tr><td class="tit" name="hdmi">HDMI:</td><td contenteditable="true">${dvrDetail.hdmi }</td></tr>
   			<tr><td class="tit" name="wdr">WDR:</td><td contenteditable="true">${dvrDetail.wdr }</td></tr>
   			<tr><td class="tit" name="adas">ADAS:</td><td contenteditable="true">${dvrDetail.adas }</td></tr>
   			<tr><td class="tit" name="usb">USB:</td><td contenteditable="true">${dvrDetail.usb }</td></tr>
   			<tr><td class="tit" name="powerSource">Power Source:</td><td contenteditable="true">${dvrDetail.powerSource }</td></tr>
   			<tr><td class="tit" name="batter">Battery:</td><td contenteditable="true">${dvrDetail.batter }</td></tr>
   			<tr><td class="tit" name="mic">MIC:</td><td contenteditable="true">${dvrDetail.mic }</td></tr>
   			<tr><td class="tit" name="speaker">Speaker:</td><td contenteditable="true">${dvrDetail.speaker }</td></tr>
   			<tr><td class="tit" name="language">Language:</td><td contenteditable="true">${dvrDetail.language }</td></tr>
   			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td contenteditable="true">${dvrDetail.operatingTemperature }</td></tr>
   			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td contenteditable="true">${dvrDetail.storageTemperature }</td></tr>
   			<tr><td class="tit" name="weight">weight:</td><td contenteditable="true">${dvrDetail.weight }</td></tr>
   			<tr><td class="tit" name="dimension">Dimension:</td><td contenteditable="true">${dvrDetail.dimension }</td></tr>
   		</table>
   		<a href="javascript:void(0)" id="confrim"> 提效修改</a><a href="javascript:history.back();" id="cancel"> 放弃修改</a>
    </div>
    <div id="hiddenForm">
    	<form method="post" enctype="multipart/form-data" name="fm" id="fm">
   			<input type='file' id='file'  name='file' />
   			<input type="text" name="id" value="${dvrDetail.id}"/>
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

		//创建Form表单  给Form填充数据 
  		$("#confrim").click(function(){
	
  		var form = $("<form></form>");
  		//设置Form表单属性
  		form.attr({action:"${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=modify&id=${dvrDetail.id}",method:"POST",enctype:"pplication/x-www-form-urlencoded"});
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
  						tvalue[index] = $(this).find("td").last().text();
  						/*****************重点：数组的传递*****************************/
  						var input = $("<input type='text' name='"+tkey+"' value='"+tvalue[index]+"' />");
  						form.append(input);
  						//console.log("tr="+i+"tkey=>"+tkey+"		tvalue==>"+tvalue);
  						index++;
  						return true;
  					}
  					//console.log("offset="+ offset);
  					if(i<offset){
  						tvalue[index] = $(this).find("td").last().text();
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
	  					value = $(this).find("td").last().text();
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  					}
  					
  				}else{
  					if(i==1){
  						key = $(this).find("td").first().attr("name");
  						var src = $(this).find("td").last().find("img").attr("src");
  						var index = src.lastIndexOf("/");
	  					value = src.substr(index);
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  					}else{
  						key = $(this).find("td").first().attr("name");
	  					value = $(this).find("td").last().text();
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
