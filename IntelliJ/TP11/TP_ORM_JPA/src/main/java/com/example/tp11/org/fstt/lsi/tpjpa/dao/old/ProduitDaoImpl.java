package com.example.tp11.org.fstt.lsi.tpjpa.dao.old;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.example.tp11.org.fstt.lsi.tpjpa.entities.Produit;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit> {

    @PersistenceContext
    private EntityManager em;
    @Override
    public Produit save(Produit p) {
        em.persist(p);
        return p;
    }

    @Override
    public List<Produit> findAll() {

        // On utilise le HQL, le langage Hibernate Query langage
        Query req=em.createQuery("select p from Produit p");
        return req.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query req=em.createQuery("select p from Produit p where p.designation like :x");
        req.setParameter("x", mc);
        return req.getResultList();
    }

    @Override
    public Produit findOne(Long id) {
        Produit p=em.find(Produit.class,id);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        em.merge(p);
        return null;
    }
    @Override
    public void delete(Long id) {
        Produit p=em.find(Produit.class,id);
        em.remove(p);
    }

}