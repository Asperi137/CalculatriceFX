package fr.afpa.utils;

import java.math.BigDecimal;

public class Calcul {
	/**
	 * Calcule et retourne la factorielle de <em>valeur</em> Pour rappel : n! = n *
	 * (n-1)!
	 *
	 * @param nombre : L'entier pour lequel on souhaite calculer la factorielle
	 * @return : Le résultat
	 * @throws calculException levée si <em>valeur</em> est négatif ou > 20
	 */
	public static BigDecimal factorielle(final BigDecimal nombre) throws CalculException {
		BigDecimal resultat = nombre;
		BigDecimal nombreIntern = nombre;

		if (nombreIntern.compareTo(BigDecimal.valueOf(0)) < 0) {
			throw new CalculException("factorielle d'une valeur négative!");
		} else if (nombreIntern.intValue() == 1 || nombreIntern.intValue() == 0) {
			return BigDecimal.valueOf(1);
		} else {
			while (nombreIntern.compareTo(BigDecimal.valueOf(1)) > 0) {
				nombreIntern = nombreIntern.add(BigDecimal.valueOf(-1));
				resultat = resultat.multiply(nombreIntern);
			}
		}
		return resultat;
	}

	/**
	 * Calcule et retourne la somme des N premier entiers Pour rappel : n = n +
	 * (n-1)
	 *
	 * @param nombre : L'entier pour lequel on souhaite calculer la factorielle
	 * @return : Le résultat
	 * @throws calculException levée si <em>valeur</em> est négatif ou > 20
	 */
	public static BigDecimal nEntier(final BigDecimal nombre) throws CalculException {
		BigDecimal resultat = nombre;
		BigDecimal nombreIntern = nombre;
		final BigDecimal one = BigDecimal.valueOf(1);
		final BigDecimal zero = BigDecimal.valueOf(0);

		if (nombre.compareTo(BigDecimal.valueOf(0)) < 0) {
			throw new CalculException("somme des n premier nombre !");
		}
		if (nombre.equals(one) || nombre.equals(zero)) {
			return nombre;
		} else {
			while (nombreIntern.compareTo(one) > 0) {
				nombreIntern = nombreIntern.subtract(one);
				resultat = resultat.add(nombreIntern);
			}
		}
		return resultat;
	}

	public static BigDecimal nEntierOptimise(final BigDecimal nombre) {

		final BigDecimal one = BigDecimal.valueOf(1);
		final BigDecimal two = BigDecimal.valueOf(2);

		return nombre.multiply(nombre.add(one)).divide(two);
	}

// Les int n'ont pas de problème de précision, si tu veux supporter des valeurs plus grandes tu peut utiliser long
//par contre si long ne suffit pas....
	public static int nEntierInt(final int nombre) {

		int resultat = 0;

		for (int i = 0; i <= nombre; i++) {

			resultat += i;

		}

		return resultat;
	}

}
