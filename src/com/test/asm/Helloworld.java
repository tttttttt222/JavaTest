package com.test.asm;

import com.sun.org.apache.bcel.internal.generic.INVOKESTATIC;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.lang.reflect.Method;


/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/21
 */
public class Helloworld extends ClassLoader{

    public static void main(String[] args) throws Exception{
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // 创建一个 MethodWriter
        cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, "Example", null, "java/lang/Object", null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();


        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "sayHello", "()V", null, null);
        mv.visitCode();
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("hello world\uff01");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 2);
        mv.visitEnd();


        cw.visitEnd();

        byte[] bytes = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream("Example.class");
        //写文件
        fos.write(bytes);
        //关闭输出流 fos.close();
        //实例化刚刚生成的类
        Helloworld loader = new Helloworld();
        Class exampleClass = loader.defineClass("Example", bytes, 0, bytes.length);
        Object o = exampleClass.newInstance();
        // 使用动态生成的类打印 Helloworld
        Method m = exampleClass.getMethod("sayHello",null);
        m.invoke(o);


    }
}
