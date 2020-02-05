package club.a2os.lovetorydemo.service;

import club.a2os.lovetorydemo.entity.User;

/**
 * @author arcosx
 */
public interface UserService {

  User findUserById(String id);

  User createUser(String name);
}
