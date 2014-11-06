package de.datepoller.services;

import de.datepoller.data.RoleRepository;
import de.datepoller.domain.Role;
import de.datepoller.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dsy on 06.11.14.
 */

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    Role findRoleByUsername(User user) {
        return roleRepository.findRoleByUser(user);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public void update(Role role) {
        roleRepository.save(role);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }

}
