<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
ModelAndView 테스트 페이지입니다.
<br>
${ObjectTest}
<br>
${listTest}
<br>
<br>
 
<html>
   <head>
      <title> Tag Example</title>
   </head>

   <body>
      <c:forEach var="listTest" items="${listTest}">
	    <td align="center" class="listtd"><c:out value="${listTest.code}"/> </td>
		<td align="center" class="listtd"><c:out value="${listTest.name}"/> </td>
		<td align="center" class="listtd"><c:out value="${listTest.team}"/> </td>
		<br>
	</c:forEach> 

   </body>
</html>