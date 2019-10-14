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

    <title>All Customers</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">
        <p>All Customers</p>
      </h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Username</th>
          <th class="text-left">Name</th>
          <th class="text-left">Contact</th>
          <th class="text-left">Email Id</th>
          <th class="text-left">House No</th>
          <th class="text-left">Locality</th>
          <th class="text-left">City</th>
          <th class="text-left">Account No</th>
          <th class="text-left">Orders</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${users}" var="user">
          <c:if test="${user.role=='customer'}">
            <tr>
              <td align="center">${user.username}</td>
              <td align="center">${user.name}</td>
              <td align="center">${user.contact}</td>
              <td align="center">${user.email}</td>
              <td align="center">${user.house_no}</td>
              <td align="center">${user.street_name}</td>
              <td align="center">${user.city}</td>
              <td align="center">${user.account_no}</td>
              <td class="text-center">
                <button
                  type="button"
                  class="btn btn-warning "
                  onclick="window.location.href='/storemanager/viewuserorders/${user.username}'"
                >
                  <span></span> View Orders
                </button>
              </td>
            </tr>
          </c:if>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
  </body>
</html>
