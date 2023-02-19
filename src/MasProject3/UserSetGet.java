package MasProject3;

public class UserSetGet {

    public String name;
    public int diff;
    public int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        new UserSetGet();
    }

}
