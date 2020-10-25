package net.lyncas.usecase.adapters;

import net.lyncas.domain.entity.Volume;

public interface VolumePersistenceAdapter {

	Volume save(Volume volume);

}
