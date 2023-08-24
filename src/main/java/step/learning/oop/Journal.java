package step.learning.oop;

public class Journal extends Literature implements Periodic, Copyable {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getCard() {
        return String.format(
                "Journal: '%s' № %d",
                super.getTitle(),
                this.getNumber()
        );
    }

    @Override
    public String getPeriod() {
        return "Monthly";
    }

    @Override
    public String getCopyable() {
        return "Copying";
    }
}
