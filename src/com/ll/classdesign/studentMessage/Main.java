package com.ll.classdesign.studentMessage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StdList stdList = new StdList();
        System.out.println("添加几条记录......");
        stdList.add(new Student("1","Zhangsan",99));
        stdList.add(new Student("2","Lisi",76));
        stdList.add(new Student("3","Alice",81));
        stdList.add(new Student("4","Bob",62));
        System.out.println("添加成功!");

        System.out.println("==============逐条查询所有记录============");
        List<Student> all = stdList.getAll();
        all.forEach(a-> System.out.println(a.toString()));

        System.out.println("===========根据学生姓名获得学生信息========");
        Student zhangsan = stdList.findStudentBySName("Bob");
        System.out.println("=========根据学生所在位置获得学生信息： ===");
        stdList.getStudentByPosition(3);
        System.out.println("==========向学生链表中2位置插入一条记录=======");
        stdList.insertStudent(new Student("5","Candy",92), 2);

        System.out.println("===========逐条查询所有学生信息============");
        all = stdList.getAll();
        all.forEach(a-> System.out.println(a.toString()));

        System.out.println("=========删除位置为1所在的学生信息==========");
        stdList.deleteStudentByPosition(1);
        all = stdList.getAll();
        all.forEach(a-> System.out.println(a.toString()));
        System.out.println("=================学生总人数================");
        System.out.println("学生信息表现在的学生个数为： "+ stdList.getSize());

    }
}

