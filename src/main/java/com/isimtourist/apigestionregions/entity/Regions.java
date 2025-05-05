package com.isimtourist.apigestionregions.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Regions {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeRegion;
    private String nom;
    private String domaineActivite;
    private double superficie;
    private String langue;

    @ManyToOne
    private Pays pays;

   public String getCode() {
       return "";
   }
}
