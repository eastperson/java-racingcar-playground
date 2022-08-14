import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 기능 요구사항
 *
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한
 * 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6) 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
 * 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
 *
 * 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 */
class StringAppendCalculatorTest {

    @Test
    @DisplayName("빈 문자열은 0을 반환한다")
    void empty_sum() {
        String str = "";
        StringAppendCalculator stringAppendCalculator = new StringAppendCalculator();
        Integer result = stringAppendCalculator.sum(str);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,2,3=6"}, delimiter = '=')
    @DisplayName("쉼표를 구분자로 숫자를 합한다")
    void comma_sum(String str, Integer expected) {
        StringAppendCalculator stringAppendCalculator = new StringAppendCalculator();
        Integer result = stringAppendCalculator.sum(str);
        assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4=10", "1,2,3:5=11"}, delimiter = '=')
    @DisplayName("세미콜론을 구분자로 숫자를 합한다")
    void semicolon_sum(String str, Integer expected) {
        StringAppendCalculator stringAppendCalculator = new StringAppendCalculator();
        Integer result = stringAppendCalculator.sum(str);
        assertThat(result).isEqualTo(expected);
    }


    @Test
    @DisplayName("||로 만든 커스텀 구분자를 사용한다")
    void custom_delimiter_sum() {
        String str = "||G\n1G2G3G";
        Integer expected = 6;
        StringAppendCalculator stringAppendCalculator = new StringAppendCalculator();
        Integer result = stringAppendCalculator.sum(str);
        assertThat(result).isEqualTo(expected);
    }
}
