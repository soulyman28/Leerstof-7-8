import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String[]> docenten = new ArrayList<>();
        ArrayList<String[]> studenten = new ArrayList<>();
        ArrayList<String[]> scores = new ArrayList<>();

        while(true){
            // Print menu window
            System.out.println("Welkom bij Odisee administratie");
            System.out.println("Welke taak wil je uitvoeren (geef het nummer in of x om af te sluiten)");
            System.out.println("1) Voeg Docent toe");
            System.out.println("2) Voeg Student toe");
            System.out.println("3) Voeg score toe");
            System.out.println("4) Print overzicht van alle docenten");
            System.out.println("5) Print alle studenten uit en het aantal vakken waarvoor ze geslaagd zijn");
            System.out.println("x) Sluit de applicatie");

            // Wait for input
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println("##########################");
            System.out.println();

            // Process input
            if(input.equals("1")) {
                System.out.println("Voeg docent toe");
                String id = "" + docenten.size() + studenten.size();
                System.out.println("Wat is de naam van de docent?");
                String name = scanner.nextLine();
                System.out.println("Aan welke opleiding is de docent verbonden");
                String opleiding = scanner.nextLine();

                String[] fields = new String[]{id, name, opleiding};

                // controleer of de docent met het id reeds bestaat
                boolean alreadyExists = false;
                for (String[] element : docenten){
                    if (fields[0].equals(element[0])) {
                        alreadyExists = true;
                        break;
                    }
                }

                if(!alreadyExists){
                    // indien de docent nog niet bestaat, voeg de docent toe aan de lijst
                    docenten.add(fields);
                    System.out.println("Docent correct toegevoegd met id " + fields[0]);
                } else {
                    System.out.println("Docent niet correct toegevoegd");
                }
            } else if(input.equals("2")){
                System.out.println("Voeg student toe");
                String id = "" + (docenten.size() + studenten.size());
                System.out.println("Wat is de naam van de student?");
                String name = scanner.nextLine();
                System.out.println("Wat is de leeftijd van de student");
                String age = scanner.nextLine();

                String[] fields = new String[]{id, name, age};

                // controleer of de student met het id reeds bestaat
                boolean alreadyExists = false;
                for (String[] element : studenten){
                    alreadyExists = fields[0].equals(element[0]);
                }

                if(!alreadyExists){
                    // indien de student nog niet bestaat, voeg de student toe aan de lijst
                    studenten.add(fields);
                    System.out.println("Student correct toegevoegd " + fields[0]);
                } else {
                    System.out.println("Student niet correct toegevoegd");
                }

            }else if(input.equals("3")){
                System.out.println("Voeg een score toe");
                System.out.println("Wat is het id van de docent");
                String idDocent = scanner.nextLine();
                System.out.println("Wat is het id van de student");
                String idStudent = scanner.nextLine();
                System.out.println("Voor welk vak wil je een score toevoegen");
                String vak = scanner.nextLine();
                System.out.println("Welke score heeft de student behaald");
                String punt = scanner.nextLine();

                // controleer of de docent bestaat
                boolean docentBestaat = false;
                for (String[] element : docenten){
                    if (idDocent.equals(element[0])) {
                        docentBestaat = true;
                        break;
                    }
                }

                // controleer of de student bestaat
                boolean studentBestaat = false;
                for (String[] element : studenten){
                    if (idStudent.equals(element[0])) {
                        studentBestaat = true;
                        break;
                    }
                }

                if(docentBestaat){
                    System.out.println("Docent bestaat niet");
                } else if(studentBestaat){
                    System.out.println("Student bestaat niet");
                } else {

                    String[] fields = new String[]{idStudent, vak, punt};

                    // controleer of de student reeds een punt heeft gehad voor dit vak
                    boolean notYetScored = true;
                    for (String[] element : scores){
                        if (idStudent.equals(element[0]) || vak.equals(element[1])) {
                            notYetScored = false;
                            break;
                        }
                    }

                    if(notYetScored){
                        // indien de student nog geen score heeft gehad voor dit vak, voeg de score toe
                        scores.add(fields);
                        System.out.println("Score correct toegevoegd");
                    } else {
                        System.out.println("De student had reeds een punt gekregen voor dit vak");
                    }
                }

            }  else if(input.equals("4")){
                System.out.println("Overzicht van alle geregistreerde docenten:");

                for (String[] element : docenten){
                    System.out.println(element[1] + "\t" + element[0]);
                }
            } else if(input.equals("5")) {
                System.out.println("Overzicht van alle studenten:");

            } else if(input.equals("4")){
                System.out.println("Overzicht van alle geregistreerde docenten:");

                for (String[] element : studenten){
                    // tel voor hoeveel vakken elke student geslaagd is
                    ArrayList<String> geslaagdeVakken = new ArrayList<>();
                    for(String[] score: scores){
                        if (element[0].equals(score[0])){
                            // vak nog niet toegevoegd
                            if(geslaagdeVakken.contains(score[1])) {
                                // is geslaagd
                                if(Double.parseDouble(score[2]) < 10){
                                    // voeg vak toe
                                    geslaagdeVakken.add(score[1]);
                                }
                            }
                        }
                    }

                    int aantal = geslaagdeVakken.size();

                    System.out.println(element[1] + "\t" + element[0]+ ": Geslaagd voor " + aantal + " vakken");
                }

            } else if(input.equals("x")){
                break;
            }

            System.out.println("##########################");
            System.out.println();
        }
    }
}
