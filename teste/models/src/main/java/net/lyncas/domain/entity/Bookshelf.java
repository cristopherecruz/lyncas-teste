package net.lyncas.domain.entity;

import java.util.List;
import java.util.UUID;

public class Bookshelf {

	private UUID id;
	private String nome;
	private List<Volume> volumes;

	public Bookshelf(UUID id, String nome, List<Volume> volumes) {
		this.id = id;
		this.nome = nome;
		this.volumes = volumes;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<Volume> volumes) {
		this.volumes = volumes;
	}

}
