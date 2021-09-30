package org.fourstack.customerdata.exceptionhandling;

/**
 * Class {@link CustomerNotFoundException} is a child class of {@link CustomerDataBaseException},
 * which is used throw the exception when the requested customer not found in Database.
 *
 * @author Manjunath HM
 */
public class CustomerNotFoundException extends CustomerDataBaseException {
    private static final long serialVersionUID = -2294258439085812493L;

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    public CustomerNotFoundException(String message,
                                     Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
