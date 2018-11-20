<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    
    <title>添加模板</title>
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
		#confrim,#cancel,#addline,#delline{border:solid 1px #ccc;width:80px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px;color:#fff;}
		#hiddenForm{display: none;}
	</style>
  </head>
  
  <body>
    <div id="content">
    		<table>
    			<tr><th colspan="2">规格书模板添加</th></tr>
    			<tr><th>序号</th><th>类目</th></tr>
    			<tr><td class="tit" name="productType"><div>1</div></td><td contenteditable="true"><div>Android LTE Mirror</div></td></tr>
    			
    		</table>
    		<a href="javascript:void(0)" id="addline">  增加行</a>
    		<a href="javascript:void(0)" id="delline"> 删除行</a>
    		<a href="javascript:void(0)" id="confrim">  添加</a>
    		<a href="javascript:history.back();" id="cancel"> 取消</a>
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
  		//表格初始行数
  		var line = 2;
  		//表格的实际行数(除表头外)
  		var actualLine = 0;
  		
  		//新增行
  		$('#addline').click(function(){
  				
  			//得到表格的总行数
  			var len = $('table tr').length;
  			
  			actualLine = len - line;
  			
  			var mtr = $('<tr><td class="tit" name="productType"><div>'+ ++actualLine +'</div></td><td contenteditable="true"><div></div></td></tr>');
  			$("table").append(mtr);
  		});
  		//删除行
  		$('#delline').click(function(){
  			//得到表格的总行数
  			var len = $('table tr').length;
  			
  			actualLine = len - line;
  			if(actualLine<=1){
  				alert("没有可删除的行了！");
  				return false;
  			}else{
  				$("table tr:last").remove();
  				actualLine--;
  			}
  				
  		});
  	
  	
  	
  		//创建Form表单
  		var form = $("<form></form>");
  		//设置Form表单属性
  		form.attr({action:"?#",method:"POST"});
  		//form.attr({action:"${pageContext.request.contextPath}/servlet/MirrorControllerServlet?ctrl=addTemp",method:"POST"});
  		
  		//表单的name 及value
  		var key, value;

		//给Form填充数据 
  		$("#confrim").click(function(){

  			$("table tr").each(function(i){
  				if(i<=1)
  					return true;
  				else{
  					//重点：重置时，本次数据还是要取走的
  						key = "field"+ $(this).find("td").first().text();
	  					value = $(this).find("td").last().text();
	  					//console.log("tr="+i+"key=>"+key+"		value==>"+value);
	  					var input = $("<input type='text' name='"+key+"' value='"+value+"' />");
	  					form.append(input);
  				}
  			});
  			//兼容chrome56
  			$("body").append(form);
  			//提交Form表单
	  		form.submit();
	  		return false;
  		});
  		
  	});
  </script> 
</html>
