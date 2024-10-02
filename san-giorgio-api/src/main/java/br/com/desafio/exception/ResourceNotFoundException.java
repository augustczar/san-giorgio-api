package br.com.desafio.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5795595129335371735L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}