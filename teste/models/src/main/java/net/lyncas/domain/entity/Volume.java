package net.lyncas.domain.entity;

import java.util.UUID;

public class Volume {

	private UUID id;
	private String volumeId;
	private String thumbnail;
	private String description;
	private String title;

	public Volume(UUID id, String volumeId, String thumbnail, String description, String title) {
		this.id = id;
		this.volumeId = volumeId;
		this.thumbnail = thumbnail;
		this.description = description;
		this.title = title;
	}

	public Volume(String volumeId, String thumbnail, String description, String title) {
		this.volumeId = volumeId;
		this.thumbnail = thumbnail;
		this.description = description;
		this.title = title;
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
