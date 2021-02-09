
package com.testJava.model;

import java.io.Serializable;
import java.util.List;

public class Subcategory__ implements Serializable
{


    private String id;

    private String name;

    private List<Subcategory___> subcategories = null;

    private String largeImageUrl;

    private String mediumImageUrl;

    private String smallImageUrl;

    private Integer relevance;
    private final static long serialVersionUID = -4501863217541006976L;

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

    public List<Subcategory___> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory___> subcategories) {
        this.subcategories = subcategories;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public void setRelevance(Integer relevance) {
        this.relevance = relevance;
    }

}
