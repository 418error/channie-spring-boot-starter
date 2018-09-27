package uk.co.channie;

import uk.co.channie.store.MessageStore;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("uk.co.channie.controller")
@ConditionalOnWebApplication
public class ChannieAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "channie", name = "message", havingValue = "rude")
    public MessageStore rudeMessage() {
        return new MessageStore("You smell of cheese!");
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "channie", name = "message", havingValue = "nice")
    public MessageStore niceMessage() {
        return new MessageStore("You're looking sharp today");
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageStore defaultMessage() {
      return new MessageStore("Hello world!");
  }
}
