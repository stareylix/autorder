package cn.star.autorder.Exceptions;

public class TokenIllegalException extends Exception {

	private static final long serialVersionUID = -8406417978506735018L;
	
	public TokenIllegalException() {
        super();
    }
	
	public TokenIllegalException(String msg) {
		super(msg);
	}
	
	public TokenIllegalException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public TokenIllegalException(Throwable cause) {
        super(cause);
    }
	
	protected TokenIllegalException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
}	
	
}
