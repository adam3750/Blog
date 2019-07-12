
package com.sg.hellosecurity.controller;

/**
 *
 * @author SMD3
 */
    
import com.sg.hellosecurity.entity.Content;
import com.sg.hellosecurity.repositories.ContentRepository;
import com.sg.hellosecurity.repositories.TagRepository;
import com.sg.hellosecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContentController {
    
    @Autowired
    ContentRepository contents;
    
    @Autowired
    TagRepository tags;
    
    @Autowired
    UserRepository users;
    
    @GetMapping("/content")
    public String displayContentPage() {
        return "content";
    }
 //   @GetMapping("/")
 //   public String index(Model model) {
 //       model.addAttribute("contents", contents.findAll());
 //       return "index";
//    }
    @PostMapping("/addContent")
    public String addContent(Content content) {
        contents.save(content);
        return "redirect:/";
    }
}