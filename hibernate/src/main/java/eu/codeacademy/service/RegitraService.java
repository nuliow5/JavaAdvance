package eu.codeacademy.service;

import eu.codeacademy.model.Person;
import eu.codeacademy.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;


public class RegitraService {
    public ArrayList<Person> findAllPersons() {

        String QUERY = "SELECT id, name, surname, age FROM person";
        System.out.println("\n---" + QUERY + "---");
        try (
                Connection conn = JdbcUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);

        ) {
            ArrayList<Person> personList = new ArrayList<>();
            while (rs.next()) {

                personList.add(new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age")
                ));

            }
            return personList;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public void findAllAuto() {
        String QUERY = "SELECT id, name, number FROM auto";
        System.out.println("\n---" + QUERY + "---");
        try (
                Connection conn = JdbcUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", number: " + rs.getString("number"));
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findPersonByCar(String carName) {
        String QUERY = "SELECT * FROM auto WHERE name = ?";
        System.out.println("\n---" + QUERY + " | ? = " + carName + "---");

        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(QUERY);
            statement.setString(1, carName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", number: " + rs.getString("number"));
                System.out.print(", user_id: " + rs.getString("user_id"));
                System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //INSERT INTO
    public void insertIntoNewPersonToSQL(Person person) {
        String QUERY = "INSERT into person (id, name, surname, age)" +
                "VALUES (?, ?, ?, ?)";
        try {
            Connection conn = JdbcUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(QUERY);

            stmt.setInt(1, (int) person.getId());
            stmt.setString(2, person.getName());
            stmt.setString(3, person.getSurname());
            stmt.setInt(4, person.getAge());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //UPDATE
    public void updatePersonNameById(int id, String personNewName) {
        String QUERY = "UPDATE person SET name = ? where id = ?";
        try {
            Connection connection = JdbcUtil.getConnection();
            PreparedStatement stm = connection.prepareStatement(QUERY);

            stm.setString(1, personNewName);
            stm.setInt(2, id);
            stm.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveAllFirstPersonCarsToSecondPerson(String firstPerson, String secondPerson) {
        String IdQUERY = "select id from person where name = ";
        String updateQUERY = "UPDATE auto set user_id = ? where user_id = ?" ;

        try {
            Connection conn = JdbcUtil.getConnection();
            Statement stmt = conn.createStatement();

            //firstPersonID = [0 index], secondPersonID = [1 index]
            int[] personsID = new int[2];

            String[] persons = {firstPerson, secondPerson};
            for (int i = 0; i < persons.length; i++) {
                String testValue = IdQUERY + persons[i];
                ResultSet rs = stmt.executeQuery(IdQUERY + "'" + persons[i] + "'");
                rs.next();
                personsID[i] = rs.getInt("id");

            }



            PreparedStatement stm = conn.prepareStatement(updateQUERY);
            stm.setInt(1, personsID[1]);
            stm.setInt(2, personsID[0]);
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
