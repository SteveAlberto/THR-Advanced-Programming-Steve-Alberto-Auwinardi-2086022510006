package Question4;

public class Main {
    public static void main(String[] args) {
        Dvd kasetDvd = new Dvd("Baby be Mine", 1982, 50000, 4);
        Magazine majalah = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Vinyl piringanHitam = new Vinyl("Song of The Wind", 1967, 350000, 12);

        kasetDvd.getDescription();
        System.out.println(); 

        majalah.getDescription();
        System.out.println();
        
        piringanHitam.getDescription();
    }
}

class ProdukDagangan {
    protected String judulBarang;
    protected int tahunRilis;
    protected double hargaBarang; 
    
    public ProdukDagangan(String judul, int tahun, double harga) {
        if (judul.length() < 255) {
            this.judulBarang = judul;
        } else {
            this.judulBarang = judul.substring(0, 254); 
        }

        if (tahun > 1800 && tahun < 2026) {
            this.tahunRilis = tahun;
        } else {
            this.tahunRilis = 0; 
        }

        this.hargaBarang = harga;
    }

    public void getDescription() {
        System.out.println("Title: " + this.judulBarang);
        System.out.println("releaseYear: " + this.tahunRilis);
        System.out.println("Price: " + (long)this.hargaBarang);
    }
}

class Dvd extends ProdukDagangan {
    private double durasiTonton; 

    public Dvd(String judul, int tahun, double harga, double durasi) {
        super(judul, tahun, harga); 
        
        if (durasi < 720) {
            this.durasiTonton = durasi;
        } else {
            this.durasiTonton = 0;
        }
    }

   @Override
    public void getDescription() {
        super.getDescription(); // Mencetak judul, tahun, harga terlebih dahulu
        System.out.println("Runtime: " + (long)this.durasiTonton + " minutes"); // Ditambah durasi khusus DVD
    }
}

class Magazine extends ProdukDagangan {
    private String namaPenulis; 
    private int jumlahHalaman;

    public Magazine(String judul, int tahun, double harga, String penulis, int halaman) {
        super(judul, tahun, harga);
        
        if (penulis.length() < 50) {
            this.namaPenulis = penulis;
        } else {
            this.namaPenulis = penulis.substring(0, 49);
        }
        
        this.jumlahHalaman = halaman;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + this.namaPenulis);
        System.out.println("Number of Pages: " + this.jumlahHalaman);
    }
}

class Vinyl extends ProdukDagangan {
    private int ukuranInci;

    public Vinyl(String judul, int tahun, double harga, int ukuran) {
        super(judul, tahun, harga);
        
        if (ukuran <= 12) {
            this.ukuranInci = ukuran;
        } else {
            this.ukuranInci = 0;
        }
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + this.ukuranInci);
    }
}