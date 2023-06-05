package StepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class steps {

    public ArrayList<String> songs=new ArrayList<>(10);
    public ArrayList<String> playlistSongs;
    public String lastSong;
    public  Integer Users;
    public  Integer capacity;
    public HashMap<String,Object> userSongsPair;

    @Given("User reads the songs in the given {string} with {int} and {int}")
    public void user_reads_the_songs_in_the_given(String artist,Integer users,Integer capacity) throws IOException {
        File file = new File("C:\\Users\\god\\IdeaProjects\\playlist\\TestData\\"+artist+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        this.Users=users;
        String song;
        this.capacity=capacity;
        while ((song = br.readLine()) != null) {
            songs.add(song);
        }
    }

    @When("User selects {int} songs and plays it in an order")
    public void user_selects_songs_and_plays_it_in_an_order(Integer numberOfSongs) {
        Random rand = new Random();
        String song = null;
        userSongsPair=new HashMap<>();
        ArrayList<String> songsForUser;
        for(int i=0;i<Users;i++) {
            songsForUser=new ArrayList<>(numberOfSongs);
            songsForUser= (ArrayList<String>) this.songs.clone();
            playlistSongs = new ArrayList<>(numberOfSongs);
            System.out.println("User "+(i+1)+" is listening to");
            for (int j = 0; j < numberOfSongs; j++) {
                int randomIndex = rand.nextInt(songsForUser.size());
                song = songsForUser.get(randomIndex);
                songsForUser.remove(randomIndex);
                System.out.println("Now Playing.........." + song);
                playlistSongs.add(song);
                if(playlistSongs.size()>capacity){
                    playlistSongs.remove(0);
                }
            }
            userSongsPair.put("User "+(i+1),playlistSongs);
        }

    }

    @Then("User validates the top {int} songs in the playlist")
    public void user_validates_the_top_songs_in_the_playlist(Integer capacity) {
        int size = playlistSongs.size();
        for (Map.Entry<String, Object> mapElement : userSongsPair.entrySet()) {
            System.out.println("Recent Songs of " + mapElement.getKey() );
            ArrayList<String> RecentSongs = (ArrayList<String>) mapElement.getValue();
            for (String song : RecentSongs) {
                System.out.println(song);
            }
        }
    }

}