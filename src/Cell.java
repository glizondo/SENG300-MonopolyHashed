import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cell {

	private String name;
	private String propertyColor;
	private int price;
	private int rent;
	private String cellType;
	private String ownedCell;
	private int moneyToReceive;
	static Scanner keyboard = new Scanner(System.in);

	public Cell(String name, String propertyColor, int price, int rent, String cellType, String ownedCell,
			int moneyToReceive) {
		super();
		this.name = name;
		this.propertyColor = propertyColor;
		this.price = price;
		this.rent = rent;
		this.cellType = cellType;
		this.ownedCell = ownedCell;
		this.moneyToReceive = moneyToReceive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPropertyColor() {
		return propertyColor;
	}

	public void setPropertyColor(String propertyColor) {
		this.propertyColor = propertyColor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

	public String getOwnedCell() {
		return ownedCell;
	}

	public void setOwnedCell(String ownedCell) {
		this.ownedCell = ownedCell;
	}

	public int getMoneyToReceive() {
		return moneyToReceive;
	}

	public void setMoneyToReceive(int moneyToReceive) {
		this.moneyToReceive = moneyToReceive;
	}

	public void addRentForPlayer(int moneyRent) {
		moneyToReceive = moneyToReceive + moneyRent;

	}

	static void jailCell() {
		System.out.println("It is jail time for you. Next turn you will be skipped");

	}

	static int communityChestCell() throws InterruptedException {
		System.out.println("COMMUNITY CHEST");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("..");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(".");
		int amount = 0;
		int random = generateRandomNumberOneOrTwo();
		if (random == 1) {
			System.out.println("Lucky you... You found $200!");
			return amount = 200;
		}
		if (random == 2) {
			System.out.println("Doctor's fee, pay up $50 bud!");
			return amount = -50;
		}
		if (random == 3) {
			System.out.println("Your grandma just left some money for you to get something for yourself, $2 for you!");
			return amount = 2;
		}
		if (random == 4) {
			System.out.println("The bills have to be paid. And they are $120!");
			return amount = -120;

		}
		return amount;

	}

	static int chanceCellOne() throws InterruptedException {
		System.out.println("CHANCE CELL");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("..");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(".");
		int cell = 0;
		int random = generateRandomNumberOneOrTwo();
		if (random == 1) {
			System.out.println("Go straight to the Free Parking space");
			return cell = 20;

		}
		if (random == 2) {
			System.out.println("Go for a visit to jail without collecting");
			return cell = 10;

		}
		return cell;

	}

	private static int generateRandomNumberOneOrTwo() {
		int max = 2;
		int min = 1;
		int range = max - min + 1;
		int random = (int) (Math.random() * range) + min;
		return random;
	}

	static int chanceCellTwo() throws InterruptedException {
		System.out.println("CHANCE CELL");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("..");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(".");
		int amount = 0;
		int random = generateRandomNumberOneOrTwo();
		if (random == 1) {
			System.out.println("A water pipe broke at one of your places! Pay $120");
			return amount = -120;
		}
		if (random == 2) {
			System.out.println("Your building loan matures, collect $150");
			return amount = 150;
		}
		return amount;
	}

	static int taxPay() {
		int amount = 0;
		int random = generateRandomNumberOneOrTwo();
		if (random == 1) {
			System.out.println("You have to pay $250 in taxes");
			return amount = 250;
		}
		if (random == 2) {
			System.out.println(
					"Do you remember that house at the beach? well, you have to pay the property taxes... $400");
			return amount = 400;
		}
		return amount;
	}

	static void freeParking() {
		System.out.println("Free parking. Take all the money from the taxes (if there is any)");
	}

	static int propertyCell(int currentCell, String namePlayer) {
		return responseAfterMovingToSpecificCell(currentCell, namePlayer);

	}

	private static int responseAfterMovingToSpecificCell(int currentCell, String namePlayer) {
		int amount = 0;
		if (Board.boardCells.get(currentCell).getOwnedCell().equalsIgnoreCase(namePlayer)
				&& Board.boardCells.get(currentCell).getMoneyToReceive() != 0) {
			System.out.println("TIME TO COLLECT THE RENT LEFT!");
			amount = Board.boardCells.get(currentCell).getMoneyToReceive();
			Board.boardCells.get(currentCell).setMoneyToReceive(0);
			return amount;
		}
		if (!Board.boardCells.get(currentCell).getOwnedCell().equalsIgnoreCase(namePlayer)
				&& !Board.boardCells.get(currentCell).getOwnedCell().equalsIgnoreCase("")) {
			amount = Board.boardCells.get(currentCell).getRent();
			System.out.println("You are on the " + Board.boardCells.get(currentCell).getName()
					+ " private property, pay the other player " + amount + " dollars");

			Board.boardCells.get(currentCell).addRentForPlayer(amount);
			System.out.println(
					"The rent was left at the property. The money will be received once the owner passes by the property");
			return (-1 * amount);
		}
		if (Board.boardCells.get(currentCell).getOwnedCell().equalsIgnoreCase("")) {
			System.out.println("Do you want to buy the " + Board.boardCells.get(currentCell).getPropertyColor()
					+ " property " + Board.boardCells.get(currentCell).getName() + " ?");
			System.out.println("It costs " + Board.boardCells.get(currentCell).getPrice() + " dollars");

			String answer = keyboard.nextLine();
			if (answer.equalsIgnoreCase("Yes")) {
				System.out
						.println("You have purchased the " + Board.boardCells.get(currentCell).getName() + " property");
				Board.boardCells.get(currentCell).setOwnedCell(namePlayer);
				amount = Board.boardCells.get(currentCell).getPrice();
				return (-1 * amount);

			}
		}

		return amount;
	}

}
