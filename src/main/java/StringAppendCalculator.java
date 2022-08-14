import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAppendCalculator {

    private List<String> delimiters = new ArrayList<>();
    private String COMMA_DELIMITER = ",";
    private String COLON_DELIMITER = ":";

    public Integer sum(String str) {
        delimiters.add(COMMA_DELIMITER);
        delimiters.add(COLON_DELIMITER);
        if (str.length() == 0) {
            return 0;
        }

        if (str.startsWith("||") && str.contains("\n")) {
            String[] strArr = str.split("\n");
            if (strArr.length > 2) {
                throw new RuntimeException("");
            }
            String delimiter = strArr[0].substring(2);
            delimiters.add(delimiter);
            str = str.substring(str.indexOf("\n") + "\n".length());
        }
        if (hasDelimiter(str)){
            for (String delimiter : delimiters) {
                str = str.replace(delimiter, COMMA_DELIMITER);
            }
            String[] strArr = str.split(COMMA_DELIMITER);
            int sum = 0;
            for (String integerStr : strArr) {
                try {
                    int integer = Integer.parseInt(integerStr);
                    sum += integer;
                } catch (NumberFormatException e) {
                    throw new RuntimeException("파싱할 수 없는 숫자 입니다.");
                }
            }
            return sum;
        }
        throw new RuntimeException("구분자를 입력하지 않았습니다.");
    }

    private boolean hasDelimiter(String str) {
        for (String delimiter : delimiters) {
            if (str.contains(delimiter)) {
                return true;
            }
        }
        return false;
    }
}
