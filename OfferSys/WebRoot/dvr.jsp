<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<<html>
  <head>
   <title> index</title>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
  	 <jsp:forward page="/servlet/DvrControllerServlet">
   		<jsp:param value="showAll" name="ctrl"/>
   	</jsp:forward>
  </body>
</html>
