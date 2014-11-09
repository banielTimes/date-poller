package de.datepoller.domain;

import java.util.*;

/**
 * Created by dsy on 08.11.14.
 */
public enum Role {
    USER(0, "User", "ROLE_USER"),
    ADMIN(1, "Admin", "ROLE_ADMIN"),
    CREATOR(2, "Creator", "ROLE_CREATOR");

    private final long id;
    private final String name;
    private final Set<String> authentications;

    private static Map<Long, Role> rolesMap = new HashMap<Long, Role>();

    static {
        for (Role role : EnumSet.allOf(Role.class)) {
            rolesMap.put(role.getId(), role);
        }
    }

    Role(long id, String name, String... authentications) {
        this.id = id;
        this.name = name;
        this.authentications = new HashSet<String>();

        for (String authentication : authentications) {
            this.authentications.add(authentication);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAuthentications() {
        return authentications;
    }
}
