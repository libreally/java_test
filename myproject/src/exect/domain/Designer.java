package exect.domain;

public class Designer extends Programmer{
    private double bonus;//奖金

    public Designer() {
    }

    public Designer(int ID, String name, int age, double salary, Equipment equipment, double bonus) {
        super(ID, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getDetailsForTeam(){
        return getMemberId()+"\t"+getID()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t设计师\t"+getBonus();
    }
    @Override
    public String toString() {
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t\t"+getEquipment().getDescription();
    }
}
