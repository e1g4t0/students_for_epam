package DBManagePack;

import Models.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;



public class DBManager {
    public static Connection conn;
    static {
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getClassesFolderPath(){
        return new Object() {}.getClass().getResource("/").getPath().substring(1);
    }

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        System.out.println(getClassesFolderPath());
        conn = DriverManager.getConnection("jdbc:sqlite:" + getClassesFolderPath() + "Students.sqlite");
        System.out.println("DB has connected");
    }


    public static void writeStudent(Student student) {
        String sql = "INSERT INTO Students('name', 'surname', 'student_group', 'admitted_year') VALUES (?, ?, ?, ?);";
        try(PreparedStatement prStmt = conn.prepareStatement(sql)){
            prStmt.setString(1, student.getName());
            prStmt.setString(2, student.getSurname());
            prStmt.setString(3, student.getGroup());
            prStmt.setInt(4, student.getYear());
            prStmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public static List<Student> readStudents() {
        try (Statement stmt = conn.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Students");
            return getStudents(resultSet);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static LinkedList<Student> readStudents(String key, Object value){
        String sql = "SELECT * FROM Students where " + key + " = ?";
        try (PreparedStatement prStmt = conn.prepareStatement(sql)){
            prStmt.setObject(1, value);
            ResultSet resultSet = prStmt.executeQuery();
            return getStudents(resultSet);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private static LinkedList<Student> getStudents(ResultSet resultSet) throws SQLException {
        LinkedList<Student> studentsData = new LinkedList<>();
        while(resultSet.next()) {
            studentsData.add(new Student(resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getInt(5))
            );
        }
        return studentsData;
    }

    public static void deleteStudent(int id){
        String sql = "DELETE FROM students WHERE id = ?;";
        try(PreparedStatement prStmt = conn.prepareStatement(sql)){
            prStmt.setInt(1, id);
            prStmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Student studentById(int id){
        String sql = "SELECT * FROM students WHERE id = ?;";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return new Student(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getInt(5));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateStudent(Student student){
        String sql = "UPDATE students SET name = ?, surname = ?, student_group = ?, admitted_year = ? WHERE id = ?;";
        try (PreparedStatement prStmt = conn.prepareStatement(sql)){
            prStmt.setString(1, student.getName());
            prStmt.setString(2, student.getSurname());
            prStmt.setString(3, student.getGroup());
            prStmt.setInt(4, student.getYear());
            prStmt.setInt(5, student.getId());
            prStmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}