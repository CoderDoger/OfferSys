<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<<html>
  <head>
   <title> index</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  	 <jsp:forward page="/servlet/ManualControllerServlet">
   		<jsp:param value="showAll" name="ctrl"/>
   		<jsp:param value="GPS" name="objName"/>
   	</jsp:forward>
  </body>
</html>
