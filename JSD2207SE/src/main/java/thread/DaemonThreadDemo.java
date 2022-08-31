package thread;

/**
 * 守护线程
 * 守护线程是通过线程的方法setDaemon(boolean on)传入参数true将一个普通线程设置而转变
 * 的。
 * 守护线程有一点是与普通线程不同的，就是进程的结束。
 * 当java进程中所有的普通线程都退出时，java进程就会退出，此时会杀死所有还在运行的守护线程
 *
 * 守护线程适合运行那些我们不关心结束时机的任务，只要主要任务都执行完毕它们可以跟着停下来
 * 时，这些任务就可以跑在守护线程上。最有代表性的就是GC，它就是跑在一个守护线程上的。
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for(int i=0;i<5;i++) {
                    System.out.println("rose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaa....");
                System.out.println("扑通");
            }
        };

        Thread jack = new Thread(){
            public void run(){
                while(true){
                    System.out.println("jack:you jump!i jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        rose.start();
        jack.setDaemon(true);//守护线程的设置必须在线程启动前进行
        jack.start();

//        while(true);//rose线程结束后如果主线程不结束，进程也不会结束，那么jack就不会被进程杀死
    }
}





