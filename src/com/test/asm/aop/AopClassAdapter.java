package com.test.asm.aop;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/3/28
 */
public class AopClassAdapter extends ClassVisitor implements Opcodes {


    public AopClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }


    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        //更改类名，并使新类继承原有的类。
        super.visit(version, access, "TestBean_Tmp", signature, name, interfaces);
        {
            MethodVisitor mv = super.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, name, "<init>", "()V",false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if ("<init>".equals(name))
            return null;
        if (!name.equals("halloAop"))
            return null;
        //
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return new AopMethod(this.api, mv);
    }



    class AopMethod extends MethodVisitor implements Opcodes {
        public AopMethod(int api, MethodVisitor mv) {
            super(api, mv);
        }

        public void visitCode() {
            super.visitCode();
            this.visitMethodInsn(INVOKESTATIC, "com/test/asm/aop/AopInterceptor", "beforeInvoke", "()V",false);
        }

        public void visitInsn(int opcode) {
            if (opcode == RETURN) {
                mv.visitMethodInsn(INVOKESTATIC, "com/test/asm/aop/AopInterceptor", "afterInvoke", "()V",false);
            }
            super.visitInsn(opcode);
        }
    }
}


