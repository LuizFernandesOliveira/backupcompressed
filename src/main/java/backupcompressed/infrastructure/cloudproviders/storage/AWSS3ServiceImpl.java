package backupcompressed.infrastructure.cloudproviders.storage;

import backupcompressed.domain.__shared.service.AWSS3Service;
import backupcompressed.domain.__shared.valueobject.File;
import backupcompressed.infrastructure.configuration.AWSS3Config;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AWSS3ServiceImpl implements AWSS3Service {
  public static final String EMPTY_FILE = "O arquivo está vazio.";

  private final AmazonS3 amazonS3;
  private final AWSS3Config config;

  public void upload(final File file) {
    if (file.getSize() == 0) throw new IllegalArgumentException(EMPTY_FILE);

    final var metaData = new ObjectMetadata();
    metaData.setContentType(file.getContentType());
    metaData.setContentLength(file.getSize());

    var object = new PutObjectRequest(config.getBucket(), file.getName(), file.getContent(), metaData);
    amazonS3.putObject(object);
  }
}
