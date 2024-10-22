package com.example.tp11.org.fstt.lsi.tpjpa;

import java.util.List;

import com.example.tp11.org.fstt.lsi.tpjpa.dao.update.CategorieRepositoy;
import com.example.tp11.org.fstt.lsi.tpjpa.dao.update.ProduitRepositoy;
import com.example.tp11.org.fstt.lsi.tpjpa.entities.Categorie;
//import org.fstt.lsi.tpjpa.dao.EntityRepository;
import com.example.tp11.org.fstt.lsi.tpjpa.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TpOrmJpaApplication {

    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(TpOrmJpaApplication.class,
                args);
        ProduitRepositoy produitDao=ctx.getBean(ProduitRepositoy.class);
        //old//EntityRepository<Produit> produitDao=ctx.getBean(EntityRepository.class);

        // List<Produit> produits=produitDao.findAll();
        //List<Produit> allproduits=produitDao.findAll();
        CategorieRepositoy categorieRepository=ctx.getBean(CategorieRepositoy.class);
        Categorie c1= new Categorie("Ordinateurs");
        Categorie c2= new Categorie("Imprimantes");
        Categorie c3= new Categorie("Logiciels");
        categorieRepository.save(c1);
        categorieRepository.save(c2);
        categorieRepository.save(c3);
        produitDao.save(new Produit("Imprimante Hp Laser",2540,30,c1));
        produitDao.save(new Produit("MacBook 2021",22000,35,c1));
        produitDao.save(new Produit("Scanner HPLX",1640,20,c2));
        List<Produit> produits=produitDao.produitsParMc("%H%");
        for(Produit p:produits){
            System.out.println("Des:"+p.getDesignation());
            System.out.println("Prix:"+p.getPrix());
        }
    }
}