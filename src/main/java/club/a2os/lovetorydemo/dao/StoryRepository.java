package club.a2os.lovetorydemo.dao;

import club.a2os.lovetorydemo.entity.Story;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author arcosx
 */
public interface StoryRepository extends CrudRepository<Story, String> {

  List<Story> findStoriesByUserId(String userId);
}
