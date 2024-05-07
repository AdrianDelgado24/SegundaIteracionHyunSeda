package co.com.hyunsedaOrder.presentation.exception;


import co.com.hyunsedaOrder.domain.service.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Maneja los errores en formato Json.
 * Esta clase es utilizada por la clase ErrorsPayload
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorJSON {

    public final ErrorCodes code;
    public final String field;
    public final String message;

    public ErrorJSON(ErrorCodes code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }
}
