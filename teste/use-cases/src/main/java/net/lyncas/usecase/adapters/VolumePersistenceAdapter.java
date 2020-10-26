package net.lyncas.usecase.adapters;

import java.util.Optional;
import java.util.UUID;

import net.lyncas.domain.entity.Volume;

public interface VolumePersistenceAdapter {

	Volume save(Volume volume);

	Optional<Volume> findById(UUID id);

	Optional<Volume> findByVolumeId(String id);

}
