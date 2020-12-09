package com.user.api.repository;

import com.user.api.model.Role;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> getRoleByRoleName(Role.RoleName roleName);
}
