package gc;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GcLoopTest {
    public static void main(String[] args) throws Exception {

//        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
//        JMXConnector connect = JMXConnectorFactory.connect(jmxServiceURL, null);
//        MBeanServerConnection mbsc = connect.getMBeanServerConnection();

        doHeapWarmUp();
    }

    private static void doHeapWarmUp() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        Runtime runtime = Runtime.getRuntime();
        long beforeUsedMem, afterUsedMem;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(true) {
            threadPoolExecutor.execute(GcLoopTest::runA);
            threadPoolExecutor.execute(GcLoopTest::runB);
            threadPoolExecutor.execute(GcLoopTest::runB);
            threadPoolExecutor.execute(GcLoopTest::runB);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void runB() {
        for (int i = 0; i < 1000; i++) {
            // Create a large object to trigger memory allocation
            ArrayList<byte[]> arrayList = new ArrayList();
            byte[] b = new byte[1048576];
            arrayList.add(b);
            // Suggest the JVM to run garbage collection

            // Optional: Check memory usage before and after GC


            // Optional: Pause to give GC time to run (not guaranteed)
            try {
                Thread.sleep(50);  // Adjust the sleep time if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static void runA() {
        ArrayList<byte[]> survivorList = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            // Create a large object to trigger memory allocation
            byte[] b = new byte[1048576];
            survivorList.add(b);
            // Suggest the JVM to run garbage collection

            // Optional: Check memory usage before and after GC


            // Optional: Pause to give GC time to run (not guaranteed)
            try {
                Thread.sleep(50);  // Adjust the sleep time if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
