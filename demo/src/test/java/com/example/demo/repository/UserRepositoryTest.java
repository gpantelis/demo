package com.example.demo.repository;

import com.example.demo.models.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    // after each test delete everything
    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindUserByEmail() {

        // given
        String email = "george@gmail.com";
        User user = new User(
                "George",
                25,
                email
        );
        underTest.save(user);

        // when
        Optional<User> user_returned = underTest.findUserByEmail(email);
        boolean expected = (user_returned.isPresent());

        // then
        assertThat(expected).isTrue();

    }

    // We use H2 database bcs we dont want to play with our main db (postgres)
    @Test
    void itShouldNotFindUserByEmail() {

        // given
        String email = "george@gmail.com";

        // when
        Optional<User> user_returned = underTest.findUserByEmail(email);
        boolean expected = (user_returned.isPresent());

        // then
        assertThat(expected).isFalse();

    }





}