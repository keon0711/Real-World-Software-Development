import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class lambdaTest {
    Apple apple1 = new Apple(10, "green");
    Apple apple2 = new Apple(8, "red");
    Apple apple3 = new Apple(15, "green");

    List<Apple> apples = new ArrayList<>(List.of(apple1, apple2, apple3));

    @Test
    void comparatorLambda() {
        apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        assertThat(apples).containsExactly(apple2, apple1, apple3);
    }

    class Apple {
        Integer weight;
        String color;

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
