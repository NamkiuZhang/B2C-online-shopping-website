 function over_detail(){
  	var targ = getActive();
  	targ.style.cursor = "pointer";
  }
  function click_detail(){
	var d = document.getElementById("product_detail");
	var c = document.getElementById("product_comment");
  	d.style.background="#EEEEEE";
  	d.style.color="black";
  	
  	c.style.background="#1FD1B7";
  	c.style.color="white";
  	document.getElementById("ddetail").style.display="block";
  	document.getElementById("comments").style.display="none";
  	
  }
  
  function over_comment(){
  	var targ = getActive();
  	targ.style.cursor = "pointer";
  }
  
  function over_score(){
	var targ = getActive();
  	targ.style.cursor = "pointer";
  	targ.style.textDecoration="underline";
  }

  function out_score(){
	 var targ = getActive();
  	targ.style.textDecoration="none";
  }
  
  function click_comment(){
  	var d = document.getElementById("product_detail");
	var c = document.getElementById("product_comment");
  	d.style.background="#1FD1B7";
  	d.style.color="white";
  	
  	c.style.background="#EEEEEE";
  	c.style.color="black";
  	document.getElementById("ddetail").style.display="none";
  	document.getElementById("comments").style.display="block";
  	
  }
  
  function clicksubmit(pid){
	var username = document.getElementById("username").innerHTML;
	
  		if(user_score==undefined){
  			alert("请给商品打分");
  		}else{
  			getXMLHTTPRequest();	
  			var commentcontent = document.getElementById("textarea").value;
  			var url = "comment.servlet?score="+user_score
  			+"&commentcontent="+commentcontent
  			+"&pid="+pid;
  			sendRequest(url,f6);
  			//window.open(url);
  		}
  }
  
  function f6(){
	  if(xmlHttp.readyState==4){
			var s = xmlHttp.responseText;
			var temp = s.split("|");
			alert(temp[0]);
			if(temp.length>1){
				document.getElementById("comment").innerHTML = temp[1];
				window.location.reload();
			}
		}
  }
  
  function over_element(){
	  var targ = getActive();
	  targ.style.cursor = "pointer";
	  targ.style.color = "black";
  }
  
  function out_element(){
	  var targ = getActive();
	  targ.style.color = "white";
  }
  
  
  function up_minus(){
	  var targ = document.getElementById("num_input");
	  var temp = parseInt(targ.value);
	  var max = parseInt(document.getElementById("storage").innerHTML);
	  if(isNaN(temp) || temp <=1){
		  targ.value="1";
	  }else if(temp>max+1){
		  alert("库存不足");
		  targ.value = max;
	  }
	  else{
		  targ.value = (temp-1)+"";
	  } 
  }
  
  function up_add(){
	  var targ = document.getElementById("num_input");
	  var temp = parseInt(targ.value);
	  var max = parseInt(document.getElementById("storage").innerHTML);
	  if(isNaN(temp) || temp <0){
		  targ.value="1";
	  }else if(temp>=max){
		  alert("库存不足");
		  targ.value = max;
	  }
	  else{
		  targ.value = (temp+1)+"";
	  } 
  }
  
  
  function up_buy(id){//立即购买商品（单种商品形成订单）；id，商品id
	var username = document.getElementById("username").innerHTML;
		//订单界面
		var num = parseInt(document.getElementById("num_input").value);//购买数量
		var url ="servlet/CartServlet?addtocart=2 &selectid="+id+"&quant="+num;
		window.open(url,"cartjsp");
  }
  
  function up_addToCart(id){//加入购物车；id，商品id
	 var username = document.getElementById("username").innerHTML;	
		//购物车servlet
		var num = parseInt(document.getElementById("num_input").value);//购买数量	
		var url ="servlet/CartServlet?addtocart=2 &selectid="+id+"&quant="+num;
		window.open(url,"cartjsp");
	  
  }
  
  
  
  