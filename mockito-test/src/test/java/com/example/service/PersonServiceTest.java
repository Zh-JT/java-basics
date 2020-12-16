package com.example.service;


import com.example.dao.PersonDao;
import com.example.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * @ClassName : PersonServiceTest
 * @Description :
 * @Author : Mr.zh
 * @Date: 2020-08-13 20:35
 */
public class PersonServiceTest {

    @Mock
    private PersonDao mockDao;

    private PersonService personService;

   /* @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1,"Person1"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);
        personService = new PersonService(mockDao);
    }*/


    @Test
    public void update() {
        boolean result = personService.update(2, "new name");
        assertFalse("must true",result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao,times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));

    }

    @Test
    public void testUpdateNotFind() {
        boolean result = personService.update(2, "new name");
        assertFalse("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
    }

}
