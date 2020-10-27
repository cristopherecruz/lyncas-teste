package net.lyncas.usecase.usecases.bookshelf;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.domain.entity.Volume;
import net.lyncas.usecase.adapters.BookshelfPersistenceAdapter;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;
import net.lyncas.usecase.services.BookshelfService;
import net.lyncas.usecase.usecases.bookshelf.exception.BookshelfNotFoundException;

@Service
public class UpdateBookshelfUseCase {

	private BookshelfPersistenceAdapter bookshelfPersistenceAdapter;
	private VolumePersistenceAdapter volumePersistenceAdapter;

	public UpdateBookshelfUseCase(BookshelfPersistenceAdapter bookshelfPersistenceAdapter, VolumePersistenceAdapter volumePersistenceAdapter) {
		this.bookshelfPersistenceAdapter = bookshelfPersistenceAdapter;
		this.volumePersistenceAdapter = volumePersistenceAdapter;
	}

	public Bookshelf update(UUID id, BookshelfService bookshelfService, Bookshelf bookshelf) {

		Bookshelf bookshelfFiltrada = bookshelfService.findById(id)
				.orElseThrow(() -> new BookshelfNotFoundException("Estante nao encontrada!"));

		bookshelf.getVolumes().forEach(v -> {
			
			Optional<Volume> findByVolumeId = volumePersistenceAdapter.findByVolumeId(v.getVolumeId());
			
			if (findByVolumeId.isPresent()) {
				
				if (!bookshelfFiltrada.getVolumes().contains(findByVolumeId.get())) {					
					bookshelfFiltrada.getVolumes().add(findByVolumeId.get());
				} else {					
					bookshelfFiltrada.getVolumes().remove(findByVolumeId.get());
				}
				
			} else {
				bookshelfFiltrada.getVolumes().add(v);
			}
			
		});

		return bookshelfPersistenceAdapter.update(bookshelfFiltrada);
	}

}
