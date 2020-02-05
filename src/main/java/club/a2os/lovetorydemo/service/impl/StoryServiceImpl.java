package club.a2os.lovetorydemo.service.impl;

import club.a2os.lovetorydemo.dao.StoryRepository;
import club.a2os.lovetorydemo.entity.Story;
import club.a2os.lovetorydemo.service.StoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arcosx
 */
@Service
public class StoryServiceImpl implements StoryService {

  @Autowired
  private StoryRepository storyRepository;

  @Override
  public Story findStoryById(String id) {
    Story story = storyRepository.findById(id).orElse(null);
    return story;
  }

  @Override
  public List<Story> findStoriesByUserId(String userId) {
    List<Story> stories = storyRepository.findStoriesByUserId(userId);
    return stories;
  }

  @Override
  public Story createStory(String userId, String content) {
    Story story = Story.builder().userId(userId).content(content).build();
    return storyRepository.save(story);
  }

  @Override
  public void deleteStoryById(String id) {
    storyRepository.deleteById(id);
  }
}
