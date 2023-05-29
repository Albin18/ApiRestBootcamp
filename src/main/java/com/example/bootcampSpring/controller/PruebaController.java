package com.example.bootcampSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {
    @GetMapping("/hola")
    public String holaMundo() {
        return "Hola Mundo";
    }

}
/**
    @GetMapping("/bootstrap")
        public String bootstrap() {
            return """
                    
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Prueba HTML en SpringFramework</title>
            </head>
            <body>
            <h1>Boton desde Spring</h1>
            <a class="btn btn-primary" href="http://www.google.com">Google</a>         
            \s
            </body>
            </html>

                   """;
        } **/

