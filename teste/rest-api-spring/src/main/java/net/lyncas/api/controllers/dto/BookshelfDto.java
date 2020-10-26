package net.lyncas.api.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import net.lyncas.domain.entity.Bookshelf;

public class BookshelfDto {

	private String nome;
	private List<VolumeDto> volumes;

	public BookshelfDto(Bookshelf bookshelf) {
		this.nome = bookshelf.getNome();
		this.volumes = bookshelf.getVolumes().stream().map(VolumeDto::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VolumeDto> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeDto> volumes) {
		this.volumes = volumes;
	}

}
