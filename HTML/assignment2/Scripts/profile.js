function editClick(){
	var buttonText = document.getElementById("edit").value.trim();
	if (buttonText == "Edit Information") {
		document.getElementById("firstName").disabled = false;
		document.getElementById("lastName").disabled = false;
		document.getElementById("emailId").disabled = false;
		document.getElementById("contactNumber").disabled = false;
		document.getElementById("companyInstitution").disabled = false;
		document.getElementById("edit").value = "Change Information"
	}else if (buttonText == "Change Information") {
		document.getElementById("firstName").disabled = true;
		document.getElementById("lastName").disabled = true;
		document.getElementById("emailId").disabled = true;
		document.getElementById("contactNumber").disabled = true;
		document.getElementById("companyInstitution").disabled = true;
		document.getElementById("edit").value = "Edit Information";
	}
}