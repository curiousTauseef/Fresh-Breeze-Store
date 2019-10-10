<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Create an account</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
  </head>
  <body>
    <div class="container">
      <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="/logout">
          <input
            type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"
          />
        </form>

        <h2
          >Welcome ${pageContext.request.userPrincipal.name} |
          <button
            ><a onclick="document.forms['logoutForm'].submit()"
              >Logout</a
            ></button
          ></h2
        >
      </c:if>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
  </body>
</html>