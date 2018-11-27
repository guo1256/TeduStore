package cn.tedu.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1565525856671162269L;
	public UsernameAlreadyExistException() {
		
	}
	public UsernameAlreadyExistException(String msg) {
		super(msg);
	}
}
