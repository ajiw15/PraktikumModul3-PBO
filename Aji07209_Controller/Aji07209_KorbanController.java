package Aji07209_Controller;

import Aji07209_Entity.Aji07209_DataKorbanEntity;
import Aji07209_Entity.Aji07209_KorbanEntity;
import java.util.Date;

public class Aji07209_KorbanController implements Aji07209_ControllerInterfaces {
    int indexLogin=0;
    
        
    public Aji07209_KorbanEntity getData(){
        return Aji07209_AllObjectModel.korbanModel.getkorbanEntityArrayList(indexLogin);
       }
    
    public void daftarstatus (int indexStatus, Aji07209_KorbanEntity korban){
       Aji07209_AllObjectModel.datakorbanModel.insertDataDataKorban(new Aji07209_DataKorbanEntity(indexStatus,korban));
    }
    
    @Override
    public void login (String nik , String nama){
        indexLogin = Aji07209_AllObjectModel.korbanModel.cekData(nik, nama);
    }
      
    public void insert (String Aji07209_nik, String Aji07209_nama,
               String Aji07209_pekerjaan,String Aji07209_goldarah,String Aji07209_agama,
               String Aji07209_jeniskelamin,String Aji07209_notelp,
               String Aji07209_bantuan,Date Aji07209_TglLahir){
       Aji07209_AllObjectModel.korbanModel.insert(new Aji07209_KorbanEntity(Aji07209_nik,Aji07209_nama,Aji07209_pekerjaan,Aji07209_goldarah,
            Aji07209_agama,Aji07209_jeniskelamin, Aji07209_notelp,Aji07209_bantuan,Aji07209_TglLahir));
    }
    
     public Aji07209_KorbanEntity korban(){
        return Aji07209_AllObjectModel.korbanModel.getkorbanEntityArrayList(indexLogin);
    }
    
    public int cekDataKorban(String nik){
        int cek = Aji07209_AllObjectModel.datakorbanModel.cekData(nik, null);
        return cek;
    }
    
    public Aji07209_DataKorbanEntity showDataKorban (int index){
        return Aji07209_AllObjectModel.datakorbanModel.showDataKorban(index);
    }

    public void update(String nik) {
        Aji07209_AllObjectModel.datakorbanModel.update(nik);
    }
}
