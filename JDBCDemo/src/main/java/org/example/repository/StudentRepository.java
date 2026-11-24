package org.example.repository;

import org.example.model.Student;

import java.sql.*;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "";

    public void createStudent(Student student){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            String sql = """
                            INSERT INTO students(name,email,age)
                            VALUES (?,?,?)
                            """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());

            int result = preparedStatement.executeUpdate();

            if(result == 1){
                System.out.println("Create Operation Successfull");
            }else{
                System.out.println("Creation failed");
            }

            connection.close();
        }catch (SQLException ex){
            System.out.println("Databse connection failed");
            ex.printStackTrace();
        }
    }

    public void updateStudent(Long id){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();

            String sql = "UPDATE students SET age=30 " +
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Update Operation Successfull");
            }else{
                System.out.println("updation failed");
            }

            connection.close();
        }catch (SQLException ex){
            System.out.println("Databse connection failed");
            ex.printStackTrace();
        }
    }
    public void deleteStudent(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();

            String sql = "DELETE from students where id = 1";

            int result = statement.executeUpdate(sql);

            if(result == 1){
                System.out.println("Delete Operation Successfull");
            }else{
                System.out.println("deletion failed");
            }

            connection.close();
        }catch (SQLException ex){
            System.out.println("Databse connection failed");
            ex.printStackTrace();
        }
    }

    public void getStudentById(){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();

            String sql = "Select id,name,email,age from students where id = 2";

            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();

            Student student = mapToStudent(resultSet);

            System.out.println(student);

            connection.close();
        }catch (SQLException ex){
            System.out.println("Databse connection failed");
            ex.printStackTrace();
        }
    }

    private Student mapToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}
