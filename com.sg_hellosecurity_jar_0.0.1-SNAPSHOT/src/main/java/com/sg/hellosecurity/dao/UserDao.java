
package com.sg.hellosecurity.dao;

import com.sg.hellosecurity.entity.User;
import java.util.List;

/**
 *
 * @author SMD3
 */
public interface UserDao {
 User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
    User createUser(User user);    
}
