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
    <title>Employee Register Form</title>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
<br><br><br>
<div class="container">
		<form:form method="post" modelAttribute="category" action="/manager/updatecategory/" class="form-horizontal" role="form">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Update Category</h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="name">Id</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i></div>
                        <input type="text" name="category_id" class="form-control" id="category_id" readonly value="${category.category_id}"
                               placeholder="Category Id" required ="true">
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="name">Name</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-shopping-basket"></i></div>
                        <input type="text" name="name" class="form-control" id="name" readonly value="${category.name}"
                               placeholder="Name" required ="true">
                    </div>
                </div>
            </div>
            
        </div>
         <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="employee_id">Managed by</label>
            </div>
            <div class="col-md-6">
			        <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                     <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i>
							<form:select path="employee_id">
								<c:forEach var="employee" items="${employees}">
									<form:option value="${employee.employee_id}" >${employee.name}</form:option>
								</c:forEach>
							</form:select>
						
					</div></div></div></div>
            
        </div>
        <br><br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Update</button>
            </div>
        </div>
    </form:form>
</div>
</body>

