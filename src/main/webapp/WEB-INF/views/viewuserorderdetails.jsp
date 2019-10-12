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

    <title>All Items</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All Items</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Product</th>
          <th class="text-left">Quantity</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allitems}" var="item">
          <tr>
            <td align="center">${products.get(item.ord_item_id).name}</td>
            <td align="center">${item.quantity}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
  </body>
</html>
