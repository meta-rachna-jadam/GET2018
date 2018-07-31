import java.util.ArrayList;
import java.util.List;

/**
 * This class will perform various operations on Zoo management
 * @author Rachna Jadam
 */
public class ZooManagement {
    List<Zone> listOfZone = new ArrayList<Zone>(); // create the list of zones
	
    /**
     * This method add the zone for a specific type of animal
     * @param zoneType
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     */
    public boolean addZone(AnimalFamily zoneType, int capacity, boolean hasPark, boolean hasCanteen)
    {
        Zone zone = null;		
        switch(zoneType)
        {
            case BIRD:
                zone = new BirdZone(capacity, hasPark, hasCanteen);
                break;
            case MAMMAL:
                zone = new MammalZone(capacity, hasPark, hasCanteen);
                break;
            case REPTILE:
                zone = new ReptileZone(capacity, hasPark, hasCanteen);
                break;		
        }
        listOfZone.add(zone);
        return true;
    }
	
    /**
     * This method will add cage to a particular zone
     * @param animal      animal name for what you want to add cage
     * @param capacity    capacity of cage for a particular animal
     * @return            true if cage add successfully
     * @exception         assertion error if no zone or animal present of a particular type
     */
    public boolean addCage(AnimalName animal, int capacity) throws AssertionError{
        Cage cage = new Cage(animal, capacity);
        for(Zone zone: listOfZone){
            if(zone.spareCapacity() != 0){
                // check for a specific zone type and their animals
                if(zone.getZoneType() == AnimalFamily.BIRD && (AnimalName.PARROT.equals(animal)
                        || AnimalName.PEACOCK.equals(animal))){
                    zone.addCage(cage);
                    return true;
                }
                else if(zone.getZoneType() == AnimalFamily.MAMMAL && (animal.equals(AnimalName.LION)
                        || animal.equals(AnimalName.ELEPHANT))){
                    zone.addCage(cage);
                    return true;
                }
                else if(zone.getZoneType() == AnimalFamily.REPTILE && (animal.equals(AnimalName.CROCODILE)
                        || animal.equals(AnimalName.SNAKE))){
                    zone.addCage(cage);
                    return true;
                }	
            }			
        }
        throw new AssertionError("You need to add a zone first.");
    }
	
	/**
	 * This method adds the animal to a specific cage
	 * @param animal 
	 * @return true if added successfully
	 * @exception if all zones are full
	 */
    public boolean addAnimal(Animal animal) throws AssertionError{
        for(Zone zone: listOfZone){
            if(zone.getZoneType().equals(animal.getCategory()) && zone.addAnimal(animal)){
                return true;
            }
        }
        throw new AssertionError("All zones are full. You need to add a zone first!!");
    }
	
    /**
     * This method removes the specific animal from the cage
     * @param animal takes the animal name
     */
    public boolean removeAnimal(AnimalName animal) throws AssertionError {
    	if(animal == null){
    	    throw new AssertionError("Animal name contains null");
    	}
        AnimalFamily category = null;
        switch(animal)
		{
            case CROCODILE:
            case SNAKE:
                category = AnimalFamily.REPTILE;
                break;
                
            case ELEPHANT:
            case LION:
                category = AnimalFamily.MAMMAL;
                break;
                
            case PARROT:
            case PEACOCK:
                category = AnimalFamily.BIRD;
                break;
        }
        if(category == null){
            throw new AssertionError("Animal is not present in zoo");
        }
        for(Zone zone: listOfZone){
            if(zone.getZoneType().equals(animal) && zone.removeAnimal(animal)){
                return true;
            }
        }
        throw new AssertionError("Animal not found.");
    }
}