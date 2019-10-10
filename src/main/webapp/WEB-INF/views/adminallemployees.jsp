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

    <title>All Employees</title>
  </head>
  <body>
    <div class="table-title">
      <h3 align="center">All Employees</h3>
      <br />
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Name</th>
          <th class="text-left">Contact</th>
          <th class="text-left">E-mail</th>
          <th class="text-left">House No</th>
          <th class="text-left">Street Name</th>
          <th class="text-left">City</th>
          <th class="text-left">Date of Joining</th>
          <th class="text-left">Salary</th>
          <th class="text-left">Account No</th>
          <th class="text-left">Edit Employee</th>
          <th class="text-left">Remove Employee</th>
        </tr>
      </thead>

      <tbody class="table-hover">
        <c:forEach items="${allemployees}" var="employee">
          <tr>
            <td align="center">${employee.employee_id}</td>
            <td align="center">${employee.name}</td>
            <td align="center">${employee.contact}</td>
            <td align="center">${employee.email}</td>
            <td align="center">${employee.house_no}</td>
            <td align="center">${employee.street_name}</td>
            <td align="center">${employee.city}</td>
            <td align="center">${employee.joining_date}</td>
            <td align="center">${employee.salary}</td>
            <td align="center">${employee.account_no}</td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-warning "
                onclick="window.location.href='/manager/updateemployee/${employee.employee_id}'"
              >
                Edit
              </button>
            </td>
            <td class="text-center">
              <button
                type="button"
                class="btn btn-danger "
                onclick="window.location.href='/manager/removeemployee/${employee.employee_id}'"
              >
                <span class="glyphicon glyphicon-remove"></span> Remove
              </button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br /><br /><br />
    <div class="row" style="padding-top: 1rem">
      <div class="col-md-5"></div>
      <div class="col-md-15">
        <button
          type="submit"
          class="btn btn-primary btn-lg"
          onclick="window.location.href='/manager/registeremployee'"
        >
          <i class="fa fa-plus-circle"></i>&nbsp;&nbsp;&nbsp;Add employee
        </button>
      </div>
    </div>
  </body>
</html>
