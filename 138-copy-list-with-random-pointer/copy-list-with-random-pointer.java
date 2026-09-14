/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node h = new Node(head.val);
        Node t = h;
        Node temp = head;
        temp = temp.next;
        int c = 1;
        while(temp!=null){
            t.next = new Node(temp.val);
            t = t.next;
            temp = temp.next;
            c++;
        }
        temp = head;
        t = h;
        while(temp!=null){
            if(temp.random == null){
                t.random = null;
            }
            else{
                int a = e(temp.random);
                t.random = f(h, c-a);
            }
            temp = temp.next;
            t = t.next;
        }
        return h;
    }
    public int e(Node temp){
        int a = 0;
        while(temp!=null){
            a++;
            temp = temp.next;
        }
        return a;
    }
    public Node f(Node head,int n)
    {
        Node temp = head;
        while(n>0){
            temp = temp.next;
            n--;
        }
        return temp;
    }
}