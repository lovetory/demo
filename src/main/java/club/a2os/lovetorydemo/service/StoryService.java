package club.a2os.lovetorydemo.service;

import club.a2os.lovetorydemo.entity.Story;
import java.util.List;

/**
 * @author arcosx
 */
public interface StoryService {

  Story findStoryById(String id);

  List<Story> findStoriesByUserId(String userId);

  Story createStory(String userId, String content);

  void deleteStoryById(String id);
}
