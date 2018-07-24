
public final class Poly {
    private int coefficientAndExponentials[][];
    public Poly(int[][] coefficientAndExponentials) {
        this.coefficientAndExponentials = coefficientAndExponentials; 
    }
    
    /**
     * evaluate value of polynomial for a particular value of variable. 
     * @param valueOnWhichPolynomialEvaluate
     * @return evaluate value
     */
    public float evaluate(float valueOnWhichPolynomialEvaluate){
        float result = 0;
        for(int index = 0; index < this.coefficientAndExponentials.length; index++){
            result += coefficientAndExponentials[index][0] * Math.pow(valueOnWhichPolynomialEvaluate,
                      this.coefficientAndExponentials[index][1]);
        }
        return result;
    }
    
    /**
     * find highest degree of polynomial
     * @return highest degree of polynomial
     */
    public int degree(){
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
    public Poly addPoly(Poly p1, Poly p2){
        int polynomialOneIndex;
        int polynomialTwoIndex;
        int index = 0;
        int size = p1.coefficientAndExponentials.length + p2.coefficientAndExponentials.length;
        int arrayOfCoeffAndExp[][] = new int[size][size];
        for(polynomialOneIndex = 0 , polynomialTwoIndex = 0; polynomialOneIndex < p1.
            coefficientAndExponentials.length && polynomialTwoIndex < p2.coefficientAndExponentials.length;){
            if(p1.coefficientAndExponentials[polynomialOneIndex][1] < 
               p2.coefficientAndExponentials[polynomialTwoIndex][1]){
                arrayOfCoeffAndExp[index][0] = p2.coefficientAndExponentials[polynomialTwoIndex][0];
                arrayOfCoeffAndExp[index][1] = p2.coefficientAndExponentials[polynomialTwoIndex][1];
                index++;
                polynomialTwoIndex++;
            }
            else if(p1.coefficientAndExponentials[polynomialOneIndex][1] > p2.coefficientAndExponentials
                   [polynomialTwoIndex][1]){
        	    arrayOfCoeffAndExp[index][0] = p1.coefficientAndExponentials[polynomialOneIndex][0];
        	    arrayOfCoeffAndExp[index][1] = p1.coefficientAndExponentials[polynomialOneIndex][1];
        	    index++;
        	    polynomialOneIndex++;
            }
            else{
        	    arrayOfCoeffAndExp[index][0] = p1.coefficientAndExponentials[polynomialOneIndex][0]
                        + p2.coefficientAndExponentials[polynomialTwoIndex][0];
                arrayOfCoeffAndExp[index][1] = p1.coefficientAndExponentials[polynomialOneIndex][1];
                index++;
                polynomialOneIndex++;
                polynomialTwoIndex++;
            }
        }
        while(polynomialOneIndex < p1.coefficientAndExponentials.length){
            arrayOfCoeffAndExp[index][0] = p1.coefficientAndExponentials[polynomialOneIndex][0];
    	    arrayOfCoeffAndExp[index][1] = p1.coefficientAndExponentials[polynomialOneIndex][1];
    	    index++;
    	    polynomialOneIndex++;
        }
        while(polynomialTwoIndex < p2.coefficientAndExponentials.length){
            arrayOfCoeffAndExp[index][0] = p2.coefficientAndExponentials[polynomialTwoIndex][0];
    	    arrayOfCoeffAndExp[index][1] = p2.coefficientAndExponentials[polynomialTwoIndex][1];
    	    index++;
    	    polynomialTwoIndex++;
        }
        
        return new Poly(arrayOfCoeffAndExp);
    }
    
    /**
     * use to show polynomial
     */
    /*public void showPoly() {
    	for(int i=0;i<coefficientAndExponentials.length;i++)
    	{
    		System.out.print(coefficientAndExponentials[i][0]+"X^"+coefficientAndExponentials[i][1]+" + ");
    	}
		
	}*/
    
    /**
     * Multiply two polynomials
     * @param p1 polynomial one
     * @param p2 polynomial two
     * @return multiplication of polynomial one and two
     */
    public Poly multiplyPoly(Poly p1, Poly p2){
        int size = p1.coefficientAndExponentials.length * p2.coefficientAndExponentials.length + 1;
        int arrayOfCoeffAndExp[][] = new int[size][size];
        int index = 0;
        for(int polynomialOneRowIndex = 0; polynomialOneRowIndex < p1.coefficientAndExponentials.length;
            polynomialOneRowIndex++){
            for(int polynomialTwoRowIndex = 0; polynomialTwoRowIndex < p2.coefficientAndExponentials.length;
                polynomialTwoRowIndex++){
                arrayOfCoeffAndExp[index][0] = p1.coefficientAndExponentials[polynomialOneRowIndex][0] * 
                p2.coefficientAndExponentials[polynomialTwoRowIndex][0];
                arrayOfCoeffAndExp[index][1] = p1.coefficientAndExponentials[polynomialOneRowIndex][1] + 
                p2.coefficientAndExponentials[polynomialTwoRowIndex][1];
                index++;	
             }
        }
        return new Poly(arrayOfCoeffAndExp) ;
    }
}