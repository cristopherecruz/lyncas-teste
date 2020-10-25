package net.lyncas.api.controllers.dto;

import net.lyncas.domain.entity.Volume;

public class VolumeDto {

	private String volumeId;
	private String thumbnail;
	private String description;
	private String title;

	public VolumeDto(Volume volume) {
		this.volumeId = volume.getVolumeId();
		this.thumbnail = volume.getThumbnail();
		this.description = volume.getDescription();
		this.title = volume.getTitle();
	}

	public String getVolumeId() {
		return volumeId;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

}
