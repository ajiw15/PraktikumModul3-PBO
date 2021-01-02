package Aji07209_SistemInformasiPendataanKorbanBencana;

import Aji07209_Entity.Aji07209_StatusEntity;
import Aji07209_Controller.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Aji07209_Main {
    private static Aji07209_KorbanController korban = new Aji07209_KorbanController();
    private static Scanner input = new Scanner (System.in);

    
     public static void main(String[] args){
        int loop=0;
        do{
           int pilih = 0 ;
           System.out.print("\n Sistem Informasi Korban Bencana" +
                            "\n 1. Daftar Korban Baru" +
                            "\n 2. Login Data Korban" +
                            "\n 3. Update Status "+
                            "\n 0. Stop" +
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                                if(pilih == 1){
                                  daftar();
                              }else if(pilih == 2){
                              logindata();
                              }else if(pilih == 3){
                              updatestatus();
                              }else if(pilih == 4){
                              }else{
                                break;
            }
        }while (loop != 1);
     }
        
    static void daftar(){
        try{
        System.out.print(" Input NIK = ");
        String nik = input.next();
        System.out.print(" Input Nama = ");
        String nama = input.next();
        System.out.print(" Input Pekerjaan = ");
        String pekerjaan = input.next();
        System.out.print(" Input Golongan Darah = ");
        String goldar =  input.next();
        System.out.print(" Input Agama = ");
        String agama =  input.next();
        System.out.print(" Input Jenis Kelamin = ");
        String jeniskelamin =  input.next();
        System.out.print(" Input No Telp = ");
        String notelp =  input.next();
        System.out.print(" Input Tgl Lahir (mm/dd/yyyy) = ");
        Date tanggal = new Date(input.next());
        System.out.print(" Bantuan = ");
        String bantuan = input.next();
        korban.insert(nik,nama,pekerjaan,goldar,
                agama,jeniskelamin,notelp,bantuan,tanggal);
        System.out.println(" Daftar Sukses !!");
        }catch (Exception exception){
          System.out.println("Format Pengisian Salah !!");
        }
    }

    static void logindata(){
        System.out.print(" NIK : ");
        String nik = input.next();
        System.out.print(" Nama : ");
        String nama = input.next();
        korban.login(nik, nama);
        System.out.println("\n Data Dari "+korban.korban().getAji07209_nama());
        int cek = korban.cekDataKorban(korban.korban().getAji07209_nik());
        if (cek == -1){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else if(cek == -2){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else{
        System.out.println(" Nama = "+korban.showDataKorban(cek).
                getKorban().getAji07209_nama());
        System.out.println(" NIK = "+korban.showDataKorban(cek).
                getKorban().getAji07209_nik());
        System.out.println(" Pekerjaan = "+korban.showDataKorban(cek).
                getKorban().getAji07209_pekerjaan());
        System.out.println(" Golongan Darah = "+korban.showDataKorban(cek).
                getKorban().getAji07209_goldarah());
        System.out.println(" Agama = "+korban.showDataKorban(cek).
                getKorban().getAji07209_agama());
        System.out.println(" Jenis Kelamin = "+korban.showDataKorban(cek).
                getKorban().getAji07209_jeniskelamin());
        System.out.println(" No Telp = "+korban.showDataKorban(cek).
                getKorban().getAji07209_notelp());
        System.out.println(" Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").
                format(korban.showDataKorban(cek)
                .getKorban().getAji07209_TglLahir()));
        System.out.println(" Status Korban = "+Aji07209_StatusEntity.Aji07209_Status
                [korban.showDataKorban(cek).getIndexStatus()]);
        }
    }
    
    static void daftarstatus(){
        System.out.print(" Pilih Status = \n");
        for(int i=0;i<Aji07209_StatusEntity.Aji07209_Status.length;i++){
        System.out.println(i+". "+Aji07209_StatusEntity.Aji07209_Status[i]);
        }
        System.out.print(" Pilih Status = ");
           int  pilstatus = input.nextInt();
            korban.daftarstatus(pilstatus,korban.getData());
        }
   
    static void updatestatus(){
        System.out.print(" Input NIK = ");
        String nik = input.next();
        korban.update(nik);
    }
}
