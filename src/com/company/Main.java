package com.company;

import java.util.Scanner;

/*Nota: No pude ejecutar correctamente el método, marca errores cuando se manda llamar la función.
Supongo que están mal los parámetros de la función, entiendo que lo que debería de solicitar es “code”
del alumno, sin embargo, la parte de que sea privado y que este en otra clase no lo entendí.
No supe como marcar que era explícitamente el code y no todo el alumno para hacer la comparación
entre el code que llega y los codes del arreglo de objetos. */

class Student{
    private String name;
    private String lastName;
    private String code;

    //Constructores
    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }
}

class Group{
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejected;
    private int eliminated;

    public String getCode(){
        return code;
    }

    Group(String code, int capacity){
        this.code = code;
        students = new Student[capacity];
    }

    //Métodos
    public boolean addStudent(Student student){
        if(enrolled < students.length){
            students[enrolled++] = student;
            return true;
        }
        rejected++;
        return false;
    }

    public boolean removeStudent(Student student) {//¿cómo poner especificamente el código del alumno si está privado?
        for (int i = 0; i< students.length; i++){
            if(students[i].getCode().equals(student.getCode())){
                goOver(i);//se llama la función que recorre
                return true;//Se eliminó correctamente
            }
        }
        return false;//No se eliminó o no existe
    }

    public void goOver(int R){//Va a sobreescribir la información para eliminar
        for (int i = R; i < enrolled; i++){
            students[i] =students[i+1];
        }
        enrolled--;//Decrementa los incritos
        eliminated++;//Aumenta los que fueron suprimidos
    }

    //Getters
    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }

    public Student getStudent(int index){
        return students[index];
    }

    public int getEliminated(){
        return eliminated;
    }
}

public class Main {

    public static void main(String[] args) {
        Student student1;//Referencia a un Alumno
        Student student2 = new Student("Iván", "Uresti", "326347");
        student1 = new Student("Rita", "Monreal","362473");//Creando un objeto alumno

        Group group = new Group("12345", 8);
        Group group2 = new Group("54321", 6);


        if(!group.addStudent(student1)){
            System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastName());
        }

        if(!group.addStudent(student2)){
            System.out.println("Estudiante no fue añadido: " + student2.getName() + " " + student2.getLastName());
        }

        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group2.addStudent(new Student("Misael", "Cabrera", "5"));
        group2.addStudent(new Student("Roberto", "Cisneros", "6"));
        group.addStudent(new Student("Juan", "Coronado", "7"));
        group.addStudent(new Student("José", "González", "8"));
        group.addStudent(new Student("Jesús", "Lara", "9"));
        group.addStudent(new Student("José", "Limón", "10"));

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

       // group.removeStudent("4");
        //group2.removeStudent("6");
        //group2.removeStudent("10");

        System.out.println();
        System.out.println("Alumnos del grupo: " + group.getCode());

        for (int i = 0; i < group.getEnrolled(); i++) {
            Student student = group.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

        System.out.println();
        System.out.println("Alumnos del grupo: " + group2.getCode());

        for (int i = 0; i < group2.getEnrolled(); i++) {
            Student student = group2.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

    }
}
