
public class Area {
	
	/**
	 * Calculate area of triangle
	 * @param base is the base of triangle, it should be greater then zero
	 * @param height  is the height of triangle, it should be greater then zero
	 * @return area of triangle
	 * @throws ArithmeticException when base or height are less then zero
	 */
	public double areaOfTriangle(double base, double height) throws ArithmeticException{
		if((base > 0) && (height > 0)){
			return (base * height)/2;
		}
		else if((base == 0) || (height == 0)){
			return 0;
		}
		else{
			throw new ArithmeticException();
		}
	}
	
	/**
	 * Calculate area of rectangle
	 * @param width is the width of rectangle, it should be greater then zero
	 * @param height  is the height of rectangle, it should be greater then zero
	 * @return area of rectangle
	 * @throws ArithmeticException when width or height are less then zero
	 */
	public double areaOfRectangle(double width, double height) throws ArithmeticException{
		if((width > 0) && (height > 0)){
			return (width * height);
		}
		else  if((width == 0) || (height == 0)){
			return 0;
		}
		else{
			throw new ArithmeticException();
		}
	}
	
	/**
	 * Calculate area of square
	 * @param width is the width of square, it should be greater then zero
	 * @return area of square
	 * @throws ArithmeticException when width is less then zero
	 */
	public double areaOfSquare(double width) throws ArithmeticException{
		return areaOfRectangle(width, width);
	}
	
	/**
	 * Calculate area of circle
	 * @param radius is the radius of circle, it should be greater then zero
	 * @return area of circle
	 * @throws ArithmeticException when radius is less then zero
	 */
	public double areaOfCircle(double radius) throws ArithmeticException{
		if(radius > 0){
			return (Math.PI)*(radius*radius);
		}
		else  if(radius == 0){
			return 0;
		}
		else{
			throw new ArithmeticException();
		}
	}
}
