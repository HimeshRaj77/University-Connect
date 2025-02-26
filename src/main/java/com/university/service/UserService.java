package com.university.service;

import com.university.model.User;
import com.university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Save a new user.
     *
     * @param user The user to save.
     * @return The saved user.
     */
    public User saveUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Find all users with a specific role.
     *
     * @param role The role to search for (e.g., "STUDENT", "ALUMNI", "ADMIN").
     * @return A list of users with the specified role.
     */
    public List<User> findUsersByRole(String role) {
        return userRepository.findByRolesContaining(role);
    }

    /**
     * Delete a user by ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Find a user by username.
     *
     * @param username The username to search for.
     * @return The user if found, or null otherwise.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    /**
     * Check if a username already exists.
     *
     * @param username The username to check.
     * @return True if the username exists, false otherwise.
     */
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * Register a new student.
     *
     * @param username The student's username.
     * @param password The student's password.
     * @return The registered student.
     */
    public User registerStudent(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of("STUDENT")); // Assign STUDENT role
        return userRepository.save(user);
    }

    /**
     * Register a new alumni.
     *
     * @param username The alumni's username.
     * @param password The alumni's password.
     * @return The registered alumni.
     */
    public User registerAlumni(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of("ALUMNI")); // Assign ALUMNI role
        return userRepository.save(user);
    }

    /**
     * Register a new admin.
     *
     * @param username The admin's username.
     * @param password The admin's password.
     * @return The registered admin.
     */
    public User registerAdmin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of("ADMIN")); // Assign ADMIN role
        return userRepository.save(user);
    }
}