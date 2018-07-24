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
    public MutablePoly addPoly(MutablePoly p1, MutablePoly p2){
        int polynomialOneIndex;
        int polynomialTwoIndex;
        System.out.println(p1.polynomialList.size()+"   "+p2.polynomialList.size());
        List<Polynomial> resultPolynomialList = new ArrayList<Polynomial>();
        for(polynomialOneIndex = 0 , polynomialTwoIndex = 0; polynomialOneIndex < p1.
                polynomialList.size() && polynomialTwoIndex < p2.polynomialList.size(); ){
            if(p1.polynomialList.get(polynomialOneIndex).getExponent() < 
               p2.polynomialList.get(polynomialTwoIndex).getExponent()){
                resultPolynomialList.add(
                        new Polynomial(p2.polynomialList.get(polynomialTwoIndex).getCoefficient(),
                                p2.polynomialList.get(polynomialTwoIndex).getExponent())
                        );
                polynomialTwoIndex++;
            }
            else if(p1.polynomialList.get(polynomialOneIndex).getExponent() > 
               p2.polynomialList.get(polynomialTwoIndex).getExponent()){
                resultPolynomialList.add(
                        new Polynomial(p1.polynomialList.get(polynomialOneIndex).getCoefficient(),
                                p1.polynomialList.get(polynomialOneIndex).getExponent())
                        );
                polynomialOneIndex++;
            }
            else{
            	resultPolynomialList.add(
                        new Polynomial(p1.polynomialList.get(polynomialOneIndex).getCoefficient()+
                        		p2.polynomialList.get(polynomialOneIndex).getCoefficient(),
                                p1.polynomialList.get(polynomialOneIndex).getExponent())
                        );
            	polynomialOneIndex++;
            	polynomialTwoIndex++;
            }
        }
        while(polynomialOneIndex < p1.polynomialList.size()){
        	resultPolynomialList.add(
                    new Polynomial(p1.polynomialList.get(polynomialOneIndex).getCoefficient(),
                            p1.polynomialList.get(polynomialOneIndex).getExponent())
                    );
        	polynomialOneIndex++;
        }
        while(polynomialTwoIndex < p2.polynomialList.size()){
        	resultPolynomialList.add(
                    new Polynomial(p2.polynomialList.get(polynomialTwoIndex).getCoefficient(),
                            p2.polynomialList.get(polynomialTwoIndex).getExponent())
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
    public MutablePoly multiplyPoly(MutablePoly p1, MutablePoly p2){
    	List<Polynomial> returnPolynomialList = new ArrayList<Polynomial>();
        for(Polynomial polynomialOne : p1.polynomialList){
            for(Polynomial polynomialTwo : p2.polynomialList){
                returnPolynomialList.add(new Polynomial(
                        polynomialOne.getCoefficient() * polynomialTwo.getCoefficient(),
                        polynomialOne.getExponent() + polynomialTwo.getExponent()));
             }
        }
        return new MutablePoly(returnPolynomialList) ;
    }
    /**
     * use to show polynomial
     */
    /*public void showPoly() {
    	for(Polynomial polynomial : this.polynomialList)
    	{
    		System.out.print(polynomial.getCoefficient()+"X^"+polynomial.getExponent()+" + ");
    	}
    }*/
}

