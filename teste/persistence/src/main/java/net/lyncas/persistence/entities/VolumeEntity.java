package net.lyncas.persistence.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import net.lyncas.domain.entity.Volume;

@Entity(name = "volume")
public class VolumeEntity {

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;

	private String volumeId;
	private String thumbnail;
	private String description;
	private String title;
	
	public VolumeEntity() {
	}

	public VolumeEntity(UUID id, String volumeId, String thumbnail, String description, String title) {
		this.id = id;
		this.volumeId = volumeId;
		this.thumbnail = thumbnail;
		this.description = description;
		this.title = title;
	}

	public static VolumeEntity fromDomain(Volume volume) {
		return new VolumeEntity(volume.getId(), volume.getVolumeId(), volume.getThumbnail(), volume.getDescription(), volume.getTitle());
	}

	public Volume toDomain() {
		return new Volume(this.getId(), this.getVolumeId(), this.getThumbnail(), this.getDescription(), this.getTitle());
	}

	public void changeState(Volume volume) {
		this.setVolumeId(volume.getVolumeId());
		this.setThumbnail(volume.getThumbnail());
		this.setDescription(volume.getDescription());
		this.setTitle(volume.getTitle());
	}

	public UUID getId() {
		return id;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
