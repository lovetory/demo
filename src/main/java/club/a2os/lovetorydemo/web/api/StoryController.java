package club.a2os.lovetorydemo.web.api;

import club.a2os.lovetorydemo.entity.Story;
import club.a2os.lovetorydemo.service.StoryService;
import club.a2os.lovetorydemo.web.dto.StoryDTO;
import java.util.List;
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
@RequestMapping("/story")
public class StoryController {

  @Autowired
  private StoryService storyService;

  @RequestMapping(value = "/{storyId}", method = RequestMethod.GET)
  Story findStoryById(@PathVariable String storyId) {
    return storyService.findStoryById(storyId);
  }

  @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
  List<Story> findStoriesByUserId(@PathVariable String userId) {
    return storyService.findStoriesByUserId(userId);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  Story createStory(@RequestBody StoryDTO storyDTO) {
    return storyService.createStory(storyDTO.getUserId(), storyDTO.getContent());
  }

}
