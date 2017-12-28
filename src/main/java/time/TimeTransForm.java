package time;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by hzlaojiaqi on 2017/12/27.
 */
public class TimeTransForm implements ClassFileTransformer{

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(!className.equals("time/TestOrigin")){
            return null;
        }
        ClassReader cr=new ClassReader(classfileBuffer);
        ClassWriter cw=new ClassWriter(cr,ClassWriter.COMPUTE_MAXS);
        TimeClassVisitor tcv=new TimeClassVisitor(cw);

        cr.accept(tcv,0);
        return cw.toByteArray();
    }
}
