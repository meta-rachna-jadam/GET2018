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
				<td><input type="text" name="fname" required="required"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="email" name="emailId" required="required"><br/>*email Id use as username</td>
			</tr>
			<tr>
				<td>Skipe Id:</td>
				<td><input type="text" name="skipeId"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob" required="required"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male"> Male</td>
  				<td><input type="radio" name="gender" value="female"> Female</td>
  				<td><input type="radio" name="gender" value="other"> Other</td>
			</tr>
			<tr>
				<td>Contact Number 1:</td>
				<td><input type="text" name="primaryContactNumber" required="required" required="required"></td>
			</tr>
			<tr>
				<td>Contact Number 2:</td>
				<td><input type="text" name="secondaryContactNumber"></td>
			</tr>
			<tr>
				<td>Date Of Joining:</td>
				<td><input type="date" name="doj" required="required"></td>
			</tr>
			<tr>
				<td>Total Experience:</td>
				<td><input type="text" name="totalExperience" required="required"></td>
			</tr>
			<tr>
				<td>Skills:</td>
				<td><input type="checkbox" name="skills" value="1">Java</td>
				<td><input type="checkbox" name="skills" value="2">Salesforce</td>
				<td><input type="checkbox" name="skills" value="3">Android</td>
				<td><input type="checkbox" name="skills" value="4">IOS</td>
				<td><input type="checkbox" name="skills" value="5">Hadoop</td>
				<td><input type="checkbox" name="skills" value="6">IOT</td>
			</tr>
			<tr>
				<td>Job Title:</td>
				<td><select name="jobTitle">
					    <option value="1" >Reporting manager</option>
					    <option value="2" >Software developer</option>
					    <option value="3" >Sr Software developer</option>
					    <option value="4" >Team Leader</option>
					    <option value="5" >Trainee</option>
				    </select>
				</td>
			</tr>	
			<tr>
				<td>Reporting Manager Id:</td>
				<td><input type="number" name="reportingMgr"></td>
			</tr>
			<tr>
				<td>Team Lead Id:</td>
				<td><input type="number" name="teamLead"></td>
			</tr>	
			<tr>
				<td>Project Id:</td>
				<td><input type="number" name="projectId"></td>
			</tr>
			<tr>
				<td>Role:</td>
				<td><input type="radio" name="role" value="admin">Admin</td>
				<td><input type="radio" name="role" value="user">User</td>
			</tr>
			<tr>
				<td>Profile Photo:</td>
				<td><input type="file" name="profilePhoto"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>		
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>	
	</form>
</body>
</html>
