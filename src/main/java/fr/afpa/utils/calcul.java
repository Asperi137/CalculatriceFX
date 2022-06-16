package fr.afpa.utils;

import java.math.BigDecimal;

public class calcul {
    /**
     * Calcule et retourne la factorielle de <em>valeur</em>
     * Pour rappel : n! = n * (n-1)!
     *
     * @param nombre : L'entier pour lequel on souhaite calculer la factorielle
     * @return : Le résultat
     * @throws calculException levée si <em>valeur</em> est négatif ou > 20
     */
    public static BigDecimal factorielle(final BigDecimal nombre) throws calculException {
        BigDecimal résultat = nombre;
        BigDecimal nombreIntern = nombre;

        if (nombreIntern.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new calculException("factorielle d'une valeur négative!");
        } else if (nombreIntern.intValue() == 1 || nombreIntern.intValue() == 0) {
            return BigDecimal.valueOf(1);
        } else {
            while (nombreIntern.compareTo(BigDecimal.valueOf(1)) > 0) {
                nombreIntern = nombreIntern.add(BigDecimal.valueOf(-1));
                résultat = résultat.multiply(nombreIntern);
            }
        }
        return résultat;
    }

    /**
     * Calcule et retourne la somme des N premier entiers
     * Pour rappel : n = n + (n-1)
     *
     * @param nombre : L'entier pour lequel on souhaite calculer la factorielle
     * @return : Le résultat
     * @throws calculException levée si <em>valeur</em> est négatif ou > 20
     */
    public static BigDecimal NEntier(final BigDecimal nombre) throws calculException {
        BigDecimal résultat = nombre;
        BigDecimal nombreIntern = nombre;

        if (nombre.compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new calculException("somme des n premier nombre !");
        }
        if (nombre.equals(1) || nombre.equals(0)) {
            return nombre;
        } else {
            while (nombreIntern.compareTo(BigDecimal.valueOf(1)) > 0) {
                nombreIntern = nombreIntern.add(BigDecimal.valueOf(-1));
                résultat = résultat.add(nombreIntern);
            }
        }
        return résultat;
    }

}
