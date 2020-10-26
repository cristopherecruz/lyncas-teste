package net.lyncas.usecase.usecases.bookshelf;

import java.util.UUID;

import org.springframework.stereotype.Service;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;
import net.lyncas.usecase.services.BookshelfService;
import net.lyncas.usecase.usecases.bookshelf.exception.BookshelfNotFoundException;

@Service
public class UpdateBookshelfUseCase {

	private BookshelfPersistenceAdapter bookshelfPersistenceAdapter;

	public UpdateBookshelfUseCase(BookshelfPersistenceAdapter bookshelfPersistenceAdapter) {
		this.bookshelfPersistenceAdapter = bookshelfPersistenceAdapter;
	}

	public Bookshelf update(UUID id, BookshelfService bookshelfService, Bookshelf bookshelf) {

		Bookshelf bookshelfFiltrada = bookshelfService.findById(id)
				.orElseThrow(() -> new BookshelfNotFoundException("Estante não encontrada!"));

		bookshelf.getVolumes().forEach(v -> {
			bookshelfFiltrada.getVolumes().add(v);
		});

		return bookshelfPersistenceAdapter.update(bookshelfFiltrada);
	}

}
