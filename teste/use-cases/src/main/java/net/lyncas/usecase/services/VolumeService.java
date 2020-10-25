package net.lyncas.usecase.services;

import org.springframework.stereotype.Service;

import net.lyncas.domain.entity.Volume;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;
import net.lyncas.usecase.usecases.CreateVolumeUseCase;

@Service
public class VolumeService {

	private CreateVolumeUseCase createVolumeUseCase;

	public VolumeService(VolumePersistenceAdapter volumePersistenceAdapter) {
		this.createVolumeUseCase = new CreateVolumeUseCase(volumePersistenceAdapter);
	}

	public Volume save(Volume volume) {
		return createVolumeUseCase.save(volume);
	}

}
