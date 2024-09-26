package agent;

public class Ao extends FinancialAgent {
    private int numerOfParticipants;

    public Ao() {
        super(TypeAgent.AO, "");
        numerOfParticipants = 0;
    }

    public Ao(String name, int numerOfParticipants) {
        super(TypeAgent.AO, name);
        this.numerOfParticipants = numerOfParticipants;
    }

    public void participantsUp() {numerOfParticipants++;}

    public void participantsDown() {numerOfParticipants--;}

    public int getNumberOfParticipants() {return numerOfParticipants;}
}
