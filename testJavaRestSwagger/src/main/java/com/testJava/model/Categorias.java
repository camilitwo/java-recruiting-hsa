
package com.testJava.model;

import java.io.Serializable;
import java.util.List;

public class Categorias implements Serializable
{
    private String id;
    private String name;
    private List<Subcategory> subcategories = null;
    private final static long serialVersionUID = 868705826702389879L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

}
