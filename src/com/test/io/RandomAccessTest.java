package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/9/21
 */
public class RandomAccessTest {

    public static void main2(String[] args) throws IOException {
        File file1 = new File("E:\\1.txt");
        File file2 = new File("E:\\2.txt");

        File file3 = new File("E:\\3.txt");

        InputStream inputStream = null;
        InputStream inputStream2 = null;
        RandomAccessFile raf1 = null;

        try {
            inputStream = new FileInputStream(file1);
            inputStream2 = new FileInputStream(file2);

            raf1 = new RandomAccessFile(file3, "rw");
            System.out.println(file1.length() + file2.length());
            raf1.setLength(file1.length() + file2.length());

            byte[] bytes = new byte[1024 * 8];
            int len = 0;

            while (((len = inputStream.read(bytes)) != -1)) {
                raf1.write(bytes, 0, len);
            }

            while (((len = inputStream2.read(bytes)) != -1)) {
                raf1.write(bytes, 0, len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                inputStream.close();
            }

            if(inputStream2 != null){
                inputStream2.close();
            }

            if (raf1 != null) {
                raf1.close();
            }
        }


    }



}
