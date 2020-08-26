package com.cevikcozum.hr.birthday.service;

import java.util.List;
import com.cevikcozum.hr.birthday.model.Birthday;
import org.springframework.data.domain.Sort;

public interface BirthdayService {

	Birthday createBirthday(Birthday birthday);
	Birthday updateBirthday(Birthday birthday);
	List<Birthday> getAllBirthdays(Sort sort);
	Birthday getBirthdayById(long birthdayId);
	void deleteBirthday(long birthdayId);
	
	
}
