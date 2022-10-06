package reflect1;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 反射的动态性:运行时才知道具体的是谁
 */
public class TestReflection2 {
    @Test
    public void test() {
        int num = new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath="java.util.Date;";
                break;
            case 1:
                classPath="java.util.Random";
                break;
            case 2:
                classPath="java.io.File;";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个指定类的对象
     * @param classPath
     * @return
     * @throws Exception
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> cls=Class.forName(classPath);
        return cls.newInstance();
    }
}
