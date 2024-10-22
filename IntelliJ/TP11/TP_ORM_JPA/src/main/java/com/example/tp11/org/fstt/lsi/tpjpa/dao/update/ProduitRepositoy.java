package com.example.tp11.org.fstt.lsi.tpjpa.dao.update;


import java.util.List;

import com.example.tp11.org.fstt.lsi.tpjpa.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


// Utilisation de l'interface de Spring JpaRepository afin de ne plus utiliser
// la classe générique EntityRepository
public interface ProduitRepositoy extends JpaRepository<Produit, Long> {

    @Query("select p from Produit p where p.designation like :x ")
    public List<Produit> produitsParMc(@Param("x")String mc);

}