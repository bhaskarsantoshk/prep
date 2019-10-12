package leetcode;

public class P155MinStack {
    private LinkedList top = null;
    public P155MinStack() {

    }

    public void push(int x) {
        LinkedList newTop = new LinkedList(x);
        if ( top == null ){
            top = newTop;
        }
        else{
            newTop.minSoFar = Math.min ( x, top.minSoFar);
            newTop.next = top;
        }
        top = newTop;
    }

    public void pop() {
        if ( top == null ){
            return;
        }
        top = top.next;
    }

    public int top() {
        if ( top == null ){
            return -1;
        }
        return top.val;
    }

    public int getMin() {
        if ( top == null ){
            return -1;
        }
        return top.minSoFar;
    }

    class LinkedList{
        int val;
        int minSoFar ;
        LinkedList next;

        LinkedList ( int val){
            this.val = val;
            this.minSoFar = val;
        }
    }
}
