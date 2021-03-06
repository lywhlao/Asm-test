import com.sun.tools.attach.VirtualMachine;

import java.lang.management.ManagementFactory;

/**
 * Created by hzlaojiaqi on 2017/12/13.
 */
public class MyJavaAgentLoader {


    //TODO 修改路径
//    private static final String jarFilePath = "C:\\Users\\hzlaojiaqi\\Desktop\\activity-project\\Asm-test\\target\\asm-test-1.0-SNAPSHOT-jar-with-dependencies.jar";
    private static final String jarFilePath2 = "/Users/laojiaqi/IdeaProjects/Asm-test/target/asm-test-1.0-SNAPSHOT-jar-with-dependencies.jar";

    public static void loadAgent() {
        System.out.println(">>>loadAgent");
        String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        int p = nameOfRunningVM.indexOf('@');
        String pid = nameOfRunningVM.substring(0, p);
        try {
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(jarFilePath2, "");
            vm.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
