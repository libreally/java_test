package com.atguigu.spring.pojo;

/**
 * bean的生命周期
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String age;

    public User() {
        System.out.println("实例化");
    }

    public User(Integer id, String name, String password, String age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id)
    {
        System.out.println("依赖注入");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void initMethod(){
        System.out.println("初始化");
    }

    public void destroyMethod(){
        System.out.println("销毁");
    }
}
