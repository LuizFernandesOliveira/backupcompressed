package backupcompressed.infrastructure.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AWSS3Bean {
  private final AWSS3Config config;

  public AWSStaticCredentialsProvider credentials() {
    var basicCredentials = new BasicAWSCredentials(config.getAccessKey(), config.getSecretKey());
    return new AWSStaticCredentialsProvider(basicCredentials);
  }

  @Bean
  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder
        .standard()
        .withCredentials(credentials())
        .withRegion(config.getRegion())
        .build();
  }
}
