
package com.sg.blogCMS.controller;

/**
 *
 * @author SMD3
 */


import com.sg.blogCMS.entity.Content;
import com.sg.blogCMS.entity.Role;
import com.sg.blogCMS.entity.User;
import com.sg.blogCMS.repositories.ContentRepository;
import com.sg.blogCMS.repositories.RoleRepository;
import com.sg.blogCMS.repositories.TagRepository;
import com.sg.blogCMS.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    
    @Autowired
    UserRepository users;
    
    @Autowired
    RoleRepository roles;
    
     @Autowired
    PasswordEncoder encoder;
     
    @Autowired
    ContentRepository contents; 
    
    @Autowired
    TagRepository tags;
     
   @GetMapping("/admin")
    public String displayAdminPage(Model model) {
        model.addAttribute("users", users.findAll());
        return "admin";
    }
    @PostMapping("/addUser")
    public String addUser(String username, String displayname, String password) {
        User user = new User();
        user.setUsername(username);
        user.setDisplayname(displayname);
        user.setPassword(encoder.encode(password));
        user.setEnabled(true);
        
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roles.findByRole("ROLE_USER"));
        user.setRoles(userRoles);
        
        users.save(user);
        
        return "redirect:/admin";
    }
     @PostMapping("/deleteUser")
    public String deleteUser(Integer id) {
        User user = users.findById(id).orElse(null);
        contents.deleteByUserid(user);
        users.deleteById(id);
        return "redirect:/admin";
    }
    @GetMapping("/editUser")
    public String editUserDisplay(Model model, Integer id, Integer error) {
        User user = users.findById(id).orElse(null);
        List roleList = roles.findAll();
        
        model.addAttribute("user", user);
        model.addAttribute("roles", roleList);
        
        if(error != null) {
            if(error == 1) {
                model.addAttribute("error", "Passwords did not match, password was not updated.");
            }
        }
        
        return "editUser";
    }
    @PostMapping(value="/editUser")
    public String editUserAction(String[] roleIdList, Boolean enabled, Integer id) {
        User user = users.findById(id).orElse(null);
        if(enabled != null) {
            user.setEnabled(enabled);
        } else {
            user.setEnabled(false);
        }
        
        List<Role> roleList = new ArrayList<>();
        for(String roleId : roleIdList) {
            Role role = roles.findById(Integer.parseInt(roleId)).orElse(null);
            roleList.add(role);
        }
        user.setRoles(roleList);
        users.save(user);
        
        return "redirect:/admin";
    }
    @PostMapping("editPassword") 
    public String editPassword(Integer id, String password, String confirmPassword) {
        User user = users.findById(id).orElse(null);
        if(password.equals(confirmPassword)) {
            user.setPassword(encoder.encode(password));
            users.save(user);
            return "redirect:/admin";
        } else {
            return "redirect:/editUser?id=" + id + "&error=1";
        }
    }
    @GetMapping("/contentDetailAdmin")
    public String displayContent(Integer id, Model model) {
        List<Content> contentList = contents.findAll();
        model.addAttribute("contents", contentList);
        
        return "contentDetailAdmin";
    }
    @PostMapping("/deleteContent")
    public String deleteContent(Integer id) {
    //    Content content = contents.findById(id).orElse(null);
    //    contents.deleteByUserid(user);
        contents.deleteById(id);
        return "redirect:/contentDetailAdmin";
    }
}