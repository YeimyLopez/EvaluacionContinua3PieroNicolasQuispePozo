package com.idat.idat_Nicolas_EVAL3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.idat_Nicolas_EVAL3.model.Hospital;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
