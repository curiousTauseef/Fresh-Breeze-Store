<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="usernavbar.jsp" />

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
    <title>Add a product</title>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
<br><br><br>
<div class="container">
		<form:form method="post" modelAttribute="payment" action="/user/processpayment/" class="form-horizontal" role="form">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Payment</h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="method">Method</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i>
                        <form:select path="method">
								
							<form:option value="online" >Online Payment</form:option>
							<form:option value="offline" >Offline Payment</form:option>
                        </form:select>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="price">Price</label>
            </div>
            <div class="col-md-6">
                <div class="form-group has-danger">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-inr"></i></div>
                        <input type="text" name="price" class="form-control" id="price"
                               placeholder="Price" required="true" readonly value="${payment.price}">
                    </div>
                </div>
            </div>
            
        </div>
        
        <c:forEach var="product" items="${items}">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <input type="hidden" name="product_id" class="form-control" id="username"
                               placeholder="Name" required ="true" readonly value="${product.product_id}">
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <input type="hidden" name="quantity${product.product_id}" class="form-control" id="quantity"
                               placeholder="Quantity" required ="true" readonly value="${product.quantity}">
                    </div>
                </div>
            </div>
            
        </div>
        </c:forEach>
        <br><br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i>Pay</button>
            </div>
        </div>
    </form:form>
</div>
</body>

