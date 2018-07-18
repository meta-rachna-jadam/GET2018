
public interface NBaseCalc {
	public int convertBaseToDecimal(String valueInBase) throws NumberFormatException;
	public String convertDecimalToBase(int valueInDesimal);
	public String add(String valueInBaseOne,String valueInBase2);
	public String subtract(String valueInBaseOne,String valueInBase2);
	public String multiply(String valueInBaseOne,String valueInBase2);
	public String divide(String valueInBaseOne,String valueInBase2);
	public boolean isEquals(String baseValue1, String baseValue2);
	public boolean isGreater(String baseValue1, String baseValue2);
	public boolean isLess(String baseValue1, String baseValue2);
}
