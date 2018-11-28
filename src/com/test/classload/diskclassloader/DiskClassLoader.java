package com.test.classload.diskclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/11/23
 */
public class DiskClassLoader extends ClassLoader {

    private String mLibPath;

    public DiskClassLoader(String path) {
        mLibPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(mLibPath, fileName);

        try {
            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int len = 0;
            while ((len = fis.read()) != -1) {
                bos.write(len);
            }

            byte[] bytes = bos.toByteArray();
            fis.close();
            bos.close();

            return defineClass(name, bytes, 0, bytes.length);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

//    private String getFileName(String name) {
//        name = name.replace(".", "\\");
//        int index = name.lastIndexOf('\\');
//        if (index == -1) {
//            return name + ".class";
//        } else {
//            return name + ".class";
//        }
//    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

}
