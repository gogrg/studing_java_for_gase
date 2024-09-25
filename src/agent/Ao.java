package agent;

public class Ooo extends FinancialAgent {
    private int numerOfParticipants;

    private float costOneShare;

    public Ooo() {
        super(typeAgent.OOO, "");
        numerOfParticipants = 0;
        costOneShare = 0;
    }

    public Ooo(String name, int numerOfParticipants, float costOneShare) {
        super(typeAgent.OOO, name);
        this.numerOfParticipants = numerOfParticipants;
        this.costOneShare = costOneShare;
    }

    public void participantsUp() {numerOfParticipants++;}

    public void participantsDown() {numerOfParticipants--;}

    public int getNumberOfParticipants() {return numerOfParticipants;}

    public void changeCostShare(float costShare) {this.costOneShare += costShare;}

    
}
