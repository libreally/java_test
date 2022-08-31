package exect.view;

import exect.domain.Employee;
import exect.domain.Programmer;
import exect.service.NameListService;
import exect.service.TeamException;
import exect.service.TeamService;

public class TeamView {
    private NameListService listSvc=new NameListService();
    private  TeamService teamSvc=new TeamService();

    public void enterMainMenu(){
        boolean loopFlag=true;
        char menu=0;
       while (loopFlag){
           if (menu!='1'){
               listAllEmployees();
           }
           System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
            menu = TSUtility.readMenuSelection();
           switch (menu){
               case '1':
                   getTeam();
                   break;
               case '2':
                   addMember();
                   break;
               case '3':
                   deleteMember();
                   break;
               case '4':
                   System.out.println("是否退出（Y/N）:");
                   char isExit=TSUtility.readConfirmSelection();
                   if (isExit=='Y'){
                       loopFlag=false;
                   }
                   break;
           }
       }
    }
//显示所有员工信息
    private void listAllEmployees(){
        System.out.println("*********************************************开发团队调度软件*********************************************\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees==null || employees.length==0){
            System.out.println("公司没有任何员工");
        }else {
            System.out.println("ID\t 姓名\t 年龄\t 工资\t 职位\t 状态\t 奖金\t 股票\t 领用设备");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println("*******************************************************************************************************\n");
    }

    private void getTeam(){
        System.out.println("*******************************团队成员列表*******************************\n");

        Programmer[] team = teamSvc.getTeam();
        if (team==null || team.length==0){
            System.out.println("目前没有成员");
        }else {
            System.out.println("ID\t 姓名\t 年龄\t 工资\t 职位\t 状态\t 奖金\t 股票");
            for (Programmer programmer : team) {
                System.out.println(programmer.getDetailsForTeam());
            }
        }

        System.out.println("********************************************************************");
    }

    private void addMember(){
        System.out.println("********************************添加成员***************************");
        System.out.print("请输入要添加的员工ID:");
        int id=TSUtility.readInt();
        try {
            Employee emp=listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，"+e.getMessage());
        }
        TSUtility.readReturn();//按回车键继续。。。。
    }

    private void deleteMember(){
        System.out.println("********************************删除成员***************************");
        System.out.print("请输入要删除的员工ID:");
        int memberID=TSUtility.readInt();

        System.out.print("确认删除（Y/N）：");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete=='N'){
            return;
        }
        try {
            teamSvc.removeMember(memberID);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，"+e.getMessage());
        }

        TSUtility.readReturn();//按回车键继续。。。。
    }

    public static void main(String[] args) {
        TeamView teamView=new TeamView();
        teamView.enterMainMenu();

    }
}
