public interface IEmployee {
    int getSalary();
    default double getBonus() {
        return getSalary() * 1.10;
    }
}
