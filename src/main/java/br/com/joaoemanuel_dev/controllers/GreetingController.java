package br.com.joaoemanuel_dev.controllers;

import br.com.joaoemanuel_dev.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!"; // string modelo
    private final AtomicLong counter = new AtomicLong(); // contador que aumenta automaticamente

    @RequestMapping("/greeting")
    public Greeting greeting( // parâmetros para serem usados na construção do objeto
            @RequestParam(value = "name",defaultValue = "Word")
            String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}


