package com.example.webtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
public class WebTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebTestApplication.class, args);
    }

    @RestController
    public class HelloWorldController {
        @RequestMapping("/")
        public String index() {
            return "<h1> blablabla </h1>";
        }
        @RequestMapping("/test")
        public String test(@RequestParam String name) {
            return "<h1> blablabla </h1>" + name;
        }
        @RequestMapping("/number")
        public String number() {

            return "<h1> Random number is: </h1>" +" "+ number();
        }
        @RequestMapping("/testluckyYou")
        public String luckyYou(@RequestParam String luckyYou,String firstname) {

            if(luckyYou.equals("animal") ){
                return firstname+"´s lyckodjur är: " +" "+ animal();
            }
            else if(luckyYou.equals("number") ){
                return firstname+"´s lyckonummer är: " +" "+ random();
            }else return "<h1> Try again </h1>";
        }
    }
        @RequestMapping("/testPath/{name}")
        public String testPath(@PathVariable String name) {
            return "<h1> blablabla </h1>" + name;
        }
        @RequestMapping("/list")
        public String list(@RequestParam List<String> names) {
            return "<h1> Lista med namn: </h1>" + " " + names;
        }
        /*@RequestMapping(value = {"/article", "/article/{id}"})
        public Article getArticle(@PathVariable Map<String, String> pathVarsMap) {
            String articleId = pathVarsMap.get("id");
            if (articleId != null) {
                Integer articleIdAsInt = Integer.valueOf(articleId);
                //...
            } else {
                //...
            }
        }*/

        public int random(){
            Random rand = new Random();
            int number=10;
            int random = rand.nextInt(number);

            return random;
        }
        public String animal(){
        Random rand = new Random();
        String[] animal={"hund", "katt", "spindel", "skata"};
        int randomAnimal=rand.nextInt(animal.length);


        return animal[randomAnimal];
    }


}
