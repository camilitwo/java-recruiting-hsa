
package com.testJava.model;

import java.io.Serializable;
import java.util.List;

public class Subcategory_ implements Serializable
{


    private String id;

    private String name;

    private Integer relevance;

    private List<Subcategory__> subcategories = null;

    private String iconImageUrl;
    private final static long serialVersionUID = 5502784816785816335L;

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

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

    public List<Subcategory__> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory__> subcategories) {
        this.subcategories = subcategories;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

}
