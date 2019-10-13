<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@taglib prefix="spring"
uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/css" />
<jsp:include page="usernavbar.jsp" />
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
          <th class="text-left">Name</th>
          <th class="text-left">Selling Price</th>
          <th class="text-left">Category</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allproducts}" var="product">
          <tr>
            <td align="center">${product.name}</td>
            <td align="center">${product.selling_price}</td>
            <td align="center">${category.get(product.category_id)}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
  </body>
</html>
