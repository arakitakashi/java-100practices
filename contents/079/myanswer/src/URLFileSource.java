import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;

import java.util.List;

class URLFileSource implements FileSource {
    private final String sourceUrl;

    public URLFileSource(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public void fetchFile(String destFolder) throws IOException {
        URL website = new URL(sourceUrl);
        try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
             FileOutputStream fos = new FileOutputStream(new File(destFolder, new File(sourceUrl).getName()))) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}
