package Session4;

import ir.huri.jcal.JalaliCalendar;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> days = new ArrayList<>();
        options.add("yes");
        options.add("no");
        days.add("Thursday");
        days.add("Friday");

        votingSystem.createVoting("Islamic republic or what ?", 0, options);

        votingSystem.createVoting("The day : ", 1, days);

        System.out.println("Print voting questions\n");
        votingSystem.getVotingList();

        System.out.println("print voting : \n");
        votingSystem.getVoting(0);
        votingSystem.getVoting(1);

        System.out.println("print result. \n");
        votingSystem.getResults(0);
        System.out.println();
        votingSystem.getResults(1);
        System.out.println();

        votingSystem.getVotingList();
        votingSystem.createVoting("The day : ", 1, days);
        votingSystem.getVotingList();
        System.out.println();

        Person firstPerson = new Person("Hassan", "Rouhani");
        Person secondPerson = new Person("Mahmoud", "Ahmadi");
        Person thirdPerson = new Person("Ghalibafe", "khar");

        ArrayList<String> firstVote = new ArrayList<>();
        ArrayList<String> secondVote = new ArrayList<>();
        ArrayList<String> thirdVote = new ArrayList<>();
        firstVote.add("yes");
        secondVote.add("yes");
        thirdVote.add("no");
        thirdVote.add("Thursday");
        thirdVote.add("Friday");
        thirdVote.add("Saturday");

        System.out.println("voting 0:");
        votingSystem.vote(0, firstPerson, firstVote);
        votingSystem.vote(0, secondPerson, secondVote);
        votingSystem.vote(0, thirdPerson, thirdVote);
        System.out.println();
        votingSystem.getResults(0);
        System.out.println();
        System.out.println("Second vote : ");
        votingSystem.vote(1, thirdPerson, secondVote);
        System.out.println();
        votingSystem.getResults(1);
    }
}