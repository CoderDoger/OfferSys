<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>DVR</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;font-family:"arial";}
		#content{margin:1%;overflow: auto;}
		table{border:solid 1px #169662;border-collapse: collapse;}
		table tr{line-height:30px;}
		table th,td{border:solid 1px #169662;padding-right:20px;padding-left:3px;}
		.tit{font-size:14px;font-weight:bold;}
		a{text-decoration:none;}
		#confrim,#cancel{border:solid 1px #ccc;width:80px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px;color:#fff;}
		#hiddenForm{display: none;}
	</style>
  </head>
  
  
  
  <body>
    <div id="content">
    		<table>
    			<tr><th colspan="2">DVR Product Specification</th></tr>
    			<tr><td class="tit" name="imageId">ID</td><td id="img"><img id="pic" src="images/bg1.jpg" width="300"></td></tr>
    			<tr><td class="tit" name="productType">product type:</td><td contenteditable="true">Car DVR</td></tr>
    			<tr><td class="tit" name="model">MODEL:</td><td contenteditable="true">CPR-4005</td></tr>
    			<tr><td class="tit" name="cpu">CPU:</td><td contenteditable="true">MSC8328P</td></tr>
    			<tr><td class="tit" name="lcd">LCD:</td><td contenteditable="true">4.0" IPS（800X480)</td></tr>
    			
    			<tr><td  class="tit" name="frontCamera">Front camera:</td><td contenteditable="true">CMOS:2M,SENSOR GC2023/OV2710</td></tr>
    			<tr><td class="tit" name="videoFormat">Video Format:</td><td contenteditable="true">H.264 AVI</td></tr>
    			
    			<tr><td class="tit" name="frameRate">Frame Rate:</td><td contenteditable="true">1920*1080@30fps</td></tr>
    			
    			<tr><td class="tit" name="photoResolution">Photo Resolution:</td><td contenteditable="true">3M</td></tr>
    			<tr><td class="tit" name="photoFormat">Photo Format:</td><td contenteditable="true">JPEG</td></tr>
    			<tr><td class="tit" name="storageCard">Storage Card:</td><td contenteditable="true">TF Card</td></tr>
    			<tr><td class="tit" name="cardCapacity">Card Capacity:</td><td contenteditable="true">Support 128G</td></tr>
    			<tr><td class="tit" name="rearCamera">Rear Camera:</td><td contenteditable="true">CVBS 0.3M VGA/USB 1.0M 720P</td></tr>
    			<tr><td class="tit" name="gsensor">G-sensor:</td><td contenteditable="true">YES</td></tr>
    			<tr><td class="tit" name="gps">GPS:</td><td contenteditable="true">YES(Option)</td></tr>
    			<tr><td class="tit" name="wifi">WIFI:</td><td contenteditable="true">NO</td></tr>
    			<tr><td class="tit" name="tvout">TV-OUT:</td><td contenteditable="true">NO</td></tr>
    			<tr><td class="tit" name="hdmi">HDMI:</td><td contenteditable="true">NO</td></tr>
    			<tr><td class="tit" name="wdr">WDR:</td><td contenteditable="true">YES</td></tr>
    			<tr><td class="tit" name="adas">ADAS:</td><td contenteditable="true">YES(Option)</td></tr>
    			<tr><td class="tit" name="usb">USB:</td><td contenteditable="true">USB2.0</td></tr>
    			<tr><td class="tit" name="powerSource">Power Source:</td><td contenteditable="true">USB 5V/1.0A</td></tr>
    			<tr><td class="tit" name="batter">Battery:</td><td contenteditable="true">***mAh Poly-lithium battery</td></tr>
    			<tr><td class="tit" name="mic">MIC:</td><td contenteditable="true">YES</td></tr>
    			<tr><td class="tit" name="speaker">Speaker:</td><td contenteditable="true">YES</td></tr>
    			<tr><td class="tit" name="language">Language:</td><td contenteditable="true">Multi-language</td></tr>
    			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td contenteditable="true">-10℃--- +60</td></tr>
    			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td contenteditable="true">-20℃--- +70</td></tr>
    			<tr><td class="tit" name="weight">weight:</td><td contenteditable="true"></td></tr>
    			<tr><td class="tit" name="dimension">Dimension:</td><td contenteditable="true"></td></tr>
    		</table>
    		<a href="javascript:void(0)" id="confrim"> 添加</a><a href="javascript:history.back();" id="cancel"> 取消</a>
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
  		//创建Form表单
  		var form = $("<form></form>");
  		//设置Form表单属性
  		form.attr({action:"${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=add",method:"POST"});
  		
  		var key, value,rowspan,tkey,tvalue;
		var offset = 0;	//夸行的末尾标记
		var rowspan = null; //夸行数
		var index = 0;

		//给Form填充数据 
  		$("#confrim").click(function(){

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
	  					//value = $(this).find("td").last().find("img").attr("src");
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
