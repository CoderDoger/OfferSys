$(function(){

		 $('#tree li a').click(function () { //点击时
			
		   var tabTitle = $(this).text(); //获取被点击菜单的标题

		   var url = $(this).attr("href");//获取被点击菜单的href
	
		  // alert(url);
		  if(url != "#")
		  {
		  	//addTab(tabTitle, url);
			  
		   //判断有没有iframe 
		  // $("#right").empty();
		   //$("#right").append(createFrame(url));
			$("#right").find("iframe").attr("src",url);
		  	return false;	//取消默认a链接点击事件响应
		  }
			
		   //调用自定义函数,开启选项卡
		   
		   //
		  
		  /* $('.easyui-accordion li div').removeClass("selected");//删除selected类CSS样式

		   $(this).parent().addClass("selected");//父类添加selected类css样式

		}).hover(function () { //鼠标放上时

		   $(this).parent().addClass("hover"); //父类添加selected类css样式

		}, function () {

		   $(this).parent().removeClass("hover");//父类删除selected类css样式
	
		});*/

		 })

})

//自定义函数创建选项卡
function addTab(subtitle, url) {
	
	//定义随机ICONS
	var icons = ["icon-book","icon-txt","icon-sum","icon-c","icon-code","icon-ic","icon-win","icon-oks"];

	var index = Math.ceil(Math.random()*7);//生成索引

	//alert(index);
   if (!$('#tab').tabs('exists', subtitle) ) {//判断选项卡面板是否存在
	//不存在，则添加新选项卡面板
	   $('#tab').tabs('add', {

		   title: subtitle,	//选项卡标题

		   iconCls:icons[index],

		   content: createFrame(url),	//选项卡面板的内容。createFrame(url)创建iframe添加到选项卡面板中

		   closable: true, //带关闭按钮

		   width: $('#mainPanle').width() - 10,	//选项卡面板的宽=中部布局面板的宽-10

		   height: $('#mainPanle').height() - 26	//选项卡面板的高=中部布局面板的高-26

	   });

   } else {
	//存在，则
	   $('#tab').tabs('select', subtitle);	//选中这个选项卡面板
  }
	
}

//自定义函数，创建iframe页面
function createFrame(url) {
   var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
   return s;
}