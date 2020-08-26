package com.cevikcozum.hr.meeting.service;

import java.util.List;

import com.cevikcozum.hr.meeting.model.ToplantiOdasi;

public interface ToplantiOdasiService {
	ToplantiOdasi createToplantiOdasi(ToplantiOdasi toplantiodasi);
	
	ToplantiOdasi updateToplantiOdasi(ToplantiOdasi toplantiodasi);
	
	List<ToplantiOdasi> getAllToplantiOdasi();
	
	ToplantiOdasi getToplantiOdasiById(long toplantiodasiId);
	
	void deleteToplantiOdasi(long id);
	
}
