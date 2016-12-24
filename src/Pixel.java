//package graphics;

// pixel on terminal window (one character, with a color)
public class Pixel {
    private char character;
    private ShellColor color;

    public Pixel(char character, ShellColor color) {
        this.character = character;
        this.color = color;
    }

    // gets the full character, counting the color code
    // this is what is used when printing to the terminal
    // example: \033[0;31m'P  <--- a red P
    public String getFullCharacter() {
        return "\\e[" + color.getColorCode() + "m" + character;//String.valueOf(character);
    }

    /// Accessors and modifiers

    public char getCharacter() {
        return character;
    }

    public ShellColor getColor() {
        return color;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setColor(ShellColor color) {
        this.color = color;
    }
}
