package com.newton.childrensickbackend.repositories;

import com.newton.childrensickbackend.entities.Enfant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EnfantRepository extends JpaRepository<Enfant,Long> {
    @Query("select e from Enfant e where e.typeConsultation like :typeCons")
    List<Enfant> enfantsEnConsultation(@Param("typeCons") String typeConsultation);

    Enfant findEnfantByCode(String enfantCode);

    @Query("select e from Enfant e where e.typeConsultation like :typeCons")
    Page <Enfant> enfantsEnConsultationPageable(@Param("typeCons") String typeConsultation, Pageable pageable);


}
