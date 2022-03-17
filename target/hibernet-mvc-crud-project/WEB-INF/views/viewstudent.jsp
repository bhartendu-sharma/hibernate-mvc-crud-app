
  <%@ page import="java.util.List" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Details Page</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/viewstudent.css">

</head>
<body>
    <div class="container outer_box">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>Students Details</b></h2>
						</div>
						<div class="col-xs-6">
							<a href="studentform"class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Student</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Roll No</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Course</th>
							<th>Branch</th>
							<th>Email</th>
							<th>Gender</th>
							<th>Actions</th>

						</tr>
					</thead>
					<tbody>
            <c:forEach var="st" items="${studentLst}">
						<tr>
              <td>${st.rollNo}</td>
              <td>${st.firstName}</td>
              <td>${st.lastName}</td>
              <td>${st.course}</td>
               <td>${st.branch}</td>
                <td>${st.email}</td>
                <td>${st.gender}</td>
							<td>
								<a href="editstudent/${st.rollNo}" data-toggle="modal"><i class="material-icons edit_icon" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								<a href="deletestudent/${st.rollNo}" data-toggle="modal"><i class="material-icons delete_icon" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
          </c:forEach>

					</tbody>
				</table>
			</div>
		</div>
    </div>


</body>
</html>