package backupcompressed.domain.backup.repository;

import backupcompressed.domain.__shared.valueobject.File;

import java.util.List;

public interface BackupRepository {
  List<File> getFiles(Integer quantityFiles);
}
