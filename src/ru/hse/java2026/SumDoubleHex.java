public class SumDoubleHex {
    public static void main(String[] args) {
        double sum = 0.0;
        for (String arg : args) {
            StringBuilder token = new StringBuilder();
            for (int i = 0; i <= arg.length(); i++) {
                char c = i < arg.length() ? arg.charAt(i) : 0;
                boolean isSpace = i == arg.length()
                        || Character.isWhitespace(c)
                        || Character.getType(c) == Character.SPACE_SEPARATOR;
                if (isSpace) {
                    if (token.length() > 0) {
                        String s = token.toString();
                        try {
                            String toParse = s;
                            String lower = s.toLowerCase();
                            if (lower.contains("x") && !lower.contains("p")) {
                                toParse = s + "p0";
                            }
                            sum += Double.parseDouble(toParse);
                        } catch (NumberFormatException e) {
                            // skip
                        }
                        token.setLength(0);
                    }
                } else {
                    token.append(c);
                }
            }
        }
        System.out.println(sum);
    }
}