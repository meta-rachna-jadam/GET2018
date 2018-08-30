function validateForm() {
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var email = document.getElementById("emailId");
    var age = document.getElementById("age");
    
    if (validateName(firstName) && validateName(lastName) && validateAge(age) && 
           validateEmail(email)) {
        document.getElementById("addEmployeeForm").submit();  
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

function validateAge(ageObject) {
    var age = ageObject.value.trim();
    age = parseInt(age, 10);
    //check if age is a number or less than or greater than 100
    if (isNaN(age) || age < 18 || age > 80) { 
        ageObject.style.border = "1px solid red";
        return false;
    }
    ageObject.style.border = "1px solid green";
    return true;
}

