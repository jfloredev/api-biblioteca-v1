package com.jfloresdev.apibibliotecav1.controller;

import com.jfloresdev.apibibliotecav1.ApiBibliotecaV1Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

   @GetMapping
    public String demo(){
       return "Hello World";
   }

   @GetMapping("/v2")
    public String demo2() {
       return "Hello World 2";
   }
}
