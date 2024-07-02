package Game;
import java.util.ArrayList;

public class FaitsDivers extends Theme{

    public FaitsDivers() {
        mensonges = new ArrayList<>();
        verites = new ArrayList<>();

     // Ajout des mensonges
        ArrayList<String> mensongesSet = new ArrayList<>();
        mensongesSet.add("src//capAustralie//4.png");
        mensongesSet.add("src//capAustralie//3.png");
        mensongesSet.add("src//capAustralie//2.png");

        mensonges.add(mensongesSet);
        mensongesSet = new ArrayList<>();
        mensongesSet.add("src//PGanimal//4.png");
        mensongesSet.add("src//PGanimal//3.png");
        mensongesSet.add("src//PGanimal//2.png");  
        mensonges.add(mensongesSet);

        

        //Ajout vérités
        verites.add("src//capAustralie//verite.png");
        verites.add("src//PGanimal//verite.png");

        
        

    }
    
    
}
