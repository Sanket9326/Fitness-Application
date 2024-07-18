package com.Project.Fitness.Controller;

import com.Project.Fitness.Service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

@RestController
@RequestMapping("quote")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("get")
    public ResponseEntity<String> getQuote(){
       return quoteService.getQuote();
    }

}
