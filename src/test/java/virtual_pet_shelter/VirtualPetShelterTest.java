package virtual_pet_shelter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {
	@Test
	public void shouldAddTwoPetsToAMapThenFeedThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.feedAllPets();
		Assert.assertEquals(2, pet1.getHunger());

	}

	@Test
	public void shouldAddTwoPetsToAMapThenWaterThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.waterAllPets();
		Assert.assertEquals(2, pet1.getThirst());

	}

	@Test
	public void shouldAddTwoPetsToAMapThenPlayThemBothAtTheSameTime() {
		VirtualPet pet1 = new VirtualPet("Pebbill");
		VirtualPet pet2 = new VirtualPet("Marbill");
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		underTest.playWithAllPets();
		Assert.assertEquals(2, pet1.getRestlessness());
	}

	@Test
	public void shouldIntakeHomelessPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Shellby");
		Map<String, VirtualPet> test = underTest.getAllPets();
		Assert.assertEquals(false, test.isEmpty());
	}

	@Test
	public void shouldAdoptOut() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.takeIn("Cuddles");
		underTest.giveId("Cuddles");
		underTest.adoptOut();

	}
}
