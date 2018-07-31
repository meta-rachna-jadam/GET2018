/**
 * This class is used to add Reptile Zone in the Zoo
 * @author Rachna Jadam
 */public class ReptileZone extends Zone{
    
	/**
     * It initializes the ReptileZone properties into Zoo
     * @param capacity        Capacity of reptile zone
     * @param hasPark         true if reptile zone has park, otherwise false
     * @param hasCanteen      true if reptile zone has canteen, otherwise false
     */
    public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen) {
        super(AnimalFamily.REPTILE, capacity, hasPark, hasCanteen);
    }
}
