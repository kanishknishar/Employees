import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee {
    private int projectCount;

    private final String analystRegex = "\\w+=(?<projectCount>\\d+)";
    private final Pattern analystPat = Pattern.compile(analystRegex);

    public Analyst(String personText) {
        super(personText);

        String details = peopleMat.group("details");
        Matcher analystMat = analystPat.matcher(details);

        if (analystMat.find()) {
            projectCount = Integer.parseInt(analystMat.group("projectCount"));
        }
    }

    public int getSalary() {
        return 2500 + projectCount * 2;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}
