
package com.sg.blogCMS.entity;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author adamhassan
 */
@Entity
public class Tag {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int tagid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;
    
    @Column(nullable = true)
    private String robot;
    
    @ManyToMany(mappedBy = "tags")
    private List<Content> contents;  

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRobot() {
        return robot;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.tagid;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.robot);
        hash = 53 * hash + Objects.hashCode(this.contents);
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
        final Tag other = (Tag) obj;
        if (this.tagid != other.tagid) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.robot, other.robot)) {
            return false;
        }
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        return true;
    }
    
    
}    
    
