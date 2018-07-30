public class ReptileZone extends Zone{
	private static int totalReptileZone = 0;
	public ReptileZone(AnimalFamily zoneType, int capacity, boolean hasPark,
			boolean hasCanteen) {
		super(AnimalFamily.REPTILE, capacity, hasPark, hasCanteen);
		totalReptileZone++;
	}
	
	public int getTotalBirdZone()
	{
		return totalReptileZone;
	}
}
