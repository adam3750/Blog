
package com.sg.hellosecurity.controller;

/**
 *
 * @author SMD3
 */
    
import com.sg.hellosecurity.entity.Content;
import com.sg.hellosecurity.repositories.ContentRepository;
import com.sg.hellosecurity.repositories.TagRepository;
import com.sg.hellosecurity.repositories.UserRepository;
import java.util.List;
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
    @GetMapping("/contentDetail")
    public String displayContent(Integer id, Model model) {
    //    Content content = contents.findById(id).orElse(null);
        List<Content> contentList = contents.findAll();
        
    //    model.addAttribute("content", content);
        model.addAttribute("contents", contentList);
        
        return "contentDetail";
    }
    
    @PostMapping("/addContent")
    public String addContent(Content content) {
        contents.save(content);
        return "redirect:/content";
    }
}
