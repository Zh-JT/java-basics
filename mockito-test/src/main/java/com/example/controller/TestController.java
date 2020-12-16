package com.example.controller;

import com.example.entity.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : TestController
 * @Description : 测试controller
 * @Author : Mr.zh
 * @Date: 2020-08-13 20:49
 */
@RestController
@RequestMapping("/testMockito")

public class TestController {

    @Autowired
    private PersonService personService;

    @PostMapping("update")
    public boolean updatePerson(@RequestBody Person person){
       return  personService.update(person.getId(),person.getName());
    }

    @PostMapping("query/{id}")
    public Person query(@PathVariable int id){
        return  personService.query(id);
    }


}
