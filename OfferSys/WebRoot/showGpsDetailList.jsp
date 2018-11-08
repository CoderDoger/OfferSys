<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
  <head>
    
    <title>GPS</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/>
  	<link rel="icon" href="./favicon.ico"  type="image/x-icon"/>
	<style type="text/css">
		*{padding:0px;margin:0px;font-size:12px;font-family: "微软雅黑";}
		
		/*******************table start**************************/
		 .table{background: #fff;}
		 .table h2{background: #eee;border-bottom: solid 1px #ccc;font-size: 0px;}
		 .table h2 i{width:16px;height:14px;display: inline-block; background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat -386px -15px;vertical-align: middle;margin: 13px;}
		 .table h2 span{height:40px;line-height: 40px;display: inline-block;vertical-align: middle;border-left: solid 1px #ccc;text-indent: 10px;}
		/*******************table end**************************/

		/********************tool start ************************************/
		 .table .tool{overflow: hidden;padding: 0px;}
		 .table .tool #tools{width:40%;list-style: none;overflow: hidden;float: left;}
		 .table .tool #tools li{float: left; margin: 10px 10px 0px 0px;background: #999;border-radius: 2px;}
		 .table .tool #tools li:hover{background: #28b779;}
		 .table .tool #tools li.tool_navi_sel{background: #28b779;}
		 .table .tool #tools li a{text-decoration: none;display: block;padding: 8px 20px;color: #fff;font-size: 0px;}
		 .table .tool #tools li a i{display: inline-block;width: 15px;height: 14px;vertical-align: middle;margin-right: 10px;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat center;}
	
		 .table .tool #tools li a i.tool_icon1{background-position:-33px -52px;}
		 .table .tool #tools li a i.tool_icon2{background-position:-4% -52px;}
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
		 .table .search .btn{height:33px;width: 40px;outline: none;border:1px solid #2CC17E;border-radius: 0px 2px 2px 0px; background:#28b779;color: #fff;cursor: pointer;float: left;}
		/********************search end ************************************/

		/********************tab_list start ************************************/
		.tab_list{margin:0px;/*border:solid 1px red;*/width:100%;}
		.tab_list .tab_head{border-collapse:collapse;color:#fff;background: #28b779;position: static;width:100%;overflow: hidden;table-layout:fixed;border: solid 1px #fff;}
		.tab_list .tab_head th{text-align: center; line-height: 40px;border: solid 1px #fff;overflow:hidden;}
		
		.tab_list .tabContent{width:100%;overflow: auto;}
		.tab_list .tab_body{border-collapse:collapse;overflow: hidden;table-layout:fixed;width:100%;overflow: auto;}
		.tab_list .tab_body tr td{border: solid 1px #ddd;text-align: left;line-height: 40px;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;text-align: center;}
	
		
		.tab_list .tab_body tr td.td_sel{}
		/*.tab_list tr .first{padding:0px 2px;}*/
		.tab_list .tab_body tr td.td_sel i{width: 21px;height: 21px;display:block;margin: 0px auto;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat -451px 1px;cursor: pointer;}
		.tab_list .tab_body tr td.td_sel i.check_off{background-position: -451px 1px;}
		.tab_list .tab_body tr td.td_sel i.check_on{background-position: -428px 1px;}
		.tab_list .tab_body tr:hover{background: #eee;cursor: pointer;}
		
		.tab_list .tab_body tr td .tab_action{height: 24px}
		.tab_list .tab_body tr td .tab_action a{width: 24px;height: 24px;display: inline-block;border-radius: 2px;background: url("${pageContext.request.contextPath}/images/ht_icon.png") no-repeat center;}
		.tab_list .tab_body tr td .tab_action a.see{background-color: #6297bc;background-position: -359px -45px;}
		.tab_list .tab_body tr td .tab_action a.edit{background-color: #27a9e3;background-position: -379px -47px;}
		.tab_list .tab_body tr td .tab_action a.save{background-color: #28b779;background-position: -398px -47px;}
		.tab_list .tab_body tr td .tab_action a.del{background-color: #ff912f;background-position: -417px -48px;}
		.tab_list .tab_body tr td .tab_action a:hover{background-color: #2f3437;}
		
		/********************tab_list end ************************************/

		
	</style>
  </head>
  
  <body>
  	<div class="table">

		<!--*************title start*************-->
		<!--
		<h2>
			<i></i>
			<span>GPS规格书管理</span>
		</h2>
		-->
		<!--*************title end*************-->

		

		<!--*************tab_list start*************-->
		<div class="tab_list">
			<table class="tab_head">
				<thead>
					<tr>
						<th class="first" style="width:4%;">Select</th>
						<th style="width:2%;" >ID</th>
						<th style="width:8%;">Model</th>
						<!--  <th style="width:8%;">OS</th>-->
						<th style="width:10%;">Display</th>
					
						<th style="width:10%;">TP</th>
						<th style="width:10%;">BT</th>
						<th style="width:5%;">FM</th>
						<th style="width:5%;">AVIN</th>
						<th style="width:5%;">TV</th>
						<!-- <th style="width:5%;">Language</th> -->
					
						
						<th  style="width:10%;">RAM</th>
						<th  style="width:5%;">FLASH</th>
						<th  style="width:5%;">DVR</th>
						<th  style="width:5%;">Charger</th>
						
						<th style="width:10%;">Battery</th>
						<th style="width:4%;">Static</th>
						<th style="width:12%;">Operation</th>	
					</tr>										
				</thead>
			</table>
			<div class="tabContent">
				<table class="tab_body">
        			<tbody>
        				<!-- ************************************************start********************************************************************* -->
						<c:forEach items="${page.records }" var="gpsDetail" varStatus="status">
						<tr>
							<td style="width:4%;" class="td_sel" idv="${gpsDetail.id} ">
								<i></i>
							</td>
							<td style="width:2%;">${status.count}</td>
							<td style="width:8%;">${gpsDetail.model }</td>
							<!--<td style="width:8%;">${gpsDetail.os }</td>-->
							<td style="width:10%;">${gpsDetail.lcd }</td>
						
							<td style="width:10%;">${gpsDetail.tp }</td> 
							<!--<td >${gpsDetail.cpu }</td>-->
							<td style="width:10%;">${gpsDetail.bluetooth }</td>
							<td style="width:5%;">${gpsDetail.fmt }</td>
							<td style="width:5%;">${gpsDetail.avin }</td>
							<td style="width:5%;">${gpsDetail.tv }</td>
							<!-- <td style="width:5%;">${gpsDetail.language}</td> -->
						
							<td style="width:10%;">${gpsDetail.ram }</td>
							<td style="width:5%;">${gpsDetail.rom }</td>
							<td style="width:5%;">${gpsDetail.dvr }</td>
							<td style="width:5%;">${gpsDetail.charger }</td>
							<td style="width:10%;">${gpsDetail.battery }</td>
						
							<c:if test="${gpsDetail.htmlStatic==0 }">
								<td style="width:4%;">否</td>
							</c:if>
							<c:if test="${gpsDetail.htmlStatic==1 }">
								<td style="width:4%;">是</td>
							</c:if>
							<td style="width:12%;" class="td_def_w">
								<div class="tab_action">
									<c:if test="${sessionScope.user.permissions>=1 }">
										<a href="${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=show&id=${gpsDetail.id}&htmlStatic=${gpsDetail.htmlStatic}&model=${gpsDetail.model}" title="查看" class="see" target="_blank"></a>
									</c:if>
									<c:if test="${sessionScope.user.permissions>=3 }">
										<a href="${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=edit&id=${gpsDetail.id}" title="编辑" class="edit"></a>
									</c:if>
									<c:if test="${sessionScope.user.permissions>=7 }">
										<a href="javascript:del(${gpsDetail.id})" title="删除" class="del"></a>
									</c:if>
									<c:if test="${sessionScope.user.permissions>=15 }">
										<a href="javascript:saveHmtl('${gpsDetail.id}','${gpsDetail.model}')" title="静态化" class="save"></a>
									</c:if>	
								</div>
							</td>
						</tr>
						</c:forEach>	
						<!-- ************************************************end********************************************************************* -->		
        			
        			</tbody>
				</table>
			</div>
		</div>
		<!--*************tab_list end*************-->
		
		<!--*************tool start*************-->
		<div class="tool">
			<c:if test="${sessionScope.user.permissions>=15 }">
				<ul id="tools">
				<li class="tool_navi_sel">
					<a href="${pageContext.request.contextPath}/addGpsDetail.jsp">
						<i class="tool_icon1"></i>
						<span>添加</span>
					</a>
				</li>
				<li id="selAll">
					<a href="javascript:void(0);">
						<i class="tool_icon9"></i>
						<span>全选</span>
					</a>
				</li>
				<li id="unselAll">
					<a href="javascript:void(0);">
						<i class="tool_icon6"></i>
						<span>反选</span>
					</a>
				</li>
				<li id="delAll">
					<a href="javascript:void(0);">
						<i class="tool_icon8"></i>
						<span>批量删除</span>
					</a>
				</li>
			</ul>
			</c:if>
			
			<div class="search">
				<form action="${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=search" method="post">
					<input type="text" class="text" placeholder="搜索" name="keyWord">
					<input type="submit" value="GO" class="btn">
				</form>
			</div>
			<div class="pagelist">
				<ul>
					<li><span>第${page.currentPageNum}页/共${page.totalPageNum }页</span></li>
					<li><a href="${pageContext.request.contextPath}/gps.jsp">首页 </a></li>
					<li><a href="${pageContext.request.contextPath}/gps.jsp?currentPageNum=${page.proviousPageNum}">上一页 </a></li>
					<li><a href="${pageContext.request.contextPath}/gps.jsp?currentPageNum=${page.nextPageNum}">下一页</a></li>
					<li><a href="${pageContext.request.contextPath}/gps.jsp?currentPageNum=${page.endPage}">尾面</a> 	</li>
				</ul>
			    <!-- 
			    <p class="pagelist">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="num" >
						<a href="${pageContext.request.contextPath}?currentPageNum=${num}">${num}</a>
					</c:forEach>	
			    </p>
			    <p class="pagelist">
			    	<select id="sel">
			    		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="num" >
			    			<option value="${num }" ${page.currentPageNum == num ? 'selected="selected"':''}>${num}</option>
						</c:forEach>	
			    	</select>
					
			    </p>
			    <p>
			    	<input type="text" id="num" />
			    	<input type="button" value = "跳转" id="bt"/>
			    </p>
			     -->
			</div>
		</div>
		
		<!--*************tool end*************-->	
</div>
  </body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		/* var wH = $(window).height();
		var wW = $(window).width();
	
		$(".tab_list").height(wH-130);
		$(".tab_list").width("98%"); */
		//
		
		var wH = $(window).height();
		$(".tabContent").height(wH-110);
		
	/* 		var tab_body_width = $(".tab_body").width()+17;
		
		$(".tabContent").width(tab_body_width);
		
		$(".tab_list").width(tab_body_width+5); */
		//滚动条动态显示
		var tab_body_height = $(".tab_body").height();
		var tabContent_height = $(".tabContent").height();
		if(tab_body_height>tabContent_height){
			//显示滚动条
			$(".tab_head tr").append("<th style='width:18px;'></th>");
		}
	});
	function del(id){
	 		var sure = window.confirm("确定要删除此条记录吗？");
	 		if(sure)
	 			window.location.href = "${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=del&id="+id;
	 	}
 	function saveHmtl(id,model){
 		var sure = window.confirm("确定要生成静态页面吗？");
 		if(sure)
 			window.location.href = "${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=pageStatic&id="+id+"&fileName="+model;
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
	  		form.attr({action:"${pageContext.request.contextPath}/servlet/GpsControllerServlet?ctrl=delAll",method:"POST"});
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
	
		//双击表格行时进入浏览
		$(".tab_body tr").dblclick(function(){
			var url = $(this).find("td .see").attr("href");
			window.open(url,"_blank");
			//alert(url);
		});
	});	
</script>
