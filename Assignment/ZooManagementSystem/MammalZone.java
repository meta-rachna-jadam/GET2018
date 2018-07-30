
public class MammalZone extends Zone{
	private static int totalMammalZone = 0;
	public MammalZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.MAMMAL, capacity, hasPark, hasCanteen);
		totalMammalZone++;
	}
	
	public int getTotalMammalZone()
	{
		return totalMammalZone;
	}
}
