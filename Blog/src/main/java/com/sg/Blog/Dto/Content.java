/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Blog.Dto;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author adamhassan
 */
@Entity
public class Content {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String contentid;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    
    @Column(nullable = false)
    private String blog;

    @Column(nullable = false)
    private LocalDate creationdate;

    @Column(nullable = false)
    private LocalDate postdate;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!Objects.equals(this.contentid, other.contentid)) {
            return false;
        }
        if (!Objects.equals(this.blog, other.blog)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        if (!Objects.equals(this.creationdate, other.creationdate)) {
            return false;
        }
        if (!Objects.equals(this.postdate, other.postdate)) {
            return false;
        }
        return true;
    }


}
