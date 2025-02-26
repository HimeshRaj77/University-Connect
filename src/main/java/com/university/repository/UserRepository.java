package com.university.repository;

import com.university.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by their username.
     *
     * @param username The username to search for.
     * @return An Optional containing the user if found, or empty otherwise.
     */
    Optional<User> findByUsername(String username);

    /**
     * Check if a user exists with the given username.
     *
     * @param username The username to check.
     * @return True if a user with the username exists, false otherwise.
     */
    boolean existsByUsername(String username);

    /**
     * Find users by their role.
     *
     * @param role The role to search for (e.g., "STUDENT", "ALUMNI", "ADMIN").
     * @return A list of users with the specified role.
     */
    List<User> findByRolesContaining(String role);
}