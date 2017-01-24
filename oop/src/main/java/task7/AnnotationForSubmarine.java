package task7;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)

public @interface AnnotationForSubmarine {
    String author();
    String date();
}
