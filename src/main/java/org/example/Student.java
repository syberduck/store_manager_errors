package org.example;

public class Student {
    int age; // это состояние (переменная)
    String name; // это состояние (переменная)

    public void greeting() {
        System.out.println("Hello! I'm " + name); // это инструкция (тело метода)
    }

    public String modifyString(String param) {
        String result = param + "!!!";
        return result;
    }
}

class Demo {
    public static void main(String[] args) {// psvm запускает код
        Student student1 = new Student();
        student1.name = "Alex";
        String newParamString = student1.modifyString("New param string");
        System.out.println(newParamString);
        student1.greeting();
    }
}








/*
host: localhost
port: 5435
user: storage_admin
password: THw7l0bxvPPkWUhP
db_name: strg_users_db
table: users

как обратиться к базе данных с помощью JDBC, используя параметры выше?

 */