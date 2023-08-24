package step.learning.oop;

public class Booklet extends Literature implements Copyable{
    public String typography;

    public String getTypography() {
        return typography;
    }

    public void setTypography(String typography) {
        this.typography = typography;
    }

    @Override
    public String getCard() {
        return String.format(
                "Booklet: %s '%s'",
                this.getTypography(),
                super.getTitle()
        );
    }

    @Override
    public String getCopyable() {
        return "Copying";
    }
}
