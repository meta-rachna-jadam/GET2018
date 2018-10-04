var errors = new Map();
function validateSignupForm() {
	var firstName = document.getElementById("firstName");
	var contactNumber = document.getElementById("contactNumber");
	var email = document.getElementById("emailId");
	var state = document.getElementById("state");
	if (validateName(firstName) && validateNumber(contactNumber) && validateState(state) && validateEmail(email)) {
        
        localStorage.clear();
        localStorage.setItem("First Name", firstName.value);
        
        localStorage.setItem("Email", email.value);
        localStorage.setItem("Phone #", contactNumber.value);
        
        var last_name = document.getElementById("lastName");
        if(last_name.value != "") {
            localStorage.setItem("Last Name", last_name.value);
        }
        
        var address = document.getElementById("address");
        if(address.value != "") {
            localStorage.setItem("Address", address.value);
        }
        
        var city = document.getElementById("city");
        if(city.value != "") {
            localStorage.setItem("City", city.value);
        }
        localStorage.setItem("State", state.value);
        if(state.value == "Rajasthan") {
            alert("Raj");
            var project_description = document.getElementById("project_description");
            
            if (project_description.value != ""){
                localStorage.setItem("Project Description", project_description.value);
            }
            
            var website = document.getElementById("website");
            alert(website);
            if(website.value != "") {
                localStorage.setItem("Website or domain name", website.value);
            }
        }
        else if(state.value == "Haryana") {
            var zipcode = document.getElementById("zipcode");
            if (zipcode.value != ""){
                localStorage.setItem("Zip Code",  zipcode.value);
            }
            
            var yesHosting = document.getElementById("yes_hosting");
            var noHosting = document.getElementById("no_hosting");
            
            if(yesHosting.checked) {
                alert("yes");
                localStorage.setItem("Has Hosting", yesHosting.value);
            }
            else if(noHosting.checked) {
                alert("No");
                localStorage.setItem("Has Hosting", noHosting.value);
            }
        }
        else if(state.value == "Maharastra") {
            var zipcode = document.getElementById("zipcode");
            if (zipcode.value != ""){
                localStorage.setItem("Zip Code",  zipcode.value);
            }
            
            var project_description = document.getElementById("project_description");
            if (project_description.value != ""){
                localStorage.setItem("Project Description", project_description.value);
            }
        }
        
		document.getElementById("contact-us-form").submit();  
	} else{
        var errorKeys = errors.keys();
        var message = "";
        
        for(var key of errorKeys) {
            message = message + key + " : " + errors.get(key) + "\n";
        }
        
        alert(message);
        return false;
    }
}

function validateEmail(email) {
	var inputValue = email.value.trim();
	if (inputValue.indexOf('@') > 0 && inputValue.indexOf('.') > 2 && inputValue.indexOf('.', inputValue.indexOf('@')) !== -1 && inputValue.indexOf('.', inputValue.indexOf('@')) < inputValue.length - 2) {
		email.style.border = "1px solid green";
        if(errors.has("E-Mail")) {
            errors.delete("E-Mail");
        }
	} else {
        errors.set("E-Mail", "Invalid email Id");
		email.style.border = "1px solid red";
		return false;
	}
	return true;
}

function validateName(name) {
	var upperName = name.value.toUpperCase().trim();
	if (upperName.length < 2) {
		name.style.border = "1px solid red";
        errors.set("First Name", "First name should have atleast 2 characters");
		return false;
	}
	var charIndex;
	for (charIndex = 0; charIndex < upperName.length; charIndex++) {
		//alert(upperName.charCodeAt(index));
		if ((upperName.charAt(charIndex) < 'A' || upperName.charAt(charIndex) > 'Z') && upperName.charAt(charIndex) != ' ') {
			name.style.border = "1px solid red";
            errors.set("First Name", "First name contains only characters ");
			return false;
		}
	}
    if(errors.has("First Name")) {
        errors.delete("First Name");
    }
	name.style.border = "1px solid green";
	return true;
}

