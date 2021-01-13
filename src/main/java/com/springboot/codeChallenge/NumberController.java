package com.springboot.codeChallenge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Logger;


@RestController
public class NumberController {
    private final static Logger log = Logger.getLogger(NumberController.class.getName());

    @Autowired(required=true)
    NumberRepository Repository;


    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> getPong() {
        return new ResponseEntity<>("Pong", HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    public ResponseEntity<Object> getPerfectNumbers() {
        return new ResponseEntity<>("Find all valid perfect numbers", HttpStatus.OK);
    }

    @RequestMapping(value = "/isPerfectNumber/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> isPerfect(@PathVariable("id") int id) {

        Boolean perfect = findPerfectNum(id, 0);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Your Answer is " + String.valueOf(perfect));
    }

    @RequestMapping(value = "/from/{startNumber}/to/{endNumber}", method = RequestMethod.GET)
    public ResponseEntity<Object> getNumberFromStartNumberToEndNumber(@PathVariable("endNumber") int endNumber, @PathVariable("startNumber") int startNumber) {

        ArrayList <Integer> numberBetween = findPerfectNumberBetween(startNumber, endNumber, 0, 0);

        return ResponseEntity.status(HttpStatus.OK)
        .body("Perfect Number lists : " + String.valueOf(numberBetween));
    }

    private boolean findPerfectNum(int Number, int Sum) {
        for (int i = 1; i < Number; i++) {
            if (Number % i == 0) {
                Sum = Sum + i;
            }
        }
        if (Sum == Number) {
            log.info("\n% d is a Perfect Number" + Number);
            return true;
        }else return false;
    }

    private ArrayList<Integer> findPerfectNumberBetween(int startNumber, int endNumber, int Number, int Sum) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int j = startNumber; j <= endNumber; j++) {
            Number = j;
            log.info("***************" + Number);

            if (findPerfectNum(Number, Sum) == true)
                result.add(Number);
            Sum = 0;
        }
        return result;
    }
}

