import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String progRegex = "\\w+=(?<locpd>\\d+),\\w+=(?<yoe>\\d+),\\w+=(?<iq>\\d+)";
    private final Pattern progPat = Pattern.compile(progRegex);

    public Programmer(String personText) {
        super(personText);
        String details = peopleMat.group("details");
        Matcher progMat = progPat.matcher(details);

        if (progMat.find()) {
            linesOfCode = Integer.parseInt(progMat.group("locpd"));
            yearsOfExp = Integer.parseInt(progMat.group("yoe"));
            iq = Integer.parseInt(progMat.group("iq"));
        }
    }

    public int getSalary() {
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

}
