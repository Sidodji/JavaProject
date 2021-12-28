package project;


import project.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    public void existsUserByLogin() {
        try {
            Assert.assertTrue(userService.existsUserByLogin("Chelovek"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void existsUserByLoginAndPassword() {
        try {
            Assert.assertTrue(userService.existsUserByLoginAndPassword("User","User"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
