package de.datepoller.data;

import de.datepoller.domain.Role;
import de.datepoller.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dsy on 06.11.14.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByUser(User user);
}
