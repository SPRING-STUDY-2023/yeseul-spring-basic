package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello") //{HTTP Method}Mapping -> 여기서는 GET 메소드에 매핑하는 컨트롤러 선언
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; //resources:templates/ +{ViewName}+ .html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
