package amazon.arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        for ( ArrayList<Integer> al: a){
            int start = 0;
            int end = al.size()-1;
            while(start < end ){
                int temp = al.get(start);
                al.set(start, al.get(end));
                al.set(end, temp);
                start++;
                end--;
            }
        }
    }

    private void transpose(ArrayList<ArrayList<Integer>> a) {
        for ( int i=0; i<a.size(); i++){
            for ( int j=0; j<i; j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int arr[][] = {{1,2}, {3,4}};
        for ( int i=0; i<arr.length; i++){
            a.add(new ArrayList<>());
            for ( int j=0; j< arr[0].length; j++){
                a.get(i).add(arr[i][j]);
            }
        }
        RotateMatrix obj = new RotateMatrix();
        obj.rotate(a);
        System.out.println(a);
    }

}
