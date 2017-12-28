package time;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by hzlaojiaqi on 2017/12/27.
 */
public class TimeClassVisitor extends ClassVisitor{
    public TimeClassVisitor() {
        super(Opcodes.ASM6);
    }

    public TimeClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM6, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if(mv!=null && !name.equals("<init>")){
            mv=new TimeMethodVisitor(mv);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        cv.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC,"timer","J",null,null);
        cv.visitEnd();
    }
}
