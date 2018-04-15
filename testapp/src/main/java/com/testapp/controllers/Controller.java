package com.testapp.controllers;

import com.testapp.mappers.CatalogMapper;
import com.testapp.repositories.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.jdbc.core.JdbcTemplate;


@RestController
public class Controller {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @RequestMapping("/testapp")
  public String index() {
      return "Hello, world!";
  }

  @RequestMapping(value = "/testapp/refreshCatalog", method = RequestMethod.PUT)
  public String refreshCatalog() 
  {
    try
    {
      String sql = "DELETE FROM catalog";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (001, \'HP - Philosophers stone\', 10, 5.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (002, \'HP - Chamber of Secrets\', 10, 6.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (003, \'HP - Prisoner of Askaban\', 10, 7.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (004, \'HP - Goblet of Fire\', 10, 8.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (005, \'HP - Order of Pheonix\', 10, 9.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (006, \'HP - Half Blood Prince\', 10, 10.5 )";
      jdbcTemplate.execute(sql);

      sql = "insert into catalog values (007, \'HP - Deathly Hallows\', 10, 11.5 )";
      jdbcTemplate.execute(sql);
      
      return "{\"status\":\"success\"}";      
    }
    catch (Exception e)
    {
      return "{\"status\":\"failure "+ e.toString()+" \"}";
    }
  }

}
