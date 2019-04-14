package interviews.google;

/**
 * https://www.interviewbit.com/problems/edit-distance/
 */
public class MinOperationsInStringChange {

    public int minDistance(String A, String B) {
        int m = A.length()+1;
        int n = B.length()+1;
        int [][] db = new int [m][n];
        for(int i=0;i<m;i++){
            db[i][0] = i;
        }
        for(int j=0;j<n;j++){
            db[0][j] = j;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    db[i][j]=db[i-1][j-1];
                }else{
                    db[i][j]=Math.min(Math.min(db[i-1][j]+1, db[i][j-1]+1), db[i-1][j-1]+1);
                }
            }
        }
        for (int[] ints : db) {
            for (int anInt : ints) {
                System.out.print(anInt +" ");
            }
            System.out.println();
        }
        return db[m-1][n-1];
    }


    public static void main(String[] args) {
        new MinOperationsInStringChange().minDistance("anura", "ra");
    }
}
