package exect.service;

import exect.domain.Architect;
import exect.domain.Designer;
import exect.domain.Employee;
import exect.domain.Programmer;

/**
 * 关于开发团队成员的管理添加删除
 */
public class TeamService {
    private static  int counter=1;//给memberld的团队成员自动增加id
    private static final int MAX_MEMBER=5;
    private Programmer[] team=new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//实际人数

    /**
     * 获取开发团队成员
     * @return
     */
    public Programmer[] getTeam(){
        Programmer[] team=new Programmer[total];
        for (int i=0;i<team.length;i++){
            team[i]=this.team[i];
        }
        return team;
    }

    /**
     * 添加指定成员到团队
     * @param e
     */
    public void addMember(Employee e)throws TeamException{
        //成员已满
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满");
        }
        //成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("成员不是开发人员，无法添加");
        }
        //成员已经在里面不可重复添加
        if (isExist(e)){
            throw new TeamException("成员已经在里面不可重复添加");
        }
        //已经是别的团队成员
        //在休假
        Programmer p= (Programmer) e;
        if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("已经是别的团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("休假中,无法添加");
        }
        /*团队中最多只能有一名架构师
        团队中最多只能有两名设计师
        团队中最多只能有三名程序员*/
        //获取各个职业的人数
        int numOfArch=0,numOfDes=0,numOfPro=0;
        for (int i=0;i<total;i++){
            if(team[i]instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }

        if (p instanceof Architect){
            if (numOfArch>=1){
                throw new TeamException("团队中最多只能有一名架构师");
            }
        }else if (p instanceof Designer){
            if (numOfDes>=2){
                throw new TeamException("团队中最多只能有两名设计师");
            }
        }else if (p instanceof Programmer){
            if (numOfPro>=3){
                throw new TeamException("团队中只能有三个程序员");
            }
        }

        //将p添加到team中
        team[total++]=p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i=0;i<total;i++){
            if(team[i].getID()==e.getID()){
                return true;
            }
        }
        return false;
    }

    /**
     * 从团队删除指定成员
     */
    public void removeMember(int memberId) throws TeamException{
        int i=0;
        for (;i<total;i++){
            if (team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到
        if (i==total){
            throw new TeamException("找不到指定memberID的员工，删除失败");
        }
        //后面的元素覆盖前面的元素
        for (int j=i+1;j<total;j++){
            team[j-1]=team[j];
        }
        team[--total]=null;

    }
}
