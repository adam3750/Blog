
package com.sg.hellosecurity.controller;

/**
 *
 * @author SMD3
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String displayHomePage() {
        
        return "home";
    }
}