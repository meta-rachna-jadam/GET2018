<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addEmployee" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male"> Male</td>
  				<td><input type="radio" name="gender" value="female"> Female</td>
  				<td><input type="radio" name="gender" value="other"> Other</td>
			</tr>
			<tr>
				<td>Date Of Joining:</td>
				<td><input type="date" name="doj"></td>
			</tr>
			<tr>
				<td>Reporting Manager:</td>
				<td><input type="number" name="reportingMgr"></td>
			</tr>
			<tr>
				<td>Team Lead:</td>
				<td><input type="number" name="teamLead"></td>
			</tr>	
			<tr>
				<td>Project Id:</td>
				<td><input type="number" name="projectId"></td>
			</tr>		
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>