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

    <title>All suppliers</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All suppliers</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Name</th>
          <th class="text-left">Contact</th>
          <th class="text-left">E-mail</th>
          <th class="text-left">House No</th>
          <th class="text-left">Street Name</th>
          <th class="text-left">City</th>
          <th class="text-left">Account No</th>
          <th class="text-left">Show all orders</th>
          <th class="text-left">Place Order</th>
          <th class="text-left">Edit supplier</th>
          <th class="text-left">Remove supplier</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allsuppliers}" var="supplier">
          <tr>
            <td align="center">${supplier.supplier_id}</td>
            <td align="center">${supplier.name}</td>
            <td align="center">${supplier.contact}</td>
            <td align="center">${supplier.email}</td>
            <td align="center">${supplier.house_no}</td>
            <td align="center">${supplier.street_name}</td>
            <td align="center">${supplier.city}</td>
            <td align="center">${supplier.account_no}</td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning"
                onclick="window.location.href='/storemanager/showsupplyorders/${supplier.supplier_id}'"
              >
                Show All Orders
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-success "
                onclick="window.location.href='/storemanager/supplyorder/${supplier.supplier_id}'"
              >
                Order
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning"
                onclick="window.location.href='/storemanager/updatesupplier/${supplier.supplier_id}'"
              >
                Edit
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-danger "
                onclick="window.location.href='/storemanager/removesupplier/${supplier.supplier_id}'"
              >
                <span class="glyphicon glyphicon-remove"></span> Remove
              </button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
    <div class="row" style="padding-top: 1rem">
      <div class="col-md-5"></div>
      <div class="col-md-15">
        <button
          type="submit"
          class="btn btn-primary btn-lg"
          onclick="window.location.href='/storemanager/registersupplier'"
        >
          <i class="fa fa-plus-circle"></i>&nbsp;&nbsp;&nbsp;Add supplier
        </button>
      </div>
    </div>
  </body>
</html>
