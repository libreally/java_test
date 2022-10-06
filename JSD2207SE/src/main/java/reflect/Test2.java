package reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 实例化与当前类Test2在同一个包中的所有类
 * 思路:
 * 1:首先定位Test2的字节码文件所在的目录(main方法里第一行代码)
 * 2:通过该目录获取里面所有的.class文件
 * 3:由于字节码文件名与类名一致(JAVA语法要求)，因此可以通过文件名确定类名
 * 4:使用Class.forName()加载对应的类并实例化
 *
 * 上述完成后，自动调用这些类中所有的无参且公开的方法(本类定义的方法)。
 *
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
            Test2.class.getResource(".").toURI()
        );
        System.out.println(dir);
        //添加过滤器获取该目录中的所有字节码文件
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for(File sub : subs){
            String fileName = sub.getName();
            String className = fileName.substring(0,fileName.lastIndexOf("."));
//            String className = fileName.replace(".class","");
            String packName = Test2.class.getPackage().getName();
            className = packName+"."+className;
            Class cls = Class.forName(className);
            Object obj = cls.newInstance();
            System.out.println(obj);

            Method[] methods = cls.getDeclaredMethods();
            for(Method method : methods){
                //判断是否为无参数方法
                if(method.getParameterCount()==0 &&
                        method.getModifiers()== Modifier.PUBLIC //是否为公开方法
                ){
                    System.out.println("调用方法:"+method.getName()+"()");
                    method.invoke(obj);
                }
            }

        }

    }
}
