package com.liberary;

public  class liberary {
    private int book_id;
    private String book_name;
    private String book_author;
    private int publish_year;


    public liberary() {
    }

    public liberary(int book_id, String book_name, String book_author, int publish_year) { // parameterized constructor
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.publish_year = publish_year;
    }

    public int getBook_id() {
        return book_id;
    }

    public int setBook_id(int book_id) {
        this.book_id = book_id;
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String setBook_name(String book_name) {
        this.book_name = book_name;
        return book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public String setBook_author(String book_author) {
        this.book_author = book_author;
        return book_author;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public int setPublish_year(int publish_year) {
        this.publish_year = publish_year;
        return publish_year;
    }

    @Override
    public String toString() {
        return "liberary{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author=" + book_author +
                ", publish_year=" + publish_year +
                '}';
    }
}
