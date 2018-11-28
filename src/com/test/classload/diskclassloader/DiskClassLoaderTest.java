package com.test.classload.diskclassloader;

import java.lang.reflect.Method;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/11/23
 */
public class DiskClassLoaderTest {



    public static void main(String[] args) {

        //创建自定义classloader对象。
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");

        try {
            Class c = diskLoader.loadClass("com.test.Test2");

            if (c != null) {
                Object o = c.newInstance();
                Method method = c.getDeclaredMethod("say", null);
                method.invoke(o, null);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
