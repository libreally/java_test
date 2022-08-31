package exect.service;

/**
 * 员工状态
 */
public class Status {
    private final String NAME;

    public static final Status FREE=new Status("FREE");
    public static final Status BUSY=new Status("BUSY");
    public static final Status VOCATIOM=new Status("VOCATION");

    private Status(String name){
        this.NAME=name;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