function validateNumber(contactNumber) {
	var number = contactNumber.value.trim();
	
	if (number.length < 9) {
		contactNumber.style.border = "1px solid red";
        errors.set("Phone Number", "Phone number should have atleast 9 numbers ");
		return false;
	}
	
	var numberIndex;
	for (numberIndex = 0; numberIndex < number.length; numberIndex++) {
		if (number.charAt(numberIndex) < '0' || number.charAt(numberIndex) > '9') {
			contactNumber.style.border = "1px solid red";
            errors.set("Phone Number", "Phone number should have only numbers");
            
			return false;
		}
	}
    if(errors.has("Phone Number")) {
        errors.delete("Phone Number");
    }
	contactNumber.style.border = "1px solid green";
	return true;
}

function validateState(state) {
    var parentRef = document.getElementById("contact-us-form");
    var childCount = parentRef.childElementCount;
    var buttonRef = document.getElementById("submit-button");
    if (state.value.length == 0) {
        errors.set("State", "Please select one state");
        return false;
    }
    if(errors.has("State")) {
        errors.delete("State");
    }
    if (childCount > 8) {
        parentRef.removeChild(parentRef.childNodes[16]);
        parentRef.removeChild(parentRef.childNodes[15]);
    }
    
    var websiteDomainName = document.createElement("div");
    websiteDomainName.className = "form-row";
    websiteDomainName.innerHTML = "<div class='form-entry-column'><div class='form-entry'><span>"+
            "Website or domain name</span></div></div><div class='form-field-column'>"+
            "<div class='form-field-icon'><span class='icon'><i class='fas fa-globe-americas'>"+
            "</i></span></div><div class='form-field'><input type='text' name='website' id='website' "+
        "placeholder='Website or domain name' required /></div></div>"
    
    var zipCode = document.createElement("div");
    zipCode.className = "form-row";
    zipCode.innerHTML = "<div class='form-entry-column'><div class='form-entry'><span>"+
            "Zip Code</span></div></div><div class='form-field-column'><div class='form-field-icon'>"+
            "<span class='icon'><i class='fas fa-home'></i></span></div><div class='form-field'>"+
            "<input type='text' name='zip-code' placeholder='Zip Code' id='zipcode' required /></div></div>"
    
    var projectDescription = document.createElement("div");
    projectDescription.className = "form-row";
    projectDescription.innerHTML = "<div class='form-entry-column'><div class='form-entry'>"+
            "<span>Project Description</span></div></div><div class='form-field-column'>"+
            "<div class='form-field-icon'><span class='icon'><i class='fas fa-pen'></i>"+
            "</span></div><div class='form-field'><textarea name='project-description' id='project_description' "+
            "placeholder='Project Description' required></textarea></div></div>"
    
    var doYouHaveHosting = document.createElement("div");
    doYouHaveHosting.className = "form-row";
    doYouHaveHosting.innerHTML = "<div class='form-entry-column'><div class='form-entry'>"+
            "<span>Do you have hosting?</span></div></div><div class='form-field-column'>"+
            "<div class='form-field'><div class='radio-btn'><input type='radio' name='hosting' id='yes_hosting' "+
            "value='yse' required /><span>Yes</span></div><div class='radio-btn'><input type='radio' id='no_hosting' "+
            " name='hosting' value='no' required /><span>No</span></div></div></div>"
    
    
    if (state.value == 'Rajasthan') {
        parentRef.insertBefore(websiteDomainName, buttonRef);
        parentRef.insertBefore(projectDescription, buttonRef);
    } else if (state.value == 'Haryana') {
        parentRef.insertBefore(zipCode, buttonRef);
        parentRef.insertBefore(doYouHaveHosting, buttonRef);
    } else if (state.value == 'Maharastra') {
        parentRef.insertBefore(zipCode, buttonRef);
        parentRef.insertBefore(projectDescription, buttonRef);
    }
    return true;
}