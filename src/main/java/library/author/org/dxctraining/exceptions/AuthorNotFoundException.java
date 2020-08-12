package library.author.org.dxctraining.exceptions;

public class AuthorNotFoundException extends RuntimeException{
	public AuthorNotFoundException(String msg) {
		super(msg);
	}
}
