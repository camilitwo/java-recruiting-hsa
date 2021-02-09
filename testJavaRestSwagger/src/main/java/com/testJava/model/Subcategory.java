
package com.testJava.model;

import java.io.Serializable;
import java.util.List;


public class Subcategory implements Serializable
{

    private String id;
    private String name;
    private List<Subcategory_> subcategories = null;
    private final static long serialVersionUID = 7521948325169253910L;

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

    public List<Subcategory_> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory_> subcategories) {
        this.subcategories = subcategories;
    }

}
