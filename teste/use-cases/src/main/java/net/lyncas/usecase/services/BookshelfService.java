package net.lyncas.usecase.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;
import net.lyncas.usecase.usecases.bookshelf.FindBookshelfUseCase;
import net.lyncas.usecase.usecases.bookshelf.UpdateBookshelfUseCase;

@Service
public class BookshelfService {

	private UpdateBookshelfUseCase updateBookshelfUseCase;
	private FindBookshelfUseCase findBookshelfUseCase;

	public BookshelfService(BookshelfPersistenceAdapter bookshelfPersistenceAdapter, VolumePersistenceAdapter volumePersistenceAdapter) {
		this.updateBookshelfUseCase = new UpdateBookshelfUseCase(bookshelfPersistenceAdapter, volumePersistenceAdapter);
		this.findBookshelfUseCase = new FindBookshelfUseCase(bookshelfPersistenceAdapter);
	}

	public Optional<Bookshelf> findById(UUID id) {
		return findBookshelfUseCase.findById(id);
	}

	public Bookshelf update(UUID id, BookshelfService bookshelfService, Bookshelf bookshelf) {
		return updateBookshelfUseCase.update(id, bookshelfService, bookshelf);
	}

}
