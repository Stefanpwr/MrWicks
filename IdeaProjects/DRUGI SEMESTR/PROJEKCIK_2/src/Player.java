import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Player {

    public Player(){
        this.businesses = new ArrayList<>();
        this.cash = 5;
        this.income=0;
        this.charisma_lvl=1;
        this.management_lvl=1;
    }

    private int cash;
    private int income;
    private int charisma_lvl;
    private int management_lvl;
    private List<Business> businesses;

    public boolean buy_shares(String name){
        for(Business s : businesses ){
            if(s.get_name().equals(name)) {
                if (cash >= s.getPrice()) {
                    s.setFactory_lvl(s.getFactory_lvl() + 1);
                    s.setIncome((s.getIncome() * 105) / 100);
                    cash=cash-s.getPrice();
                    s.setPrice((s.getPrice()*120) / 100);
                }
                return true;
            }
        }
        return false;
    }

    public boolean sell_shares(){return true;}
    Runnable add_cash = new Runnable(){
        public void run(){
            int added=0;
            for(Business s : businesses){
                added+=s.getIncome();
            }
        }
    };


    public void metodadosprawdzenia(){
        System.out.println("benio te debil");
    }

    public static void main(String args[]){
        Player player = new Player();
        Business Cigarettes = new Business("Cigarettes", 0, 5, 0);
        player.businesses.add(Cigarettes);
        Business Cigar = new Business("Cigar", 0, 150, 0);
        player.businesses.add(Cigar);
        Business Water_Pipes= new Business("Water_Pipes", 0, 4500, 0);
        player.businesses.add(Water_Pipes);
        Business Weed = new Business("Weed", 0, 15000, 0);
        player.businesses.add(Weed);
        Business Electronic_Cigarette = new Business("Electronic_Cigarette", 0, 60000, 0);
        player.businesses.add(Electronic_Cigarette);
        Business SuperSonic_Cigarettes= new Business("SuperSonic_Cigarettes", 0, 1000000, 0);
        player.businesses.add(SuperSonic_Cigarettes);
        System.out.println("jebac rudego");



    }
}
