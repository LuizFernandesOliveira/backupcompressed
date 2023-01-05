package backupcompressed.application;

import backupcompressed.domain.backup.usecase.BackupUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/backup")
public class BackupController {
  private final BackupUseCase backupService;

  @PostMapping
  public ResponseEntity<byte[]> generate(@RequestParam Integer quantityFiles) {
    try {
      var backup = backupService.generate(quantityFiles);
      return ResponseEntity.ok(backup);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
