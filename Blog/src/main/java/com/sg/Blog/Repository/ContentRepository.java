/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Blog.Repository;

import com.sg.Blog.Dto.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adamhassan
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    
}
