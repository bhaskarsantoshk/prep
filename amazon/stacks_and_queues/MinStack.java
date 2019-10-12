package amazon.stacks_and_queues;

public class MinStack {
    private LinkedList top = null;
    public MinStack(){

    }
    public void push(int x) {
        LinkedList newTop = new LinkedList(x);
        if ( top == null ){
            top = newTop;
        }
        else{
            newTop.minSoFar = Math.min(x, top.minSoFar);
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
        return top == null ? -1: top.val;
    }

    public int getMin() {
        return top == null ? -1 : top.minSoFar;
    }

    class LinkedList{
        int val;
        LinkedList next;
        int minSoFar;
        LinkedList( int val){
            this.val = val;
            this.minSoFar = val;
        }
    }
}
