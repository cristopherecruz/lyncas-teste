package net.lyncas.api.controllers.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.lyncas.api.controllers.dto.VolumeDto;
import net.lyncas.api.controllers.form.VolumeForm;

@RestController
@RequestMapping("/volume")
public interface VolumeResource {

	@PostMapping
	ResponseEntity<VolumeDto> criarVolume(@RequestBody @Valid VolumeForm volumeForm, UriComponentsBuilder uriBuilder);
	
}
