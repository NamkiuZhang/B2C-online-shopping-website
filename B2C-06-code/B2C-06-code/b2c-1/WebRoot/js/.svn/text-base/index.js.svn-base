var temp_targ;

var fcid =[6];
var smid = [7];
var rdid =[5];
var hotid=[30];

  function getActive(){
  	var targ;
  	var e = window.event;
  	if (e.target) targ = e.target;
	else if (e.srcElement) targ = e.srcElement;
	return targ;
  }
  
  
  function over_menu(id){
  	var targ = getActive();
	targ.style.background="#FAFAFA";
	targ.style.color = "black";
	targ.style.cursor = "pointer";
	if(targ.innerHTML == "首页"){
		return;
	}
	getSubmenu(targ,id);
  }
  
  function getSubmenu(targ,id){
  
 	var sub_menu = document.getElementById("sub_menu"); 
  	getXMLHTTPRequest();
  	var url = "submenu.servlet?ptid="+fcid[id-1];
  	sendRequest(url,f3); 	
  	sub_menu.style.display = "block";
  }  
  
  function out_submenu(){
	var leng = window.event.clientY+document.documentElement.scrollTop;

  	if(leng>=215 && leng<=250){
  		
  	}else{
  		remove_submenu();
  	}
  	
  }
  
  function f3(){
	  if(xmlHttp.readyState==4){
			var s = xmlHttp.responseText;
			if(s.length<=0){
				//document.getElementById("sub_menu").innerHTML = "暂无子分类！";
			}else{
				var temp = s.split(";");
				for(var i=0;i<temp.length;i++){
						var s = temp[i].split(",");
						document.getElementById("sm"+(i+1)).innerHTML = s[0];
						document.getElementById("sm"+(i+1)).style.display="inline";
						smid[i] = s[1];
				}
			}	
			
		}
  }
  
  function remove_submenu(){
  	temp_targ.style.background="#1FD1B7";
  	temp_targ.style.color = "white";
  	var submenu = document.getElementById("sub_menu");
  	for(var i=0;i<7;i++){
		document.getElementById("sm"+(i+1)).style.display="none";
	}
  	submenu.style.display = "none";
  }
  
  function out_menu(){
  	var targ = getActive();
  	if(targ.innerHTML.toLowerCase()=="首页"){
  		targ.style.background="#1FD1B7";
  		targ.style.color = "white";
  		return;
  	}
  	temp_targ = targ; 	
  	var leng = window.event.clientY+document.documentElement.scrollTop;
  	if((leng>=210 && leng<=220)){
  	}else{
  		remove_submenu();
  	}
  }
  
  
  function loadIndex(){
  		getXMLHTTPRequest();
  		var url = "load.servlet?action=index";
  		sendRequest(url,f2);
  	}
  
  
  	function f2(){
		if(xmlHttp.readyState==4){
			var s = xmlHttp.responseText;
			var ss = s.split("|");
			loadFC(ss[0]);
			loadRD(ss[1]);
			loadHOT(ss[2]);
		}
	}
	function loadFC(s){

		var ss = s.split(";");
		for(var i=0;i<ss.length;i++){
			var sss = ss[i].split(",");
			var temp = document.getElementById("fc"+(i+1));
			temp.childNodes[0].innerHTML = sss[0];
			temp.style.display = "inline";
			fcid[i] = sss[1];
		}
	}
	
	function loadRD(s){
		var ss = s.split(";");
		for(var i=0;i<ss.length;i++){
			var sss = ss[i].split(",");
			var temp = document.getElementById("rd"+(i+1));
			temp.src = sss[0];
			rdid[i] = sss[1];
		}
		over_rd2();
	}
	function loadHOT(s){
		var ss = s.split(";");
	
		for(var i=0;i<ss.length;i++){
			var sss = ss[i].split(",");		
				document.getElementById("product"+(i+1)+"_img").src = sss[0];
				document.getElementById("product"+(i+1)+"_desc").innerHTML = sss[1];
				document.getElementById("product"+(i+1)+"_price").innerHTML= "￥"+sss[2];
				hotid[i] = sss[3];
		}
	}
  function over_item(){
  	var targ = getActive();
  	document.getElementById("sm1").style.color = "black";
  	document.getElementById("sm2").style.color = "black";
  	document.getElementById("sm3").style.color = "black";
  	document.getElementById("sm4").style.color = "black";
  	document.getElementById("sm5").style.color = "black";
  	document.getElementById("sm6").style.color = "black";
  	document.getElementById("sm7").style.color = "black";
  	targ.style.color = "#1FD1B7";
  	targ.style.cursor = "pointer";
  }
  
  function over_search(){
	  var targ = getActive();
	  targ.style.cursor = "pointer";
	  targ.style.color = "black";
  }
  
  function out_search(){
	  var targ = getActive();
	  targ.style.color = "white";
  }
  
  function up_search(){
	  var content = document.getElementById("search_input").value;
	  var temp = content;
	  if(temp=="" || temp.replace(/[ ]/g,"")==""){
		  //不做响应
	  }else{
	  	var url = "keywordssearch.servlet?keywords="+content;
	  	window.open(url,"productlistjsp");
	  }
  }
  
  function up_menu(id){
	  window.open("typesearch.servlet?typeid="+fcid[id-1]);
  }
  
  function up_submenu(id){
	  window.open("typesearch.servlet?typeid="+smid[id-1]);
	 // window.location.href="typesearch.servlet?typeid="+smid[id-1];
  }
  function over_buy(){
	   var targ = getActive();
	   targ.style.cursor = "pointer";
	   targ.style.color = "black";
  }
  
  function out_buy(){
	   var targ = getActive();
	   targ.style.cursor = "pointer";
	   targ.style.color = "white";
  }
  function clickrd(id){
	  window.open("detail.servlet?pid="+rdid[id-1]);
  }
  function click_buy(id){
	  window.open("detail.servlet?pid="+hotid[id-1]);
  }
  
  function over_topElem(){
	  var targ = getActive();
	  targ.style.cursor = "pointer";
	  targ.style.color = "black";
	  targ.style.textDecoration = "underline";
  }
  
  function out_topElem(){
	  var targ = getActive();
	  targ.style.color = "#44DDEE";
	  targ.style.textDecoration = "none";
  }
  
  function over_cart(){
	  var targ = getActive();
	  targ.style.outline = "black dotted thin";
	  targ.style.cursor = "pointer";
  }
  function out_cart(){
	  var targ = getActive();
	   targ.style.outline = "none";
  }
  
  function up_login(){
	
  }
  
  function up_cart(){
	  //购物车界面
	  var url="servlet/CartServlet";
	  window.open(url);
  }
  function up_reg(){
	 
  }
  function upaboutus(){
	  //关于我们界面
  }
  
  function up_myHome(){
	   var url="myHome.jsp";
	  window.open(url);
  }
  function up_myorder(){
	   var url="servlet/OrderServlet";
	  window.open(url);
	  
  }
  
  
  
  