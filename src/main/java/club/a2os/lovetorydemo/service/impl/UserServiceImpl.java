package club.a2os.lovetorydemo.service.impl;

import club.a2os.lovetorydemo.dao.UserRepository;
import club.a2os.lovetorydemo.entity.User;
import club.a2os.lovetorydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arcosx
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findUserById(String id) {
    User user = userRepository.findById(id).orElse(null);
    return user;
  }

  @Override
  public User createUser(String name) {
    User user = User.builder().name(name).build();
    return userRepository.save(user);
  }
}
