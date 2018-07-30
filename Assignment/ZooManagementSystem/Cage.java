import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.TransactionRequiredException;

public class Cage {

	private static int cageCount = 0;
	private AnimalName animalType;
	private int capacity;
	List<Animal> listOfAnimals = new ArrayList<>();
	HashMap<AnimalName, Integer> availableSpaceForAnimalName;
			
	public Cage(AnimalName animalType, int capacity) {
		availableSpaceForAnimalName = new HashMap<AnimalName, Integer>();
		cageCount++;
		this.animalType = animalType;
		this.capacity = capacity;
		availableSpaceForAnimalName.put(animalType, capacity-1);
	}
	
	public AnimalName getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalName animalType) {
		this.animalType = animalType;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	
	public int getTotalCageAvailable()
	{
		return cageCount;
	}

	public String getInfo() {
		String cageInfo = "Total Cage: "+cageCount+
		        "\nCage Capacity: "+capacity+
		        "\nAnimal type In cage: "+animalType+
		        "\nList of animal: ";
		for(Animal animal: listOfAnimals)
		{
			cageInfo += animal.getName()+"\n";
		}
		return cageInfo;
	}
	
	public void addAnimal(AnimalName animalName) throws AssertionError {
		
		if(availableSpaceForAnimalName.containsKey(animalName)){
			if(availableSpaceForAnimalName.get(animalName) == 0){
			    new Cage(animalName, this.capacity);	
			}
			else{
				availableSpaceForAnimalName.put(animalName, availableSpaceForAnimalName.get(animalName)-1);
			}
		}
		else{
			new Cage(animalName, 4);
		}
	}
	
	public void removeAnimal(AnimalName animalName) throws AssertionError{
		
		if(availableSpaceForAnimalName.containsKey(animalName)){
			if(availableSpaceForAnimalName.get(animalName) == this.capacity){
			    new AssertionError("You can not remove animal because cage is empty");
			}
			else{
				availableSpaceForAnimalName.put(animalName, availableSpaceForAnimalName.get(animalName)+1);
			}
		}
		else{
			throw new AssertionError("You can not remove animal because no animal present of animal type "+animalName);
		}
	}
	
	public int spareCapacity(AnimalName animalName) {
		return this.availableSpaceForAnimalName.get(animalName);
	}
}
