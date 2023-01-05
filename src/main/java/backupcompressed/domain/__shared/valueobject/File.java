package backupcompressed.domain.__shared.valueobject;

import lombok.Builder;
import lombok.Getter;

import java.io.ByteArrayInputStream;

@Builder
@Getter
public class File {
  private final String name;
  private final ByteArrayInputStream content;
  private String contentType;

  public int getSize() {
    return content.readAllBytes().length;
  }
}
