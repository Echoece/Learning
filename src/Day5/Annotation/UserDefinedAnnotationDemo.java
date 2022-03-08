package Day5.Annotation;

import java.lang.annotation.*;

// 1. class level annotation
@MyCustomAnnotation(name="Echo",projectName = "Demo", date = "08-Mar-2022",version = 14.0f)
public class UserDefinedAnnotationDemo {
    @MyCustomAnnotation(name="Echo",projectName = "Demo", date = "08-Mar-2022")
    int date;           // 2. instance level annotation

    // 3. method level and parameter level annotation
    @MyCustomAnnotation(name="Echo",projectName = "Demo", date = "08-Mar-2022",version = 14.0f)
    public static void main(@MyCustomAnnotation(name="Echo",projectName = "Demo", date = "08-Mar-2022",version = 14.0f) String[] args) {
        @MyCustomAnnotation(name="Echo",projectName = "Demo", date = "08-Mar-2022",version = 14.0f)
        int x;      // 4. local variable level
    }
}


// built in :
// retention - has 3 enums, check image for details.
// documented - means it will be available in the javadoc.
// target -  defines where we can use this. check image for enum details
// Inherited - means the subclass will inherit the annotation too
// Repeatable - we can use multiple times
@Inherited
@Retention(RetentionPolicy.CLASS)
@Documented
@Target(value = {ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.PARAMETER})
@interface MyCustomAnnotation{
    // elements of annotation/ metadata, default values can be skipped
    String name();
    String projectName();
    String date();
    float version() default 8.0f;
}
