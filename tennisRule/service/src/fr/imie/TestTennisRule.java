package fr.imie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTennisRule {

	private Game game;
	
	@Before
	public void init(){
		this.game = new Game();
	}
	
	@Test
	public void testInitSuccess() {
		//arrange
		//act
		//assert
		assertEquals(game.getScore(), "0-0");
	}

	@Test
	public void test_15_0_Success() {
		//arrange
		//act
		game.scorePlayer1();
		//assert
		assertEquals("15-0",game.getScore());
	}
	
	@Test
	public void test_15_15_Success() {
		//arrange
		game.scorePlayer1();
		//act
		game.scorePlayer2();
		//assert
		assertEquals("15-15",game.getScore());
	}
	
	@Test
	public void test_30_15_Success() {
		//arrange
		game.scorePlayer1();
		game.scorePlayer2();
		//act
		game.scorePlayer1();
		//assert
		assertEquals("30-15",game.getScore());
	}
	
	@Test
	public void test_30_30_Success() {
		//arrange
		game.scorePlayer1();
		game.scorePlayer2();
		game.scorePlayer1();
		//act
		game.scorePlayer2();
		//assert
		assertEquals("30-30",game.getScore());
	}
	
	@Test
	public void test_40_30_Success() {
		//arrange
		arrange_30_30(game);
		//act
		game.scorePlayer1();
		//assert
		assertEquals("40-30",game.getScore());
	}

	private void arrange_30_30(Game game) {
		game.scorePlayer1();
		game.scorePlayer2();
		game.scorePlayer1();
		game.scorePlayer2();
	}
	
	@Test
	public void test_30_40_Success() {
		//arrange
		arrange_30_30(game);
		//act
		game.scorePlayer2();
		//assert
		assertEquals("30-40",game.getScore());
	}
	
	
	

}
