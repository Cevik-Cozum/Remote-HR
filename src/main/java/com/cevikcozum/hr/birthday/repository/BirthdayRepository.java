package com.cevikcozum.hr.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cevikcozum.hr.birthday.model.Birthday;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {

}
