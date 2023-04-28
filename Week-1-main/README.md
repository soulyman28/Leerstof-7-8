# Opdracht week 1

In deze repository staat de opgave van de eerste week.
Het is bedoeling dat je bij het uitwerken van deze opgave gebruik maakt van de programmeertaal Java en de IDE IntelliJ.
Deze code moet ingediend worden voor de volgende les door deze te **pushen naar deze github Repository**.
Deze opgave wordt individueel gemaakt.

# Oefening 1

Maak een IntelliJ project aan in een folder met de naam Toegangscontrole.
In dit project gaan we een console-applicatie schrijven om te controleren of er nog voldoende plaats is op een veerboot voor een bepaald voertuig.
Dit project moet bestaan uit twee klassen namelijk Veerboot en VeerbootGebruik

De klasse Veerboot beschikt over 3 publieke properties, namelijk:
* aantalAutos: deze begint op 0
* aantalBussen: deze begint op 0
* capaciteit: de beginwaarde is 15

Daarnaast beschikt de Toegangscontrole klasse over de volgende methoden:
* voegAutoToe() die het aantal autos met 1 verhoogt en de capaciteit verlaagt met 1
* voegBusToe() die het aantal bussen verhoogt met 1 en de capaciteit verlaagt met 3
* magOpDeVeerboot(boolean isAuto) die een boolean returned die true is als de capaciteit ten minste 1 of 3 is voor respectievelijk een auto of een bus. In de andere gevallen geeft het false terug.

De klasse VeerbootGebruik bevat enkel een main methode.
In deze main methode worden de volgende stappen uitgevoerd:
* Maak een Veerboot-object aan met naam veerboot
* Daarna komen er 4 auto's toe die op de veerboot willen. Roep dus 4 keer de methode voegAutoToe op.
* Daarna komen er 3 bussen toe die op de veerboot willen. Roep dus 3 keer de methode voegBusToe op.
* Na een tijdje wil er nog een bus op de veerboot. Omdat de veerboot redelijk vol begint te geraken, controleer eerst of de bus op de veerboot mag met de magOpDeVeerboot functie. Indien deze functie true returned, voeg de bus toe.
* Print op dit punt eens de beschikbare capaciteit uit van de veerboot. Dit getal zou 2 moeten zijn.
* Na een tijdje wil er nog een auto op de veerboot binnenkomen. Controleer opnieuw of de auto nog op de veerboot past en voeg hem enkel toe indien het zo is.
* Print op dit punt nog eens de beschikbare capaciteit uit. Deze stap zou 1 moeten uitprinten.

# Oefening 2

Bestudeer het project in de SRP-opgave folder.
Beantwoord de volgende vragen in een aparte textfile of commentaar van de code.
* Wat doet dit project?
* Welke data wordt er bijgehouden? Wat stelt deze data voor?
* Wat kan er verbeterd worden?

Pas daarna op basis van je opmerkingen de cde in het project aan om je voorgestelde verbeteringen toe te voegen.
