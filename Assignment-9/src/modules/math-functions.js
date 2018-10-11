const sumNumber = (firstNumber, secondNumber = "") => {
   if(secondNumber == "") {
       return function(secondNumber) {
           return firstNumber + secondNumber;
       }
   }
   else
       return firstNumber + secondNumber;
}

export {sumNumber};