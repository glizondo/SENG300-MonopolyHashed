import java.util.Scanner;

public class Monopoly {

	public static void main(String[] args) throws InterruptedException {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Monopoly");

		System.out.println("What is the name of Player 1?");
		String answerName1 = keyboard.nextLine();
		Player player1 = new Player(answerName1);

		System.out.println("What is the name of Player 2?");
		String answerName2 = keyboard.nextLine();
		Player player2 = new Player(answerName2);

		Board monopolyBoard = new Board();

		player1.printStats();
		player2.printStats();

		System.out.println("Do you want to play? If you want to quit just type <Quit>");
		String answer = keyboard.nextLine();

		while (!answer.equalsIgnoreCase("Quit") && answer.equalsIgnoreCase("Yes") && player1.getMoney() > 0
				&& player2.getMoney() > 0) {

			trackingForJailAndDecideTurnPlay(player1, player2);

			player1.printStats();
			player2.printStats();

			System.out.println("Keep playing?");
			answer = keyboard.nextLine();

		}
		System.out.println("GAME OVER");
	}

	private static void trackingForJailAndDecideTurnPlay(Player player1, Player player2) throws InterruptedException {
		if (player1.getRemainInJail() == 0) {
			player1.moveActionAndConsequenceForCell();
		} else {
			player1.decreaseJail();
		}
		if (player2.getRemainInJail() == 0) {
			player2.moveActionAndConsequenceForCell();
		} else {
			player2.decreaseJail();
		}
	}

}
