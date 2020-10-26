package net.lyncas.usecase.usecases.bookshelf;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;

public class CreateBookshelfUseCase {

	private BookshelfPersistenceAdapter bookshelfPersistenceAdapter;
	
	public Bookshelf save(Bookshelf bookshelf) {
		return bookshelfPersistenceAdapter.save(bookshelf);
	}

}
