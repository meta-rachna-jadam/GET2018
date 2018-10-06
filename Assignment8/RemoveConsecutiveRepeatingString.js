function removeConsecutiveRepeatingString(inputString) {
    //debugger;
    var isCharAppearFirstTime = true,
        resultString = inputString,
        isCharAppearFirstTime = true,
        repeatationStartIndex = -1;
    for (var index = 0; index < resultString.length-1; index++) {
        console.log("Start");
        console.log(index);
        console.log("repeatationStartIndex = "+repeatationStartIndex);
        if (inputString.charAt(index) == inputString.charAt(index + 1)){
            if (isCharAppearFirstTime) {
                repeatationStartIndex = index;
            }
            isCharAppearFirstTime = false;
        } else if (inputString.charAt(index) != inputString.charAt(index + 1)) {
            isCharAppearFirstTime = true;
            
            if (repeatationStartIndex != -1) {
                console.log("test = "+resultString.substring(repeatationStartIndex,index+1));
                resultString = resultString.replace(resultString.substring(repeatationStartIndex,index+1),"");
                console.log("rs = "+resultString);
                index = -1;
                repeatationStartIndex = -1;
            }
            
            
        }
        console.log("End");
        
    }
    console.log("Result = "+resultString);
    return resultString;
}

removeConsecutiveRepeatingString("eeabcddcbfgf");