package net.lyncas.persistence.adapter;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import net.lyncas.domain.entity.Volume;
import net.lyncas.persistence.entities.VolumeEntity;
import net.lyncas.persistence.repositories.VolumeRepository;
import net.lyncas.usecase.adapters.VolumePersistenceAdapter;

@Component
public class JpaVolumePersistenceAdapter implements VolumePersistenceAdapter {

	private VolumeRepository volumeRepository;

	public JpaVolumePersistenceAdapter(VolumeRepository volumeRepository) {
		this.volumeRepository = volumeRepository;
	}

	@Override
	public Volume save(Volume volume) {
		return volumeRepository.save(VolumeEntity.fromDomain(volume)).toDomain();
	}

	@Override
	public Optional<Volume> findById(UUID id) {
		return volumeRepository.findById(id).map(VolumeEntity::toDomain);
	}

	@Override
	public Optional<Volume> findByVolumeId(String id) {
		return volumeRepository.findByVolumeId(id).map(VolumeEntity::toDomain);
	}

}
