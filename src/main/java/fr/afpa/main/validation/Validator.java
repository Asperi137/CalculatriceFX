package fr.afpa.main.validation;

import java.util.List;

public interface Validator<T> {

	boolean validate(final T object);

	List<String> getErreurs();

}
