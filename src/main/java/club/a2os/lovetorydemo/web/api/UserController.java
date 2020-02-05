package club.a2os.lovetorydemo.web.api;

import club.a2os.lovetorydemo.entity.User;
import club.a2os.lovetorydemo.service.UserService;
import club.a2os.lovetorydemo.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arcosx
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  User findUserById(@PathVariable String userId) {
    return userService.findUserById(userId);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  User CreateUser(@RequestBody UserDTO userDTO) {
    return userService.createUser(userDTO.getName());
  }
}
