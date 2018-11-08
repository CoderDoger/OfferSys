
var menu = ["产品规格书","产品说明书"];

var 产品规格书 = {

            	GPS规格书: "./gps.jsp",
            	PND规格书 : "./pnd.jsp",
            	DVR规格书 : "./dvr.jsp",
            	"3G/4G Car dvr规格书" : "./mirror.jsp"	
            } ;
var 产品说明书 = {

    	GPS说明书: "./gpsManual.jsp",
    	PND说明书 : "./pndManual.jsp",
    	DVR说明书 : "./dvrManual.jsp",
    	Mirror说明书 : "./mirrorManual.jsp"	
    } 

$(function(){

    //alert(typeof(data[menu[0]]['j2se']));

    function parseObj(obj,id)
    {
        var index = 0;//记录obj个数的指针

        var ol = getObjLength(obj); //获取obj的长度

        for(var key in obj)
        {
            ++index;  //记录obj

            //alert(obj[key]+"=="+typeof(obj[key]));

            if(typeof(obj[key])=="object")
            {
               // var length = objLength(obj);

               if(index==ol){  //如果记录的obj长度 和获取的obj 的长度相等，那么则表示已到达最后一个obj

                    var f = createFolder(key,true); //为最后的个obj 建立folder

               }else{

                    var f = createFolder(key); 
               }                            
            
                $("#"+id).append(f);

                parseObj(obj[key],key);
            }
            else
            {
               var m = createMenu(key,obj[key]);

               $("#"+id).append(m);
            } 

        }  
    }


    //取得obj的长度，只取第一级(粗爆)
    function getObjLength(obj){

        var l = 0;

        for(var i in obj)
        {
           /* if(typeof(obj[i])=="object"){

                ++l;

               l+=getObjLength(obj[i]);

            }*/

            l++;   
        }

        return l;
    }

    //create Folder 创建 文件夹
    function createFolder(key,end){

         if(end){
            var folder = '<li class="end"><div><i class="default_A"></i><i class="default_B"></i><a href="#">'+key+'</a></div></li><ul id="'+key+'"></ul>';
        }else{
            var folder = '<li><div><i class="default_A"></i><i class="default_B"></i><a href="#">'+key+'</a></div></li><ul id="'+key+'"></ul>';
        }

        return folder;
    }

    //create Menu  创建菜单项
    function createMenu(key,url){

        var menu = '<li><div><i class="default_A"></i><i class="default_B"></i><a href="'+url+'">'+key+'</a></div></li>';
        return menu;
    }

    //create MainMenu  创建主菜单项(一级主目录)

    function mainMenu(obj)
    {
        for (var i = 0; i < obj.length; i++) {

            var menu ;

            if(i==obj.length-1){

                 menu = '<li class="end"><div><i></i><i></i><a href="#">'+obj[i]+'</a></div></li><ul id="'+obj[i].toLowerCase()+'"></ul>';
            }else{

                menu = '<li><div><i></i><i></i><a href="#">'+obj[i]+'</a></div></li><ul id="'+obj[i].toLowerCase()+'"></ul>';
            }
            
            $("#tree ul:first").append(menu);
        };
    }

    //loadTree 创建Tree 目录 。
    function loadTree(Arr)
    {
        mainMenu(Arr);//创建主菜单

        //*初始化加载数据
        for(var i = 0; i<Arr.length;i++)
        {
            obj = eval(Arr[i]);

            id = Arr[i].toLowerCase();

            parseObj(obj,id);
        }
           
    }
    //alert(getObjLength(HTML5));
    loadTree(menu);
})