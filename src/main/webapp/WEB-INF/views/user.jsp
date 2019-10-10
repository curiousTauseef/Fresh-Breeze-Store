<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>User</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
  </head>
  <body>
    <p>${user}</p>
  </body>
</html>
