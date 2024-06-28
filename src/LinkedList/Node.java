package LinkedList;
import Business.Business;

public class Node{

    Node next;
    Business business;

    public Node (Business business){
        this.business= business;
        this.next = null;

    }

    public Business getBusiness() {
        return business;
    }
}