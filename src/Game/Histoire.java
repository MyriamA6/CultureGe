package Game;
import java.util.ArrayList;

public class Histoire extends Theme {
	
	public Histoire() {
		mensonges = new ArrayList<>();
        verites = new ArrayList<>();

        // Ajout des mensonges
        ArrayList<String> mensongesSet = new ArrayList<>();
        mensongesSet.add("src//USAelec//4.png");
        mensongesSet.add("src//USAelec//3.png");
        mensongesSet.add("src//USAelec//2.png");

        mensonges.add(mensongesSet);
        
        mensongesSet = new ArrayList<>();
        mensongesSet.add("src//traiteVers//4.png");
        mensongesSet.add("src//traiteVers//3.png");
        mensongesSet.add("src//traiteVers//2.png");  
        mensonges.add(mensongesSet);
        
        mensongesSet = new ArrayList<>();
        mensongesSet.add("src//revFr//4.png");
        mensongesSet.add("src//revFr//3.png");
        mensongesSet.add("src//revFr//2.png");  
        mensonges.add(mensongesSet);

        //Ajout vérités
        verites.add("src//USAelec//verite.png");
        verites.add("src//traiteVers//verite.png");
        verites.add("src//revFr//verite.png");


	}
	
	
	

}
