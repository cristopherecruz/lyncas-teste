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

	public Bookshelf(List<Volume> volumes) {
		this.volumes = volumes;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID uuid) {
		this.id = uuid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((volumes == null) ? 0 : volumes.hashCode());
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
		Bookshelf other = (Bookshelf) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (volumes == null) {
			if (other.volumes != null)
				return false;
		} else if (!volumes.equals(other.volumes))
			return false;
		return true;
	}

}
