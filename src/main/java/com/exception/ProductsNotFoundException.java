package com.exception;

public class ProductsNotFoundException extends Exception {
    public ProductsNotFoundException(String s) {
        super(s);
    }
    public ProductsNotFoundException(){
        super();
    }
    public ProductsNotFoundException(String message , Throwable cause){
        super(message,cause);
    }
    public ProductsNotFoundException(Throwable cause){
        super(cause);
    }
    protected ProductsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
