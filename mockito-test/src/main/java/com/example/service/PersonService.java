package com.example.service;

import com.example.dao.PersonDao;
import com.example.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : PersonService
 * @Description : PersonService
 * @Author : Mr.zh
 * @Date: 2020-08-13 20:30
 */
@Service
public class PersonService {

    @Resource
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int id,String name){
        Person person = personDao.getPerson(id);
        if (null == person){
            return false;
        }
        Person personUpdate = new Person(person.getId(), name);
        return personDao.update(personUpdate);
    }

    public Person query(int id) {
        return personDao.getPerson(id);
    }
}
