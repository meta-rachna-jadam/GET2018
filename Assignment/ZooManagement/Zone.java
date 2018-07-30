import java.util.ArrayList;
import java.util.List;

public class Zone 
{
	private AnimalFamily zoneType; 
	private final int capacity;
	private List<Cage> listOfCages = new ArrayList<>();
	private boolean hasPark;
	private boolean hasCanteen;
	
	public Zone(AnimalFamily zoneType, int capacity, boolean hasPark, boolean hasCanteen)
	{
		this.zoneType = zoneType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	public AnimalFamily getZoneType() {
		return this.zoneType;
	}

	public void setZoneType(AnimalFamily zoneType) {
		this.zoneType = zoneType;
	}

	public List<Cage> getNoOfCages() {
		return this.listOfCages;
	}

	public boolean isHasPark() {
		return this.hasPark;
	}

	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	public boolean isHasCanteen() {
		return this.hasCanteen;
	}

	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

	public int getCapacity() {
		return this.capacity;
	}
	
	public int spareCapacity() {
		return this.capacity - listOfCages.size();
	}
	
	public void addCage(Cage cage)
	{
		if(spareCapacity() != 0)
			this.listOfCages.add(cage);
		else
			throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
	}
	
	public void removeCage()
	{
		this.listOfCages.remove(this.listOfCages.size() - 1);
	}
	
	
}
