import java.util.ArrayList;

/**
 * Static class
 */
public class FullTable {
    static void scanEqual(int key){
        Stopwatch stopwatch = new Stopwatch();
        ArrayList<Record> out = new ArrayList<>();
        Block b;
        for (int i = 1; i < 100; i++) {
            b = new Block("src/Project2Dataset/F" + i + ".txt");
            for (Record record : b.records) {
                if (record.v == key) {
                    out.add(record);
                }
            }
        }
        System.out.print("Full Table equality Scan took ");
        stopwatch.elapsed();
        System.out.println(out.size() + " blocks were scanned");

        for (Record record : out) {
            System.out.println(record.content);
        }
    }

    static void scanNotEq(int key){
        int numScan = 0;
        Stopwatch stop = new Stopwatch();
        ArrayList<Record> out = new ArrayList<>();
        Block b;
        for (int i = 1; i < 100; i++) {
            b = new Block("src/Project2Dataset/F" + i + ".txt");
            numScan++;
            for (Record record : b.records) {
                if (record.v != key) {
                    out.add(record);
                }
            }
        }
        System.out.print("Full Table inequality Scan took ");
        stop.elapsed();
        System.out.println(numScan + " blocks were scanned");

        for (Record record : out) {
            System.out.println(record.content);
        }
    }

    static void scanRange(int lo, int hi){
        int numScan = 0;
        Stopwatch stop = new Stopwatch();
        ArrayList<Record> out = new ArrayList<>();
        Block b;
        for (int i = 1; i < 100; i++) {
            b = new Block("src/Project2Dataset/F" + i + ".txt");
            numScan++;
            for (Record record : b.records) {
                if (record.v > lo && record.v < hi) {
                    out.add(record);
                }
            }
        }
        System.out.print("Full Table range Scan took ");
        stop.elapsed();
        System.out.println(numScan + " blocks were scanned");

        for (Record record : out) {
            System.out.println(record.content);
        }
    }
}
