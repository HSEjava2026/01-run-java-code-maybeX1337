import java.math.BigDecimal;
import java.math.BigInteger;

public class SumBigDecimalHex {
    public static void main(String[] args) {
        BigDecimal sum = BigDecimal.ZERO;
        for (String arg : args) {
            StringBuilder token = new StringBuilder();
            for (int i = 0; i <= arg.length(); i++) {
                char c = i < arg.length() ? arg.charAt(i) : 0;
                boolean isSpace = i == arg.length()
                        || Character.isWhitespace(c)
                        || Character.getType(c) == Character.SPACE_SEPARATOR;
                if (isSpace) {
                    if (token.length() > 0) {
                        sum = sum.add(parse(token.toString()));
                        token.setLength(0);
                    }
                } else {
                    token.append(c);
                }
            }
        }
        System.out.println(sum.toPlainString());
    }

    private static BigDecimal parse(String s) {
        try {
            String low = s.toLowerCase();
            int x = low.indexOf('x');
            if (x >= 0) {
                boolean neg = s.contains("-");
                String hex = low.substring(x + 1).replace("-", "").replace("+", "");
                int sIdx = hex.indexOf('s');
                if (sIdx >= 0) {
                    BigInteger mantissa = new BigInteger(hex.substring(0, sIdx), 16);
                    int scale = Integer.parseInt(hex.substring(sIdx + 1), 16);
                    BigDecimal val = new BigDecimal(mantissa, scale);
                    return neg ? val.negate() : val;
                } else {
                    BigDecimal val = new BigDecimal(new BigInteger(hex, 16));
                    return neg ? val.negate() : val;
                }
            }
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }
}