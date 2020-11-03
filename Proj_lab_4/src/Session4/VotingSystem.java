package Session4;

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    public void createVoting(String question,int type,ArrayList<String> list){
        Voting voting = new Voting(type, question);
        for (String temp: list) {
            voting.createChoices(temp);
        }
        votingList.add(voting);
        System.out.println("Created voting");
    }

    public void getVotingList(){
        for (Voting temp: votingList) {
            System.out.println(temp.getQuestion());
        }
    }

    public void getVoting(int type){
        if (validInput(type))
        {
            System.out.println("Question: "+ votingList.get(type).getQuestion());
            ArrayList<String> temp = votingList.get(type).getChoices();
            for (String move: temp)
            {
                System.out.println("\t"+move);
            }
        }
    }

    public void vote(int num,Person voter,ArrayList<String> votes){
        if(validInput(num)) {
            votingList.get(num).vote(voter, votes);
        }
    }

    public void getResults(int num){
        if(validInput(num)) {
            System.out.println("print result:\tvoters:");
            votingList.get(num).getVoters();
            System.out.println("\t\tresult:");
            votingList.get(num).printVotes();
        }
    }

    private boolean validInput(int index) {
        if (index < 0 || index >= votingList.size()) {
            System.out.println("Index is invalid");
            return false;
        } else {
            return true;
        }
    }
}
