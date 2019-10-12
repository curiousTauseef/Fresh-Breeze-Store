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

    <title>All products</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All Products</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Name</th>
          <th class="text-left">Selling Price</th>
          <th class="text-left">Quantity Left</th>
          <th class="text-left">Category</th>
          <th class="text-left">Increase/Decrease quantity</th>
          <th class="text-left">Edit product</th>
          <th class="text-left">Remove product</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allproducts}" var="product">
          <tr>
            <td align="center">${product.product_id}</td>
            <td align="center">${product.name}</td>
            <td align="center">${product.selling_price}</td>
            <td align="center">${product.quantity_left}</td>
            <td align="center">${category.get(product.category_id)}</td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/manager/updatequantity/${product.product_id}'"
              >
                <span></span> Change quantity
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/manager/updateproduct/${product.product_id}'"
              >
                Edit
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-danger "
                onclick="window.location.href='/manager/removeproduct/${product.product_id}'"
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
          onclick="window.location.href='/manager/addproduct'"
        >
          <i class="fa fa-plus-circle"></i>&nbsp;&nbsp;&nbsp;Add Product
        </button>
      </div>
    </div>
  </body>
</html>
