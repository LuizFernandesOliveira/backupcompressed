package backupcompressed.domain.backup.usecase;

import backupcompressed.domain.__shared.service.AWSS3Service;
import backupcompressed.domain.__shared.valueobject.File;
import backupcompressed.domain.backup.repository.BackupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BackupUseCaseTest {
  @Mock private BackupRepository backupRepository;
  @Mock private AWSS3Service awsS3Service;
  @InjectMocks private BackupUseCase useCase;

  @Test
  void generate() throws IOException {
    var quantityFiles = 1;
    var backup = useCase.generate(quantityFiles);

    assertTrue(backup.length > 0);

    then(backupRepository).should().getFiles(quantityFiles);
    then(awsS3Service).should().upload(any(File.class));
  }
}