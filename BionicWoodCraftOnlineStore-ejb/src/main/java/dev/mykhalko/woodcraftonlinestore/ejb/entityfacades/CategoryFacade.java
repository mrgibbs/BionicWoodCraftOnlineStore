/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.woodcraftonlinestore.ejb.entityfacades;

import dev.mykhalko.woodcraftonlinestore.ejb.exceptions.NoSuchCategoryException;
import dev.mykhalko.woodcraftonlinestore.entities.Category;
import java.util.ArrayList;
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
public class CategoryFacade extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "dev.mykhalko_BionicWoodCraftOnlineStore-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    public Category findGeneralByName(String name){
        TypedQuery<Category> query = em.createNamedQuery("Category.findGeneralCategoryByName", Category.class);
        query.setParameter("cur_name", name);
        Category category = null;
//        try {
//            category = query.getSingleResult();
//        } catch (NoResultException e) {
//            //TODO: ADD LOGGING
//        }   
        category = query.getSingleResult();
        return category;
    }
    
    public List<Category> getRootCategories() {
        List<Category> root_categories = null;
        TypedQuery<Category> query = em.createNamedQuery("Category.findRootCategories", Category.class);
        root_categories = query.getResultList();
        return root_categories;
    }
    
    public Category findSubCategoryByNameAndSuperCategory(String name, Category super_cat) {
        TypedQuery<Category> query = em.createNamedQuery("Category.findSubCategoryByNameAndSuper",
                Category.class);
        query.setParameter("sub_name", name);
        query.setParameter("super_category", super_cat);
        Category category = query.getSingleResult();
        return category;
    }
    
    public List<Category> getCategoriesByPathList(List<String> path_list)
            throws NoSuchCategoryException {
        List<Category> categoriesList = new ArrayList<>();
        try {
            categoriesList.add(findGeneralByName(path_list.get(0)));
        } catch (NoResultException e) {
            throw new NoSuchCategoryException("root category not found");
        }
        for (int i = 1; i < path_list.size(); ++i) {
            try {
                categoriesList.add(
                        findSubCategoryByNameAndSuperCategory(path_list.get(i), categoriesList.get(i-1)));
            } catch (NoResultException e) {
                throw new NoSuchCategoryException("subcategory not found");
            }
        }
        return categoriesList;
    }
    
}
