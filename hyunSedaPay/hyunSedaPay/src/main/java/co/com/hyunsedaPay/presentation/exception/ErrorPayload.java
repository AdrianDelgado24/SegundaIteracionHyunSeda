package co.com.hyunsedaPay.presentation.exception;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
/**
 * Clase utilizada por la clase GlobalDefaultExceptionHandler para manejar los errores.
 */

import java.util.ArrayList;
import java.util.List;

public class ErrorPayload {

    public final List<ErrorJSON> errors;

    public ErrorPayload(List<PayError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }

    private ErrorJSON fromApplicationError(PayError error) {
        return new ErrorJSON(error.code, error.field, error.description);
    }
}
