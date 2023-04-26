import com.jdbcconnectivity.connectivity;
import com.liberary.liberary;
import com.liberary_operations.operations;

import java.sql.SQLException;
import java.util.Scanner;


public class main {

    public static void menu(){
        System.out.println("1.ADD BOOK");
        System.out.println("2.DELETE BOOK");
        System.out.println("3.SHOW BOOKS");
        System.out.println("4.UPDATE BOOK");
        System.out.println("5.SHOW BOOK BY ID");
        System.out.println("6.EXIT");
    }
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        liberary liberary =new liberary();

        int id;
        String name;
        String author;
        int publish_year;



        int option;
        do {
            menu();
            System.out.println("enter the choice");
            option= sc.nextInt();
            try {
                switch (option) {
                    case (1):
                        // add the book
                        System.out.println("enter the book id");
                        id = liberary.setBook_id(sc.nextInt());
                        System.out.println("enter the book name");
                        name = liberary.setBook_name(sc.next());
                        System.out.println("enter the book author");
                        author = liberary.setBook_author(sc.next());
                        System.out.println("enter the book publish year");
                        publish_year = liberary.setPublish_year(sc.nextInt());
                        liberary obj = new liberary(id, name, author, publish_year);
                        try {
                            operations.insert(obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case (2):
                        // delete the book
                        System.out.println("enter the id of book");
                        id= sc.nextInt();
                        operations.delete(id);
                        break;

                    case(3):
                        operations.show_data();
                        break;

                    case(4):
                        System.out.println("enter the id to update");
                        int up_id= sc.nextInt();
                        System.out.println("enter the new id");
                        id= sc.nextInt();
                        System.out.println("enter the new book name");
                        name=sc.next();
                        System.out.println("enter the new author name");
                        author=sc.next();
                        System.out.println("enter the new publish year");
                        publish_year=sc.nextInt();

                        operations.update_data(up_id, id , name, author, publish_year);
                        break;

                    case (5):
                        System.out.println("enter the id to show data");
                        id= sc.nextInt();
                        operations.show_by_id(id);
                        break;
                }


            } catch (Exception e){
                e.printStackTrace();
            }
        } while (option!=0);
    }
}
