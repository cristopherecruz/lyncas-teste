package net.lyncas.usecase.usecases.bookshelf;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;

@Service
public class FindBookshelfUseCase {

	private BookshelfPersistenceAdapter bookshelfPersistenceAdapter;

	public FindBookshelfUseCase(BookshelfPersistenceAdapter bookshelfPersistenceAdapter) {
		this.bookshelfPersistenceAdapter = bookshelfPersistenceAdapter;
	}

	public Optional<Bookshelf> findById(UUID id) {
		return bookshelfPersistenceAdapter.findById(id);
	}

}
