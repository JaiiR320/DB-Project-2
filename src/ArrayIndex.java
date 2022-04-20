import java.util.ArrayList;

/**
 * ArrayIndex
 */
public class ArrayIndex {
    private int N = 5000;
    ArrayList<ArrayList<Entry>> buckets = new ArrayList<>(this.N);
    
    ArrayIndex(){
        for (int i = 0; i < this.N; i++) {
            buckets.add(new ArrayList<Entry>());
        }
        Block b;
        for (int i = 1; i < 100; i++) {
            b = new Block("src/Project2Dataset/F" + i + ".txt");
            for (Record record : b.records) {
                this.put(record.v, record.file + record.slot);
            }
        }
    }

    void put(int key, String id){
        this.buckets.get(key-1).add(new Entry(key, id));
    }

    void get(int low, int hi){ // check next elements
        Stopwatch stop = new Stopwatch();
        ArrayList<Entry> out = new ArrayList<>();
        for (int i = low+1; i < hi; i++) {
            ArrayList<Entry> t = buckets.get(i-1);
            for (Entry e : t) {
                out.add(e);
            }
        }
        System.out.print("Array Index range scan took ");
        stop.elapsed();
        System.out.println(out.size() + " blocks were scanned");

        for (Entry entry2 : out) {
            System.out.println(Main.getRecord(entry2));
        }

    }
}