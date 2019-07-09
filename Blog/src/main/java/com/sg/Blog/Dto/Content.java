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

}
