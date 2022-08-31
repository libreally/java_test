package exect.domain;

import exect.service.Status;

import java.awt.*;

public class Programmer extends Employee {
    private int memberId;//团队ID
    private Status status=Status.FREE;
    private Equipment equipment;

    public Programmer(){
        super();
    }

    public Programmer(int ID, String name, int age, double salary, Equipment equipment) {
        super(ID, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getDetailsForTeam(){
        return memberId+"\t"+getID()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员\t";
    }
    @Override
    public String toString() {
        return getDetails()+"\t程序员\t"+status+"\t\t\t\t\t"+equipment.getDescription();
    }
}
