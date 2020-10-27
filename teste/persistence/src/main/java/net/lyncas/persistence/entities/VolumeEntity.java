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
	@Type(type = "uuid-char")
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
		return new VolumeEntity(volume.getId(), volume.getVolumeId(), volume.getThumbnail(), volume.getDescription(),
				volume.getTitle());
	}

	public Volume toDomain() {
		return new Volume(this.getId(), this.getVolumeId(), this.getThumbnail(), this.getDescription(),
				this.getTitle());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((volumeId == null) ? 0 : volumeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VolumeEntity other = (VolumeEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (volumeId == null) {
			if (other.volumeId != null)
				return false;
		} else if (!volumeId.equals(other.volumeId))
			return false;
		return true;
	}

}
