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

    <title>All Supply Orders</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All Supply Orders of ${name}</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Date</th>
          <th class="text-left">Status</th>
          <th class="text-left">Product</th>
          <th class="text-left">Quantity</th>
          <th class="text-left">Price</th>
          <th class="text-left">Managed by (Employee)</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allorders}" var="order">
          <tr>
            <td align="center">${order.supply_order_date}</td>
            <td align="center">${order.supply_order_status}</td>
            <td align="center">${products.get(order.supply_order_id)}</td>
            <td align="center">${order.quantity}</td>
            <td align="center">${order.price}</td>
            <td align="center">${employees.get(order.supply_order_id)}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
