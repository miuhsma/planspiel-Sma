package ui;

public enum BUTTON {
    STARTGAME("Start"), 
    SETTINGS("Einstellungen"), 
    ABOUTUS("Über uns"), 
    EXIT("Schließen"),
    CONTINUE_TO_GAME("Spielen!"),
    ANSWER("_ANTWORT"),
    SCENARIO_DARKNET("Es wurde Daten im Darknet veröffentlicht"),
    SCENARIO_SUPPLIER("Ein Zulieferer wurde gehackt");
    
/*
 *  message = "Sie können nun aus 5 verschiedenen Szenarien wählen\n" + 
                "=============================================\n" +
                "1. Daten im Darknet veröffentlicht\n" + 
                "---------------------------------------------\n" +
                "2. Ein Zulieferer wurde gehackt\n" + 
                "---------------------------------------------\n" +
                "3. Gestörte Windkraftanlagen\n" + 
                "---------------------------------------------\n" +
                "4. Diebstahl von 30 Bitcoin\n" + 
                "---------------------------------------------\n" +
                "5. Mitarbeiter verliert USB-Stick\n" + 
                "---------------------------------------------\n";
 */

    private String name;
    BUTTON(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
