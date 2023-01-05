package backupcompressed.domain.__shared.service;

import backupcompressed.domain.__shared.valueobject.File;

public interface AWSS3Service {
  void upload(final File file);
}
