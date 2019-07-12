
package com.sg.hellosecurity.dao;

import com.sg.hellosecurity.entity.Role;
import java.util.List;

/**
 *
 * @author SMD3
 */
public interface RoleDao {
Role getRoleById(int id);
    Role getRoleByRole(String role);
    List<Role> getAllRoles();
    void deleteRole(int id);
    void updateRole(Role role);
    Role createRole(Role role);    
}
