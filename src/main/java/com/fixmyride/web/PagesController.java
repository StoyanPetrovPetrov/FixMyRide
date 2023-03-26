package com.fixmyride.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

  @GetMapping("/")
  public String home() {
    return "index";
  }

  @GetMapping("/pages/all")
  public String all() {
    return "all";
  }

  @GetMapping("/pages/admins")
  public String admins() {
    return "admins";
  }

  @GetMapping("/pages/moderators")
  public String moderators() {
    return "moderators";
  }

  @GetMapping("/pages/history")
  public String history(){
    return "history";
  }

  @GetMapping("/pages/appointment")
  public String appointment(){
    return "appointment";
  }

  @GetMapping("/pages/mechanic")
  public String mechanic(){
    return "mechanic";
  }

  @GetMapping("/pages/vehicles")
  public String vehicles(){
    return "vehicles";
  }

}
