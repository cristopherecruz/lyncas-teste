package net.lyncas.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.domain.entity.Volume;

public class BookshelfBuilder {

	private Bookshelf bookshelf;
	
	public Bookshelf build() {
		return this.bookshelf;
	}
	
	public static BookshelfBuilder umaEstante() {
		BookshelfBuilder bookshelfBuilder = new BookshelfBuilder();

		List<Volume> volumes = new ArrayList<>();
		
		bookshelfBuilder.bookshelf = new Bookshelf(UUID.fromString("0d4229cc-15bf-4c26-a42f-8793bfae39f7"), "Estante Teste", volumes);
		
		return bookshelfBuilder;
	}
	
	
	public BookshelfBuilder comId() {
		this.bookshelf.setId(UUID.randomUUID());
		return this;
	}
	
}
