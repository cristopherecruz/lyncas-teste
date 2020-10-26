package net.lyncas.api.controllers.resource;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.lyncas.api.controllers.dto.BookshelfDto;
import net.lyncas.api.controllers.form.BookshelfForm;

@RestController
@RequestMapping("/bookshelf")
public interface BookshelfResource {

	@PostMapping
	ResponseEntity<BookshelfDto> createBookshelf(@RequestBody @Valid BookshelfForm bookshelfForm, UriComponentsBuilder uriBuilder);
	
	@PutMapping("/{id}")
	ResponseEntity<BookshelfDto> updateBookshelf(@PathVariable UUID id, @RequestBody @Valid BookshelfForm bookshelfForm);
	
}
