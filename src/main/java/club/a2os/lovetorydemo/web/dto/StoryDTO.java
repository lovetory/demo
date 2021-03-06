package club.a2os.lovetorydemo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author arcosx
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoryDTO {

  private String userId;
  private String content;
}
