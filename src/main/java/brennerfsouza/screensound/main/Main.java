package brennerfsouza.screensound.main;

import brennerfsouza.screensound.model.Artist;
import brennerfsouza.screensound.model.ArtistType;
import brennerfsouza.screensound.model.Music;
import brennerfsouza.screensound.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private Scanner reader = new Scanner(System.in);

    private ArtistRepository repository;

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

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
        var registerNew = "s";
        while (registerNew.equalsIgnoreCase("s")) {

            System.out.println("Digite o nome do Artista:");
            var name = reader.nextLine();
            System.out.println("Digite o tipo do Artista: (Solo, Duo ou Band)");
            var type = reader.nextLine();
            ArtistType artistType = ArtistType.valueOf(type.toUpperCase());

            Artist artist = new Artist(name, artistType);
            repository.save(artist);
            System.out.println("Cadastrar novo Artista? (S/N)");
            registerNew = reader.nextLine();
        }

    }

    private void registerMusic() {
        System.out.println("Cadastrar musica de qual artista?");
        var name = reader.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);
        if (artist.isPresent()) {
            System.out.println("Diga o nome da musica:");
            var musicName = reader.nextLine();
            Music music = new Music(musicName);
            music.setArtist(artist.get());
            artist.get().getMusics().add(music);
            repository.save(artist.get());
        } else {
            System.out.println("Artista não cadastrado");
        }
    }


    private void listMusics() {
        List<Artist> artists = repository.findAll();
        artists.forEach(System.out::println);
    }

    private void searchMusicByArtist() {
        System.out.println("Digite o nome do Artista:");
        var name = reader.nextLine();
        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);
        if (artist.isPresent()) {
            artist.get().getMusics().forEach(System.out::println);

        }
    }


}
