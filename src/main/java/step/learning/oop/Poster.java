package step.learning.oop;

public class Poster extends Literature {
    public boolean color;

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public String getCard() {
        return String.format(
                "Poster: %s '%b'",
                super.getTitle(),
                this.getColor()
        );
    }
}
