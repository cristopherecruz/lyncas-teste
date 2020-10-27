package net.lyncas.api.controllers;

import java.net.URI;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.UriComponentsBuilder;

import net.lyncas.api.controllers.dto.BookshelfDto;
import net.lyncas.api.controllers.form.BookshelfForm;
import net.lyncas.api.controllers.resource.BookshelfResource;
import net.lyncas.domain.entity.Bookshelf;
import net.lyncas.usecase.services.BookshelfService;

@Controller
public class BookshelfController implements BookshelfResource {

	
	private BookshelfService bookshelfService;

	@Autowired
	public BookshelfController(BookshelfService bookshelfService) {
		this.bookshelfService = bookshelfService;
	}

	@Override
	public ResponseEntity<BookshelfDto> createBookshelf(@Valid BookshelfForm bookshelfForm, UriComponentsBuilder uriBuilder) {
		
		Bookshelf bookshelf = bookshelfForm.toBookshelf();
		
		Bookshelf newBookshelf = bookshelfService.save(bookshelf);
		
		URI uri = uriBuilder.path("/bookshelf").buildAndExpand(newBookshelf.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new BookshelfDto(newBookshelf));
	}
	
	@Override
	public ResponseEntity<BookshelfDto> updateBookshelf(UUID id, BookshelfForm bookshelfForm) {
		
		var bookshelfEditada = bookshelfService.update(id, bookshelfService, bookshelfForm.toBookshelf());
		
		return ResponseEntity.ok(new BookshelfDto(bookshelfEditada));
	}

}
