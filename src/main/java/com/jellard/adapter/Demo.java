package com.jellard.adapter;

class Demo {
    public static void main(String[] args) {
        final int num;
        num = 10;
        //num = 20;
        System.out.println(num);

        final Person p = new Person("张三",23);
        //无法为最终变量p分配值
        //p = new Person("李四",24);
        p.setName("李四");
        p.setAge(24);

        System.out.println(p.getName() + "..." + p.getAge());

        method(10);
        //弹栈消失了
        method(20);
    }

    //这么写也是可以的，只是开发中很少使用，意义不大
    public static void method(final int x) {
        System.out.println(x);
    }
}
/*
* A:案例演示
    * 方法内部或者方法声明上都演示一下(了解)

    * 基本类型，是值不能被改变
    * 引用类型，是地址值不能被改变,对象中的属性可以改变
*/

class Person {
    private String name;            //姓名
    private int age;                //年龄

    public Person(){}               //空参构造

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {  //设置姓名
        this.name = name;
    }

    public String getName() {       //获取姓名
        return name;
    }

    public void setAge(int age) {   //设置年龄
        this.age = age;
    }

    public int getAge() {           //获取年龄
        return age;
    }
}

