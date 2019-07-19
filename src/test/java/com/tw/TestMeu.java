package com.tw;
import java.util.ArrayList;
import javax.security.auth.Subject;
public class TestMeu {
    public static void main(String[] args){
        Student student = new Student();
        Menu menu = new Menu(student);
        menu.mainMethod(student);
    }
}
