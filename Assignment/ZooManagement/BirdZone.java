/**
 * This class is used to add Bird Zone in the Zoo
 * @author Rachna Jadam
 */
public class BirdZone extends Zone{
	
	/**
     * It initializes the BirdZone properties into Zoo
     * @param capacity        Capacity of bird zone
     * @param hasPark         true if bird zone has park, otherwise false
     * @param hasCanteen      true if bird zone has canteen, otherwise false
     */
    public BirdZone(int capacity, boolean hasPark, boolean hasCanteen)
    {
        super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
    }
}
