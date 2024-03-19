public class GameOfLife {
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12);

        verden.tegn();
        verden.oppdatering();
        verden.tegn();
        verden.oppdatering();
        verden.tegn();
        verden.oppdatering();
    }
}
