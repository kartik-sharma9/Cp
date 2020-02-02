public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] arr) {
        boolean[] bool = new boolean[arr.length];
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++){
                if(!bool[i]) {
                    if (arr[i][0] >= arr[j][0])
                        if (arr[i][1] >= arr[j][1]) {
                            bool[i] = Boolean.TRUE;
                        }
                }
                if(!bool[j])
                    if(arr[i][0]<=arr[j][0])
                        if(arr[i][1]<=arr[j][1]){
                            bool[j]=Boolean.TRUE;
                        }



            }

        int count=0;
        for(int i=0;i<bool.length;i++)
            if(bool[i])
                count++;

        return count==0?bool.length:count;
    }

    public static void main(String args[]){
        RussianDollEnvelopes env = new RussianDollEnvelopes();
        System.out.println(env.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}
