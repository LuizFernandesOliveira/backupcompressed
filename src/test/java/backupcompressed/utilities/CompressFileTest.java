package backupcompressed.utilities;

import backupcompressed.domain.__shared.utilities.CompressFile;
import backupcompressed.domain.__shared.valueobject.File;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompressFileTest {

  @Test
  void ZipCompact() {
    var file = buildFile();

    assertDoesNotThrow(() -> {
      var compressedFile = CompressFile.zipCompact(List.of(file));

      assertTrue(compressedFile.toByteArray().length > 0);
    });
  }

  private File buildFile() {
    return File.builder()
      .name("File Name")
      .content(new ByteArrayInputStream(new byte[]{1, 2, 3}))
      .build();
  }
}