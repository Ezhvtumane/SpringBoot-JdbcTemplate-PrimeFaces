package ogs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

}
