package com.se.dp.prototype.clone;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        People people=new People("DMS",11);
        People peopleCloned = (People) people.clone();
        System.out.println(people);
        System.out.println(peopleCloned);
        System.out.println("改变String");
        peopleCloned.setName("杜明松");
        System.out.println(people);
        System.out.println(peopleCloned);

    }

}
