package backupcompressed.infrastructure.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AWSS3Config {
  @Value("${cloud-providers.aws.credentials.access-key}")
  private String accessKey;

  @Value("${cloud-providers.aws.credentials.secret-key}")
  private String secretKey;

  @Value("${cloud-providers.aws.region}")
  private String region;

  @Value("${cloud-providers.aws.s3.bucket}")
  private String bucket;
}
