package ejercicio08;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamWout extends ObjectOutputStream {

    public ObjectOutputStreamWout(OutputStream out) throws IOException {
        super(out);
    }

    public void writeStreamHeader() throws IOException {

    }

}
