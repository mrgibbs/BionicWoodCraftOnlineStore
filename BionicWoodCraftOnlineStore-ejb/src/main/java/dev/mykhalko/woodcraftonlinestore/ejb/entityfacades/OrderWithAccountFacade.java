/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.entityfacades;

import dev.mykhalko.woodcraftonlinestore.entities.OrderWithAccount;
import dev.mykhalko.woodcraftonlinestore.helpers.OrderStatus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mrgibbs
 */
@Stateless
public class OrderWithAccountFacade extends AbstractFacade<OrderWithAccount> {
    @PersistenceContext(unitName = "dev.mykhalko_BionicWoodCraftOnlineStore-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderWithAccountFacade() {
        super(OrderWithAccount.class);
    }
    
    public List<OrderWithAccount> findOrdersByStatus(OrderStatus orderStatus) {
        TypedQuery<OrderWithAccount> query = em.createNamedQuery("OrderWithAccount.findByStatus", OrderWithAccount.class);
        query.setParameter("status", orderStatus);
        List<OrderWithAccount> orders = null;
        try {
            orders = query.getResultList();
        } catch (NoResultException nre) {
            System.out.println("Orders not found in OrdersWithAccount getByStatus method");
        }
        return orders;
    }
    
}
