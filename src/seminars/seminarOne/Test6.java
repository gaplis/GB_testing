//Найдите и исправьте ошибку

package seminars.seminarOne;

import static org.assertj.core.api.Assertions.*;
import static seminars.seminarOne.Test3.sum;

public class Test6 {
    public static void main(String[] args) {
        expectedValue();
    }

    public static void expectedValue() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }
}
