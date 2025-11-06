package com.cda.camping.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "factures_services")
public class FacturesService {
    
    @Id
    @Column(name="id_facture")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date_facture")
    private Date dateFacture;

    @Column(name="prix_ttc")
    private double prixTtc;

    @Column(name="prix_ht")
    private double prixHt;

    @Column(name="facture")
    private boolean facture;

    @Column(name="id_services")
    private Integer idServices;

    public boolean getFacture() {
        return facture;
    }
}
