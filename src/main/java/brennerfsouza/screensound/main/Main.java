package brennerfsouza.screensound.main;

import java.util.Scanner;

public class Main {
    private Scanner reader = new Scanner(System.in);

    public void menuShow() {
        var operation = -1;


        while (operation != 0) {
            System.out.println("""
                    *** Menu ***
                     1- Cadastrar artistas
                     2- Cadastrar músicas
                     3- Listar músicas
                     4- Buscar músicas por artistas
                                    
                     0 - Fechar programa
                    """);
            operation = reader.nextInt();
            reader.nextLine();

            switch (operation) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    searchMusicByArtist();
                    break;
                case 0:
                    System.out.println("Finalizando Sistema!");
                    break;
            }


        }

    }

    private void registerArtist() {
        System.out.println(1);
    }

    private void registerMusic() {
        System.out.println(2);
    }

    private void listMusics() {

    }

    private void searchMusicByArtist() {

    }




}
