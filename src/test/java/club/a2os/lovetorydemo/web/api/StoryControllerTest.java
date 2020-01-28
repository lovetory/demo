package club.a2os.lovetorydemo.web.api;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import club.a2os.lovetorydemo.common.Util;
import club.a2os.lovetorydemo.entity.Story;
import club.a2os.lovetorydemo.service.StoryService;
import club.a2os.lovetorydemo.web.dto.StoryDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class StoryControllerTest {

  private MockMvc mockMvc;
  @Mock
  private StoryService storyService;
  @InjectMocks
  private StoryController storyController;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(storyController).build();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void findStoryById() throws Exception {
    Story story = new Story("5e301b228082ef6124457a6e", "5e300a79257ae63dba873ef8", "just test");
    when(storyService.findStoryById("5e301b228082ef6124457a6e")).thenReturn(story);
    mockMvc.perform(get("/story/{storyId}", "5e301b228082ef6124457a6e"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("5e301b228082ef6124457a6e"))
        .andExpect(jsonPath("$.userId").value("5e300a79257ae63dba873ef8"))
        .andExpect(jsonPath("$.content").value("just test"));
    verify(storyService, times(1)).findStoryById("5e301b228082ef6124457a6e");
    verifyNoMoreInteractions(storyService);

  }

  @Test
  void findStoriesByUserId() throws Exception {
    Story story1 = new Story("5e301b228082ef6124457a6e", "5e300a79257ae63dba873ef8",
        "user content 1");
    Story story2 = new Story("5e301b228082ef6124457a6d", "5e300a79257ae63dba873ef8",
        "user content 2");
    List<Story> stories = new ArrayList<>();
    stories.add(story1);
    stories.add(story2);
    when(storyService.findStoriesByUserId("5e300a79257ae63dba873ef8")).thenReturn(stories);
    mockMvc.perform(get("/story/user/{userId}", "5e300a79257ae63dba873ef8"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("5e301b228082ef6124457a6e"))
        .andExpect(jsonPath("$[0].userId").value("5e300a79257ae63dba873ef8"))
        .andExpect(jsonPath("$[0].content").value("user content 1"))
        .andExpect(jsonPath("$[1].id").value("5e301b228082ef6124457a6d"))
        .andExpect(jsonPath("$[1].userId").value("5e300a79257ae63dba873ef8"))
        .andExpect(jsonPath("$[1].content").value("user content 2"));
    verify(storyService, times(1)).findStoriesByUserId("5e300a79257ae63dba873ef8");
    verifyNoMoreInteractions(storyService);
  }

  @Test
  void createStory() throws Exception {
    Story story = new Story("5e301b228082ef6124457a6e", "5e300a79257ae63dba873ef8", "user content");
    StoryDTO storyDTO = new StoryDTO("5e300a79257ae63dba873ef8", "user content");
    when(storyService.createStory("5e300a79257ae63dba873ef8", "user content")).thenReturn(story);
    mockMvc.perform(post("/story/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(Util.asJsonString(storyDTO)))
        .andExpect(jsonPath("$.userId").value("5e300a79257ae63dba873ef8"))
        .andExpect(jsonPath("$.content").value("user content"));
    verify(storyService, times(1)).createStory(storyDTO.getUserId(), storyDTO.getContent());
    verifyNoMoreInteractions(storyService);
  }
}