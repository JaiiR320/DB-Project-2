import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to hold file information
 */
public class Block {
    private String content;
    ArrayList<Record> records = new ArrayList<>();

    Block(String fileName){
        try{
            File f = new File(fileName);
            Scanner scan = new Scanner(f);
            this.content = scan.nextLine();
            for (int i = 0; i < 100; i++) {
                records.add(new Record(getRecord(i+1)));
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    String getRecord(int slot){
        int offset = 40*(slot-1);
        return content.substring(offset, offset + 40);
    }
}
