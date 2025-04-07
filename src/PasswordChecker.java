public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength <= 0) {
            throw new IllegalArgumentException("Минимальная длина должна быть > 0");
        } else {
            this.minLength = minLength;
        }
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимально допустимое количество повторений должно быть > 0");
        } else {
            this.maxRepeats = maxRepeats;
        }
    }

    public boolean verify(String password) {
        if (this.minLength <= 0 || this.maxRepeats <= 0) {
            throw new IllegalStateException("Не установлена Минимальная длина и/или Максимально допустимое количество повторений");
        }
        if (password.length() < this.minLength) {
            return false;
        }
        if (password.length() == 1) {
            return true;
        }
        int repeats = 1;
        char lastChar = password.charAt(0);
        for (int i = 1; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar == lastChar) {
                repeats++;
                if (repeats > this.maxRepeats) {
                    return false;
                }
            } else {
                lastChar = currentChar;
                repeats = 1;
            }
        }
        return true;
    }
}