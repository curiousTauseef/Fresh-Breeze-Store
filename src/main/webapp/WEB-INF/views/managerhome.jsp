<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@taglib prefix="spring"
uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/css" />
<jsp:include page="adminnavbar.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link rel="stylesheet" type="text/css" href="${css}/css1/table.css" />

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css"
    />

    <title>Welcome ${user.name}</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">
        <p>Details of ${user.name}</p>
        <p>ROLE : ${user.role}</p>
      </h3>
      <br />
    </div>
    <table class="table-fill">
      <tbody class="table-hover">
        <tr>
          <td align="center"><strong>Username</strong></td>
          <td align="center">${user.username}</td>
        </tr>
        <tr>
          <td align="center"><strong>Name</strong></td>
          <td align="center">${user.name}</td>
        </tr>
        <tr>
          <td align="center"><strong>Contact</strong></td>
          <td align="center">${user.contact}</td>
        </tr>
        <tr>
          <td align="center"><strong>Email Id</strong></td>
          <td align="center">${user.email}</td>
        </tr>
        <tr>
          <td align="center"><strong>House No</strong></td>
          <td align="center">${user.house_no}</td>
        </tr>
        <tr>
          <td align="center"><strong>Locality</strong></td>
          <td align="center">${user.street_name}</td>
        </tr>
        <tr>
          <td align="center"><strong>City</strong></td>
          <td align="center">${user.city}</td>
        </tr>
        <tr>
          <td align="center"><strong>Account No</strong></td>
          <td align="center">${user.account_no}</td>
        </tr>
      </tbody>
    </table>
    <br /><br /><br />
  </body>
</html>
