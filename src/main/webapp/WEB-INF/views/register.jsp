<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Create an account</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootstrap.css" rel="stylesheet" />
  </head>

  <body>
    <div class="container">
      <form:form method="POST" modelAttribute="user" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="username"
              class="form-control"
              placeholder="Username"
              autofocus="true"
            ></form:input>
            <form:errors path="username"></form:errors>
          </div>
        </spring:bind>

        <spring:bind path="password">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="password"
              path="password"
              class="form-control"
              placeholder="Password"
            ></form:input>
            <form:errors path="password"></form:errors>
          </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="password"
              path="passwordConfirm"
              class="form-control"
              placeholder="Confirm your password"
            ></form:input>
            <form:errors path="passwordConfirm"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="name">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="name"
              class="form-control"
              placeholder="Name"
            ></form:input>
            <form:errors path="name"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="contact">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="contact"
              class="form-control"
              placeholder="Contact"
            ></form:input>
            <form:errors path="contact"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="email">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="email"
              path="email"
              class="form-control"
              placeholder="Email"
            ></form:input>
            <form:errors path="email"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="house_no">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="house_no"
              class="form-control"
              placeholder="House"
            ></form:input>
            <form:errors path="house_no"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="street_name">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="street_name"
              class="form-control"
              placeholder="Street Name"
            ></form:input>
            <form:errors path="street_name"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="city">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="city"
              class="form-control"
              placeholder="City"
            ></form:input>
            <form:errors path="city"></form:errors>
          </div>
        </spring:bind>
        <spring:bind path="account_no">
          <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input
              type="text"
              path="account_no"
              class="form-control"
              placeholder="Account no"
            ></form:input>
            <form:errors path="account_no"></form:errors>
          </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit"
          >Submit</button
        >
      </form:form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="webapp/js/bootstrap.min.js"></script>
  </body>
</html>
