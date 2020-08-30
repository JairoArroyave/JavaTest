package com.example.java.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    @GetMapping("/test")
    public String greeting() {

        String cadena = "Hola () ";
        Stack stack = new Stack();
        for(char c : cadena.toCharArray()) {
            if(c == '{' || c =='('){
                stack.push(c);
            }
            if(c == ')'){
                 if (stack.peek().equals('(')){
                     stack.pop();
                 }
            }
            if(c == '}'){
                if (stack.peek().equals('}')){
                    stack.pop();
                }
            }
        }
        if(stack.size()==0){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }




        return "Hello World";
    }
}