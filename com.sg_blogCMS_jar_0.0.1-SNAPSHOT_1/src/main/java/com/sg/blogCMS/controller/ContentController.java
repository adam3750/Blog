
package com.sg.blogCMS.controller;

/**
 *
 * @author SMD3
 */
    
import com.sg.blogCMS.entity.Content;
import com.sg.blogCMS.entity.User;
import com.sg.blogCMS.repositories.ContentRepository;
import com.sg.blogCMS.repositories.TagRepository;
import com.sg.blogCMS.repositories.UserRepository;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
   
        List<Content> contentList = contents.findAll();
        model.addAttribute("contents", contentList);
        
        return "contentDetail";
    }
    
    @PostMapping("/addContent")
    public String addContent(@Valid Content content, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/content";
        }
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = users.findByUsername(currentUserName);
        content.setUserid(user);
        contents.save(content);
        return "redirect:/content";
    }
}
