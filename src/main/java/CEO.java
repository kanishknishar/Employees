import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements Flyer {
    private int avgStockPrice;

    private final String ceoRegex = "(?<avgStockPrice>\\d+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);
    public final Flyer flyer = new Pilot(15, true);

    public CEO(String personText) {
        super(personText);

        String details = peopleMat.group("details");
        Matcher ceoMat = ceoPat.matcher(details);

        if (ceoMat.find()) {
            avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
        }
    }

    public int getSalary() {
        return 5000 * avgStockPrice;
    }

    public void fly() {
        flyer.fly();
    }

    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }

    public int getAvgStockPrice() {
        return avgStockPrice;
    }

    public void setAvgStockPrice(int avgStockPrice) {
        this.avgStockPrice = avgStockPrice;
    }
}
