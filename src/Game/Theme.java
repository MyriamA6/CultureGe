package Game;
import java.util.ArrayList;
import java.util.Random;

public abstract class Theme {
	protected ArrayList<ArrayList<String>> mensonges;
    protected ArrayList<String> verites;
    protected ArrayList<Integer> choosenNumbers= new ArrayList<Integer>();
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
    
    public ArrayList<String> gameSet(){
    	ArrayList<String> setJeu = new ArrayList<String>();
    	alea=new Random();
    	int res = alea.nextInt(verites.size());
    	while (choosenNumbers.contains(res)) {
    		res=alea.nextInt(verites.size());
    	}
    	choosenNumbers.add(res);
    	System.out.println(res);
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
        
}
