package mas.mp5.mas_final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home controller shows initial panel
 */

@Controller
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
