package com.se.dp.prototype.clone;

import java.util.List;

public class People implements Cloneable {
    private String name;
    private int age;


    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 不实现cloneable就会抛出异常
     * @param args
     */
    public static void main(String[] args) {
        People people=new People("DMS",11);
        try {
            People clone = (People) people.clone();
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不重载外部就无法访问
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}
