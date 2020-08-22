package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.ToplantiOdasi;
import com.example.springboot.service.ToplantiOdasiService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class ToplantiOdasiController {
	@Autowired
	private ToplantiOdasiService toplantiodasiService;
	
	@GetMapping("/ToplantiOdasi")
	public ResponseEntity<List<ToplantiOdasi>>getAllToplantiOdasi(){
		return ResponseEntity.ok().body(toplantiodasiService.getAllToplantiOdasi());
	}
	@GetMapping("/ToplantiOdasi/{id}")
	public ResponseEntity<ToplantiOdasi>getToplantiOdasiById(@PathVariable long id){
		return ResponseEntity.ok().body(toplantiodasiService.getToplantiOdasiById(id));
	}
	
	@PostMapping("/ToplantiOdasi")
	public ResponseEntity<ToplantiOdasi>createToplantiOdasi(@RequestBody ToplantiOdasi toplantiodasi){
		return ResponseEntity.ok().body(toplantiodasiService.createToplantiOdasi(toplantiodasi));
		
	}
	
	@PutMapping("/ToplantiOdasi/{id}")
	public ResponseEntity<ToplantiOdasi> updateToplantiOdasi(@PathVariable long id,@RequestBody ToplantiOdasi toplantiodasi){
		toplantiodasi.setId(id);
		return ResponseEntity.ok().body(toplantiodasiService.updateToplantiOdasi(toplantiodasi));
	}
	
	@DeleteMapping("/ToplantiOdasi/{id}")
	public HttpStatus deleteToplantiOdasi(@PathVariable long id) {
	    this.toplantiodasiService.deleteToplantiOdasi(id);
	    return HttpStatus.OK;
	}

}
