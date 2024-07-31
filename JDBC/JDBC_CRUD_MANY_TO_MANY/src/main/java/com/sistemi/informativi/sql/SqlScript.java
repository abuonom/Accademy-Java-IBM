package com.sistemi.informativi.sql;

public interface SqlScript {

    static final String sqlCustomerInsert = "insert into customer (name,email) values(?,?)";

    static final String sqlProductInsert = "insert into product(name,price) values(?,?)";

    static final String sqlJoinInsert= "insert into Customer_Product(customer_id,product_id) values(?,?)";

    static final String sqlCustomersNameByProduct = """
            select customer.name from customer
            JOIN customer_product ON customer.id=customer_product.customer_id
            JOIN product ON product.id=customer_product.product_id
            where product.id=?""";

    static String sqlCourseInsert = "insert into course(title)values(?)";

    static String sqlReviewInsert = "insert into review(location,course_id)values(?,?)";

    static String sqlReviewsLocationByCourse = "select location from review,course where review.course_id=course.id and course.id=?";

    static String sqlDeleteCourse = "delete from course where id=?";

}
