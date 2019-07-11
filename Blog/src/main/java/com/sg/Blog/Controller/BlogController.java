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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author adamhassan
 * 
 */
@Controller
public class BlogController {
  @Autowired 
  ContentRepository contents;
  
  @Autowired 
  RoleRepository roles;
  
  @Autowired 
  TagsRepository tags;
  
  @Autowired 
  UserRepository users;
  
     @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("content", contents.findAll());
        return "index";
        
    }
    @PostMapping("/addContent")
    public String addContent(Content content) {
        contents.save(content);
        return "redirect:/";
    }
    
/*     @GetMapping("/viewInventory")
    public String viewInventory(Integer id, Model model) {
       Content content = (Content) contents.findById(id).orElse(null);
        List<Content> contentList = contents.findByStore(Content);
        
        model.addAttribute("content", content);
        model.addAttribute("contents", contentList);
        
        return "inventory";     */
}

