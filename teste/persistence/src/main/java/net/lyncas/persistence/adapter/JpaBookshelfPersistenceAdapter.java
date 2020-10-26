package net.lyncas.persistence.adapter;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.persistence.entities.BookshelfEntity;
import net.lyncas.persistence.repositories.BookshelfRepository;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;

@Component
public class JpaBookshelfPersistenceAdapter implements BookshelfPersistenceAdapter {

	private BookshelfRepository bookshelfRepository;

	@Override
	public Optional<Bookshelf> findById(UUID id) {
		return bookshelfRepository.findById(id).map(BookshelfEntity::toDomain);
	}

	@Override
	public Bookshelf update(Bookshelf bookshelfFiltrada) {
		return bookshelfRepository.save(BookshelfEntity.fromDomain(bookshelfFiltrada)).toDomain();
	}

}
