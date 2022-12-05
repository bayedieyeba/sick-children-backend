package com.newton.childrensickbackend.dtos;

import lombok.Data;

import java.util.List;
@Data
public class EnfantPageable {
    private String code;
    private String prenom;
    private String nom;
    private int age;
    private String telephoneParent;
    private double montant;
    private String typeConsultation;
    private String adresse;
    private String typeCancer;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<EnfantResponseDTO> enfantResponseDTOS;
}
