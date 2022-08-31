package exect.service;

import exect.domain.*;


import static exect.service.Data.*;

/**
 * 负责将data中的数据封装到employee【】数组中，同时提供相关的方法调动
 */
public class NameListService {
    private Employee[] employees;

    /**
     * 给数组及数组元素初始化
     */
    public NameListService(){
        employees =new Employee[EMPLOYEES.length];
        for (int i=0;i<employees.length;i++){
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取employee的4个基本信息
            int id=Integer.parseInt(EMPLOYEES[i][1]);
            String name= EMPLOYEES[i][2];
            int age=Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE -> employees[i] = new Employee(id, name, age, salary);
                case PROGRAMMER -> {
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                }
                case DESIGNER -> {
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                }
                case ARCHITECT -> {
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                }
            }
        }
    }

    /**
     * 获取指定index位置上的员工的设备
     */
    private Equipment creatEquipment(int index) {
        int key=Integer.parseInt(EQIPMENTS[index][0]);
        String modelORname=EQIPMENTS[index][1];
        switch (key) {
            case PC -> {
                String display = EQIPMENTS[index][2];
                return new PC(modelORname, display);
            }
            case NOTEBOOK -> {
                double price = Double.parseDouble(EQIPMENTS[index][2]);
                return new NoteBook(modelORname, price);
            }
            case PRINTER -> {
                String type = EQIPMENTS[index][2];
                return new Printer(modelORname, type);
            }
        }
        return  null;
    }

    /**
     * 获取当前所有员工
     * @return employees
     */
    public Employee[] getAllEmployees(){

        return employees;
    }

    /**
     * 获取指定ID员工对象
     * @param id
     * @return employee
     */
    public Employee getEmployee(int id ) throws TeamException {
        for (Employee employee : employees) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        throw new TeamException("找不到指定员工");
    }

}
