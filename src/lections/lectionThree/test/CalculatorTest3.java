import org.junit.jupiter.api.Test;
import lections.lectionThree.main.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest3 {

    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void substractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 1, '-')).isEqualTo(1);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 4, '*')).isEqualTo(8);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(4, 2, '/')).isEqualTo(2);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorStmbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);

        lections.lectionThree.main.Calculator.getOperand();

        System.out.println(testedValue);
        System.setIn(inputStream);
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(() -> lections.lectionThree.main.Calculator.getOperand())
                .isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка в вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }

    @Test
    void computeCircleRadiusWorksCorrectly() {
        assertThat(Calculator.computeAreaCircle(10)).isEqualTo(314.1592653589793);
    }
}
