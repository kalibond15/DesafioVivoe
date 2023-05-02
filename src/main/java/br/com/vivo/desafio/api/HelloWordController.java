package br.com.vivo.desafio.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/helloWord")
    @ResponseBody
    public String getHelloWord(){
        return "hello word";
    }
}
