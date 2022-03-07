package Day4.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class ScatterGatherDemo {
    public static void main(String[] args) throws IOException {
        String data = "Scattering and Gathering example";
        gatherWrite(data);
        scatteringRead();
    }

    static void gatherWrite(String data) throws IOException {
        ByteBuffer buffer1 = ByteBuffer.allocate(8);    //The First Buffer is used for holding a random number
        ByteBuffer buffer2 = ByteBuffer.allocate(400);  //The Second Buffer is used for holding a data that we want to write

        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);

        GatheringByteChannel gatherer = createChannelInstance("ScatterGather.txt", true); // creating Channel from FileOutputStream

        //Write the data into file
        try {
            gatherer.write(new ByteBuffer[] { buffer1, buffer2 });
        } catch (Exception e) {
            e.printStackTrace();
        }
        gatherer.close();
    }

    static void scatteringRead() throws IOException {

        ByteBuffer buffer1 = ByteBuffer.allocate(8);    //The First Buffer is used for holding a random number
        ByteBuffer buffer2 = ByteBuffer.allocate(400);  //The Second Buffer is used for holding a data that we want to write

        ScatteringByteChannel scatter = createChannelInstance("ScatterGather.txt", false);    // creating Channel from FileInputStream

        //Reading a data from the channel
        try {
            scatter.read(new ByteBuffer[] { buffer1, buffer2 });
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Read the two buffers separately
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();

        //Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);

        scatter.close();

    }

    public static FileChannel createChannelInstance(String file, boolean isOutput)
    {
        FileChannel FChannel = null;
        try {
            if (isOutput) {
                FChannel = new FileOutputStream(file).getChannel();
            } else {
                FChannel = new FileInputStream(file).getChannel();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return FChannel;
    }



}
