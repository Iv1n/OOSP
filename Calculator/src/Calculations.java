public class Calculations {
    private String[] tokens;
    private int pos;

    public void analiz(String uravn) {
        this.tokens = uravn.split(" ");
        this.pos = 0;
    }

    public double calculate(){
        double first = miltiply();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")){
                break;
            } else {
                pos++;
            }

            double second = miltiply();
            if (operator.equals("+")) {
                first += second;
            }
            else {
                first -= second;
            }
        }
        return first;
    }

    private double miltiply(){
        double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")){
                break;
            } else {
                pos++;
            }

            double second = factor();
            if (operator.equals("*")) {
                first *= second;
            }
            else {
                first /= second;
            }
        }
        return first;
    }

    private double factor() {
        String next = tokens[pos];
        double result;
        if (next.equals("(")) {
            pos++;
            result = calculate();
            String closBracket;
            if (pos < tokens.length){
                closBracket = tokens[pos];
            }
            else {
                throw new IllegalArgumentException("Не найдено ')'");
            }
            if (closBracket.equals(")")){
                pos++;
                return result;
            }
            else new IllegalArgumentException("ожидали ')' но появился символ " + closBracket + "");
        }
        pos++;
        return Double.parseDouble(next);
    }

}
