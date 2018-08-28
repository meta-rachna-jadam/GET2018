function validateSignupForm()
{
	var firstName = document.getElementById("firstName");
	var lastName = document.getElementById("lastName");
	var contactNumber = document.getElementById("contactNumber");
	var email = document.getElementById("emailId");
	var password = document.getElementById("password");
	var confirmPassword = document.getElementById("confirmPassword");
	
	return validateName(firstName) && validateName(lastName) && validateContactNumber(contactNumber) && 
		   validateEmail(email) && validatePassword(password) && checkPassword(password, confirmPassword);
}

function validateEmail(email){
	var inputValue = email.value;
	if (inputValue.indexOf('@') > 0 && inputValue.indexOf('.') > 2 && inputValue.indexOf('.') < inputValue.length-2) {
		email.style.border = "1px solid green";
		//alert("true");
	}else {
		//alert("false");
		email.style.border = "1px solid red";
		return false;
	}
	return true;
}

function validateName(name){
	var upperName = name.value.toUpperCase();
	
	var charIndex;
	for(charIndex = 0; charIndex < upperName.length; charIndex++)
	{
		//alert(upperName.charCodeAt(index));
		if((upperName.charAt(charIndex) < 'A' || upperName.charAt(charIndex) > 'Z') && upperName.charAt(charIndex) != ' ')
		{
			name.style.border = "1px solid red";
			return false;
		}
	}
	name.style.border = "1px solid green";
	return true;
}

function validateNumber(contactNumber){
	if(contactNumber.value.length < 9)
	{
		contactNumber.style.border = "1px solid red";
		return false;
	}
	
	var numberIndex;
	for(numberIndex = 0; numberIndex < contactNumber.value.length; numberIndex++)
	{
		if(contactNumber.value.charAt(numberIndex) < '0' || contactNumber.value.charAt(numberIndex) > '9')
		{
			contactNumber.style.border = "1px solid red";
			return false;
		}
	}
	contactNumber.style.border = "1px solid green";
	return true;
}

function validatePassword(passwordObject)
{
	var  password = passwordObject.value;
	
	if(password.length < 8)
	{
		passwordObject.style.border = "1px solid red";
		return false;
	}
	
	var checkUpperAlphabet = false;
	var checkLowerAlphabet = false;
	var checkNumber = false;
	var checkSpecialCaseCharacter = false;
	
	var i;
	for(i=0; i<password.length; i++)
	{
		if(password.charCodeAt(i) >= 65 && password.charCodeAt(i) <= 90)
		{
			checkUpperAlphabet = true;
			//alert("upper");
		}
		if(password.charCodeAt(i) >= 97 && password.charCodeAt(i) <= 122)
		{
			checkLowerAlphabet = true;
			//alert("lower");
		}
		if(password.charCodeAt(i) >= 48 && password.charCodeAt(i) <= 57)
		{
			checkNumber = true;
			//alert("number");
		}
		if((password.charCodeAt(i) >= 33 && password.charCodeAt(i) <= 47) || 
		   (password.charCodeAt(i) >= 58 && password.charCodeAt(i) <= 64) || 
		   (password.charCodeAt(i) >= 91 && password.charCodeAt(i) <= 96) || 
		   (password.charCodeAt(i) >= 123 && password.charCodeAt(i) <= 126))
		{
			checkSpecialCaseCharacter = true;
			//alert("character");
		}
	}
	
	if(checkUpperAlphabet && checkLowerAlphabet && checkNumber && checkSpecialCaseCharacter)
	{
		passwordObject.style.border = "1px solid green";
		//alert("all true");
		return true;
	}
	passwordObject.style.border = "1px solid red";
	//alert("all not true");
	return false;
}

function checkPassword(password, confirmPassword)
{
	//debugger;
	if(password.value == confirmPassword.value)
	{
		confirmPassword.style.border = "1px solid green";
		return true;
	}
	confirmPassword.style.border = "1px solid red";
	return false;
}