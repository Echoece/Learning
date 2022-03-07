package Day4.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelToChannelDataTransfer {
    public static void main(String[] args) throws Exception {
        //Path of Input files
        String[] inputFiles = new String[]{"src\\Day4\\NIO\\input1.txt","src\\Day4\\NIO\\input2.txt","src\\Day4\\NIO\\input3.txt","src\\Day4\\NIO\\input4.txt"};
        //Path of Output file and contents will be written in this file
        String outputFile = "src\\Day4\\NIO\\combine_output.txt";

        //Acquired the channel for output file
        FileOutputStream output = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = output.getChannel();

        for (String s : inputFiles) {
            //Get the channel for input files
            FileInputStream input = new FileInputStream(s);
            FileChannel inputChannel = input.getChannel();

            //The data is tranfer from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close an input channel
            inputChannel.close();
            input.close();
        }

        //close the target channel
        targetChannel.close();
        output.close();
    }
}
