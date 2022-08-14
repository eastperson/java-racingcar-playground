public class StringAppendCalculator {
    public Integer sum(String str) {
        if (str.contains(",")){
            String[] strArr = str.split(",");
            Integer sum = 0;
            for (String integerStr : strArr) {
                int integer = Integer.parseInt(integerStr);
                sum += integer;
            }
            return sum;
        }
        return 0;
    }
}
