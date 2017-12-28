package time;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;

/**
 * Created by hzlaojiaqi on 2017/12/27.
 */
public class TimeMethodVisitor extends MethodVisitor {

    public TimeMethodVisitor() {
        super(Opcodes.ASM6);
    }

    public TimeMethodVisitor( MethodVisitor mv) {
        super(Opcodes.ASM6, mv);
    }

    @Override
    public void visitCode() {
        mv.visitCode();
        mv.visitFieldInsn(GETSTATIC, "time/TestTime", "timer", "J");
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
        mv.visitInsn(LSUB);
        mv.visitFieldInsn(PUTSTATIC, "time/TestTime", "timer", "J");
    }

    @Override
    public void visitInsn(int opcode) {
       if((opcode>=Opcodes.IRETURN && opcode <=RETURN)||opcode==ATHROW){
           mv.visitFieldInsn(GETSTATIC, "time/TestTime", "timer", "J");
           mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
           mv.visitInsn(LADD);
           mv.visitFieldInsn(PUTSTATIC, "time/TestTime", "timer", "J");
           mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
           mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
           mv.visitInsn(DUP);
           mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
           mv.visitLdcInsn("time is-->");
           mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
           mv.visitFieldInsn(GETSTATIC, "time/TestTime", "timer", "J");
           mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
           mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
           mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
        mv.visitInsn(opcode);
    }
}


