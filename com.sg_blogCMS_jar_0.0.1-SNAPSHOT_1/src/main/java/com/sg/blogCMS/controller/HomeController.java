
package com.sg.blogCMS.controller;

/**
 *
 * @author SMD3
 */

import com.sg.blogCMS.entity.Content;
import com.sg.blogCMS.repositories.ContentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    ContentRepository contents;
    

    @GetMapping({"/", "/home"})
    public String displayHomePage(Model model) {
        
        List<Content> contentList = contents.findAll();
        
        model.addAttribute("contents", contentList);
        
        return "home";
    }
}