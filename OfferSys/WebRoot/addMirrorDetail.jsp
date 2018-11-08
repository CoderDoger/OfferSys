<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>Mirror</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:14px;font-family:"Arial";}
		#content{margin:1%;overflow: auto;}
		table{border:solid 1px #169662;border-collapse: collapse;white-space: pre-wrap;}
		table tr{line-height:30px;}
		#show_disable{display: none;}
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
    			<tr><th colspan="2">Mirror Product Specificationr</th></tr>
    			<tr><td class="tit" name="imageId"><div>ID</div></td><td id="img"><div><img width="300" id="pic" src="images/bg1.jpg"></div></td></tr>
    			<tr><td class="tit" name="productType"><div>product type:</div></td><td contenteditable="true"><div><br>Android LTE Mirror</div></td></tr>
    			<tr><td class="tit" name="model"><div>MODEL:</div></td><td contenteditable="true"><div>CPR-6801</div></td></tr>
    			<tr><td class="tit" name="os"><div>OS:</div></td><td contenteditable="true"><div>Android5.1</div></td></tr>
    			<tr><td class="tit" name="cpu"><div>CPU:</div></td><td contenteditable="true"><div>MT8735 Quad-Core Cortex -A7 @1.3GHz</div></td></tr>
    			<tr><td class="tit" name="lcd"><div>LCD:</div></td><td contenteditable="true"><div>6.86&quot;TFT 480X1280</div></td></tr>
    			<tr><td class="tit" name="tp"><div>TP:</div></td><td contenteditable="true"><div>Capacitive Touch Screen ,5 points touch</div></td></tr>
    			<tr><td class="tit" name="ram"><div>RAM:</div></td><td contenteditable="true"><div>1GB</div></td></tr>
    			<tr><td class="tit" name="rom"><div>FLASH ROM:</div></td><td contenteditable="true"><div>8GB/16G(optional)</div></td></tr>
    			<tr><td class="tit" name="dvr"><div>DVR:</div></td><td contenteditable="true"><div>Build-in DVR 1080P@30fps</div></td></tr>
    			<tr><td class="tit" name="frontCamera"><div>Front Camera:</div></td><td contenteditable="true"><div>CMOS:2M,SENSOR GC2023/OV2710;lens:4G; D=130，H=100，V=80</div></td></tr>
    			<tr><td class="tit" name="realCamera"><div>Real Camera:</div></td><td contenteditable="true"><div>0.3M CVBS(optional)</div></td></tr>
    			<tr><td class="tit" name="card"><div>TF Card:</div></td><td contenteditable="true"><div>Max 32G</div></td></tr>
    			
    			<tr><td class="tit" name="multimedia"><div>Software Support:</div></td><td contenteditable="true"><div>Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer</div></td></tr>
    			<!-- 业务显示屏蔽tools显示 -->
    			<tr id="show_disable"><td class="tit" name="tools"><div>Tools:</div></td><td contenteditable="true"><div>Support calendar and calculator</div></td></tr>	
    			
    			<tr><td class="tit" name="gps"><div>GPS:</div></td><td contenteditable="true"><div>Built-in GPS+AGPS</div></td></tr>
    			<tr><td class="tit" name="bluetooth"><div>BT:</div></td><td contenteditable="true"><div>YES(optional)</div></td></tr>
    			<tr><td class="tit" name="wifi"><div>WIFI:</div></td><td contenteditable="true"><div>Build-in WIFI,802.11b/g/n</div></td></tr>
    			<tr><td class="tit" name="avin"><div>AVIN:</div></td><td contenteditable="true"><div>YES(optional)</div></td></tr>
    			<tr><td class="tit" name="fmt"><div>FM transmit:</div></td><td contenteditable="true"><div>YES(optional)</div></td></tr>
    			
    			<tr>
	    			<td class="tit" name="band"><div>Band:</div></td>
	    			<td contenteditable="true"><div>GSM/WCDMA/TDS-CDMA/FDD-LTE/TDD-LTE; 
GSM:900/1800; 
WCDMA:BAND1/8; 
TDS-CDMA:BAND34/39; 
FDD-LTE:BAND1/3; 
TDD-LTE:BAND38/39/40/41; 
WCDMA:UL-5.76Mbps;DL-21Mbps; 
TDS-CDMA:UL-2.2Mbps;DL-2.8Mbps; 
LTE:UL-50Mbps;DL-150Mbps;</div></td>
    			</tr>
    			
    			
    			<tr><td class="tit" name="speaker"><div>Speaker:</div></td><td contenteditable="true"><div>Build-in 1.5W Speaker</div></td></tr>
    			<tr><td class="tit" name="gsensor"><div>G-sensor:</div></td><td contenteditable="true"><div>YES(optional)</div></td></tr>
    			<tr><td class="tit" name="mic"><div>MIC:</div></td><td contenteditable="true"><div>Build-in MIC</div></td></tr>
    			<tr><td class="tit" name="usb"><div>USB:</div></td><td contenteditable="true"><div>USB2.0</div></td></tr>
    			<tr><td class="tit" name="charger"><div>Charger:</div></td><td contenteditable="true"><div>MinUSB 5V/1A</div></td></tr>
    			<tr><td class="tit" name="battery"><div>Battery:</div></td><td contenteditable="true"><div>650mAh Poly-lithium battery</div></td></tr>
    			<tr><td class="tit" name="language"><div>Language:</div></td><td contenteditable="true"><div>Multi-language</div></td></tr>
    			<tr><td class="tit" name="operatingTemperature">Operating temperature:</td><td contenteditable="true">-10℃--- +60</td></tr>
    			<tr><td class="tit" name="storageTemperature">Storage temperature:</td><td contenteditable="true">-20℃--- +70</td></tr>
    			<tr><td class="tit" name="weight">Weight:</td><td contenteditable="true">TBD</td></tr>
    			<tr><td class="tit" name="dimension">Dimension:</td><td contenteditable="true">'315.25*82.05*24.2mm</td></tr>
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
  		form.attr({action:"${pageContext.request.contextPath}/servlet/MirrorControllerServlet?ctrl=add",method:"POST"});
  		
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
