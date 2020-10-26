package net.lyncas.usecase.usecases.bookshelf.exception;

@SuppressWarnings("serial")
public class BookshelfNotFoundException extends RuntimeException {

	public BookshelfNotFoundException(String message) {
		super(message);
	}

}
