package com.tw;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Student student;
    public Menu(Student student){
        this.student = student;
    }
    int find = 0, find1 = 0;
    public void show(){
        System.out.println("请输入1~3：\n"+"1.添加学生"+"\n2.打印成绩单"+"\n3.退出");
    }
    public void mainMethod(Student student){
        while (find1 == 0){
        //String[] str =student.getSubject();
        show();
        Scanner input = new Scanner(System.in);
        int input_from_key = input.nextInt();

            switch (input_from_key){
                case 1:
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                    Scanner input1 = new Scanner(System.in);
                    String string1 = input1.nextLine();
                    int key1 = 0, key2 = 0;
                    for (int i=1; i < string1.length(); i++){
                        if ((string1.charAt(i))== ':'){
                            key1++; //获取“：”的个数
                        }
                        if ((string1.charAt(i))== ','){
                            key2++; //获取“，”的个数
                        }
                    }
                    if ((key1!= 4)||(key2!=5)){
                        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
                        //find = 1;
                        mainMethod(student,1);
                    }
                    String[] aa = string1.split(",|:");
                    String[] temp1 =student.getName();
                    for (int j = student.getStudentNum(); j < student.getStudentNum()+1; j++){
                        //temp1[j]=input1.next();
                        temp1[j] = aa[0];
                        student.setName(temp1);
                    }
                    String[] temp2 =student.getID();
                    for (int j = student.getStudentNum(); j < student.getStudentNum()+1; j++){
                        //temp2[j]=input1.next();
                        temp2[j] = aa[1];
                        student.setID(temp2);
                    }
                    int[][]temp3 =student.getGrade();
                    int sub = 3;
                    for (int j = student.getStudentNum(); j < student.getStudentNum()+1; j++) {
                        for (int k= 0; k< 4; k++) {
                            //System.out.println(str[k] + ":成绩");
                            //temp3[student.getStudentNum()][k] = input1.nextInt();
                            temp3[student.getStudentNum()][k] = Integer.parseInt(aa[sub]);
                            sub+=2;
                        }
                    }
                    student.setStudentNum(student.getStudentNum()+1);
                    break;

                case 2:
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    Scanner scanner = new Scanner(System.in);
                    ArrayList<String> ns =new ArrayList<>();
                      do {
                            String string = scanner.nextLine();
                            if (string.equals("")) {
                               break;
                          }
                          ns.add(string);
                     } while (true);
                      int z = 0;
                      String[] Name = student.getName();
                      String[] id   = student.getID();
                      int [][] grade = student.getGrade();
                      String[] Name1 = new String[100];
                      String[] id1   =new String[100];
                      int [][] grade1 = new int[100][4];
                     for (String o: ns){
                         for (int n = 0; n < id.length; n++) {
                             String b = id[n];
                             if (b!=null&&(o).equals(b)) {
                                 id1[z] = id[n];
                                 Name1[z] = Name[n];
                                 for (int m = 0; m < 4; m++) {
                                     grade1[z][m] = grade[n][m];
                                 }
                                 z++;
                             }

                         }
                     }
                    System.out.println("成绩单");
                    System.out.println("姓名|学号|数学|语文|英语|编程|平均分|总分");
                    for (int k = 0 ;k<z;k++) {
                        double sum = grade1[k][0]+grade1[k][1]+grade1[k][2]+grade1[k][3];
                        double avg =sum/4;
                        System.out.println(Name1[k]+"|"+id1[k]+"|"+grade1[k][0]+"|"+grade1[k][1]+"|"+grade1[k][2]+"|"+grade1[k][3]+"|"+sum+"|"+avg);

                    }
                    break;

                case 3:
                    find1 = 1;
                    break;
            }
        }

    }

    /***********打印所有人的成绩单**************/
    public void printGradeList(Student student){
        System.out.println("成绩单");
        System.out.println("姓名|学号|数学|语文|英语|编程|平均分|总分");
    String[] Name = student.getName();
    String[] id   = student.getID();
    int [][] grade = student.getGrade();
        for (int i = 0 ;i<student.getStudentNum();i++) {
        double sum = grade[i][0]+grade[i][1]+grade[i][2]+grade[i][3];
        double avg =sum/4;
        System.out.println(Name[i]+"|"+id[i]+"|"+grade[i][0]+"|"+grade[i][1]+"|"+grade[i][2]+"|"+grade[i][3]+"|"+sum+"|"+avg);

    }
}
    public void mainMethod(Student student,int input_from_key) {
        while (true) {
            String[] str = student.getSubject();
            switch (input_from_key) {
                case 1:
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                    Scanner input1 = new Scanner(System.in);
                    String string1 = input1.nextLine();
                    int key1 = 0, key2 = 0;
                    for (int i = 1; i < string1.length(); i++) {
                        if ((string1.charAt(i)) == ':') {
                            key1++;
                        }
                        if ((string1.charAt(i)) == ',') {
                            key2++;
                        }
                    }
                    if ((key1 != 4) && (key1 != 5)) {
                        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
                        find = 1;
                        mainMethod(student,find);
                    }
                    String[] aa = string1.split(",|:");
                    String[] temp1 = student.getName();
                    for (int j = student.getStudentNum(); j < student.getStudentNum() + 1; j++) {
                        //temp1[j]=input1.next();
                        temp1[j] = aa[0];
                        student.setName(temp1);
                    }
                    String[] temp2 = student.getID();
                    for (int j = student.getStudentNum(); j < student.getStudentNum() + 1; j++) {
                        //temp2[j]=input1.next();
                        temp2[j] = aa[1];
                        student.setID(temp2);
                    }
                    int[][] temp3 = student.getGrade();
                    int sub = 3;
                    for (int j = student.getStudentNum(); j < student.getStudentNum() + 1; j++) {
                        for (int k = 0; k < 4; k++) {
                            //System.out.println(str[k] + ":成绩");
                            //temp3[student.getStudentNum()][k] = input1.nextInt();
                            temp3[student.getStudentNum()][k] = Integer.parseInt(aa[sub]);
                            sub += 2;
                        }
                    }
                    student.setStudentNum(student.getStudentNum() + 1);
                    break;

                case 2:
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    Scanner scanner = new Scanner(System.in);
                    ArrayList<String> ns = new ArrayList<>();
                    do {
                        String string = scanner.nextLine();
                        if (string.equals("")) {
                            break;
                        }
                        ns.add(string);
                    } while (true);
                    int z = 0;
                    String[] Name = student.getName();
                    String[] id = student.getID();
                    int[][] grade = student.getGrade();
                    String[] Name1 = new String[100];
                    String[] id1 = new String[100];
                    int[][] grade1 = new int[100][4];
                    for (String o : ns) {
                        for (int n = 0; n < id.length; n++) {
                            String b = id[n];
                            if (b != null && (o).equals(b)) {
                                id1[z] = id[n];
                                Name1[z] = Name[n];
                                for (int m = 0; m < 4; m++) {
                                    grade1[z][m] = grade[n][m];
                                }
                                z++;
                            }

                        }
                    }
                    System.out.println("成绩单");
                    System.out.println("姓名|学号|数学|语文|英语|编程|平均分|总分");
                    for (int k = 0; k < z; k++) {
                        double sum = grade1[k][0] + grade1[k][1] + grade1[k][2] + grade1[k][3];
                        double avg = sum / 4;
                        System.out.println(Name1[k] + "|" + id1[k] + "|" + grade1[k][0] + "|" + grade1[k][1] + "|" + grade1[k][2] + "|" + grade1[k][3] + "|" + sum + "|" + avg);

                    }
                    break;

                case 3:
                    break;
            }
        }
    }
}
