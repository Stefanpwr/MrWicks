 public class Business {
    private String name;
    private int factory_lvl;
    private int price;
    private int income;
    public Business(String name, int factory_lvl, int price, int income){
        this.name=name;
        this.factory_lvl = factory_lvl;
        this.price = price;
        this.income = income;

    }


    public void metoda(String komunikat){
        System.out.println(komunikat);
        System.out.println("nic waznego");
        System.out.println("znowu nic waznego");
    }

    public int funkcjaDodawania(int a, int b){
        return a+b;
    }

}
