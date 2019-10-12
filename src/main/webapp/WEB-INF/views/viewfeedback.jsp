<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@taglib prefix="spring"
uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/css" />
<jsp:include page="adminnavbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" type="text/css" href="${css}/css1/table.css" />

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"
    />

    <title>Feedback</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${check=='true'}">
        <div class="table-title">
          <h3 align="center">Feedback</h3>
          <br />
        </div>
        <table class="table-fill">
          <thead>
            <tr>
              <th class="text-left">Type</th>
              <th class="text-left">Rating</th>
              <th class="text-left">Comment</th>
            </tr>
          </thead>

          <tbody class="table-hover">
            <tr>
              <td align="center">${feedback.type}</td>
              <td align="center">${feedback.rating}</td>
              <td align="center">${feedback.comment}</td>
            </tr>
          </tbody>
        </table>
      </c:when>
      <c:otherwise>
        <div class="table-title">
          <h3 align="center">No Feedback Available for this Order!!</h3>
          <br />
        </div>
      </c:otherwise>
    </c:choose>
  </body>
</html>
