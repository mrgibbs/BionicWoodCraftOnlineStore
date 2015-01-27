/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.entityfacades;

import dev.mykhalko.woodcraftonlinestore.entities.ProductFeature;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mrgibbs
 */
@Stateless
public class ProductFeatureFacade extends AbstractFacade<ProductFeature> {
    @PersistenceContext(unitName = "dev.mykhalko_BionicWoodCraftOnlineStore-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFeatureFacade() {
        super(ProductFeature.class);
    }
    
}
