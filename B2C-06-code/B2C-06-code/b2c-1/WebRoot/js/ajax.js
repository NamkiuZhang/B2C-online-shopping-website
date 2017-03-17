	var xmlHttp;
	function sendRequest(url,f1){
		var xmlReq = getXMLHTTPRequest();
		xmlReq.onreadystatechange = f1;
		xmlHttp.open("POST",url,true);
		xmlHttp.send(null);
	}
	function getXMLHTTPRequest(){
 	//alert("ffffffffffffffffffffffffffffffffffk");
	 	try
	    {
		   // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
	    }
	 	catch (e)
	    {
	
		  // Internet Explorer
	    try
	      {
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	      }
	   		catch (e)
		      {
		
		      try
		         {
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		         }
		      catch (e)
		         {
		         alert("²»Ö§³ÖAJAX£¡");
		         }
		      }
		}
		return xmlHttp;
	}
	