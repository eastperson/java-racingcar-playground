import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAppendCalculator {

    public StringAppendCalculator() {
        delimiters.add(COMMA_DELIMITER);
        delimiters.add(COLON_DELIMITER);
    }

    private static List<String> delimiters = new ArrayList<>();
    private String COMMA_DELIMITER = ",";
    private String COLON_DELIMITER = ":";
    private String DELIMITER_PARSE_START_WITH = "||";
    private String DELIMITER_PARSE_END_WITH = "\n";

    public Integer sum(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        str = parseDelimiter(str);

        if (hasDelimiter(str)) {
            return sumInteger(str);
        }
        throw new RuntimeException("구분자를 입력하지 않았습니다.");
    }

    private Integer sumInteger(String str) {
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

    private String parseDelimiter(String str) {
        if (str.startsWith(DELIMITER_PARSE_START_WITH) && str.contains(DELIMITER_PARSE_END_WITH)) {
            String[] strArr = str.split(DELIMITER_PARSE_END_WITH);
            if (strArr.length > 2) {
                throw new RuntimeException("구분자 입력이 잘못됐습니다");
            }
            String delimiter = strArr[0].substring(2);
            delimiters.add(delimiter);
            str = str.substring(str.indexOf(DELIMITER_PARSE_END_WITH) + DELIMITER_PARSE_END_WITH.length());
        }
        return str;
    }

    private boolean isEmpty(String str) {
        return str.length() == 0;
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
