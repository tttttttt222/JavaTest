package com.test.asm.asmexample;

import org.objectweb.asm.*;

import java.io.IOException;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/28
 */
public class ClassReaderExample {
    private static class MyClassVisitor extends ClassVisitor {


        public MyClassVisitor(int api) {
            super(api);
        }

        public MyClassVisitor(int api, ClassVisitor cv) {
            super(api, cv);
        }

        @Override
        public void visit(int version, int access, String name,
                          String signature, String superName, String[] interfaces) {
            System.out.println("class name:" + name);
            System.out.println("super class name:" + superName);
            System.out.println("class version:" + version);
            System.out.println("class access:" + access);
            System.out.println("class signature:" + signature);
            if (interfaces != null && interfaces.length > 0) {
                for (String str : interfaces) {
                    System.out.println("implemented interface name:" + str);
                }
            }
        }


        @Override
        public void visitSource(String source, String debug) {

        }


        @Override
        public void visitOuterClass(String owner, String name, String desc) {

        }


        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return null;

        }


        @Override
        public void visitAttribute(Attribute attr) {


        }


        @Override
        public void visitInnerClass(String name, String outerName,
                                    String innerName, int access) {

        }


        @Override


        public FieldVisitor visitField(int access, String name, String desc,
                                       String signature, Object value) {
            return null;

        }


        @Override
        public MethodVisitor visitMethod(int access, String name, String desc,
                                         String signature, String[] exceptions) {
            return null;

        }


        @Override
        public void visitEnd() {


        }

    }


    public static void main(String args[]) throws IOException {
        ClassReader classReader = new ClassReader("java.lang.String");
        classReader.accept(new MyClassVisitor(Opcodes.ASM6), 0);
        System.out.println(classReader);
    }
}
