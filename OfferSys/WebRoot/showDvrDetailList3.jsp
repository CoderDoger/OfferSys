<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    
    <title>DVR</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/>
  	<link rel="icon" href="./favicon.ico"  type="image/x-icon"/>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:12px;font-family: "微软雅黑";}
		
		/*******************table start**************************/
		 .table{border: 1px solid #ccc;margin: 1%;background: #fff;}
		 .table h2{background: #eee;border-bottom: solid 1px #ccc;font-size: 0px;}
		 .table h2 i{width:16px;height:14px;display: inline-block; background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat -386px -15px;vertical-align: middle;margin: 13px;}
		 .table h2 span{height:40px;line-height: 40px;display: inline-block;vertical-align: middle;border-left: solid 1px #ccc;text-indent: 10px;}
		/*******************table end**************************/

		/********************tool start ************************************/
		 .table .tool{overflow: hidden;padding: 0px 1%;}
		 .table .tool #tools{width:40%;list-style: none;overflow: hidden;float: left;}
		 .table .tool #tools li{float: left; margin: 10px 10px 0px 0px;background: #999;border-radius: 2px;}
		 .table .tool #tools li:hover{background: #28b779;}
		 .table .tool #tools li.tool_navi_sel{background: #28b779;}
		 .table .tool #tools li a{text-decoration: none;display: block;padding: 8px 20px;color: #fff;font-size: 0px;}
		 .table .tool #tools li a i{display: inline-block;width: 15px;height: 14px;vertical-align: middle;margin-right: 10px;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat center;}
	
		 .table .tool #tools li a i.tool_icon1{background-position:-33px -52px;}
		 .table .tool #tools li a i.tool_icon2{background-position:-50px -52px;}
		 .table .tool #tools li a i.tool_icon3{background-position: -67px -52px;}
		 .table .tool #tools li a i.tool_icon4{background-position:-87px -52px;}
		 .table .tool #tools li a i.tool_icon5{background-position:-105px -52px;}
		 .table .tool #tools li a i.tool_icon6{background-position:-123px -52px}
		 .table .tool #tools li a i.tool_icon7{background-position:-140px -52px;}
		 .table .tool #tools li a i.tool_icon8{background-position:-155px -52px;}
		 .table .tool #tools li a i.tool_icon9{background-position:-172px -52px;}
		 .table .tool #tools li a i.tool_icon10{background-position:-191px -52px;}
		 .table .tool #tools li a i.tool_icon11{background-position:-212px -52px;}
		 .table .tool #tools li a span{vertical-align: middle;}
		/********************tool end ************************************/
		
		/***************************pagelist start******************************************/
		.table .pagelist{float:left;}
		.table .pagelist ul{list-style: none;overflow: hidden;}
		.table .pagelist ul li{ float:left;margin: 10px 25px 0px 0px;}
		.table .pagelist ul li span{font-weight: bold; color: #169662;display:inline-block;padding-top:8px;}
		.table .pagelist ul li a{display:inline-block;padding: 8px 15px;text-decoration: none;color: #fff;background:#169662;text-align:center; border-radius:5px;}
		/***************************pagelist end******************************************/

		/********************search start ************************************/
		 .table .search{font-size: 0px;width: 19%;float: right;margin: 10px 0px 0px 0px;}
		 .table .search .text{height:30px;width: 70%;outline: none;border:solid 1px #2CC17E; border-radius: 2px 0px 0px 2px;padding: 0px 5px;float: left;}
		 .table .search .btn{height:32px;width: 40px;outline: none;border:1px solid #2CC17E;border-radius: 0px 2px 2px 0px; background:#28b779;color: #fff;cursor: pointer;float: left;}
		/********************search end ************************************/

		/********************tab_list start ************************************/
		.tab_list{margin: 10px 0px;overflow: auto;}
		.tab_list .tab{border-collapse:collapse;width: 98%;margin: 0px 1%;color:#666;}
		.tab_list thead{border: solid 1px #ddd;}
		.tab_list thead th{background: #eee;text-align: center;white-space:nowrap;word-break:keep-all; line-height: 40px;padding: 0px 5px;}
		.tab_list tr td{border: solid 1px #ddd;text-align: left;white-space:nowrap;word-break:keep-all;line-height: 40px;padding:0px 5px;}
		.tab_list tr td.td_def_w{width: 110px;}
		.tab_list tr td.td_sel{width: 30px;}
		/*.tab_list tr .first{padding:0px 2px;}*/
		.tab_list tr td.td_sel i{width: 21px;height: 21px;display:block;margin: 0px auto;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat -451px 1px;cursor: pointer;}
		.tab_list tr td.td_sel i.check_off{background-position: -451px 1px;}
		.tab_list tr td.td_sel i.check_on{background-position: -428px 1px;}
		.tab_list tr:hover{background: #eee;}
		/*.tab_list tr:hover td .tab_action{display: block;}*/

		.tab_list tr td .tab_action{height: 24px}
		.tab_list tr td .tab_action a{width: 24px;height: 24px;display: inline-block;border-radius: 2px;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat center;}
		.tab_list tr td .tab_action a.see{background-color: #6297bc;background-position: -359px -45px;}
		.tab_list tr td .tab_action a.edit{background-color: #27a9e3;background-position: -379px -47px;}
		.tab_list tr td .tab_action a.save{background-color: #28b779;background-position: -398px -47px;}
		.tab_list tr td .tab_action a.del{background-color: #ff912f;background-position: -417px -48px;}
		.tab_list tr td .tab_action a:hover{background-color: #2f3437;}
		/********************tab_list end ************************************/
	
		
	</style>
  </head>
  
  <body>
  	
		<div class="tab_list">
		<table class="tab">
			<thead>
				<tr style="position:static;">
					<th class="first">Select</th>
					<th>ID</th>
					<th>Model</th>
					<th>Cpu</th>
					<th>Display</th>
					<th>Video</th>
					<th>Photo</th>
					<th>Gsensor</th>
					<th>GPS</th>
					<th>Adas</th>
					<th>Language</th>
					<th>Battery</th>
					<th>Static</th>
					<th>Operation</th>
				</tr>										
			</thead>
			<tbody>
			<!-- 
				<tr>
					<td class="td_sel first" >
						<i></i>
					</td>
					<td>CPR-4005</td>
					<td>MSC8328P</td>
					<td>4.0" IPS（800X480）</td>
					<td>H.264 AVI</td>
					<td>JPEG</td>
					<td>YES</td>
					<td>YES(Option)</td>
					<td>YES(Option)</td>
					<td>Multi-language</td>
					<td>150mAh Poly-lithium battery</td>
					<td class="td_def_w">
						<div class="tab_action">
							<a href="${pageContext.request.contextPath}/servlet/ControllerServlet?ctrl=show&id=1" title="查看" class="see"></a>
							<a href="${pageContext.request.contextPath}/servlet/ControllerServlet?ctrl=edit&id=1" title="编辑" class="edit"></a>
							<a href="javascript:del(id)" title="删除" class="del"></a>
						</div>
					</td>
				</tr>
			 -->
<!-- ************************************************start********************************************************************* -->
				<c:forEach items="${page.records }" var="dvrDetail" varStatus="status">
				<tr>
					<td class="td_sel" idv="${dvrDetail.id} ">
						<i></i>
					</td>
					<td>${status.count}</td>
					<td>${dvrDetail.model }</td>
					<td>${dvrDetail.cpu }</td>
					<td>${dvrDetail.lcd }</td>
					<td>${dvrDetail.videoFormat }</td>
					<td>${dvrDetail.photoFormat }</td>
					<td>${dvrDetail.gsensor }</td>
					<td>${dvrDetail.gps }</td>
					<td>${dvrDetail.adas }</td>
					<td>${dvrDetail.language }</td>
					<td>${dvrDetail.batter }</td>
					<c:if test="${dvrDetail.htmlStatic==0 }">
						<td>否</td>
					</c:if>
					<c:if test="${dvrDetail.htmlStatic==1 }">
						<td>是</td>
					</c:if>
					<td class="td_def_w">
						<div class="tab_action">
							<a href="${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=show&id=${dvrDetail.id}&htmlStatic=${dvrDetail.htmlStatic}&model=${dvrDetail.model}" title="查看" class="see" target="_blank"></a>
							<a href="${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=edit&id=${dvrDetail.id}" title="编辑" class="edit"></a>
							<a href="javascript:del(${dvrDetail.id})" title="删除" class="del"></a>
							<a href="javascript:saveHmtl('${dvrDetail.id}','${dvrDetail.model}')" title="静态化" class="save"></a>
						</div>
					</td>
				</tr>
				</c:forEach>	
<!-- ************************************************end********************************************************************* -->		
		</table>
	</div>

  
  
    
  </body>
</html>
<script type="text/javascript">
	function del(id){
	 		var sure = window.confirm("确定要删除此条记录吗？");
	 		if(sure)
	 			window.location.href = "${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=del&id="+id;
	 	}
 	function saveHmtl(id,model){
 		var sure = window.confirm("确定要生成静态页面吗？");
 		if(sure)
 			window.location.href = "${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=pageStatic&id="+id+"&fileName="+model;
 	}
	$(function(){
		//表格选种
		$(".td_sel").find("i").click(function(){
			$(this).toggleClass("check_on");	
		});
		//工具菜单导航
		$("#tools").find("li").click(function(){

			$(this).addClass("tool_navi_sel").siblings().removeClass("tool_navi_sel");
		});
		
		//全选
		$("#selAll").click(function(){
			
			$(".td_sel i").addClass("check_on");
		});
		//反选
		$("#unselAll").click(function(){
			
			$(".td_sel i").removeClass("check_on");
			
		});
		//批量删除
		$("#delAll").click(function(){
			//判断是否有选中的选项
			if($(".check_on").length<1){
				alert("4不4撒，你什么都没有选中！");
				return false;
			}
			//创建Form表单
	  		var form = $("<form></form>");
	  		//设置Form表单属性
	  		form.attr({action:"${pageContext.request.contextPath}/servlet/DvrControllerServlet?ctrl=delAll",method:"POST"});
	  		//给Form设置值 
	  		$(".check_on").each(function(i){
  				var val = $(this).parent("td").attr("idv");
  				//alert(val);
  				form.append("<input type='text' name='idv' value='"+val+"' />");
	  		});
	  		//提示用户是否确认删除
	  		var sure = window.confirm("确定要批量删除当前选中项吗？");
 			if(sure)
 				form.submit(); //提交Form表单
 			else
 				return false;
 				
  			return false;
		});
	});	
</script>
