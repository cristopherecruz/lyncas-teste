package net.lyncas.api.controllers.form;

import java.util.List;
import java.util.stream.Collectors;

import net.lyncas.domain.entity.Bookshelf;

public class BookshelfForm {

	private String nome;
	private List<VolumeForm> volumes;

	public Bookshelf toBookshelf() {

		var volumes = this.volumes.stream().map(VolumeForm::toVolume).collect(Collectors.toList());

		return new Bookshelf(this.nome, volumes);
	}

}
