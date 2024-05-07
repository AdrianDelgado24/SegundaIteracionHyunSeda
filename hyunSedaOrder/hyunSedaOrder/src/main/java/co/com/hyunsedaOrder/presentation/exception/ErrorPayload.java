package co.com.hyunsedaOrder.presentation.exception;

/**
 * Clase utilizada por la clase GlobalDefaultExceptionHandler para manejar los errores.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
public class ErrorPayload {

    public final List<ErrorJSON> errors;

    public ErrorPayload(List<OrderError> applicationErrors) {
        this.errors = new ArrayList<>();
        applicationErrors.forEach(applicationError -> errors.add(fromApplicationError(applicationError)));
    }

    private ErrorJSON fromApplicationError(OrderError error) {
        return new ErrorJSON(error.code, error.field, error.description);
    }
}
