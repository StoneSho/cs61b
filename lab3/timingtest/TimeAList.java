package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        AList<Integer> test = new AList<Integer>();
        int temp = 1000;
        while(temp<=128000){
            Ns.addLast(temp);  //将1000，2000，4000，8000，16000，32000，64000添加到最后一位，对应编号为0，1，2，3...
            opCounts.addLast(temp);  //同理
            temp=temp*2;
        }

        for(int i=0;i<Ns.size();i++){
            int N=Ns.get(i);  //读取试验次数
            Stopwatch sw = new Stopwatch();
            int j=0;
            for(;j<N;j++){  //算运行时间
                test.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();  //读取addLast函数运行N次得时间
            times.addLast(timeInSeconds);  //将运行时间存入times
        }
        printTimingTable(Ns,times,opCounts);
    }
}
