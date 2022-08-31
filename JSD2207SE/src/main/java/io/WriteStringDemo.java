package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 向文件中写入文本数据
 */
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.txt中写入文本数据
        /*
            文件流的构造器
            FileOutputStream(String filename)
            FileOutputStream(File file)
            以上两个构造器创建文件流时,为"覆盖模式".
            特点:
            如果指定的文件不存在会自动创建.但是如果文件存在,会将该文件数据全部清除,
            然后将通过这个流写出的数据全部保留在文件中.

            追加模式:
            FileOutputStream(String filename,boolean append)
            FileOutputStream(File file,boolean append)
            上述构造器如果第二个参数传入的值为true,则文件流采取追加模式,特点:
            当文件存在,那么文件数据全部保留,新写入的数据会被追加到文件中.
         */
        FileOutputStream fos = new FileOutputStream("fos.txt",true);
//        String line = "还记得你说家是唯一的城堡,随着稻香河流继续奔跑.";
//
//            UTF-8 万国码
//            英文,数字,符号每个字符占1个字节
//            中文每个字符占3个字节
//            String自身提供了将字符串转换为一组字节的方法:getBytes()
//
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);
//        line = "微微笑,小时候的梦我知道.";
//        fos.write(line.getBytes(StandardCharsets.UTF_8));
        fos.write("爱你孤身走暗巷".getBytes(StandardCharsets.UTF_8));
        fos.write("爱你不跪的模样".getBytes(StandardCharsets.UTF_8));
        System.out.println("写出完毕");
        fos.close();
    }
}
