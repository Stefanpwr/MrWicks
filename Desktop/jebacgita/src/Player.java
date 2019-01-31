import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(){
        businesses = new ArrayList<>();
    }

    private int cash;
    private int income;
    private int charisma_lvl;
    private int rudychuj;
    private int management_lvl;
    private List<Business> businesses;

    public boolean buy_shares(Business new_business){
        businesses.add(new_business);
        return true;
    }
    public boolean sell_shares(){return true;}
    public boolean upgrade_factory(){return true;}



    public static void main(String args[]){

    }
}
