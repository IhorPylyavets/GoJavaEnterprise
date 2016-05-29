package com.goit.collections.common;

import java.io.*;

public class FileWriterDemo {
    public FileWriterDemo() {
    }

    public void writeDataToFile(String outFile, String resultData) throws IOException {
        byte[] data = resultData.getBytes("UTF-8");

        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));

            for (int i = 0; i < data.length; i++) {
                out.write(data[i]);
            }

            out.close();


        } catch (EOFException e) {
            System.out.println("Reached enf of file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
