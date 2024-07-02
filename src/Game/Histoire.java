package Game;
import java.util.ArrayList;

public class Histoire extends Theme {
	
	public Histoire() {
		mensonges = new ArrayList<>();
        verites = new ArrayList<>();

        // Ajout des mensonges
        ArrayList<String> mensongesSet1 = new ArrayList<>();
        mensongesSet1.add("src//USAelec//4.png");
        mensongesSet1.add("src//USAelec//3.png");
        mensongesSet1.add("src//USAelec//2.png");

        mensonges.add(mensongesSet1);

        //Ajout vérités
        verites.add("src//USAelec//verite.png");

	}
	
	
	

}
