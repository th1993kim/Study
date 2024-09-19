package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalAngle = 0;
        int[] angles = new int[3];
        for(int i=0; i<angles.length; i++) {
            angles[i] = Integer.parseInt(br.readLine());
            totalAngle += angles[i];
        }

        if (totalAngle == 180) {
            if (angles[0] == 60 && angles[1] == 60 && angles[2] == 60) {
                System.out.println("Equilateral");
            } else if (angles[0] == angles[1] || angles[1] == angles[2] || angles[0] == angles[2]){
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}
