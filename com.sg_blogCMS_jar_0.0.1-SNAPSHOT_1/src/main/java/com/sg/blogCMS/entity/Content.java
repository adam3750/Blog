/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogCMS.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author adamhassan
 */
@Entity
public class Content {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int contentid;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate creationdate;
   

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postdate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @ManyToMany
    @JoinTable(name = "content_tags",
            joinColumns = {@JoinColumn(name = "contentid")},
            inverseJoinColumns = {@JoinColumn(name = "tagid")})
    private List<Tag> tags;

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    public LocalDate getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    public LocalDate getPostdate() {
        return postdate;
    }

    public void setPostdate(LocalDate postdate) {
        this.postdate = postdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.contentid;
        hash = 37 * hash + Objects.hashCode(this.creationdate);
        hash = 37 * hash + Objects.hashCode(this.postdate);
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.category);
        hash = 37 * hash + Objects.hashCode(this.userid);
        hash = 37 * hash + Objects.hashCode(this.tags);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Content other = (Content) obj;
        if (this.contentid != other.contentid) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.creationdate, other.creationdate)) {
            return false;
        }
        if (!Objects.equals(this.postdate, other.postdate)) {
            return false;
        }
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        return true;
    }

    
}