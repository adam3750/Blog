/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.Blog.Controller;

import com.sg.Blog.Dto.Content;
import com.sg.Blog.Repository.ContentRepository;
import com.sg.Blog.Repository.RoleRepository;
import com.sg.Blog.Repository.TagsRepository;
import com.sg.Blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author adamhassan
 */
public class Controller {
  @Autowired 
  ContentRepository content;
  
  @Autowired 
  RoleRepository role;
  
  @Autowired 
  TagsRepository tag;
  
  @Autowired 
  UserRepository user;
  
     @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("content", content.findAll());
        return "index";
        
    }
    @PostMapping("/addContent")
    public String addContent(Content content) {
        content.save(content);
        return "redirect:/";
    }
    
}

