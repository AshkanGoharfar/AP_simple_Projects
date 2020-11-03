package Session4;

import java.util.Objects;
public class Vote {
    private Person voter;
    private String date;

    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }

    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getVoter(), vote.getVoter()) &&
                Objects.equals(getDate(), vote.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoter(), getDate());
    }
}
