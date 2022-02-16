package com.example.demo.services;

import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

//    private AutoCloseable autoCloseable;
    private UserService underTest;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserService(userRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void getUsers() {
        // when
        underTest.getUsers();

        // then
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    void addNewUser() {
    }
    @Test

    void myTest() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());


        spyList.add("one");
        spyList.add("two");
        System.out.println(spyList.toString());

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");
        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());


    }

    @Test

    void myTest2() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        System.out.println(mockList.toString());


        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }

    @Test
    void myTest3() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        Mockito.verify(mockList).add(arg.capture());
//        System.out.println(arg.capture());
        assertEquals("one", arg.getValue());

    }
    @Test
    @Disabled
    void deleteUser() {
    }

    @Test
    @Disabled
    void updateUser() {
    }
}