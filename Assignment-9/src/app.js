import {sumNumber} from './modules/math-functions';

const result = document.getElementById("submitResult");

result.addEventListener("click", function() {
	const firstNumber = parseInt(document.getElementById("firstNumber").value, 10);
	const secondNumber = parseInt(document.getElementById("secondNumber").value, 10);
	const resultOfAddition = document.getElementById("result");
	resultOfAddition.textContent = `sumNumber(${firstNumber})(${secondNumber}) = ${sumNumber(firstNumber)(secondNumber)}, sumNumber(${firstNumber}, ${secondNumber}) = ${sumNumber(firstNumber, secondNumber)}`;
});