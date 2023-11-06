public class Main {
    public static void main(String[] args) {
        ProductDatabase productDatabase = new ProductDatabase();
        CommandLine commandline = new CommandLine(productDatabase);
        commandline.start();
    }
}
