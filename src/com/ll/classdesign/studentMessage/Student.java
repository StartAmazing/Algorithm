package com.ll.classdesign.studentMessage;

public class Student {

    private String sNo;
    private String sName;
    private double sGrade;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getsGrade() {
        return sGrade;
    }

    public void setsGrade(double sGrade) {
        this.sGrade = sGrade;
    }

    public Student(String sNo, String sName, double sGrade) {
        this.sNo = sNo;
        this.sName = sName;
        this.sGrade = sGrade;
    }

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", sGrade='" + sGrade + '\'' +
                '}';
    }
}
