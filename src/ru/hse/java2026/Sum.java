public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            System.err.println("Processing arg: " + arg);
            StringBuilder token = new StringBuilder();
            for (int i = 0; i <= arg.length(); i++) {
                char c = (i < arg.length()) ? arg.charAt(i) : 0;
                boolean isWs = (i == arg.length()) || Character.isWhitespace(c)
                        || Character.getType(c) == Character.SPACE_SEPARATOR;
                if (!isWs) {
                    token.append(c);
                } else if (token.length() > 0) {
                    String t = token.toString();
                    try {
                        sum += Integer.parseInt(t);
                        System.err.println("Parsed: " + t);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipped: " + t);
                    }
                    token.setLength(0);
                }
            }
        }
        System.out.println(sum);
    }
}