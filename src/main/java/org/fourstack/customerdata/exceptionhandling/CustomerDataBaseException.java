package org.fourstack.customerdata.exceptionhandling;

/**
 * Class {@link CustomerDataBaseException} is a child class of {@link RuntimeException},
 * which is used to handle all the sub-exceptions of customer-data application.
 *
 * @author Manjunath HM
 */
public class CustomerDataBaseException extends RuntimeException {
    private static final long serialVersionUID = -8955547033401871653L;

    public CustomerDataBaseException() {
        super();
    }

    public CustomerDataBaseException(String message) {
        super(message);
    }

    public CustomerDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerDataBaseException(Throwable cause) {
        super(cause);
    }

    protected CustomerDataBaseException(String message,
                                        Throwable cause,
                                        boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
