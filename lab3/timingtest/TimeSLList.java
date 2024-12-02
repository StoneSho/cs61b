package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int temp = 1000;
        while(temp<=128000){
            Ns.addLast(temp); //存储添加的数
            temp=temp*2;
        }

        for(int i=0;i<Ns.size();i++){
            int N = Ns.get(i);
            int j=0;
            SLList<Integer> test = new SLList<>();
            for(;j<N;j++){
                test.addLast(j);  //添加N项
            }
            Stopwatch sw = new Stopwatch();
            int k=0;
            for(;k<10000;k++){
                test.getLast();  //读取10000次最后一个
            }
            times.addLast(sw.elapsedTime());//将运行时间存入times
            opCounts.addLast(10000);
        }
        printTimingTable(Ns,times,opCounts);
    }

}
