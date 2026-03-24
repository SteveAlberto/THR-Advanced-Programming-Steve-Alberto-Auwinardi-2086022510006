package Question3;

public class Main {
    public static void main(String[] args) {
        Food pesanan1 = new Food("Beef Rendang", 15000);
        RegularMenu pesanan2 = new RegularMenu("Chicken Ramen", 20000);
        SpecialMenu pesanan3 = new SpecialMenu("Fiery Fried Rice", 80000);

        pesanan1.getInfo();
        System.out.println(); 

        pesanan2.getInfo();
        System.out.println();
        
        pesanan3.getInfo();
    }
}

class Food {
    protected String namaMakanan;
    protected int hargaDasar; 

    public Food(String namaMakanan, int hargaDasar) {
        if (hargaDasar >= 1000000) {
            System.out.println("Error: Harga dasar tidak boleh mencapai 1.000.000!");
            this.hargaDasar = 0; 
        } else {
            this.namaMakanan = namaMakanan;
            this.hargaDasar = hargaDasar;
        }
    }

    public int calcPrice() {
        int biayaTenagaKerja = 5000;
        return this.hargaDasar + biayaTenagaKerja;
    }

    public void getInfo() {
        System.out.println("Name: " + this.namaMakanan);
        System.out.println("Price: " + calcPrice());
    }
}

class RegularMenu extends Food {
    public RegularMenu(String namaMakanan, int hargaDasar) {
        super(namaMakanan, hargaDasar);
    }

    @Override
    public int calcPrice() {
        int pajakReguler = 10000;
        return super.calcPrice() + pajakReguler;
    }
}

class SpecialMenu extends Food {
    public SpecialMenu(String namaMakanan, int hargaDasar) {
        super(namaMakanan, hargaDasar);
    }

    @Override
    public int calcPrice() {
        int pajakSpesial = 20000;
        return super.calcPrice() + pajakSpesial;
    }
}
