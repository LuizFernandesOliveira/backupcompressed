package backupcompressed.infrastructure.database;

import backupcompressed.domain.backup.repository.BackupRepository;
import backupcompressed.domain.__shared.valueobject.File;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class BackupRepositoryImpl implements BackupRepository {
  public List<File> getFiles(Integer quantityFiles) {
    var files = new ArrayList<File>();
    for (int i = 0; i < quantityFiles; i++) {
      files.add(File.builder()
          .name("file" + i + ".pdf")
          .content(new ByteArrayInputStream(new byte[]{(byte) i}))
          .build());
    }
    return files;
  }
}
