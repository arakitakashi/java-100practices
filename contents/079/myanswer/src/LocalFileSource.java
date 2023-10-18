import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;

import java.util.List;

class LocalFileSource implements FileSource {
    private final String sourcePath;

    public LocalFileSource(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Override
    public void fetchFile(String destFolder) throws IOException {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destFolder, sourceFile.getName());
        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
