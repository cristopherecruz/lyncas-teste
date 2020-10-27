package net.lyncas.persistence.entities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import net.lyncas.domain.entity.Bookshelf;

@Entity(name = "bookshelf")
public class BookshelfEntity {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL)
	private List<VolumeEntity> volumes;

	public BookshelfEntity() {
	}

	public BookshelfEntity(UUID id, String nome, List<VolumeEntity> volumes) {
		this.id = id;
		this.nome = nome;
		this.volumes = volumes;
	}

	public static BookshelfEntity fromDomain(Bookshelf bookshelf) {

		var volumes = bookshelf.getVolumes().stream().map(VolumeEntity::fromDomain).collect(Collectors.toList());

		return new BookshelfEntity(bookshelf.getId(), bookshelf.getNome(), volumes);
	}

	public Bookshelf toDomain() {

		var volumes = this.getVolumes().stream().map(VolumeEntity::toDomain).collect(Collectors.toList());

		return new Bookshelf(this.getId(), this.getNome(), volumes);
	}

	public void changeState(Bookshelf bookshelf) {
		this.setNome(bookshelf.getNome());
		this.setVolumes(bookshelf.getVolumes().stream().map(VolumeEntity::fromDomain).collect(Collectors.toList()));
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

	public List<VolumeEntity> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeEntity> volumes) {
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
		BookshelfEntity other = (BookshelfEntity) obj;
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
