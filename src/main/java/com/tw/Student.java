package com.tw;

public class Student {
    private String[] Name=new String[100];
    private String[] ID=new String[100]; //有若干个ID，存在一个数组里，否则会覆盖之前的
    public String[] Subject= new String[]{"语文", "数学", "英语", "编程"};
    private int[][] grade=new int[100][4];
    public  int StudentNum = 0;

    public int getStudentNum() {
        return StudentNum;
    }

    public String[] getName() {
        return Name;
    }

    public String[] getID() {
        return ID;
    }

    public String[] getSubject() {
        return Subject;
    }

    public void setName(String[] name) {
        Name = name;
    }

    public void setID(String[] ID) {
        this.ID = ID;
    }

    public int[][] getGrade() {
        return grade;
    }

    public void setStudentNum(int studentNum) {
        StudentNum = studentNum;
    }


}
