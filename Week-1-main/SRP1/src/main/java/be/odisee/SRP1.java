package be.odisee;
import java.util.ArrayList;
import java.util.List;


public class SRP1 {


    public static int rekeningIndex = 0;
    static List<Rekening> rekeningen = new ArrayList<>();
    static {
        rekeningen.add(new Rekening(1, "me", 100.0));
        rekeningen.add(new Rekening(2, "myself", 0.0));
        rekeningen.add(new Rekening(666, "Geeraard", 666.0));
    }

    // wijzig de rekening
    public static void rekeningVerrichting (String type,double bedrag) {
        if(rekeningIndex >= rekeningen.size()) System.out.println("Rekening bestaat niet"); //Hebben we een rekening geselecteerd?
        Rekening rekening = rekeningen.get(rekeningIndex);
        if (type.equals("afhalen")) {
            if(rekening.getSaldo() < bedrag) {
                System.out.println("Te weinig op rekening");
            } else {
                rekening.setSaldo(rekening.getSaldo() - bedrag);
            }
        } else if (type.equals("storten")) {
            rekening.setSaldo(rekening.getSaldo() + bedrag);
        }
    }


    public static void main(String[] args) {
        System.out.println("Rekeningen aan de start:");
        for (Rekening rekening : rekeningen) {
            System.out.println(rekening);
        }

        rekeningIndex = 0;
        rekeningVerrichting("storten", 100.0);
        rekeningIndex = 2;
        rekeningVerrichting("afhalen", 200.0);
        rekeningIndex = 1;
        rekeningVerrichting("afhalen", 100.0);

        System.out.println("Rekeningen na transacties:");
        for (Rekening rekening : rekeningen) {
            System.out.println(rekening);
        }

// add a fourth account and initialize it to 0.0