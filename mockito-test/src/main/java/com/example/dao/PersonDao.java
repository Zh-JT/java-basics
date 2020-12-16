package com.example.dao;

import com.example.entity.Person;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : PersonDao
 * @Description : dao层
 * @Author : Mr.zh
 * @Date: 2020-08-13 20:29
 */
@Repository
public interface PersonDao {

    @Select("select * from person where id = #{id}")
    Person getPerson(int id);

    @Update(" UPDATE person SET name=#{name} WHERE id=#{id}")
    boolean update(Person person);
}
