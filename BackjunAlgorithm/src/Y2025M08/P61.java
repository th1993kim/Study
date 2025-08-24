package Y2025M08;


public class P61 {


    public int dfs(int i) {
        if(i==1) return 1;
        else if (i==2) return 1;
        else return dfs(i - 1) + dfs(i - 2);
    }

    public static void main(String[] args) {
        P61 main = new P61();
        int n = 7;
        for (int i = 1; i <= n; i++) {
            System.out.print(main.dfs(i) + " ");
        }
    }

}
