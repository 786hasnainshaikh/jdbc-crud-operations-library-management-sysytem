package com.liberary_operations;

import com.jdbcconnectivity.connectivity;
import com.liberary.liberary;

import java.sql.*;


public class operations {

    static liberary liberary=new liberary();
    static Connection con=connectivity.Connection();

    public static void insert(liberary liberary) throws SQLException {
        String queery="insert into l_data () values (?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(queery); // create statement

        pstm.setInt(1, liberary.getBook_id());          // set the value of book id
        pstm.setString(2, liberary.getBook_name());     // set the value of book name
        pstm.setString(3, liberary.getBook_author());   // set the value of book author
        pstm.setInt(4, liberary.getPublish_year());     // set the value of book publish year

        // execute the queery
        pstm.execute();
        System.out.println("inserted successfully");


        // close the connection
        pstm.close();

    }  // insert into database

    public static void delete(int id) throws SQLException {
       Statement stm = con.createStatement();
       String queery="delete from l_data where book_id= " + id;
       boolean res= stm.execute(queery);
        System.out.println(res);
        if (res == false ){
            System.out.println("data deleted successfully");
        } else {
            System.out.println("record not found");
        }

        stm.close();
    }  // delete from database

    public static void show_data() throws SQLException {
        Statement stm= con.createStatement();  // create the connection
        String queery=" select * from l_data";
        ResultSet resultSet= stm.executeQuery(queery);
        while (resultSet.next()){
           System.out.println("book id: " + resultSet.getInt(1) +
                              " book name: " +resultSet.getString(2) +
                              " book author: " + resultSet.getString(3) +
                              " publish year: "+ resultSet.getInt(4) );
            System.out.println("===================================================");

        }
        stm.close();

    }  // show data from database

    public static void update_data( int up_id, int id , String name, String author, int pub_year) throws SQLException {
        String queery="update l_data set book_id=? , book_name=?, book_author=?, publish_year=?  where book_id= " + up_id;
        PreparedStatement pstm= con.prepareStatement(queery); // create statemnt

        pstm.setInt(1, id);
        pstm.setString(2,name);
        pstm.setString(3,author);
        pstm.setInt(4, pub_year);
        boolean result= pstm.execute();
        if (result == false){
            System.out.println("data updated successfully");
        }
        else {
            System.out.println("some thing went wrong");
        }

        pstm.close();

    }  // update the record from database

    public static void show_by_id(int id) throws SQLException {
        Statement stm= con.createStatement();
        String queery="select * from l_data where book_id = " + id;
        ResultSet resultSet=stm.executeQuery(queery);
        while (resultSet.next()){
            System.out.println("book id: "+ resultSet.getInt("book_id") +
                               " book name: "+ resultSet.getString("book_name")+
                               " book author: "+ resultSet.getString("book_author")+
                               " book publish year: "+ resultSet.getInt("publish_year")
            );
        }
    }   // show data by id from database


}
