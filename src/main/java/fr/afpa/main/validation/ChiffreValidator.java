package fr.afpa.main.validation;

import java.util.ArrayList;
import java.util.List;

public class ChiffreValidator implements Validator<String> {

	private List<String> erreurs = new ArrayList<>();

	@Override
	public boolean validate(final String input) {

		final int intATester;

		if (input == null || input.isBlank()) {

			erreurs.add("Veuillez entrer un entier positif");
			return false;
		}

		try {
			intATester = Integer.parseInt(input.trim());

		} catch (NumberFormatException e) {

			erreurs.add("N'est pas un nombre entier");
			return false;
		}

		if (intATester < 0) {

			erreurs.add("Est un entier strictement négatif");
			return false;

		}

		return true;

	}

	@Override
	public List<String> getErreurs() {

		return new ArrayList<>(erreurs); // Renvoi une copie à la place de l'original.
	}

}
