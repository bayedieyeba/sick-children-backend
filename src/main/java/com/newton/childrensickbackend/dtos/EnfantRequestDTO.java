package com.newton.childrensickbackend.dtos;

import com.newton.childrensickbackend.enums.EnumConsultation;
import lombok.Data;

@Data
public class EnfantRequestDTO {
    private String code;
    private String prenom;
    private String nom;
    private int age;
    private String telephoneParent;
    private double montant;
    private String typeConsultation;
    private String adresse;
    private String typeCancer;
}
