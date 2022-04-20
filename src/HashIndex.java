import java.util.ArrayList;

/**
 * Hash Table
 * Auto initializes the 100 files with N buckets
 */
public class HashIndex {
    private int N = 50;
    ArrayList<ArrayList<Entry>> buckets = new ArrayList<>(this.N);
    
    HashIndex(){
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

    void put(int key, String rid){
        buckets.get(hash(key)).add(new Entry(key, rid));
    }

    void get(int key){ // check next elements
        Stopwatch stop = new Stopwatch();
        ArrayList<Entry> out = new ArrayList<>();
        ArrayList<Entry> t = buckets.get(hash(key));
        for (Entry e : t) {
            if (e.key == key) {
                out.add(e);
            }
        }
        System.out.print("Hash Index equality scan took ");
        stop.elapsed();
        System.out.println(out.size() + " blocks were scanned");
        
        for (Entry entry : out) {
            System.out.println(Main.getRecord(entry));
        }
    }

    private int hash(int k){
        return k % N;
    }
}
