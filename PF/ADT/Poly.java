
public final class Poly {
    private final int coefficientAndExponentials[][];
    public Poly(int[][] coefficientAndExponentials, int arraySize) {
        this.coefficientAndExponentials = new int[arraySize][2];
        for(int index = 0; index < arraySize; index++){
             this.coefficientAndExponentials[index][0] = coefficientAndExponentials[index][0];
             this.coefficientAndExponentials[index][1] = coefficientAndExponentials[index][1];
        } 
    }
    
    public float evaluate(float valueOnWhichPolynomialEvaluate){
        float result = 0;
        for(int index = 0; index < this.coefficientAndExponentials.length; index++){
            result += coefficientAndExponentials[index][0] * Math.pow(valueOnWhichPolynomialEvaluate, this.coefficientAndExponentials[index][1]);
        }
        return result;
    }
    
    public int degree() {
        int degree = 0;
        for(int index = 0; index < this.coefficientAndExponentials.length; index++){
            if(degree < coefficientAndExponentials[index][1]){
                degree = coefficientAndExponentials[index][1];
            }
        }
        return degree;
    }
    
    /**
     * add two polynomial, here we add two coefficient if their exponentials are same.
     * Take polynomial in sorted form 
     * @param p1 polynomial one
     * @param p2 polynomial two
     * @return addition of polynomial one and polynomial two
     */
    public Poly addPoly(Poly polynomialOne, Poly polynomialTwo) throws NullPointerException {
        if(polynomialOne == null && polynomialTwo == null){
    	    throw new NullPointerException();
        }
        int polynomialOneIndex;
        int polynomialTwoIndex;
        int index = 0;
        int size = polynomialOne.coefficientAndExponentials.length + polynomialTwo.coefficientAndExponentials.length;
        int arrayOfCoeffAndExp[][] = new int[size][size];
        for(polynomialOneIndex = 0 , polynomialTwoIndex = 0; polynomialOneIndex < polynomialOne.
            coefficientAndExponentials.length && polynomialTwoIndex < polynomialTwo.coefficientAndExponentials.length;){
        	
            if(polynomialOne.coefficientAndExponentials[polynomialOneIndex][1] < polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][1]){
                arrayOfCoeffAndExp[index][0] = polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][0];
                arrayOfCoeffAndExp[index][1] = polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][1];
                index++;
                polynomialTwoIndex++;
            }
            else if(polynomialOne.coefficientAndExponentials[polynomialOneIndex][1] > polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][1]){
        	    arrayOfCoeffAndExp[index][0] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][0];
        	    arrayOfCoeffAndExp[index][1] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][1];
        	    index++;
        	    polynomialOneIndex++;
            }
            else{
        	    arrayOfCoeffAndExp[index][0] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][0] + polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][0];
                arrayOfCoeffAndExp[index][1] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][1];
                index++;
                polynomialOneIndex++;
                polynomialTwoIndex++;
            }
        }
        while(polynomialOneIndex < polynomialOne.coefficientAndExponentials.length){
            arrayOfCoeffAndExp[index][0] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][0];
    	    arrayOfCoeffAndExp[index][1] = polynomialOne.coefficientAndExponentials[polynomialOneIndex][1];
    	    index++;
    	    polynomialOneIndex++;
        }
        while(polynomialTwoIndex < polynomialTwo.coefficientAndExponentials.length){
            arrayOfCoeffAndExp[index][0] = polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][0];
    	    arrayOfCoeffAndExp[index][1] = polynomialTwo.coefficientAndExponentials[polynomialTwoIndex][1];
    	    index++;
    	    polynomialTwoIndex++;
        }  
        return new Poly(arrayOfCoeffAndExp, arrayOfCoeffAndExp.length);
    }
    
    public void showPoly() {
    	for(int i=0;i<coefficientAndExponentials.length;i++){
    		System.out.print(coefficientAndExponentials[i][0]+"X^"+coefficientAndExponentials[i][1]+" + ");
    	}
		
	}
    
    /**
     * Multiply two polynomials
     * @param p1 polynomial one
     * @param p2 polynomial two
     * @return multiplication of polynomial one and two
     */
    public Poly multiplyPoly(Poly polynomialOne, Poly polynomialTwo) throws NullPointerException{
        if(polynomialOne == null && polynomialTwo == null){
            throw new NullPointerException();
        }
        int array[] = new int[polynomialOne.coefficientAndExponentials[0][1] + polynomialTwo.coefficientAndExponentials[0][1] + 1];
        for(int polynomialOneRowIndex = 0; polynomialOneRowIndex < polynomialOne.coefficientAndExponentials.length; polynomialOneRowIndex++){
            for(int polynomialTwoRowIndex = 0; polynomialTwoRowIndex < polynomialTwo.coefficientAndExponentials.length; polynomialTwoRowIndex++){
            	
            	array[polynomialOne.coefficientAndExponentials[polynomialOneRowIndex][1] + polynomialTwo.coefficientAndExponentials[polynomialTwoRowIndex][1]] += 
                this.coefficientAndExponentials[polynomialOneRowIndex][0] * polynomialTwo.coefficientAndExponentials[polynomialTwoRowIndex][0]; 			
            }
        }
        int arrayOfCoeffAndExp[][] = new int[array.length][2];
        int rowIndex = 0;
        for(int arrayIndex = array.length-1; arrayIndex >= 0 ; arrayIndex--){
        	System.out.println(rowIndex+"   "+array[arrayIndex]);
            arrayOfCoeffAndExp[rowIndex][0] = array[arrayIndex];
            arrayOfCoeffAndExp[rowIndex][1] = arrayIndex;
            rowIndex++;
        }
        return new Poly(arrayOfCoeffAndExp, arrayOfCoeffAndExp.length) ;
    }
}
