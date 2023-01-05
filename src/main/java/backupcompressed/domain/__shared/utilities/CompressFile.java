package backupcompressed.domain.__shared.utilities;

import backupcompressed.domain.__shared.valueobject.File;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompressFile {
  public static ByteArrayOutputStream zipCompact(List<File> files) throws IOException {
    var compressedFile = new ByteArrayOutputStream();
    var zipOutputStream = new ZipOutputStream(compressedFile);
    for (var file : files) {
      addEntry(zipOutputStream, file);
    }
    zipOutputStream.close();
    return compressedFile;
  }

  private static void addEntry(ZipOutputStream zipOutputStream, File file) throws IOException {
    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
    zipOutputStream.write(file.getContent().readAllBytes());
    zipOutputStream.closeEntry();
  }
}
