package org.voco.crud;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.voco.crud.user.User;
import org.voco.crud.user.UserRepository;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setFirstName("erki");
        user.setLastName("allekõrs");
        user.setEmail("erki@alle.com");
        user.setPassword("password123");

        User savedUser = repo.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = repo.findAll();
        assertThat(users).hasSizeGreaterThan(0);

        for ( User user : users ) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("password321");
        repo.save(user);

        User updatedUser = repo.findById(userId).get();
        assertThat(updatedUser.getPassword()).isEqualTo("password321");
    }

    @Test
    public void testGet() {
        Integer userId = 2;
        Optional<User> optionalUser = repo.findById(userId);
        assertThat(optionalUser.isPresent()).isTrue();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        assertThat(optionalUser.isPresent()).isFalse();
    }
}
