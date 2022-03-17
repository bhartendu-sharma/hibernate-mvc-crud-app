<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/studentform.css">
  <link rel="stylesheet" href="tmp.css">
  <title>Student Edit Page</title>
</head>
<body>
<marquee >
   कृपया जानकारी ध्यानपूर्वक भरें , हालांकि हम आपको सुधारने का मौका देंगे , लेकिन संभव हो समय की गंभीरता को समझें।
</marquee>
 <div class="inner-container">
    <div class="box">
      <h1>Edit Student Details</h1>
      <form:form method="POST" modelAttribute="student" action="/hibernet-mvc-crud-project/editsave">
          <form:hidden  path="rollNo" />
        <form:input type="text" path="firstName" placeholder="Enter First Name" required="true"/>
        <form:input type="text" path="lastName" placeholder="Enter Last Name" required="true"/>
        <form:input type="text" path="course" placeholder="Enter Course Name" required="true"/>
        <form:input type="text" path="branch" placeholder="Enter Branch Name" required="true"/>
        <form:input type="email" path="email" placeholder="Enter Email Address" required="true"/>
         <form:label path="gender">Select Gender : </form:label>
         <br><br>
        <form:select path="gender">
          <form:option value="Male">Male</form:option>
          <form:option value="Female">Female</form:option>
          <form:option value="Other">Other</form:option>
        </form:select>
        <button type="submit">Save</button>
   </form:form>
    </div>
  </div>

</body>
</html>