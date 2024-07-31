package com.sistemi.informativi.repository;

import com.sistemi.informativi.document.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
MongoRepository è una Interfaccia API fornita dal modulo Spring Data Mongo
Al pari di JpaRepository espone una serie di metodi di CRUD già pronti, come save
saveAll, findbyID
 */
public interface CourseRepository extends MongoRepository<Course, String> {

}
