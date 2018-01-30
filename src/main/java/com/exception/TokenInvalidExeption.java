package com.exception;

public class TokenInvalidExeption extends Exception {
    public TokenInvalidExeption(String s) {
        super(s);
    }
    public TokenInvalidExeption(){
        super();
    }
    public TokenInvalidExeption(String message , Throwable cause){
        super(message,cause);
    }
    public TokenInvalidExeption(Throwable cause){
        super(cause);
    }
    protected TokenInvalidExeption (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
