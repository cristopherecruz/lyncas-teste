package net.lyncas.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import net.lyncas.api.controllers.dto.VolumeDto;
import net.lyncas.api.controllers.form.VolumeForm;
import net.lyncas.api.controllers.resource.VolumeResource;
import net.lyncas.domain.entity.Volume;
import net.lyncas.usecase.services.VolumeService;

public class VolumeController implements VolumeResource {

	private VolumeService volumeService;

	@Autowired
	public VolumeController(VolumeService volumeService) {
		this.volumeService = volumeService;
	}

	@Override
	public ResponseEntity<VolumeDto> criarVolume(VolumeForm volumeForm, UriComponentsBuilder uriBuilder) {

		Volume volume = volumeForm.toVolume();

		var newVolume = volumeService.save(volume);

		URI uri = uriBuilder.path("/volume").buildAndExpand(newVolume.getId()).toUri();

		return ResponseEntity.created(uri).body(new VolumeDto(newVolume));
	}

}
