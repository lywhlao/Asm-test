import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * Created by hzlaojiaqi on 2017/12/13.
 */
public class AgentMain {
    private static Instrumentation instrumentation;

    /**
     * 可以再main方法执行前或者执行后任意时间点调用
     * @param args
     * @param ins
     */
    public static void agentmain(String args, Instrumentation ins) throws UnmodifiableClassException {
        Class[] allLoadedClasses = ins.getAllLoadedClasses();
        for(Class<?> temp:allLoadedClasses){
            if(temp.getName().equals("TestClass1")){
                System.out.println(">>>apply transformer");
                ins.addTransformer(new Transformer(),true);
                ins.retransformClasses(temp);
            }
        }
        instrumentation=ins;
    }

    public static void initialize() {
        if (instrumentation == null) {
            MyJavaAgentLoader.loadAgent();
        }
    }
}
