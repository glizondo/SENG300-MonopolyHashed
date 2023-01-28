import java.util.HashMap;

public class Board {

	static HashMap <Integer, Cell> boardCells = new HashMap<>();

	public Board() {
		boardCells.put(0, new Cell("Start", "None", 0, 0, "start", "", 0));
		boardCells.put(1, new Cell("Vine Street", "Brown", 1500, 150, "brown cell", "", 0));
		boardCells.put(2, new Cell("Community Chest", "None", 0, 0, "community chest", "", 0));
		boardCells.put(3, new Cell("Coventry Street", "Brown", 2000, 200, "brown cell", "", 0));
		boardCells.put(4, new Cell("Tax Income", "None", 200, 0, "tax income", "", 0));
		boardCells.put(5, new Cell("Train Station", "White", 6000, 600, "white cell", "", 0));
		boardCells.put(6, new Cell("Leicester Square", "Light Blue", 3000, 300, "light blue cell", "", 0));
		boardCells.put(7, new Cell("Chance One", "None", 0, 0, "chance one", "", 0));
		boardCells.put(8, new Cell("Brow Street", "Light Blue", 3500, 350, "light blue cell", "", 0));
		boardCells.put(9, new Cell("White Chapel Road", "Light Blue", 4000, 400, "light blue cell", "", 0));
		boardCells.put(10, new Cell("Jail", "None", 0, 0, "jail", "", 0));
		boardCells.put(11, new Cell("The Angel Islington", "Pink", 4000, 400, "pink", "", 0));
		boardCells.put(12, new Cell("Electric Company", "Black", 6000, 600, "black", "", 0));
		boardCells.put(13, new Cell("Trafalgar Square", "Pink", 4500, 450, "pink", "", 0));
		boardCells.put(14, new Cell("Northumrld Avenue", "Pink", 5000, 500, "pink", "", 0));
		boardCells.put(15, new Cell("Fenchurch Station", "White", 6000, 600, "white", "", 0));
		boardCells.put(16, new Cell("Mborough Street", "Gold", 5500, 550, "gold", "", 0));
		boardCells.put(17, new Cell("Community Chest", "None", 0, 0, "community chest", "", 0));
		boardCells.put(18, new Cell("Fleet Street", "Gold", 6000, 600, "gold", "", 0));
		boardCells.put(19, new Cell("Old Kent Road", "Gold", 6500, 650, "gold", "", 0));
		boardCells.put(20, new Cell("Free Parking", "None", 0, 0, "free parking", "", 0));
		boardCells.put(21, new Cell("Whitehall", "Red", 7000, 700, "red", "", 0));
		boardCells.put(22, new Cell("Chance Two", "None", 0, 0, "chance two", "", 0));
		boardCells.put(23, new Cell("Pentonville Road", "Red", 7500, 750, "red", "", 0));
		boardCells.put(24, new Cell("Pall Mall", "Red", 8000, 800, "red", "", 0));
		boardCells.put(25, new Cell("Kings Cross Station", "White", 6000, 600, "white", "", 0));
		boardCells.put(26, new Cell("Bond Street", "Yellow", 8500, 850, "yellow", "", 0));
		boardCells.put(27, new Cell("Strand", "Yellow", 9000, 900, "yellow", "", 0));
		boardCells.put(28, new Cell("Water Works", "Black", 6000, 600, "black", "", 0));
		boardCells.put(29, new Cell("Regent Street", "Yellow", 9500, 950, "yellow", "", 0));
		boardCells.put(30, new Cell("Jail", "None", 0, 0, "jail", "", 0));
		boardCells.put(31, new Cell("Euston Road", "Green", 10000, 1000, "green", "", 0));
		boardCells.put(32, new Cell("Piccadilly", "Green", 10500, 1050, "green", "", 0));
		boardCells.put(33, new Cell("Community Chest", "None", 0, 0, "community chest", "", 0));
		boardCells.put(34, new Cell("Oxford Street", "Green", 11000, 1100, "green", "", 0));
		boardCells.put(35, new Cell("Liverpool St. Station", "White", 6000, 600, "white", "", 0));
		boardCells.put(36, new Cell("Chance One", "None", 0, 0, "chance one", "", 0));
		boardCells.put(37, new Cell("Park Lane", "Blue", 11500, 1150, "blue", "", 0));
		boardCells.put(38, new Cell("Tax Income", "None", 0, 0, "tax income", "", 0));
		boardCells.put(39, new Cell("Mayfair", "Blue", 12000, 1200, "blue", "", 0));

	}

}
