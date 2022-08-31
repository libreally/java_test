package exect.domain;

public class Architect extends Designer{
    private int stock;//公司奖励的股票数量

    public Architect() {
    }

    public Architect(int ID, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(ID, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam(){
        return getMemberId()+"\t"+getID()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师\t"+getBonus()+"\t"+getStock();
    }
    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();

    }
}
