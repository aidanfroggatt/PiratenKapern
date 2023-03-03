package pk;

public class player {
    public int totalScore=0, rollScore=0, skulls=0, usableDice=8, wins=0, max;
    public double winPercentage=0;
    public cards card;
    public String strategy = "";
    public Faces maxFace;
    public static Faces[] roll = new Faces[8];
}
