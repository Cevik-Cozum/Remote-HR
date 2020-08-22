package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.ToplantiOdasi;
import com.example.springboot.repository.ToplantiOdasiRepository;

@Service
@Transactional

public class ToplantiOdasiServicelmpl implements ToplantiOdasiService {

	@Autowired
	private ToplantiOdasiRepository toplantiodasiRepository;
	
	@Override
	public ToplantiOdasi createToplantiOdasi(ToplantiOdasi toplantiodasi) {
		
		return toplantiodasiRepository.save(toplantiodasi);
	}

	@Override
	public ToplantiOdasi updateToplantiOdasi(ToplantiOdasi toplantiodasi) {
		
	Optional<ToplantiOdasi> toplantiodasiDb = this.toplantiodasiRepository.findById(toplantiodasi.getId());
	if(toplantiodasiDb.isPresent()) {
		ToplantiOdasi toplantiodasiUpdate = toplantiodasiDb.get();
		toplantiodasiUpdate.setId(toplantiodasi.getId());
		toplantiodasiUpdate.setSalon(toplantiodasi.getSalon());	
		toplantiodasiUpdate.setKonu(toplantiodasi.getKonu());
		toplantiodasiUpdate.setTarih(toplantiodasi.getTarih());
		toplantiodasiRepository.save(toplantiodasiUpdate);
		return toplantiodasiUpdate;
			
	}
	else{
		throw new ResourceNotFoundException("Kayıt bulunamadı: " + toplantiodasi.getId());
	}
	}

	@Override
	public List<ToplantiOdasi> getAllToplantiOdasi() {
		
		return this.toplantiodasiRepository.findAll();
	}

	@Override
	public ToplantiOdasi getToplantiOdasiById(long toplantiodasiId) {
		Optional<ToplantiOdasi> toplantiodasiDb = this.toplantiodasiRepository.findById(toplantiodasiId);
		
		if(toplantiodasiDb.isPresent()) {
		return toplantiodasiDb.get();
		}
		else{
			throw new ResourceNotFoundException("Kayıt bulunamadı: " + toplantiodasiId);
		}
	}

	@Override
	public void deleteToplantiOdasi(long toplantiodasiId) {
		Optional<ToplantiOdasi> toplantiodasiDb = this.toplantiodasiRepository.findById(toplantiodasiId);
		if(toplantiodasiDb.isPresent()) {
			this.toplantiodasiRepository.delete(toplantiodasiDb.get());	
			
		}
		else{
			throw new ResourceNotFoundException("Kayıt bulunamadı: " + toplantiodasiId);
		}
			
	}

}
