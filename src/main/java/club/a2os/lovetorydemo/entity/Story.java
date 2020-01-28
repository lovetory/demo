package club.a2os.lovetorydemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author arcosx
 */
@Data
@Document
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Story {

  @Id
  private String id;
  private String userId;
  private String content;
}
