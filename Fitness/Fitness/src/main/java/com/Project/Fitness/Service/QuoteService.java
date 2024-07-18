package com.Project.Fitness.Service;

import com.Project.Fitness.DAO.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class QuoteService {

    @Autowired
    QuoteDao quoteDao;

    public ResponseEntity<String> getQuote() {
        try{
            String day = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
             String quote = quoteDao.getQuote(day);
             return new ResponseEntity<>(quote, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
