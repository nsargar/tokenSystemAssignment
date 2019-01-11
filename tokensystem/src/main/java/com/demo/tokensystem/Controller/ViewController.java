package com.demo.tokensystem.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/tokengen")
    public String getHome(){

        return "tokengen";
    }

    @RequestMapping("/counter")
    public String getCounter(){

        return "counter";
    }

    @RequestMapping("/display")
    public String getDisplay(){

        return "display";
    }

}
