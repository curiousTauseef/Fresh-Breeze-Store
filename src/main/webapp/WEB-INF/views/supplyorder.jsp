<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="adminnavbar.jsp" />

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
    <title>Supply Order</title>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
<br><br><br>
<div class="container">
		<form:form method="post" modelAttribute="supplyorder" action="/manager/supplyorder/" class="form-horizontal" role="form">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Place a Supply Order</h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="product">Product</label>
            </div>
            <div class="col-md-6">
			        <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                     <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i>
							<form:select path="product_id">
								<c:forEach var="product" items="${products}">
									<form:option value="${product.product_id}" >${product.name}</form:option>
								</c:forEach>
							</form:select>
						
					</div></div></div></div>
            
        </div>
        
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="quantity">Quantity</label>
            </div>
            <div class="col-md-6">
                <div class="form-group has-danger">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i></div>
                        <input type="text" name="quantity" class="form-control" id="quantity"
                               placeholder="Quantity" required="true">
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="supplier_id">Supplier Id</label>
            </div>
            <div class="col-md-6">
                <div class="form-group has-danger">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i></div>
                        <input type="text" name="supplier_id" class="form-control" id="supplier_id"
                               placeholder="Supplier Id" required="true" readonly value="${supplier}">
                    </div>
                </div>
            </div>
            
        </div>
        <br><br>
        <div class="row">
            <div class="col-md-4"></div>

                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Place Order</button>
            </div>
        </div>
    </form:form>
</div>
</body>

