import java.util.ArrayList;

/**
 * Created by rudolf on 2.02.2017.
 */
public class Andmebaas {
    int laoseis;
    int päevad;
    int laostSaadetud;
    int kokkuMüüdud;
    int koguKasum;
    int tänaMüüdud;
    int suurimPäevaMüük;
    int suurimaPäevaMüügiIndeks;
    ArrayList müügiHinnad = new ArrayList();
    ArrayList päevaKasumid = new ArrayList();

    Andmebaas(String firma){
        String firmanimi = firma;
    }

    void alustaPäeva(int tulnudkaup){
        laoseis += tulnudkaup;
        laostSaadetud += tulnudkaup;
    }

    void lõpetaPäev(int müüdudkaup, int müügihind){
        laoseis -= müüdudkaup;
        müügiHinnad.add(müügihind);
        päevaKasumid.add((müügihind-2)*müüdudkaup);
        päevad++;
        kokkuMüüdud += müüdudkaup;
        tänaMüüdud = müüdudkaup;
        System.out.println(müügiHinnad);
        System.out.println(päevaKasumid);
    }

    String kuvaStatistika(){
        return "Seni arvet peetud päevi: " + päevad + "\nViimase päeva lõpu laoseis: " + laoseis
                + "\nLaost kokku saadetud: " + laostSaadetud+"\nKokku müüdud: "+kokkuMüüdud;
    }
    int kasum(){
        koguKasum = 0;
        for (int i = 0; i < päevaKasumid.size(); i++) {
            koguKasum += (int) päevaKasumid.get(i);
        }
        return  koguKasum;
    }

    int efektiivseimHind(){
        for (int i = 0; i < päevaKasumid.size(); i++) {
            if((int)päevaKasumid.get(i)>suurimPäevaMüük){
                suurimPäevaMüük = (int)päevaKasumid.get(i);
                suurimaPäevaMüügiIndeks = i;
            }
        }
        return (int) müügiHinnad.get(suurimaPäevaMüügiIndeks);
    }

}
