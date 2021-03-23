package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Profile("test")
@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private static final String template1 = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Value("${my.name: default value}")
  private String nam;

  @GetMapping("/greeting")
  public Greeting greeting() {
    return new Greeting(counter.incrementAndGet(), String.format(template, nam));
  }
}