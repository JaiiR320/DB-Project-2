import java.util.Scanner;

/**
 * Main
 * main class that runs the CLI
 * CREATE INDEX ON Project2Dataset (RandomV)
 * SELECT * FROM Project2Dataset WHERE RandomV = v (7)
 * SELECT * FROM Project2Dataset WHERE RandomV > v1 AND RandomV < v2 (7, 11)
 * SELECT * FROM Project2Dataset WHERE RandomV != v (7)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashIndex table = new HashIndex();
        ArrayIndex array = new ArrayIndex();

        boolean indexed = false;
        while(true){
            System.out.print("> ");
            String line = scan.nextLine();
            String[] com = line.split("\\ ");
            if(line.equals("CREATE INDEX ON Project2Dataset (RandomV)")){
                System.out.println("The hash-based and array-based indexes are built successfully.\nProgram is ready and waiting for user command.");
                indexed = true;
            }
            if(com[0].equals("SELECT")){
                if (com[6].equals("=")) {
                    if (indexed) {
                        table.get(Integer.valueOf(com[7]));
                    } else {
                        FullTable.scanEqual(Integer.valueOf(com[7]));
                    }
                } else if (com[6].equals(">")) {
                    if (indexed) {
                        array.get(Integer.valueOf(com[7]), Integer.valueOf(com[11]));
                    } else {
                        FullTable.scanRange(Integer.valueOf(com[7]), Integer.valueOf(com[11]));
                    }
                } else if (com[6].equals("!=")){
                    FullTable.scanNotEq(Integer.valueOf(com[7]));
                }
            }
            if(com[0].equals("quit")) return;
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

