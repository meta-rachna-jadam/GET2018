public class BirdZone extends Zone{
    private static int totalBirdZone = 0;

	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
	    totalBirdZone++;
	}
	
	public int getTotalBirdZone()
	{
		return totalBirdZone;
	}
	
}
