package service.file;

import java.io.BufferedInputStream;

/**
 * Created by akhil on 25/6/14.
 */
public class ManagedIOStream {
    private BufferedInputStream stream;

    public BufferedInputStream getStream() {
        return stream;
    }

    public void dispose() {
        stream.close();
    }
}
