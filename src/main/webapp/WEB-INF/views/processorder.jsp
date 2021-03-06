<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="usernavbar.jsp" />
<spring:url var="css" value="/css" />
<htmL>
<style>
@media(min-width: 768px) {
  .field-label-responsive {
    padding-top: .5rem;
    text-align: right;
  }
}
</style>

<head>
    <!-- Standard Meta -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>Place Order</title>

    <!-- Stylesheets -->
     <link rel="stylesheet" type="text/css" href="${css}/css1/table.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
    <c:choose>
        <c:when test="${error=='true'}">
            <div class="table-title">
                <h3 align="center"><p>You haven't selected any products.</p><br> <button type="button" class="btn btn-danger " onclick="window.location.href='/user/placeorder'">Select Products</button></h3>

            
            </div>
        </c:when>
        <c:otherwise>
            <br><br><br>
<div class="container">
		<form:form method="post" action="/user/finalprocessorder/" class="form-horizontal" role="form">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Place Order for ${username}</h2>
                <hr>
            </div>
        </div>
        
        <c:forEach var="product" items="${products}">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <input type="hidden" name="product_id" class="form-control" id="username"
                               placeholder="Name" required ="true" value="${product.product_id}">
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="name">${product.name}</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="number" name="quantity${product.product_id}" class="form-control" id="quantity"
                               placeholder="Quantity" required ="true">
                    </div>
                </div>
            </div>
            
        </div>
        </c:forEach>
        <br><br>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i>Select</button>
            </div>
        </div>
    </form:form>
</div>

        </c:otherwise>
    </c:choose>
</body>

