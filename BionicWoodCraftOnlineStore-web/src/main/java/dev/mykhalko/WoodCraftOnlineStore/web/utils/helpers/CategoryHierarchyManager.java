/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.mykhalko.WoodCraftOnlineStore.web.utils.helpers;

import dev.mykhalko.woodcraftonlinestore.entities.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrgibbs
 */
public class CategoryHierarchyManager {
    private List<Category> hierarchyList;
    private Category emptyCategory;
    private List<Category> rootCategories;
    private int currentLevel;
    
    public CategoryHierarchyManager(List<Category> rootCategories) throws Exception {
        if (rootCategories == null) {
            throw new Exception("rootCategorie list equals null");
        }
        this.rootCategories = rootCategories;
        hierarchyList = new ArrayList<>();
        emptyCategory = new Category();
        emptyCategory.setId(-1L);
        emptyCategory.setNameUkr("Вибрати");
        currentLevel = 0;
        System.out.println("New instance of CHM");
    }
    
    public boolean listExistsAtLevel(int level) {
        
        if(!checkLevel(level)){
            return false;
        }
        if(level == 0) {
            return true;
        } else {
            List<Category> subList = hierarchyList.get(level - 1).getSubCategoriesList();
//            System.out.println("subList size: " + subList.size());
            return subList != null && subList.size() > 0;
        }
        
    }
    
    public List<Category> getListAtLevel(int level) throws IndexOutOfBoundsException {
        List<Category> resultList = new ArrayList<>();
        resultList.add(emptyCategory);
        if (!checkLevel(level)) {
            throw new IndexOutOfBoundsException("Attempt to obtain list with invalid level");
        }
        if (listExistsAtLevel(level)) {
            List<Category> categoryList = null;
            if (level == 0) {
                categoryList = rootCategories;
            } else {
                categoryList = hierarchyList.get(level - 1).getSubCategoriesList();
            }
            resultList.addAll(categoryList);
        }
        return resultList;        
    }
    
    public void update(Category category) {
        if (category.equals(emptyCategory)) {
            hierarchyList = hierarchyList.subList(0, currentLevel);
//            System.out.println("from update - currentLevel = " + currentLevel);
            return;
        }
        for (Category cat : rootCategories) {
           if (category.equals(cat)){
                hierarchyList.clear();
                hierarchyList.add(category);
                return;               
           }           
        }
        for (int i = 0; i < hierarchyList.size(); ++i) {
            if (listExistsAtLevel(i + 1)){
                List<Category> subCatList = hierarchyList.get(i).getSubCategoriesList();
                for (Category cat : subCatList){
                    if (category.equals(cat)) {
                        hierarchyList = hierarchyList.subList(0, i + 1);
                        hierarchyList.add(category);
                    }
                }
            }
        }
    }

    public List<Category> getHierarchyList() {
        return hierarchyList;
    }
    
    public int getHierarchySize() {
        return hierarchyList.size();
    }
    
    public List<Integer> getDisplayLevels() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < hierarchyList.size() + 1; ++i) {
           list.add(i);
        }
        return list;
    }
    
    public void setCurrentCategory(Category category) {
        update(category);
//        currentLevel = 0;
//        System.out.println("setCurrentCategory " + category.getNameUkr() + "   size = " + hierarchyList.size());
    }
    
    public Category getCurrentCategory() {
        if (hierarchyList.size() > 0 && currentLevel < hierarchyList.size()) {
//            System.out.println("currentLevel: " + currentLevel);
            return hierarchyList.get(currentLevel);            
        } else {
            return emptyCategory;
        }
    }
    
    private boolean checkLevel(int level) {
        return level >= 0 && level <= hierarchyList.size();
    }

    public List<Category> getRootCategories() {
        return rootCategories;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
//        System.out.println("setting with " + currentLevel);
    }
    
//    public void setCurrentLevel_debug(int currentLevel) {
//        this.currentLevel = currentLevel;
//        System.out.println("setting with debug level: " + currentLevel);
//    }
    
    
    
    
}
