package virtual_pet_shelter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {
	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public void addPet(VirtualPet newPet) {
		pets.put(newPet.getID(), newPet);
	}
	// TODO make a generate pet method?

	public void feedAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().feedPet();
		}
	}

	public void waterAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().waterPet();
		}
	}

	public void playWithAllPets() {
		for (Entry<String, VirtualPet> currentPet : pets.entrySet()) {
			currentPet.getValue().playWithPet();
		}
	}

	public void takeIn(String name) {
		VirtualPet newPet = new VirtualPet(name);
		addPet(newPet);
	}

	public Map<String, VirtualPet> getAllPets() {
		return pets;
	}

	public void giveId(String string) {
		// TODO Auto-generated method stub

	}

}
