<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
    <!-- <title>Fresh Breeze Stores</title> -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Site Properties -->
    <title>Employee Register Form</title>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
</head>
<body>
<br><br><br>
<div class="container">
		<form:form method="post" modelAttribute="user" action="/manager/registeremployee/" class="form-horizontal" role="form">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Create your account</h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="username">Username</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="username" class="form-control" id="username"
                               placeholder="Username" required ="true">
                        <form:errors path="username"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="password">Password</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Password" required ="true">
                        <form:errors path="password"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="passwordConfirm">Confirm Password</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <input type="password" name="passwordConfirm" class="form-control" id="passwordConfirm"
                               placeholder="Confirm Password" required ="true">
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="name">Name</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="name" class="form-control" id="name"
                               placeholder="Name" required ="true">
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="contact">Contact</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="contact" class="form-control" id="contact"
                               placeholder="(+91)9119119119" required="true">
                        <form:errors path="contact"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="email">Email</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem">
                            <i class="fa fa-at"></i>
                        </div>
                        <input type="email" name="email" class="form-control"
                               id="email" placeholder="you@example.com" required="true">
                               <form:errors path="email"></form:errors>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="house">House No</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-university"></i></div>
                        <input type="text" name="house_no" class="form-control" id="house_no"
                               placeholder="House No" required ="true">
                               <form:errors path="house_no"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="street">Street Name</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-university"></i></div>
                        <input type="text" name="street_name" class="form-control" id="street_no"
                               placeholder="Street Name" required="true">
                               <form:errors path="street_name"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="city">City</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-university"></i></div>
                        <input type="text" name="city" class="form-control" id="city"
                               placeholder="City" required="true">
                               <form:errors path="city"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="account">Account No</label>
            </div>
            <div class="col-md-6">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-inr"></i></div>
                        <input type="text" name="account_no" class="form-control" id="account"
                               placeholder="Account No" required="true">
                               <form:errors path="account_no"></form:errors>
                    </div>
                </div>
            </div>
            
        </div>
        <br><br>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i>Register</button>
            </div>
        </div>
    </form:form>
</div>
</body>

