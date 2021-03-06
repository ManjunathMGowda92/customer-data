package org.fourstack.customerdata.exceptionhandling;

import org.fourstack.customerdata.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * ExceptionHandler class which extends the {@link ResponseEntityExceptionHandler} class.
 * Along with the Exceptions handled in the {@link ResponseEntityExceptionHandler}, additional
 * custom Exceptions are handled.
 *
 * @author Manjunath HM
 */
@ControllerAdvice
public class CustomerDataExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Exception Handling method to handle all sub-exception of {@link CustomerDataBaseException}.
     * <p>
     * Whenever any child exceptions of {@link CustomerDataBaseException} occurs, then this method will capture
     * the exception, with the help of @ExceptionHandler annotation and {@link ErrorResponse}
     * will be generated and sent back to the client applications.
     * </p>
     *
     * @param exception  {@link CustomerDataBaseException} object reference used to catch
     *                   Child and Parent exceptions of {@link CustomerDataBaseException}.
     * @param webRequest {@link WebRequest} object
     * @return ErrorResponse Object.
     */
    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleCustomerDataExceptions(
            CustomerDataBaseException exception, WebRequest webRequest) {

        ErrorResponse response = null;
        if (exception instanceof CustomerNotFoundException) {
            response = generateErrorResponse(
                    HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                    HttpStatus.NOT_FOUND, webRequest.getDescription(false)
            );
            return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
        } else {
            throw exception;
        }

    }

    /**
     * Method which creates the {@link ErrorResponse} object.
     *
     * @param errorCode HttpStatus ErrorCode value
     * @param errorMsg  Error Message
     * @param status    {@link HttpStatus} value
     * @param uri       URL for which exception occurred.
     * @return ErrorResponse Object.
     */
    private ErrorResponse generateErrorResponse(int errorCode, String errorMsg,
                                                HttpStatus status, String uri) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMsg);
        response.setStatus(status);
        response.setTimeStamp(LocalDateTime.now());
        response.setUrlDetails(uri);

        return response;
    }
}
