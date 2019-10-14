<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/css" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Create an account</title>

    <link href="${css}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${css}/css/bootstrap.css" rel="stylesheet" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"
    />
  </head>

  <body>
    <div class="jumbotron">
      <div class="container">
        <form:form method="POST" modelAttribute="user" class="form-signin">
          <h2 class="form-signin-heading">Create your account</h2>
          <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <form:input
                type="text"
                path="username"
                required="true"
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
                required="true"
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
                required="true"
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
                required="true"
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
                required="true"
                pattern="[6789][0-9]{9}"
                class="form-control"
                placeholder="9191991919"
              ></form:input>
              <form:errors path="contact"></form:errors>
            </div>
          </spring:bind>
          <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <form:input
                type="email"
                path="email"
                required="true"
                class="form-control"
                placeholder="you@example.com"
              ></form:input>
              <form:errors path="email"></form:errors>
            </div>
          </spring:bind>
          <spring:bind path="house_no">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <form:input
                type="text"
                path="house_no"
                required="true"
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
                required="true"
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
                required="true"
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
                required="true"
                class="form-control"
                placeholder="Account No. (9 to 18 digits only)"
                pattern="[0-9]{9,18}"
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
      <script src="${css}/js/bootstrap.min.js"></script>
    </div>
  </body>
</html>
