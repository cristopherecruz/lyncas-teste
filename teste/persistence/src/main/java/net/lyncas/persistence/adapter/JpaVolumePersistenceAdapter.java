package net.lyncas.persistence.adapter;

import org.springframework.stereotype.Component;

import net.lyncas.domain.entity.Volume;
import net.lyncas.persistence.entities.VolumeEntity;
import net.lyncas.persistence.repositories.VolumeRepository;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;

@Component
public class JpaVolumePersistenceAdapter implements VolumePersistenceAdapter {

	private VolumeRepository volumeRepository;

	@Override
	public Volume save(Volume volume) {
		return volumeRepository.save(VolumeEntity.fromDomain(volume)).toDomain();
	}

}
