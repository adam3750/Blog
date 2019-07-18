/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogCMS.repositories;

import com.sg.blogCMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMD3
 */
@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    User findByUsername(String username);
}
