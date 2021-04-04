package tugasprakw7;
import java.util.*;

public class user {
    private String nama;
    private ArrayList<user> friend;
    private ArrayList<user> noFriend;
    private ArrayList<user> incomingPending;
    private ArrayList<user> outgoingPending;
   
    user() {
        friend= new ArrayList<>();
        noFriend= new ArrayList<>();
        incomingPending= new ArrayList<>();
        outgoingPending= new ArrayList<>();
    }
    
    void setNama(String nama){this.nama= nama;}
    void setFriend(ArrayList friend) {this.friend= friend;}
    void setnoFriend(ArrayList noFriend) {this.noFriend= noFriend;} 
    void setIncoming(ArrayList incoming) {this.incomingPending= incomingPending;}
    void setOutgoing(ArrayList outgoing) {this.outgoingPending= outgoingPending;}

    String getNama() {return this.nama;}
    ArrayList getFriend() {return this.friend;}
    ArrayList getnoFriend() {return this.noFriend;}
    ArrayList getIncoming() {return this.incomingPending;}
    ArrayList getOutgoing() {return this.outgoingPending;}

    @Override
    public String toString() {
        return this.nama;
    }
}
