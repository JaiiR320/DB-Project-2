/**
 * F01-Rec001, Name001, address001, 4037...
 * easier to integer.valueof later
 * helper for block class
 */
public class Record {
    String content;
    String file; //[1, 2]
    String slot; //[7, 9]
    String name; //[12, 18]
    String address; //[21, 30]
    int v; //[33, 36]

    Record(String c){
        this.content = c;
        this.file = c.substring(1, 3);
        this.slot = c.substring(7, 10);
        this.name = c.substring(12, 19);
        this.address = c.substring(21, 31);
        this.v = Integer.valueOf(c.substring(33, 37));
    }
}
