package Day4.NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

// two ways to get channel:
// 1. One way to obtain a channel is by calling getChannel( ) on an object that supports channels.
//          a. When called on a FileInputStream, FileOutputStream, or RandomAccessFile : getChannel( ) returns a channel of type FileChannel.
//          b. When called on a Socket (DatagramSocket, ServerSocket, Socket) :  getChannel( ) returns a SocketChannel.
// 2. Another way to obtain a channel is to use one of the static methods defined by the Files class.

//Channels such as FileChannel and SocketChannel support various read( ) and write( ) methods that enable you to perform I/O operations through the channel.

public class ChannelDemo {
    public static void main(String[] args) {
        try(
                ReadableByteChannel source = new FileInputStream("D:\\NIO_input.txt").getChannel();
                WritableByteChannel destination = new FileInputStream("D:\\NIO_output.txt").getChannel()
        ){
            copyData(source, destination);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException
    {
        ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);    // 1 MB
        while (src.read(buffer) != -1) {
            buffer.flip();  // flip() : first we read into a buffer, then we flip it and read from it.
            // keep sure that buffer was fully drained
            while (buffer.hasRemaining())
            {
                dest.write(buffer);
            }
            buffer.clear(); // Now the buffer is empty, ready for the filling
        }
    }
}
