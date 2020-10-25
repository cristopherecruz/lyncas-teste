package net.lyncas.persistence.entities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.lyncas.domain.entity.Bookshelf;

@Entity(name = "bookshelf")
public class BookshelfEntity {

	@Id
	@GeneratedValue
	private UUID id;

	private String nome;

	@OneToMany
	private List<VolumeEntity> volumes;

	public BookshelfEntity(UUID id, String nome, List<VolumeEntity> volumes) {
		this.id = id;
		this.nome = nome;
		this.volumes = volumes;
	}

	public static BookshelfEntity fromDomain(Bookshelf bookshelf) {

		var volumes = bookshelf.getVolumes().stream().map(VolumeEntity::fromDomain)
				.collect(Collectors.toList());

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

}
