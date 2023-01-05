package backupcompressed.domain.backup.usecase;

import backupcompressed.domain.__shared.service.AWSS3Service;
import backupcompressed.domain.__shared.valueobject.File;
import backupcompressed.domain.backup.repository.BackupRepository;
import backupcompressed.domain.__shared.utilities.CompressFile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class BackupUseCase {
  private final BackupRepository backupRepository;
  private final AWSS3Service awsS3Service;

  public byte[] generate(Integer quantityFiles) throws IOException {
    var files = backupRepository.getFiles(quantityFiles);

    var zipFiles = CompressFile.zipCompact(files);

    var fileToUpload = File.builder()
        .name("backup.zip")
        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
        .content(new ByteArrayInputStream(zipFiles.toByteArray()))
        .build();

    awsS3Service.upload(fileToUpload);

    return zipFiles.toByteArray();
  }
}
