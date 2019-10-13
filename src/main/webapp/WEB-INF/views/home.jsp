<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<spring:url var="css" value="/css" />
<html lang="en">
    <head>
        <title>Fresh Breeze Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600&amp;subset=latin-ext" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="${css}/home/css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="site" id="page">
            <a class="skip-link sr-only" href="#main">Skip to content</a>
            <section class="hero-section hero-section--image clearfix clip">
                <div class="hero-section__wrap">
                    <div class="hero-section__option">
                        <img src="${css}/home/images/home.jpg" alt="bg" style="position: absolute; top:50%; left: 50%; transform: translate(-50%,-50%);">
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="offset-lg-2 col-lg-8">
                                <div class="title-01 title-01--11 text-center">
                                    <h2 class="title__heading">
                                        <span>Fresh Breeze Store</span> 
                                    </h2>                                   
                                    <div class="title__action"><a href="\login" class="btn btn-warning" style="color: black;">Login</a></div>
                                    </br> <div class="title__action"><a href="\register" class="btn btn-warning" style="color: black;">Create an Account</a></div> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
    </body>
</html>