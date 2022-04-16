public class Stopwatch {
    long start;
    Stopwatch(){
        start = System.currentTimeMillis();
    }
    void elapsed(){
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
