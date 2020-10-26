package net.lyncas.api.controllers.form;

import net.lyncas.domain.entity.Volume;

public class VolumeForm {

	private String volumeId;
	private String thumbnail;
	private String description;
	private String title;

	public VolumeForm() {
	}

	public VolumeForm(String volumeId, String thumbnail, String description, String title) {
		this.volumeId = volumeId;
		this.thumbnail = thumbnail;
		this.description = description;
		this.title = title;
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

	public Volume toVolume() {
		return new Volume(this.volumeId, this.thumbnail, this.description, this.title);
	}

}
