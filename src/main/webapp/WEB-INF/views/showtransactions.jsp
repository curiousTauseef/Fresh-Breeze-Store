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
    <br />
    <div class="table-title">
      <h3 align="center">All Supply Orders for the given duration.</h3>
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
    <br />
    <div>
      <h3 align="center">
        Total Amount Spent on Supply Orders = Rs.${sumsupply}
      </h3>
    </div>

    <div class="table-title">
      <h3 align="center">All User Orders for the given duration.</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Username</th>
          <th class="text-left">Status</th>
          <th class="text-left">Order Date</th>
          <th class="text-left">Payment Method</th>
          <th class="text-left">Price</th>
          <th class="text-left">View Items</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allords}" var="ord">
          <tr>
            <td align="center">${ord.username}</td>
            <td align="center">${ord.status}</td>
            <td align="center">${ord.order_date}</td>
            <td align="center">${payments.get(ord.order_id).method}</td>
            <td align="center">${payments.get(ord.order_id).price}</td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/manager/viewuserorderdetails/${ord.order_id}'"
              >
                <span></span> Items
              </button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br />
    <div>
      <h3 align="center">
        Total Amount Earned from User Orders = Rs.${sumorder}
      </h3>
      <br />
    </div>
  </body>
</html>
