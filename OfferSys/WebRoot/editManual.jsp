<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>UpLoad Manual</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<style type="text/css">
		*{font-size:14px;font-family:"arial";padding:0px;margin:0px;}
		#content{margin:1%;overflow: auto;}
		#content .upload{width:500px;height:300px;margin:auto;position: absolute;top: 0px;left:0px;right:0px;bottom:0px;border:solid 1px #28b779;border-radius:5px;box-showdow:2px 2px 18px #2CC17E;}
		#content .upload h2{background: #2CC17E;color: #fff;height:30px;line-height: 30px;}
		#content .upload p{line-height:50px;text-indent: 10px;}
		input,select{width:250px;line-height: 30px;border:solid 1px #28b779;border-radius:2px;outline: none;vertical-align: middle;}
		a{text-decoration:none;}
		#confrim,#cancel{border:solid 1px #ccc;width:80px;line-height:30px;border-radius:5px;display:inline-block;text-align:center;background:#169662;margin:20px;color:#fff;}
	</style>
  </head>
  
  <body>
    <div id="content">
	  <div class="upload">
	  	  <h2>产品说明书上传</h2>
			<form id="f1" method="post" type="ap" >
				<p>
					<label>产品类别：</label>
					<select name="object">
						<c:if test="${manual.objName eq 'GPS' }">
							<option value="GPS" selected="selected">GPS Manual</option>
							<option value="DVR" >DVR Manual</option>
							<option value="PND">PND Manual</option>
							<option value="Mirror">Mirror Manual</option>
						</c:if>
						<c:if test="${manual.objName eq 'DVR' }">
							<option value="GPS" >GPS Manual</option>
							<option value="DVR" selected="selected">DVR Manual</option>
							<option value="PND">PND Manual</option>
							<option value="Mirror">Mirror Manual</option>
						</c:if>
						<c:if test="${manual.objName eq 'PND' }">
							<option value="GPS" >GPS Manual</option>
							<option value="DVR" >DVR Manual</option>
							<option value="PND" selected="selected">PND Manual</option>
							<option value="Mirror">Mirror Manual</option>
						</c:if>
						<c:if test="${manual.objName eq 'Mirror' }">
							<option value="GPS" >GPS Manual</option>
							<option value="DVR" >DVR Manual</option>
							<option value="PND">PND Manual</option>
							<option value="Mirror" selected="selected">Mirror Manual</option>
						</c:if>
					</select>
				</p>
				<p>
					<label>产品名称：</label> <input type="text" name="productName" value="${manual.productName }"/>
				</p>
				<p>
					<label>作者签名：</label> <input type="text" name="author" value="${sessionScope.user.userName }"  />
				</p>
				<p>
					<label>选择文件：</label> <input type="file" name="uploadFile" />
				</p>
				<p>
					<input type="hidden" name="id" value="${manual.id}"/>
				</p>
				
				<a href="javascript:void(0)" id="confrim"> 上传</a><a href="javascript:history.back();" id="cancel"> 取消</a>
			</form>
	  	
	  </div>
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
  		
		//给Form填充数据 
  		$("#confrim").click(function(){
			var flag = true;
  			var fm = $("#f1").attr({action:"${pageContext.request.contextPath}/servlet/ManualUplaodServlet",method:"POST",enctype:"multipart/form-data"});
  			
  			//检测表单有效性
  			$("#f1 input").each(function(i){
  				var value = $(this).val();
  				if(value==""||value.length<1){
  					alert("4不4洒，表单还没填完整！");
  					flag = false;
  					return flag;
  				}
  				
  			});
  			//兼容chrome56
  			$("body").append(form);
  			//提交Form表单
  			if(flag)
	  			fm.submit();
	  		return false;
  		
  		});
  		
  		 /*****************************************************************/
  		//ID图上传
  		/*var file = $("#file");
  		
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
  		}); */
  	});
  </script> 
</html>
