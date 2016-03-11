package br.pucrs.fds.dgt.hangman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HangmanTest {

	private Hangman game;
	
	@Before
	public void setUp() {
		game = new Hangman("hangman");

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecretIsNull() {
		Hangman game = new Hangman(null);
	}

	
	@Test
	public void testSecretIsHangman() {
		assertEquals("hangman", game.getSecret());
	}

	@Test
	public void testSecretIsMalandro() {
		Hangman game = new Hangman("malandro");
		assertEquals("malandro", game.getSecret());
	}
	
	@Test
	public void testGuessE() {
		game.setGuess('E');
		assertEquals("e", game.getMisses());
	}

	@Test
	public void testGuessEAndThenGuessT() {
		game.setGuess('E');
		game.setGuess('T');
		assertEquals("e,t", game.getMisses());
	}
	
	@Test
	public void testGuessEAndThenGuessTAndThenGuessA() {
		game.setGuess('E');
		game.setGuess('T');
		game.setGuess('A');
		assertEquals("e,t", game.getMisses());
	}
	
	@Test
	public void testGetWord() {
		assertEquals("-------", game.getWord());
	}	              

	@Test
	public void testGuessAAndThenGetWord() {
		game.setGuess('A');
		assertEquals("-A---A-", game.getWord());
	}                  	

	@Test
	public void testGuessAAndThenGuessHAndThenGetWord() {
		game.setGuess('A');
		game.setGuess('H');
		assertEquals("HA---A-", game.getWord());
	} 	
	
}



