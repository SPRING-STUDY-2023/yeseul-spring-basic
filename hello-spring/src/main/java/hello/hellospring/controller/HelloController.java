package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody
    public  String helloString(@RequestParam("name") String name) {
        return  "hello" + name; //"hello spring" -> view 없이 그냥 문자 그대로 클라단에 전달
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //JSON 방식으로 클라에게 return
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
           this.name = name;
        }
    }
}
