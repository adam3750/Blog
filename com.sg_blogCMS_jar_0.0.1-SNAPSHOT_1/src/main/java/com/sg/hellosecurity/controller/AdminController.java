
package com.sg.hellosecurity.controller;

/**
 *
 * @author SMD3
 */


import com.sg.hellosecurity.entity.Role;
import com.sg.hellosecurity.entity.User;
import com.sg.hellosecurity.repositories.RoleRepository;
import com.sg.hellosecurity.repositories.UserRepository;
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
     
    
   @GetMapping("/admin")
    public String displayAdminPage(Model model) {
        model.addAttribute("users", users.findAll());
        return "admin";
    }
    @PostMapping("/addUser")
    public String addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
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
        
   //     Set<Role> roleList = new HashSet<>();
        List<Role> roleList = new ArrayList<>();
        for(String roleId : roleIdList) {
            Role role = roles.findById(Integer.parseInt(roleId)).orElse(null);
       //      User user = users.findById(id).orElse(null);
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
}