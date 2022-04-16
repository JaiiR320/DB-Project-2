import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 * main class that runs the CLI
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashIndex table = new HashIndex();
        ArrayIndex array = new ArrayIndex();

        array.get(1, 10);

        table.get(100);

        FullTable.scanEqual(100);

        //FullTable.scanNotEq(100);

        FullTable.scanRange(1, 10);

        while(true){
            System.out.print("> ");
            String line = scan.nextLine();
            String[] com = line.split("\\ ");
            switch (com[0]) {
                case "quit":
                    scan.close();
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * Helper to convert form entry to actual record (essentially bring blocks in mem and scan blocks)
     * @param entry
     * @return
     */
    static String getRecord(Entry entry){
        int fileNum = Integer.valueOf(entry.id.substring(0, 2));
        int slot = Integer.valueOf(entry.id.substring(2, 5));
        Block b = new Block("src/Project2Dataset/F" + fileNum + ".txt");
        return b.getRecord(slot);
    }
}

