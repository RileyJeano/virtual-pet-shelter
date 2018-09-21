package virtual_pet_shelter;

import java.util.Scanner;
import java.util.Map.Entry;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		VirtualPetShelter shelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);
		System.out.println("Greeting");

		while (shelter.isOpen()) {
			if (shelter.isEmpty()) {
				noPets(shelter, input);
			} else {
				hasPets(shelter, input);

			}

		}
	}

	private static void hasPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("This is the status of your pets:");
		for (Entry<String, VirtualPet> currentPet : shelter.getAllPets().entrySet()) {
			System.out.println(currentPet.getValue().displayStats());
		}
		System.out.println("What would you like to do next?\r\n" + "\r\n" + "1. Feed the pets\r\n"
				+ "2. Water the pets\r\n" + "3. Play with all pet\r\n" + "4. Adopt out a pet\r\n" + "5. Admit a pet\r\n"
				+ "6. BURN IT DOWN");
		shelter.tick();
		String userChoice = input.nextLine();
		userChoice(shelter, userChoice, input);

	}

	private static void userChoice(VirtualPetShelter shelter, String userChoice, Scanner input) {
		switch (userChoice) {
		case "1":
			System.out.println("Type all to feed all or type name to feed pet");
			String choice = input.nextLine();
			if (choice.equalsIgnoreCase("all")) {
				shelter.feedAllPets();
			} else {
				if (shelter.getAllPets().containsKey(choice)) {
					shelter.getPet(choice).feedPet();
				} else {
					System.out.println("Invalid Input");
					break;
				}
			}
			// TODO reference name against list of contains
			break;
		case "2":
			shelter.waterAllPets();
			break;
		case "3":
			shelter.playWithAllPets();
			break;
		case "4":

			System.out.println("Which pet do you want to adpot out?");
			String petToAdopt = input.nextLine();
			int happiness = shelter.getPet(petToAdopt).getHappiness();
			if (happiness >= 10) {
				System.out.println(shelter.getPet(petToAdopt).getName() + " was adopted to a lovely family!");
				shelter.adoptOut(petToAdopt);

			} else {
				System.out.println("This pet is not happy enough to adopt");
			}

			break;
		case "5":
			System.out.println("Name your new pet: ");
			String newName = input.nextLine();
			shelter.takeIn(newName);

			break;
		case "6":
			System.out.println("You burned down the shelter. System failure...");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input... ");
			break;
		}

	}

	private static void noPets(VirtualPetShelter shelter, Scanner input) {
		System.out.println("Name your new pet");
		String name = input.nextLine();
		shelter.takeIn(name);
	}

}
