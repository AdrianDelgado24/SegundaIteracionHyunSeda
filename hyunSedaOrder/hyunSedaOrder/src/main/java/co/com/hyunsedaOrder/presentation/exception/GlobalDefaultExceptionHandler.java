package co.com.hyunsedaOrder.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Para capturar errores o excepciones de manera global, se crear esta clase
 * anotada con @ControllerAdvic. Aquí define cada tipo de error que se desea
 * manejar con @ExceptionHandler. Este método recibe la excepción en particular.
 * Se puede manejar todas las excepciones que se desee.
 * @author Laura Sofia Botina Montero, Esteban Caicedo Muñoz Gomez, Adrian Fernando Delgado Serna, Felipe Armand Pino Sierra 
 */
 @ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @RequestMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>("{\"errors\":[{\"code\":\"NOT_FOUND\"}]}", HttpStatus.NOT_FOUND);
    }

    /**
     * Método para manejar la excepcion OrderDomainException
	 *
     * @param e OrderDomainException
	 * @return la excepción en formato Json
	 */
    @ExceptionHandler(OrderDomainException.class)
    @RequestMapping(produces = "application/json")
    @ResponseBody
    public ResponseEntity<ErrorPayload> handleTodoDomainException(OrderDomainException e) {
        return new ResponseEntity<>(new ErrorPayload(e.errors), HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
