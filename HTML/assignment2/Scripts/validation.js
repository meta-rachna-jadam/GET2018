function validateSignupForm() {
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var contactNumber = document.getElementById("contactNumber");
	var email = document.getElementById("emailId");
	var password = document.getElementById("password");
	var confirmPassword = document.getElementById("confirmPassword");
	
	if (validateName(firstName) && validateName(lastName) && validateNumber(contactNumber) && 
		   validateEmail(email) && validatePassword(password) && checkPassword(password, confirmPassword)) {
		document.getElementById("signUpForm").submit();  
	}
}

function validateLoginForm(){
	var email = document.getElementById("loginEmailId");
	var password = document.getElementById("loginPassword");
	
	if (validateEmail(email) && validatePassword(password)) {
		document.getElementById("loginForm").submit();   
	}
}

function validateEmail(email) {
	var inputValue = email.value.trim();
	if (inputValue.indexOf('@') > 0 && inputValue.indexOf('.') > 2 && inputValue.indexOf('.', inputValue.indexOf('@')) != -1 && 
	        inputValue.indexOf('.', inputValue.indexOf('@')) < inputValue.length-2) {
		email.style.border = "1px solid green";
		//alert("true");
	}else {
		//alert("false");
		email.style.border = "1px solid red";
		return false;
	}
	return true;
}

function validateName(name) {
	var upperName = name.value.toUpperCase().trim();
	if (upperName.length < 2) {
		name.style.border = "1px solid red";
		return false;
	}
	var charIndex;
	for(charIndex = 0; charIndex < upperName.length; charIndex++) {
		//alert(upperName.charCodeAt(index));
		if((upperName.charAt(charIndex) < 'A' || upperName.charAt(charIndex) > 'Z') && upperName.charAt(charIndex) != ' ') {
			name.style.border = "1px solid red";
			return false;
		}
	}
	name.style.border = "1px solid green";
	return true;
}

function validateNumber(contactNumber){
	var number = contactNumber.value.trim();
	
	if(number.length < 9) {
		contactNumber.style.border = "1px solid red";
		return false;
	}
	
	var numberIndex;
	for(numberIndex = 0; numberIndex < number.length; numberIndex++) {
		if(number.charAt(numberIndex) < '0' || number.charAt(numberIndex) > '9') {
			contactNumber.style.border = "1px solid red";
			return false;
		}
	}
	contactNumber.style.border = "1px solid green";
	return true;
}

function validatePassword(passwordObject) {
	var  password = passwordObject.value.trim();
	
	if(password.length < 8) {
		passwordObject.style.border = "1px solid red";
		return false;
	}
	
	var checkUpperAlphabet = false;
	var checkLowerAlphabet = false;
	var checkNumber = false;
	var checkSpecialCaseCharacter = false;
	var passwordIndex;
	for(passwordIndex = 0; passwordIndex < password.length; passwordIndex++) {
		if(password.charCodeAt(passwordIndex) >= 65 && password.charCodeAt(passwordIndex) <= 90) {
			checkUpperAlphabet = true;
			//alert("upper");
		}
		if(password.charCodeAt(passwordIndex) >= 97 && password.charCodeAt(passwordIndex) <= 122) {
			checkLowerAlphabet = true;
			//alert("lower");
		}
		if(password.charCodeAt(passwordIndex) >= 48 && password.charCodeAt(passwordIndex) <= 57) {
			checkNumber = true;
			//alert("number");
		}
		if((password.charCodeAt(passwordIndex) >= 33 && password.charCodeAt(passwordIndex) <= 47) || 
			   (password.charCodeAt(passwordIndex) >= 58 && password.charCodeAt(passwordIndex) <= 64) || 
			   (password.charCodeAt(passwordIndex) >= 91 && password.charCodeAt(passwordIndex) <= 96) || 
			   (password.charCodeAt(passwordIndex) >= 123 && password.charCodeAt(passwordIndex) <= 126)) {
			checkSpecialCaseCharacter = true;
			//alert("character");
		}
	}
	
	if(checkUpperAlphabet && checkLowerAlphabet && checkNumber && checkSpecialCaseCharacter) {
		passwordObject.style.border = "1px solid green";
		//alert("all true");
		return true;
	}
	passwordObject.style.border = "1px solid red";
	//alert("all not true");
	return false;
}

function checkPassword(password, confirmPassword) {
	
	//debugger;
	if(password.value.trim() == confirmPassword.value.trim()) {
		confirmPassword.style.border = "1px solid green";
		return true;
	}
	confirmPassword.style.border = "1px solid red";
	return false;
}
