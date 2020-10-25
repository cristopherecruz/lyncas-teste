package net.lyncas.usecase.usecases;

import net.lyncas.domain.entity.Volume;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;

public class CreateVolumeUseCase {

	private VolumePersistenceAdapter volumePersistenceAdapter;

	public CreateVolumeUseCase(VolumePersistenceAdapter volumePersistenceAdapter) {
		this.volumePersistenceAdapter = volumePersistenceAdapter;
	}

	public Volume save(Volume volume) {
		return volumePersistenceAdapter.save(volume);
	}

}
