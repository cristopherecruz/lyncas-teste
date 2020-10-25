package net.lyncas.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.lyncas.persistence.entities.VolumeEntity;

@Repository
public interface VolumeRepository extends JpaRepository<VolumeEntity, UUID> {

}
