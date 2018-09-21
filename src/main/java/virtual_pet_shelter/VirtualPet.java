package virtual_pet_shelter;

import java.util.UUID;

public class VirtualPet {
	private String name;
	private String description;
	private int hunger;
	private int restlessness;
	private int thirst;
	private boolean gameOver = false;
	private int happiness;
	private String iD;

	// accessors
	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getRestlessness() {
		return restlessness;
	}

	public int getThirst() {
		return thirst;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean isHappy() {
		if (happiness >= 10) {
			return true;
		} else {
			return false;
		}
	}

	public String getID() {
		return iD;
	}

	// constructors
	public VirtualPet(String newName) {
		iD = UUID.randomUUID().toString();
		name = newName;
		// TODO
		description = "Nice guy";
		hunger = 5;
		restlessness = 5;
		thirst = 5;
		happiness = 0;

	}

	public VirtualPet(String newName, String newDescription) {
		iD = UUID.randomUUID().toString();
		name = newName;
		description = newDescription;
		hunger = 5;
		restlessness = 5;
		thirst = 5;
		happiness = 0;

	}

	public VirtualPet(String newName, String newDescription, int newHunger, int newRest, int newThirst) {
		iD = UUID.randomUUID().toString();
		name = newName;
		description = newDescription;
		hunger = newHunger;
		restlessness = newRest;
		thirst = newThirst;
		happiness = 0;
	}

	// funtimes
	public String displayStats() {

		return name + " " + description + " " + hunger + " " + restlessness + " " + thirst;
	}

	public void tick() {
		hunger++;
		restlessness++;
		thirst++;
		happiness++;
		if (hunger < 1) {
			getsFat();
		}
		if (hunger > 10) {
			starve();
		}
		if (thirst < 1) {
			drown();
		}
		if (thirst > 10) {
			crumbleToDust();
		}
		if (restlessness < 1) {
			overStimulated();
		}
		if (restlessness > 10) {
			runAway();
		}

	}

	private void runAway() {
		gameOver = true;

	}

	private void overStimulated() {
		gameOver = true;
	}

	private void crumbleToDust() {
		gameOver = true;

	}

	public void getsFat() {
		gameOver = true;
	}

	public void starve() {
		gameOver = true;
	}

	public void drown() {
		gameOver = true;
	}

	public void feedPet() {
		hunger -= 3;
	}

	public void playWithPet() {
		restlessness -= 3;
	}

	public void waterPet() {
		thirst -= 3;
	}

}
