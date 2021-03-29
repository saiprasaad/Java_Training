<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
   <head>
      <title> Tag Example</title>
   </head>

   <body>
      <c:out value = "${'<tag> , &'}"/>
      <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <c:out value = "${salary}"/>
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <p>Before Remove Value: <c:out value = "${salary}"/></p>
         <c:remove var = "salary"/>
      <p>After Remove Value: <c:out value = "${salary}"/></p>
        <c:catch var ="catchException">
         <% int x = 5/0;%>
      </c:catch>

      <c:if test = "${catchException != null}">
         <p>The exception is : ${catchException} <br />
         There is an exception: ${catchException.message}</p>
      </c:if>
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <c:if test = "${salary > 2000}">
         <p>My salary is:  <c:out value = "${salary}"/><p>
      </c:if>
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      <c:choose>
         
         <c:when test = "${salary <= 0}">
            Salary is very low to survive.
         </c:when>
         
         <c:when test = "${salary > 1000}">
            Salary is very good.
         </c:when>
         
         <c:otherwise>
            No comment sir...
         </c:otherwise>
      </c:choose>
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      <c:choose>
         
         <c:when test = "${salary <= 0}">
            Salary is very low to survive.
         </c:when>
         
         <c:when test = "${salary > 1000}">
            Salary is very good.
         </c:when>
         
         <c:otherwise>
            No comment sir...
         </c:otherwise>
      </c:choose>
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      <c:choose>
         
         <c:when test = "${salary <= 0}">
            Salary is very low to survive.
         </c:when>
         
         <c:when test = "${salary > 1000}">
            Salary is very good.
         </c:when>
         
         <c:otherwise>
            No comment sir...
         </c:otherwise>
      </c:choose>
      <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>
      <c:forTokens items = "Zara,nuha,roshy" delims = "," var = "name">
         <c:out value = "${name}"/><p>
      </c:forTokens>
       <a href = "<c:url value = "/jsp/index.htm"/>">TEST</a>
   </body>
</html>