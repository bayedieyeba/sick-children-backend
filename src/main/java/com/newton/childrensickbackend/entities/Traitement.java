package com.newton.childrensickbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Traitement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeTraitement;
    private Date dateCommancement;
    private int duree;
    @ManyToOne
    private Enfant enfant;
}
