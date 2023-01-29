
public class Player {

	private int number;
	private String name;
	private int dice;
	private Integer money;
	private int currentCell;
	private int roundBoard;
	private int remainInJail;
	static Integer taxesCollected;

	public Player(String name) {

		number = 0;
		this.name = name;
		dice = randomRoll();
		money = 50000;
		currentCell = 0;
		roundBoard = 0;
		remainInJail = 0;
		taxesCollected = 0;

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
			this.money = money;
	}

	public int getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(int currentCell) {
		this.currentCell = currentCell;
	}

	public int getRoundBoard() {
		return roundBoard;
	}

	public void setRoundBoard(int roundBoard) {
		this.roundBoard = roundBoard;
	}

	public int getRemainInJail() {
		return remainInJail;
	}

	public void setRemainInJail(int remainInJail) {
		this.remainInJail = remainInJail;
	}

	public void decreaseJail() {
		remainInJail--;
	}

	public void printStats() {

		System.out.println("----------" + name + "-----------");
		System.out.println("rounds: " + getRoundBoard());
		System.out.println("money: " + getMoney());
		System.out.println("position: " + getCurrentCell());

	}

	public int randomRoll() {
		int max = 12;
		int min = 2;
		int range = max - min + 1;
		int random = (int) (Math.random() * range) + min;
		return random;
	}

	public void updateMoney(int money) {
		int currentMoney = getMoney();
		int updateMoney = currentMoney + money;
		setMoney(updateMoney);

	}

	public void chargeTaxesToPlayer(int amount) {
		money -= amount;
	}

	public void collectedTaxes(int amount) {
		taxesCollected += amount;
	}

	public void moveActionAndConsequenceForCell() throws InterruptedException {
		System.out.println("----------" + name + "----------");
		int randomRoll = randomRoll();
		System.out.println("Rolls the dice and gets a " + randomRoll);

		currentCell = currentCell + randomRoll;
		if (currentCell >= 0 && currentCell <= 39) {
			setCurrentCell(currentCell);

		} else {
			int updatedCell = currentCell - 40;
			setCurrentCell(updatedCell);
			System.out.println("Collect $1000");
			++roundBoard;
			updateMoney(1000);
		}
		System.out.println("You are on cell number: " + currentCell);

		switch (Board.boardCells.get(currentCell).getCellType()) {
		case "community chest":
			updateMoney(Cell.communityChestCell());
			break;
		case "tax income":
			int moneyFromTaxes = Cell.taxPay();
			chargeTaxesToPlayer(moneyFromTaxes);
			collectedTaxes(moneyFromTaxes);
			break;
		case "chance one":
			setCurrentCell(Cell.chanceCellOne());
			break;
		case "chance two":
			updateMoney(Cell.chanceCellTwo());
			break;
		case "jail":
			System.out.println("Say goodbye to your wife and kids, you are going to jail for a round");
			remainInJail = 1;
			break;
		}

		switch (Board.boardCells.get(currentCell).getCellType()) {
		case "free parking":
			Cell.freeParking();
			updateMoney(taxesCollected);
			taxesCollected = 0;
			break;
		}
		switch (Board.boardCells.get(currentCell).getPropertyColor()) {
		case "Brown":
			int amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "White":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Light Blue":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Pink":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Black":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Gold":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Red":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Yellow":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Green":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		case "Blue":
			amount = Cell.propertyCell(currentCell, name);
			updateMoney(amount);
			break;
		}

	}

}
