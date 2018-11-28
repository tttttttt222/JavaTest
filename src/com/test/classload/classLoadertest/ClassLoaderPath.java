package com.test.classload.classLoadertest;

/**
 * 项目名称:testProject 描述: 创建人:ryw 创建时间:2018/11/22
 */
public class ClassLoaderPath {


    public static void main2(String[] args) {

        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));
    }


    public static void main(String[] args) {

        ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());
        System.out.println("ClassLoader is:"+cl.getParent().toString());
//
//        ClassLoader icl = int.class.getClassLoader();
//
//        System.out.println("ClassLoader is:"+icl.toString());
    }

}
