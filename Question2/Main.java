package Question2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nama dan nama teman:");

        String namaTeman = input.nextLine().trim();
        String daftarNama = input.nextLine().trim();
        input.close();
        
        String[] kumpulanNama = daftarNama.split(" ");
        Queue<String> antreanOrang = new LinkedList<>();
        for (String nama : kumpulanNama) {
            antreanOrang.add(nama);
        }
        
        Stand standTeman;
        if (namaTeman.equalsIgnoreCase("Josuke")) {
            standTeman = new StandJosuke();
        } else if (namaTeman.equalsIgnoreCase("Jotaro")) {
            standTeman = new StandJotaro();
        } else if (namaTeman.equalsIgnoreCase("Okuyasu")) {
            standTeman = new StandOkuyasu();
        } else if (namaTeman.equalsIgnoreCase("Koichi")) {
            standTeman = new StandKoichi();
        } else if (namaTeman.equalsIgnoreCase("Rohan")) {
            standTeman = new StandRohan();
        } else {
            standTeman = new Stand(); 
        }

        StandDetektif standKita = new StandDetektif();
        Stack<String> tumpukanPenjara = new Stack<>();
        
        while (!antreanOrang.isEmpty()) {
            String orangYangDiperiksa = antreanOrang.poll(); 
            boolean ketahuan = standTeman.cekPenjahat(orangYangDiperiksa);
            
            if (ketahuan == true) {
                standKita.tangkap(orangYangDiperiksa, tumpukanPenjara);
            }
        }
        
        if (tumpukanPenjara.isEmpty()) {
            System.out.println(namaTeman + " exposed no one.");
        } else {
            System.out.println(namaTeman + " exposed someone!");
        }
        
        System.out.println("Arrested: " + tumpukanPenjara.toString());
    }
}

class Stand {
    public boolean cekPenjahat(String nama) {
        return false; 
    }
    
    public void tangkap(String nama, Stack<String> penjara) {
    }
}

class StandDetektif extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        return false; 
    }
    
    @Override
    public void tangkap(String nama, Stack<String> penjara) {
        penjara.push(nama); 
    }
}

class StandJosuke extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        return nama.toLowerCase().startsWith("k");
    }
}

class StandJotaro extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        return nama.length() <= 3;
    }
}

class StandOkuyasu extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        String namaKecil = nama.toLowerCase();
        for (int i = 0; i < namaKecil.length() - 1; i++) {
            if (namaKecil.charAt(i) == namaKecil.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

class StandKoichi extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        int jumlahVokal = 0;
        String namaKecil = nama.toLowerCase();
        for (char huruf : namaKecil.toCharArray()) {
            if (huruf == 'a' || huruf == 'e' || huruf == 'i' || huruf == 'o' || huruf == 'u') {
                jumlahVokal++;
            }
        }
        return jumlahVokal >= 3;
    }
}

class StandRohan extends Stand {
    @Override
    public boolean cekPenjahat(String nama) {
        String namaKecil = nama.toLowerCase();
        String namaDibalik = new StringBuilder(namaKecil).reverse().toString();
        
        if (namaKecil.equals(namaDibalik) && namaKecil.length() > 1) {
            return true;
        } else {
            return false;
        }
    }
}