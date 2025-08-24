package Y2025M08;


public class P61 {

    static int[] fibo;

    public int dfs(int i) {
        if(fibo[i] != 0) return fibo[i];
        if(i==1) return fibo[i] = 1;
        else if (i==2) return fibo[i] = 1;
        else return fibo[i] = dfs(i - 1) + dfs(i - 2);
    }

    public static void main(String[] args) {
        P61 main = new P61();
        int n = 45;
        fibo = new int[n + 1];
        main.dfs(n);

        for (int i = 1; i <=n; i++) {
            System.out.println(fibo[i] + " ");
        }
    }

}
