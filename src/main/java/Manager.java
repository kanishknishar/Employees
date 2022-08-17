import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {
    private int orgSize;
    private int directReports;

    private final String mgrRegex = "\\w+=(?<orgSize>\\d+),\\w+=(?<dr>\\d+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);

    protected Manager(String personText) {
        super(personText);
        String details = peopleMat.group("details");
        Matcher mgrMat = mgrPat.matcher(details);

        if (mgrMat.find()) {
            orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            directReports = Integer.parseInt(mgrMat.group("dr"));
        }
    }

    public int getSalary() {
        return 3500 + orgSize * directReports;
    }

    public int getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(int orgSize) {
        this.orgSize = orgSize;
    }

    public int getDirectReports() {
        return directReports;
    }

    public void setDirectReports(int directReports) {
        this.directReports = directReports;
    }
}