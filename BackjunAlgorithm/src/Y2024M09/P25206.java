package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25206 {

    public static void main(String[] args) throws IOException {

        double totalMultiScore = 0;
        double totalScore = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String project;
        while ((project = br.readLine()) != null && !project.isBlank()) {
            String[] projectSplit = project.split(" ");
            String gradeName = projectSplit[2];

            if (!"P".equals(gradeName)) {
                double score = Double.parseDouble(projectSplit[1]);
                totalScore += score;
                totalMultiScore += score * getGrades(gradeName);
            }
        }

        double result = 0.0;
        if (totalScore != 0.0) {
            result = totalMultiScore / totalScore;
        }
        System.out.println(result);
    }

    private static double getGrades(String gradeName) {
        switch (gradeName) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            default: return 0.0;
        }
    }
}
