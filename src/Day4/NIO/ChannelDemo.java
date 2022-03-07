package Day4.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

// two ways to get channel:
// 1. One way to obtain a channel is by calling getChannel( ) on an object that supports channels.
//          a. When called on a FileInputStream, FileOutputStream, or RandomAccessFile : getChannel( ) returns a channel of type FileChannel.
//          b. When called on a Socket (DatagramSocket, ServerSocket, Socket) :  getChannel( ) returns a SocketChannel.
// 2. Another way to obtain a channel is to use one of the static methods defined by the Files class.

//Channels such as FileChannel and SocketChannel support various read( ) and write( ) methods that enable you to perform I/O operations through the channel.

public class ChannelDemo {
    public static void main(String[] args) {
        ChannelDemo.channelDemo1();
        ChannelDemo.readDemo();
    }

    // reads from a file and writes to output file.
    static void channelDemo1(){
        try(
                ReadableByteChannel source = new FileInputStream("src\\NIO_input.txt").getChannel();
                WritableByteChannel destination = new FileOutputStream("src\\NIO_output.txt").getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);    // 1 MB
            while (source.read(buffer) != -1) {
                buffer.flip();  // flip() : first we read from source into a buffer, then we flip it and read from buffer.
                // keep sure that buffer was fully drained
                while (buffer.hasRemaining())
                {
                    destination.write(buffer);
                }
                buffer.clear(); // Now the buffer is empty, ready for the filling
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void readDemo(){
        int count;
        Path filePath= null;

        // 1. we try to get the path.
        try{
            filePath= Path.of("src\\NIO_input.txt");
        }catch (InvalidPathException e){
            System.out.println("Path error : " + e);
        }
        // 2. obtain a channel to that file with a try with resource block
        try(SeekableByteChannel channel = Files.newByteChannel(filePath)){
            // allocate a buffer
            ByteBuffer buffer = ByteBuffer.allocate(128);
            do{
                // read a buffer
                count = channel.read(buffer);
                // when reached end of stream count = -1
                if(count!=-1){
                    buffer.rewind();            // rewind the buffer so it can be read
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer.get());
                    }
                }
            }while (count!=-1);
        }catch (IOException e){
            System.out.println("I/O error : " + e);
        }
    }
}
