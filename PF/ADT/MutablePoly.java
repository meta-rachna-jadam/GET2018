import java.util.ArrayList;
import java.util.List;


public class MutablePoly {
    private List<Polynomial> polynomialList;
    
    public MutablePoly() {
	    polynomialList = new ArrayList<Polynomial>();
	}
    
    public MutablePoly(List<Polynomial> polynomialList){
    	this.polynomialList = polynomialList;
    }
    
    public void addPolynomial(Polynomial polynomial){
        polynomialList.add(polynomial);
    }
    
    public void removePolynomial(Polynomial polynomial){
        polynomialList.remove(polynomial);
    }
    
    /**
     * evaluate value of polynomial for a particular value of variable. 
     * @param valueOnWhichPolynomialEvaluate
     * @return evaluate value
     */
    public float evaluate(float valueOnWhichPolynomialEvaluate){
        float result = 0;
        for(Polynomial polynomial : polynomialList){
            result += polynomial.getCoefficient() * Math.pow(valueOnWhichPolynomialEvaluate,
                      polynomial.getExponent());
        }
        return result;
    }
    
    /**
     * find highest degree of polynomial
     * @return highest degree of polynomial
     */
    public int degree(){
        int degree = 0;
        for(Polynomial polynomial : polynomialList){
            if(degree < polynomial.getExponent()){
                degree = polynomial.getExponent();
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
    public MutablePoly addPoly(MutablePoly polynomialOne, MutablePoly polynomialTwo) throws NullPointerException{
        if(polynomialOne == null && polynomialTwo == null){
            throw new NullPointerException();
        }
        int polynomialOneIndex;
        int polynomialTwoIndex;
        System.out.println(polynomialOne.polynomialList.size()+"   "+polynomialTwo.polynomialList.size());
        List<Polynomial> resultPolynomialList = new ArrayList<Polynomial>();
        for(polynomialOneIndex = 0 , polynomialTwoIndex = 0; polynomialOneIndex < polynomialOne.
                polynomialList.size() && polynomialTwoIndex < polynomialTwo.polynomialList.size(); ){
            if(polynomialOne.polynomialList.get(polynomialOneIndex).getExponent() < 
            		polynomialTwo.polynomialList.get(polynomialTwoIndex).getExponent()){
                resultPolynomialList.add(
                        new Polynomial(polynomialTwo.polynomialList.get(polynomialTwoIndex).getCoefficient(),
                        		polynomialTwo.polynomialList.get(polynomialTwoIndex).getExponent())
                        );
                polynomialTwoIndex++;
            }
            else if(polynomialOne.polynomialList.get(polynomialOneIndex).getExponent() > 
            polynomialTwo.polynomialList.get(polynomialTwoIndex).getExponent()){
                resultPolynomialList.add(
                        new Polynomial(polynomialOne.polynomialList.get(polynomialOneIndex).getCoefficient(),
                        		polynomialOne.polynomialList.get(polynomialOneIndex).getExponent())
                        );
                polynomialOneIndex++;
            }
            else{
            	resultPolynomialList.add(
                        new Polynomial(polynomialOne.polynomialList.get(polynomialOneIndex).getCoefficient()+
                        		polynomialTwo.polynomialList.get(polynomialOneIndex).getCoefficient(),
                        		polynomialOne.polynomialList.get(polynomialOneIndex).getExponent())
                        );
            	polynomialOneIndex++;
            	polynomialTwoIndex++;
            }
        }
        while(polynomialOneIndex < polynomialOne.polynomialList.size()){
        	resultPolynomialList.add(
                    new Polynomial(polynomialOne.polynomialList.get(polynomialOneIndex).getCoefficient(),
                    		polynomialOne.polynomialList.get(polynomialOneIndex).getExponent())
                    );
        	polynomialOneIndex++;
        }
        while(polynomialTwoIndex < polynomialTwo.polynomialList.size()){
        	resultPolynomialList.add(
                    new Polynomial(polynomialTwo.polynomialList.get(polynomialTwoIndex).getCoefficient(),
                    		polynomialTwo.polynomialList.get(polynomialTwoIndex).getExponent())
                    );
        	polynomialTwoIndex++;
        }
        
        return new MutablePoly(resultPolynomialList);
    }
    
    /**
     * Multiply two polynomials
     * @param p1 polynomial one
     * @param p2 polynomial two
     * @return multiplication of polynomial one and two
     */
    public MutablePoly multiplyPoly(MutablePoly firstPolynomial, MutablePoly secondPolynomial){
    	int array[] = new int[firstPolynomial.polynomialList.get(0).getExponent() + secondPolynomial.polynomialList.get(0).getExponent() + 1];
    	List<Polynomial> returnPolynomialList = new ArrayList<Polynomial>();
        for(Polynomial polynomialOne : firstPolynomial.polynomialList){
            for(Polynomial polynomialTwo : secondPolynomial.polynomialList){
            	array[polynomialOne.getExponent() + polynomialTwo.getExponent()] += polynomialOne.getCoefficient() * polynomialTwo.getCoefficient();
             }
        }
        for(int arrayIndex = array.length-1; arrayIndex >= 0 ; arrayIndex--){
            returnPolynomialList.add(new Polynomial(array[arrayIndex],arrayIndex));
        }
        return new MutablePoly(returnPolynomialList) ;
    }
    
    /**
     * use to show polynomial
     */
    public void showPoly() {
    	for(Polynomial polynomial : this.polynomialList)
    	{
    		System.out.print(polynomial.getCoefficient()+"X^"+polynomial.getExponent()+" + ");
    	}
    }
}