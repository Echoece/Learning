package Day4.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuf = ByteBuffer.allocate(28);       //  allocation of ByteBuffer, with capacity of 28 bytes
        CharBuffer charBuf = CharBuffer.allocate(2048);     // allocation of CharBuffer, with space for 2048 characters

        // Reading Data from a buffer
        byte aByte = byteBuf.get();

        // Writing data to buffer
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        int bytesRead = inChannel.read(byteBuf); // read from source and write into buffer.
        byteBuf.put((byte) 122);                //  write into the buffer myself, there are many overloads of put, check docs.

        // flip(): switches a Buffer from writing mode to reading mode. Sets, limit = position and then position = 0
        charBuf.flip();

        // reading data from buffer
        int bytesWritten = inChannel.write(byteBuf);        // read from buffer and write into channel.
        byte aByte1 = byteBuf.get();                        // read from buffer myself

        // rewind() : sets position = 0, and limit unchanged. so we can re-read all data again.
        byteBuf.rewind();

        // clear() and compact() : Once reading is done, we can make the buffer ready for write again using clear() and compact().
        // If there is still unread data in the Buffer, and you want to read it later, but you need to do some writing first, call compact() instead of clear().

        // 1. compact(): copies all unread data to the beginning of the Buffer. Then it sets position to right after the last
        // unread element. The limit property is still set to capacity, just like clear() does. Now the Buffer is ready for writing, but you
        // will not overwrite the unread data.
        byteBuf.compact();

        // 2. clear():  the position is set back to 0 and the limit to capacity. In other words, the Buffer is cleared.If there is any
        // unread data in the Buffer when you call clear() that data will be "forgotten", meaning you no longer have any markers
        // telling what data has been read, and what has not been read.
        byteBuf.clear();

        // mark() and reset(): We can mark a given position in a Buffer by calling the Buffer.mark() method. You can then later
        // reset the position back to the marked position by calling the Buffer.reset() method.

        byteBuf.mark();
        //call buffer.get() a couple of times, e.g. during parsing.
        byteBuf.reset();  //set position back to mark.

        // equality:
        // equals() : Two buffers are equal if:
                                //They are of the same type (byte, char, int etc.)
                                //They have the same amount of remaining bytes, chars etc. in the buffer.
                                //All remaining bytes, chars etc. are equal.

        // compareTo(): The compareTo() method compares the remaining elements (bytes, chars etc.) of the two buffers, for use in e.g.
        // sorting routines. A buffer is considered "smaller" than another buffer if:
                                //The first element which is equal to the corresponding element in the other buffer, is smaller than that in the other buffer.
                                //All elements are equal, but the first buffer runs out of elements before the second buffer does (it has fewer elements).
    }
}
