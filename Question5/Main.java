package Question5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Book> tumpukanBuku = new Stack<>();

        Book buku1 = new Book("Why Black Moves First", "Wesley So", 2025);
        GeneralBook buku2 = new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary");
        ChildrenBook buku3 = new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true);

        tumpukanBuku.push(buku1);
        tumpukanBuku.push(buku2);
        tumpukanBuku.push(buku3);

        tumpukanBuku.push(new Book("Buku 4", "Penulis A", 2025));
        tumpukanBuku.push(new Book("Buku 5", "Penulis B", 2026));

        for (int i = 0; i < 3; i++) {
            tumpukanBuku.get(i).getInfo();
            
            if (i < 2) {
                System.out.println();
            }
        }
    }
}

class Book {
    protected String judulBuku;
    protected String namaPenulis;
    protected int tahunTerbit;

    public Book(String judul, String penulis, int tahun) {
        if (judul.length() < 255) {
            this.judulBuku = judul;
        } else {
            this.judulBuku = judul.substring(0, 254);
        }

        if (penulis.length() < 50) {
            this.namaPenulis = penulis;
        } else {
            this.namaPenulis = penulis.substring(0, 49);
        }

        // Constraint: 1800 < year < 2026
        if (tahun > 1800 && tahun < 2026) {
            this.tahunTerbit = tahun;
        } else {
            this.tahunTerbit = 0;
        }
    }

    public void getInfo() {
        System.out.println("Title: " + this.judulBuku);
        System.out.println("Author: " + this.namaPenulis);
        System.out.println("Year of Publication: " + this.tahunTerbit);
    }
}

class GeneralBook extends Book {
    private String genreBuku;

    public GeneralBook(String judul, String penulis, int tahun, String genre) {
        super(judul, penulis, tahun); 
        
        if (genre.length() <= 30) {
            this.genreBuku = genre;
        } else {
            this.genreBuku = genre.substring(0, 30);
        }
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + this.genreBuku);
    }
}

class ChildrenBook extends Book {
    private int batasUmur;
    private boolean adaVisualisasi;

    public ChildrenBook(String judul, String penulis, int tahun, int umur, boolean visual) {
        super(judul, penulis, tahun); 
        
        if (umur > 3 && umur < 12) {
            this.batasUmur = umur;
        } else {
            this.batasUmur = 4; 
        }
        this.adaVisualisasi = visual;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + this.batasUmur);
        
        if (this.adaVisualisasi) {
            System.out.println("Has Visualisation: Yes");
        } else {
            System.out.println("Has Visualisation: No");
        }
    }
}