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

    <title>All Orders</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All Orders of ${username}</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Status</th>
          <th class="text-left">Order Date</th>
          <th class="text-left">Payment Method</th>
          <th class="text-left">Price</th>
          <th class="text-left">View Items</th>
          <th class="text-left">View Feedback</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allorders}" var="order">
          <tr>
            <td align="center">${order.status}</td>
            <td align="center">${order.order_date}</td>
            <td align="center">${payments.get(order.order_id).method}</td>
            <td align="center">${payments.get(order.order_id).price}</td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/storemanager/viewuserorderdetails/${order.order_id}'"
              >
                <span></span> Items
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/storemanager/viewfeedback/${order.order_id}'"
              >
                View Feedback
              </button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
  </body>
</html>
