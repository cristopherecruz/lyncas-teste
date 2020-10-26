package net.lyncas.api.controllers.form;

import java.util.List;
import java.util.stream.Collectors;

import net.lyncas.domain.entity.Bookshelf;

public class BookshelfForm {

	private List<VolumeForm> volumes;

	public BookshelfForm() {
	}

	public Bookshelf toBookshelf() {

		var volumes = this.volumes.stream().map(VolumeForm::toVolume).collect(Collectors.toList());

		return new Bookshelf(volumes);
	}

	public List<VolumeForm> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeForm> volumes) {
		this.volumes = volumes;
	}

}
