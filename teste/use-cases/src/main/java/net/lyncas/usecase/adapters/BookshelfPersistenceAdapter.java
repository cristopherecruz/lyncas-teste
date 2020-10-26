package net.lyncas.usecase.adapters;

import java.util.Optional;
import java.util.UUID;

import net.lyncas.domain.entity.Bookshelf;

public interface BookshelfPersistenceAdapter {

	Optional<Bookshelf> findById(UUID id);

	Bookshelf update(Bookshelf bookshelfFiltrada);

	Bookshelf save(Bookshelf bookshelf);

}
