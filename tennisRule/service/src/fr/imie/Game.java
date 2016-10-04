package fr.imie;

/**
 * Jeux de Tennis
 * @author imiedev
 *
 */
public class Game {

	Integer player1Score=0;
	Integer player2Score=0;
	
	
	public String getScore() {
		return player1Score.toString().concat("-").concat(player2Score.toString());
	}

	public void scorePlayer1() {
		this.player1Score=incrementScore(this.player1Score);
	}

	public void scorePlayer2() {
		this.player2Score=incrementScore(this.player2Score);
	}
	
	private Integer incrementScore(Integer playerScore) {
		Integer out=null;
		switch (playerScore) {
		case 0:
			out=15;
			break;
		case 15:
			out=30;
			break;
		case 30:
			out=40;
			break;
		default:
			break;
		}
		return out;
	}



}
