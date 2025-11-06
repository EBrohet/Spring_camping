package com.cda.camping.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cda.camping.model.FacturesService;

@Repository
public class FacturesServiceRepository {
    
     @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FacturesService> findAll(){
        String sql = "SELECT id_facture, date_facture, prix_ttc, prix_ht, facture, id_services FROM factures_services";
        return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            List<FacturesService> facturesService = new ArrayList<>();
            while (resultSet.next()) {
                FacturesService f = new FacturesService();
                f.setId(resultSet.getInt("id_facture"));
                f.setDateFacture(resultSet.getDate("date_facture"));
                f.setPrixTtc(resultSet.getDouble("prix_ttc"));
                f.setPrixHt(resultSet.getDouble("prix_ht"));
                f.setFacture(resultSet.getBoolean("facture"));
                f.setIdServices(resultSet.getInt("id_services"));
                facturesService.add(f);
            }
            return facturesService;
        });
    }

    public FacturesService findById(Integer id){
        String sql = "SELECT id_facture, date_facture, prix_ttc, prix_ht, facture, id_services FROM factures_services WHERE id_facture = ?";
        return jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            if (resultSet.next()){
                FacturesService f = new FacturesService();
                f.setId(resultSet.getInt("id_facture"));
                f.setDateFacture(resultSet.getDate("date_facture"));
                f.setPrixTtc(resultSet.getDouble("prix_ttc"));
                f.setPrixHt(resultSet.getDouble("prix_ht"));
                f.setFacture(resultSet.getBoolean("facture"));
                f.setIdServices(resultSet.getInt("id_services"));
                return f;
            }
            return null;
        }, id);
    }

    public int save(FacturesService f){
        String sql = "INSERT INTO factures_services(date_facture, prix_ttc, prix_ht, facture, id_services) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdServices());
    }

    public int update(FacturesService f){
        String sql = "UPDATE factures_services set date_facture = ?, prix_ttc = ?, prix_ht = ?, facture = ?, id_services = ? WHERE id_facture = ?";
        return jdbcTemplate.update(sql, f.getDateFacture(), f.getPrixTtc(), f.getPrixHt(), f.getFacture(), f.getIdServices(), f.getId());
    }

    public int delete(Integer id){
        String sql = "DELETE FROM factures_services WHERE id_facture = ?";
        return jdbcTemplate.update(sql, id);
    }
}
