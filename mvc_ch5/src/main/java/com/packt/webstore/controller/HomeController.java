package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing web store");
//        redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
//        redirectAttributes.addFlashAttribute("tagline", "The one and only amazing web store");
        return "redirect:/welcome/greeting";
    }

    @RequestMapping("/welcome/greeting")
    public String greeting() {
        return "welcome";
    }

    @RequestMapping("/home")
    public ModelAndView greeting(Map<String, Object> model) {
        model.put("greeting", "Welcome to Web Store!");
        model.put("tagline", "The one and only amazing web store");
        View view = new InternalResourceView("/WEB-INF/jsp/welcome.jsp");
        return new ModelAndView(view, model);
    }
}
