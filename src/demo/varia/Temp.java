package demo.varia;

public class Temp {

	private int playerTurn;
	private String[][] spielfeld = new String[3][3];
	
	public Temp() {
		this.initializeSpielfeld();
	}

	private double switchPlayerTurn() {

		final int NUMBER_OF_FIELDS = 9;
		final int NUMBER_OF_PLAYERS = 2;
		int numberOfEmptyFields = 0;

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j].equals("")) {
					numberOfEmptyFields++;
				}
			}
		}
		
		System.out.println("Aktuell gibt es " + numberOfEmptyFields + " leere Felder auf dem Spielfeld.");
		playerTurn = (NUMBER_OF_FIELDS - numberOfEmptyFields) % NUMBER_OF_PLAYERS;
		return playerTurn;
	}
	
	private void initializeSpielfeld() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				spielfeld[x][y] = new String();
			}
		}
	}

	private void setSpielfeld(int x, int y, String spielerName) {
		System.out.println("Spieler " + spielerName + " wurde auf spielfeld[" + x + "][" + y + "] gesetzt");
		this.spielfeld[x][y] = spielerName;
	}

	public static void main(String arags[]) {
		Temp temp = new Temp();
		int counter = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(counter++ % 2 == 0) {
					temp.setSpielfeld(x, y, "Spieler");
				} else {
					temp.setSpielfeld(x, y, "Computer");
				}
				System.out.println("Playerturn is: " + temp.switchPlayerTurn());
			}
		}
		
	}

}
