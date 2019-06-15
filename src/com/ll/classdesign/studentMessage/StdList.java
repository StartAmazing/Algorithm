package com.ll.classdesign.studentMessage;

import java.util.ArrayList;
import java.util.List;

public class StdList {

    public int size;
    public SNode first;

    public class SNode{

        public Student student;
        public SNode next;

        public SNode(Student student){
            this.student = student;
            this.next = null;
        }
    }

    public StdList(){
        first = null;
        size = 0;
    }

    //添加学生
    public void add(Student student){
        if(first == null) {
            first = new SNode(student);
            this.size ++;
            return;
        }
        SNode cur = first;
        while(cur.next!=null){
            cur =cur.next;
        }
        cur.next = new SNode(student);
        size++;
    }

    //得到第i个学生
    public SNode get(int i){
        if(i < 0 || i >= size){
            throw new RuntimeException("your index is out of bounds!");
        }
        int j = 0;
        SNode cur = first;
        while(j != i ){
            cur = cur.next;
            j ++;
        }
        return cur;
    }

    //输入学生信息
    public void add(String sNo, String sName, double sGrade){
        if(first == null) {
            first = new SNode(new Student(sNo, sName, sGrade));
            size ++;
            return;
        }
        SNode cur = first;
        while(cur.next!=null){
            cur =cur.next;
        }
        cur.next = new SNode(new Student(sNo, sName, sGrade));
        size++;
    }

    //逐个显示学生表中所有学生的相关信息
    public List<Student> getAll(){
        ArrayList<Student> list = new ArrayList<>();
        SNode cur = first;
        while(cur != null){
            list.add(cur.student);
            cur = cur.next;
        }
        return list;
    }

    //根据姓名进行查找，返回此学生的学号和成绩
    public Student findStudentBySName(String name){
        if(size == 0){
            System.out.println("No Data!");
            return null;
        }
        SNode cur = first;
        for(int i = 0; i < this.size; i++) {
            if( !this.get(i).student.getsName().equals(name)) {
                cur = cur.next;
            }else{
                System.out.println("查找到该学生的学号是： " + cur.student.getsName() + "成绩是： " + cur.student.getsGrade());
                return cur.student;
            }
        }
        System.out.println("Not Found!");
        return null;
    }

    //根据指定的位置返回相应学生的信息
    public Student getStudentByPosition(int index){
        System.out.println(this.get(index).student.toString());
        return this.get(index).student;
    }

    //给定一个学生信息，插入到表中的指定位置
    public void insertStudent(Student student, int position){
        if(position < 0 || position > size){
            throw new RuntimeException("Illegal position!");
        }
        if(position == size){
            this.add(student);
        }
        SNode node = new SNode(student);
        SNode pre = this.get(position - 1);
        SNode next = this.get(position);
        pre.next = node;
        node.next = next;
        size ++;
        System.out.println("插入学生信息成功！");
    }

    //删除指定位置的学生记录
    public void deleteStudentByPosition(int position){
        if(position < 0 || position >= size)
            throw new RuntimeException("illegal position!");
        SNode del = this.get(position);
        SNode preDel = this.get(position - 1);
        preDel.next = del.next;
        del.next = null;
        size --;
        System.out.println("删除学生信息成功！");
    }

    //统计表中学生个数
    public int getSize(){
        return this.size;
    }

}
