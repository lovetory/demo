package club.a2os.lovetorydemo.dao;

import club.a2os.lovetorydemo.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author arcosx
 */
public interface UserRepository extends CrudRepository<User, String> {

}
