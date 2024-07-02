package Game;
import java.util.ArrayList;
import java.util.Random;

public abstract class Theme {
	protected ArrayList<ArrayList<String>> mensonges;
    protected ArrayList<String> verites;
    private int choix;
    private Random alea;
    
    private int placeVerite;
    
    Theme(){
    }
    
    public ArrayList<ArrayList<String>> getMensonges() {
        return mensonges;
    }

    public ArrayList<String> getVerites() {
        return verites;
    }
    
    public ArrayList<String> gameSet(ArrayList<Integer> choosenNumbers){
    	ArrayList<String> setJeu = new ArrayList<String>();
    	alea=new Random();
    	int res = alea.nextInt(verites.size());
    	while (choosenNumbers.contains(res)) {
    		System.out.println("here");
    		res=alea.nextInt(verites.size());
    	}
    	System.out.println(res);
    	choix=res;
    	placeVerite=alea.nextInt(3);
    	switch(placeVerite) {
    	case 0:
    		setJeu.add(verites.get(res));
        	setJeu.add(mensonges.get(res).get(0));
        	setJeu.add(mensonges.get(res).get(1));
        	setJeu.add(mensonges.get(res).get(2));
        	break;
    	case 1:
        	setJeu.add(mensonges.get(res).get(0));
    		setJeu.add(verites.get(res));
        	setJeu.add(mensonges.get(res).get(1));
        	setJeu.add(mensonges.get(res).get(2));
    		break;
    	case 2 :
    		setJeu.add(mensonges.get(res).get(0));
        	setJeu.add(mensonges.get(res).get(1));
    		setJeu.add(verites.get(res));
        	setJeu.add(mensonges.get(res).get(2));
    		break;
    	case 3 :
    		setJeu.add(mensonges.get(res).get(0));
        	setJeu.add(mensonges.get(res).get(1));
        	setJeu.add(mensonges.get(res).get(2));
    		setJeu.add(verites.get(res));
    		break;   		
    	}
    	return setJeu;	
    }
    
    public int getPlaceVerite() {
    	return placeVerite;
    }

	public int getChoix() {
		return choix;
	}
        
}
