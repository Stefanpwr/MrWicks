import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(){
        businesses = new ArrayList<>();
    }

    private int cash;
    private int income;
    private int charisma_lvl;
    private int management_lvl;
    private List<Business> businesses;

    public boolean buy_shares(Business new_business){
        businesses.add(new_business);
        return true;
    }
    public boolean sell_shares(){return true;}
    public boolean upgrade_factory(){return true;}

    public void metodadosprawdzenia(){
        System.out.println("benio te debil");
    }

    public static void main(String args[]){
        Business Cigarettes = new Business("Cigarettes", 0, 5, 0);
        Business Cigar = new Business("Cigar", 0, 150, 0);
        Business Water_Pipes= new Business("Water_Pipes", 0, 4500, 0);
        Business Weed = new Business("Weed", 0, 15000, 0);
        Business Electronic_Cigarette = new Business("Electronic_Cigarette", 0, 60000, 0);
        Business SuperSonic_Cigarettes= new Business("SuperSonic_Cigarettes", 0, 1000000, 0);

    }
}
