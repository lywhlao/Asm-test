import java.lang.instrument.Instrumentation;

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
    public static void agentmain(String args, Instrumentation ins){
        ins.addTransformer(new Transformer());
        instrumentation=ins;
    }

    public static void initialize() {
        if (instrumentation == null) {
            MyJavaAgentLoader.loadAgent();
        }
    }
}
