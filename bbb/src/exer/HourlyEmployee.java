package exer;

public class HourlyEmployee extends Employee {
    private int wage;//每小时
    private int hour;//月工作时间数


    public HourlyEmployee(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    public HourlyEmployee(String name, int number, MyDate birthday, int wage,int hour) {
        super(name, number, birthday);
        this.hour=hour;
        this.wage=wage;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{"+super.toString()+"}";
    }
}
