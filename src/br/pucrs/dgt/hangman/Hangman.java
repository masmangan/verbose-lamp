package br.pucrs.fds.dgt.hangman;

public class Hangman {
	private String secret;
	private String misses;
	private String word;

	public Hangman(String secret) {
		if (secret == null)
			throw new IllegalArgumentException("A palavra não pode ser null.");
		this.secret = secret;
		misses = "";
		word = "";
		for (int i = 0; i < secret.length(); i++) {
			word += "-";
		}
	}

	public String getSecret() {
		return secret;
	}

	public void setGuess(char guess) {
		char lowerCaseGuess = Character.toLowerCase(guess);
		if (!secret.contains(String.valueOf(lowerCaseGuess))) {
			wrongGuess(lowerCaseGuess);
		} else {
			goodGuess(guess, lowerCaseGuess);
		}

	}

	private void goodGuess(char guess, char lowerCaseGuess) {
		String newWord = "";
		for (int i = 0; i < secret.length(); i++) {
			if (lowerCaseGuess == secret.charAt(i))
				newWord += Character.toUpperCase(guess);
			else
				newWord += word.charAt(i);
		}
		word = newWord;
	}

	private void wrongGuess(char lowerCaseGuess) {
		if (!misses.isEmpty())
			misses += ",";
		misses += lowerCaseGuess;
	}

	public String getMisses() {
		return misses;
	}

	public String getWord() {
		return word;
	}

}
