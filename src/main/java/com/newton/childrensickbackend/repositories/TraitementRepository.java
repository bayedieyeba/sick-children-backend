package com.newton.childrensickbackend.repositories;

import com.newton.childrensickbackend.entities.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TraitementRepository extends JpaRepository<Traitement,Long> {
List<Traitement>findByEnfantCode(String codeEnfant);

    List<Traitement> findById(long id);

    List<Traitement> findAllByEnfantId(long id);
}
