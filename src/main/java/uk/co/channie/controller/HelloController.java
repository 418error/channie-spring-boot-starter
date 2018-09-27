package uk.co.channie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.channie.store.MessageStore;

@RestController
public class HelloController {

  private final MessageStore messageStore;

  @Autowired
  public HelloController(final MessageStore messageStore) {
      this.messageStore = messageStore;
  }

  @RequestMapping("/some-message")
  public String message() {
      return messageStore.getMessage();
  }
  
}
