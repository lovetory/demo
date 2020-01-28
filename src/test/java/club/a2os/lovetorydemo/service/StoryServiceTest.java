package club.a2os.lovetorydemo.service;

import club.a2os.lovetorydemo.entity.Story;
import club.a2os.lovetorydemo.web.dto.StoryDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoryServiceTest {

  @Autowired
  private StoryService storyService;

  @Test
  void StoryCRUD() {
    // create
    StoryDTO storyDTO = new StoryDTO("5e300a79257ae63dba873ef8", "user content");
    Story story = storyService.createStory(storyDTO.getUserId(), storyDTO.getContent());
    assert story.getUserId().equals("5e300a79257ae63dba873ef8");
    assert story.getContent().equals("user content");
    String storyId = story.getId();
    // find by id
    Story storyFindById = storyService.findStoryById(storyId);
    // find by userId
    List<Story> storiesByUserIdFindByUserId = storyService
        .findStoriesByUserId("5e300a79257ae63dba873ef8");
    assert storyFindById.getContent().equals("user content");
    assert storiesByUserIdFindByUserId.get(0).getContent().equals("user content");
    // delete by id
    storyService.deleteStoryById(storyId);
    // find by id
    Story storyFindByIdAfterDelete = storyService.findStoryById(storyId);
    assert storyFindByIdAfterDelete == null;
  }
}