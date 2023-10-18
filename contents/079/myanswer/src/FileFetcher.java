import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;

import java.util.List;

public class FileFetcher {
    public static void fetchFiles(List<FileSource> sources, String destFolder) {
        for (FileSource source : sources) {
            try {
                source.fetchFile(destFolder);
            } catch (IOException e) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(new File(destFolder, "error.txt"), true))) {
                    writer.println("Failed to fetch: " + e.getMessage());
                } catch (IOException ex) {
                    System.err.println("Error writing to error.txt: " + ex.getMessage());
                }
            }
        }
    }
}
