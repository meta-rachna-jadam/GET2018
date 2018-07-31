/**
 * This class will add the Mammal zone into Zoo
 * @author Rachna Jadam
 */
public class MammalZone extends Zone{
    /**
     * It initializes the MammalZone properties into Zoo
     * @param capacity        Capacity of mammal zone
     * @param hasPark         true if mammal zone has park, otherwise false
     * @param hasCanteen      true if mammal zone has canteen, otherwise false
     */
    public MammalZone(int capacity, boolean hasPark, boolean hasCanteen)
    {
        super(AnimalFamily.MAMMAL, capacity, hasPark, hasCanteen);
	}
}
