package Day4.NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.Selector;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        // creating a selector
        Selector selector = Selector.open();
        ReadableByteChannel source = new FileInputStream("src\\NIO_input.txt").getChannel();

        // In order to use a Channel with a Selector you must register the Channel with the Selector


    }
}
