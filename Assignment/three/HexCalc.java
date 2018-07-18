
public class HexCalc implements NBaseCalc{
		
    @Override
    public int convertBaseToDecimal(String valueInBase) throws NumberFormatException{
	    int valueInDecimal=0;
		String valueInBaseInUpperCase=valueInBase.toUpperCase();
		int powerOfBase=valueInBaseInUpperCase.length(); 
		for(int i=0;i<valueInBaseInUpperCase.length();i++){
		    powerOfBase--;
			switch (valueInBaseInUpperCase.charAt(i)) {
			    case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				    valueInDecimal+=(Math.pow(16, (powerOfBase)))*Integer.parseInt(""+valueInBaseInUpperCase.charAt(i)); 
					break;
				case 'A':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*10; 
					break;
				case 'B':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*11; 
					break;
				case 'C':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*12; 
					break;
				case 'D':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*13; 
					break;
				case 'E':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*14; 
					break;
				case 'F':
					valueInDecimal+=(Math.pow(16, (powerOfBase)))*15; 
					break;
				default:
					throw new NumberFormatException();
				
			}
		}
        return valueInDecimal;
	}

	@Override
	public String convertDecimalToBase(int valueInDesimal){
		int decimalValue=valueInDesimal;
		StringBuilder valueInBase=new StringBuilder();
		char possibleHexValue[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(decimalValue>0)
		{
			int remender=decimalValue%16;
			valueInBase.append(possibleHexValue[remender]);
			decimalValue=decimalValue/16;
		}
		return valueInBase.reverse().toString();
	}
	
	@Override
	public String add(String valueInBaseOne,String valueInBase2){
		int addResultInDecimal=convertBaseToDecimal(valueInBaseOne)+convertBaseToDecimal(valueInBase2);
		String addResultInBase=convertDecimalToBase(addResultInDecimal);
		return addResultInBase;
	}
	
	@Override
	public String subtract(String valueInBaseOne,String valueInBase2){
		int subtractResultInDecimal=convertBaseToDecimal(valueInBaseOne)-convertBaseToDecimal(valueInBase2);
		String subtractResultInBase=convertDecimalToBase(subtractResultInDecimal);
		return subtractResultInBase;
	}
	
	@Override
	public String multiply(String valueInBaseOne,String valueInBase2){
		int multiplyResultInDecimal=convertBaseToDecimal(valueInBaseOne)*convertBaseToDecimal(valueInBase2);
		String multiplyResultInBase=convertDecimalToBase(multiplyResultInDecimal);
		return multiplyResultInBase;
	}
	
	@Override
	public String divide(String valueInBaseOne,String valueInBase2){
		int divideResultInDecimal=convertBaseToDecimal(valueInBaseOne)/convertBaseToDecimal(valueInBase2);
		String divideResultInBase=convertDecimalToBase(divideResultInDecimal);
		return divideResultInBase;
	}
	
	public String trimLeadingZeros(String value){
		for(int i=0;i<value.length();i++){
			char temp=value.charAt(i);
			if(temp!='0'){
				return value.substring(i); 
			}		
		}
		return "0";
	}
	
	@Override
	public boolean isEquals(String valueInBase1, String valueInBase2){
		String hexValue1WithoutLeadingZeros=trimLeadingZeros(valueInBase1);
		String hexValue2WithoutLeadingZeros=trimLeadingZeros(valueInBase2);
		if(hexValue1WithoutLeadingZeros.equalsIgnoreCase(hexValue2WithoutLeadingZeros)){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public boolean isGreater(String valueInBase1, String valueInBase2){
		String hexValue1WithoutLeadingZeros=trimLeadingZeros(valueInBase1);
		hexValue1WithoutLeadingZeros=hexValue1WithoutLeadingZeros.toUpperCase();
		String hexValue2WithoutLeadingZeros=trimLeadingZeros(valueInBase2);
		hexValue2WithoutLeadingZeros=hexValue2WithoutLeadingZeros.toUpperCase();
		boolean result;
		if(hexValue1WithoutLeadingZeros.length()>hexValue2WithoutLeadingZeros.length()){
			result= true;
		}
		else if(hexValue1WithoutLeadingZeros.length()<hexValue2WithoutLeadingZeros.length()){
			result= false;
		}
		else{
			for(int i=0;i<hexValue1WithoutLeadingZeros.length();){
				char charOfFirstArg=hexValue1WithoutLeadingZeros.charAt(i);
				char charOfSecondArg=hexValue2WithoutLeadingZeros.charAt(i);
				if(charOfFirstArg>charOfSecondArg){
					result= true;
				}
				else if(charOfFirstArg==charOfSecondArg){
					i++;
				}
				else{
					result= false;
				}
			}
		    result=false;
		}
		return result;
	}
	
	@Override
	public boolean isLess(String valueInBase1, String valueInBase2){
		if(isGreater(valueInBase1, valueInBase2)){
			return false;
		}
		else{
			return true;
		}
	}
}
