package com.newton.childrensickbackend.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class TraitementRequestDTO {
    private String typeTraitement;
    private Date dateCommancement;
    private int duree;
    private long idEnfant;
}
