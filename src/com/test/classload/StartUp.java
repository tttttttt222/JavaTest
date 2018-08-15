package com.test.classload;

import java.lang.reflect.Method;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/6
 */
public class StartUp {


    public static void main(String[] args) throws ClassNotFoundException {
        int i = 0;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        while (true) {
            MyClassLoader myClassLoader = new MyClassLoader();
            System.out.println(myClassLoader.getParent());
            Class<?> personClass = myClassLoader.findClass("com.test.classload.Person");
            try {
                Object person = personClass.newInstance();
                Method sayHello = personClass.getMethod("sayHello");
                sayHello.invoke(person);
                System.out.println(++i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

        }

    }


}
