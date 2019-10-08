package com.udemy.rest.webservicescourse.theEmperor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PraiseTheEmperorController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping(path = "/praiseTheEmperor")
  public String praiseTheEmperor(){
    return "The Emperor Protects";
  }

  @GetMapping(path = "/praiseTheEmperor/{name}")
  public PraiseTheEmperorBean praiseTheEmperor(@PathVariable String name){
    return new PraiseTheEmperorBean(String.format("Praise the Emperor, %s", name));
  }

  @GetMapping(path = "/praiseTheEmperorBean")
  public PraiseTheEmperorBean praiseTheEmperorBean(){
    return new PraiseTheEmperorBean("Praise the Emperor");
  }

  @GetMapping(path = "/praiseTheEmperor-internationalized")
  public String praiseTheEmperorInternationalized() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }

}
