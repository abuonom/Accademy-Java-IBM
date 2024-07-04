package com.sistemi.informativi.facede;

import java.util.stream.Stream;

public interface FacedeDAO {

    public Stream<Object> getFrontEndCourses();
    public Stream<Object> getBackEndCourses();

}
