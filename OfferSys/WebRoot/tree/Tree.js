
$(document).ready(function(){
	//alert();
	//将所的ul菜单隐藏
	//$("#tree").find("li").next("ul").hide();  //20180302 修改初始化时 默认展开菜单

	//为所有下的标签添加背景图标
	$("#tree ul li").find("i:first").addClass("default_A");
	$("#tree ul li").find("i:last").addClass("default_B");

	//找到有ul菜单的li将其ICON做对应的修改
	$("#tree").find("ul").prev("li").find("i").each(function(i){
		if(i%2==0)
			$(this).addClass("node");
		else
			$(this).addClass("folder");
	});

	//设置首个li的ICON样式
	//$("#tree").find("ul").prev("li:first").find("i:first").addClass("node_first"); //原
	//$("#tree").find("ul").prev("li:first").find("i:first").addClass("node_last_open"); ////20180302 修改初始化时 默认展开菜单
	//$("#tree").find("ul").prev("li:first").find("i:last").addClass("folder_open");////20180302 修改初始化时 默认展开菜单
	
	$("#tree").find("ul").prev("li:first").find("i:first").addClass("node_open"); ////20180302 修改初始化时 默认展开菜单
	$("#tree").find("ul").prev("li:first").find("i:last").addClass("folder_open");////20180302 修改初始化时 默认展开菜单
	$("#tree").find("ul ul:first").attr("show","true");
	
	
	//找到Tree ul 下最后一个li ，设置ICON样式
	$("ul li:last-child").find("i:first").addClass("last_li_icon");

	$('.end').find('i:first').addClass("node_last")


	$("#tree ul:first").css("background","white");

	$('.end').next().css("background","white");
	
	$('.end').next().hide();

	/*
	var ul_length = $("#tree ul").length-1;
	$("#tree ul").each(function(i){
		if(i==0||i==ul_length)
		{
			$(this).css("background","white");
		}
	});
*/
	//找到有字菜单的li,绑定点击事件
	$("#tree").find("ul").prev("li").click(function(){
	
		
		//为ul菜单添加一个show属性，值为false/undefined 时，变换节点样式
		if( $(this).next("ul").attr("show")==null|| $(this).next("ul").attr("show")=="false")
		{
			//判断是否是最后一个菜单
			if($(this).attr("class")=="end"){
				$(this).find("i:first").addClass("node_last_open");
			}else{
				$(this).find("i:first").addClass("node_open");
			}

			$(this).find("i:last").addClass("folder_open");

			$(this).next("ul").attr("show","true");

		}else{
			//同上
			if($(this).attr("class")=="end"){
				$(this).find("i:first").removeClass("node_last_open");
			}else{
				$(this).find("i:first").removeClass("node_open");
			}
			
			$(this).find("i:last").removeClass("folder_open");

			$(this).next("ul").attr("show","false");
			
		} 
		 //20180302 修改初始化时 默认展开菜单
		//以下为反向添加，恢复时请放开上面，删除下面这一段代码
		//为ul菜单添加一个show属性，值为false/undefined 时，变换节点样式
		/*if( $(this).next("ul").attr("show")==null|| $(this).next("ul").attr("show")=="false")
		{
			
			if($(this).attr("class")=="end"){
				$(this).find("i:first").removeClass("node_last_open");
			}else{
				$(this).find("i:first").removeClass("node_open");
			}
			
			$(this).find("i:last").removeClass("folder_open");

			$(this).next("ul").attr("show","true");

		}else{
		
			
			if($(this).attr("class")=="end"){
				$(this).find("i:first").addClass("node_last_open");
			}else{
				$(this).find("i:first").addClass("node_open");
			}

			$(this).find("i:last").addClass("folder_open");

			$(this).next("ul").attr("show","false");
			
		} */
		
		
		
		$(this).next("ul").slideToggle();	//显示对应的ul菜单


		/*******************************可选择性开启，默认开启*******************************************/

 
		//特效：只显示正在查看的菜单，其它同级菜单如果是展开状态，那么则让其收起(关闭)


		//取得当前菜单ul 的兄弟菜单ul ，将其收起，然后再设置被收起菜单的样式

		$(this).next("ul").siblings("ul").slideUp("slow").prev("li").find("i:first").removeClass("node_open");

		$(this).next("ul").siblings("ul").prev("li").find("i:last").removeClass("folder_open");

		$(this).next("ul").siblings("ul:last").prev("li").find("i:first").removeClass("node_last_open");

		$(this).next("ul").siblings("ul").attr("show","false");



		//如果补收起的菜单中还含有子菜单，那么也要对应将收起来
	
		//取得当前菜单ul 的兄弟菜单ul 的子菜单ul，将其收起，然后再设置被收起菜单的样式
	/*	$(this).next("ul").siblings("ul").children("ul").slideUp("slow");
		
		$(this).next("ul").siblings("ul").children("ul").prev("li").find("i:first").removeClass("node_open");

		$(this).next("ul").siblings("ul").children("ul").prev("li").find("i:last").removeClass("folder_open");


		

		//$(this).next("ul").siblings("ul").children("ul:last").prev("li").find("i:first").removeClass("node_last_open");

		//$(this).next("ul").siblings("ul").children("ul").attr("show","false");

		


		/*$(this).next("ul").siblings("ul").children("ul:last").prev("li").find("i:first").removeClass("node_last_open");

		$(this).next("ul").siblings("ul").children("ul:last").prev("li").find("i:last").removeClass("folder_open");

		$(this).next("ul").siblings("ul").children("ul:last").attr("show","false");


	//*/

	/**************************************************************************/

	});

	//将HTML字符转为DOM对象
	function parseDom(str)
	{
		
		var objE = document.createElement("div");

		objE.innerHTML = str; 

　　	   return objE.firstChild;
	}

});
