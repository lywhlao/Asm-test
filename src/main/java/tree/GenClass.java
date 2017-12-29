package tree;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * Created by hzlaojiaqi on 2017/12/29.
 */
public class GenClass {

    public void init(){

        ClassNode classNode=new ClassNode();
        classNode.version= Opcodes.V1_8;

    }
}
