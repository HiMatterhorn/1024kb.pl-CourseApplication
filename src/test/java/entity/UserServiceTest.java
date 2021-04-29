package entity;

import org.junit.Assert;
import org.junit.Test;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

 /*   @Test
    public void testGetAllUsers() {
        //given
        List<User> users = new ArrayList<User>();
        users.add(new User(1l, "Tomasz","Ciapek"));
        users.add(new User(2l,"Matylda","Wołow"));

        //when
        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        //then
        Assert.assertEquals(users,usersFromTestClass);
    }

    @Test
    public void testAddUser (){
        //given
        List<User> users = new ArrayList<User>();
        User userSample = new User (1l,"Maciej","Pipja");
        users.add(userSample);

        //when
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(userSample);
        List<User> usersFromTestClass = userService.getAllUsers();

        //then
        Assert.assertEquals(users,usersFromTestClass);
    }

    @Test
    public void testRemoveUser () {
        //given
        List<User> users = new ArrayList<User>();
        User user1 = new User (1l,"Ryszard","Nowacki");
        User user2 = new User (2l,"admin","admin");
        users.add(user1);
        users.add(user2);

        //when
        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(2l);
        users.remove(user2);
        List<User> usersFromTestClass = userService.getAllUsers();

        //then
        Assert.assertEquals(users, usersFromTestClass);
    }*/
}
