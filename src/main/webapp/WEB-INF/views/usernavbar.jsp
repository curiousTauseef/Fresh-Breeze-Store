<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<head lang="en">
    <!-- {% load static %} -->
    <meta charset="UTF-8">
    <title>Fresh Breeze Stores</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
    $(document).ready(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>

</head>
<style>

</style>

<body>
    <nav class="navbar navbar-inverse bg-inverse navbar-fixed-top">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a href="/user">Dashboard</a></li>
                <li><a href="/user/viewcategories">View Categories</a></li>
                <li><a href="/user/viewproducts">View Products</a></li>
                <li><a href="/user/placeorder">Place Order</a></li>
                <li><a href="/user/vieworders">Previous Orders</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span></a>
          <ul class="dropdown-menu">
        
            <!-- <li role="separator" class="divider"></li> -->
            <li><a href="/logout">Logout</a></li>
          </ul>
        </li>
    </ul>
        </div>
    </nav><br><br>
</body>
</html>