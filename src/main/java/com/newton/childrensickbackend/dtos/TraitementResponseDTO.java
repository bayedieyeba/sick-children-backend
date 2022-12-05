package com.newton.childrensickbackend.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class TraitementResponseDTO {
    private long id;
    private String typeTraitement;
    private Date dateCommancement;
    private int duree;
}
