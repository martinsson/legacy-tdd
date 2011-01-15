package matchers.dojo;

import java.io.PrintWriter;

class CompressingPrintWriter extends PrintWriter {

    private final PrintWriter backingWriter;

    public CompressingPrintWriter(PrintWriter writerToForwardTo) {
        super(writerToForwardTo); // must do to avoid compilation error
        backingWriter = writerToForwardTo;
    }
    
    @Override
    public void write(String s) {
        backingWriter.write(s.replaceAll(" *", " "));
    }
    
}