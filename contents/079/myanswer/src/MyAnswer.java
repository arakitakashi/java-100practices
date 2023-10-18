import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;

import java.util.List;

public class MyAnswer {
    public static void main(String[] args) {
        List<FileSource> sources = List.of(
                new URLFileSource("http://example.com/folder/file.png"),
                new LocalFileSource("C:\\temp\\test.txt"),
                new UNCFileSource("\\\\host\\public\\file.html")
        );
        FileFetcher.fetchFiles(sources, "C:\\destination");
    }
}
