package nl.saxion.oop.week1;

import nl.saxion.app.CsvReader;
import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;

public class Application implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Application(), 1200, 600);
    }

    public void run() {
        CsvReader reader = new CsvReader("Exercise2/youtubevideos.csv");
        reader.skipRow();
        reader.setSeparator(';');

        ArrayList<Video> videos = new ArrayList<>();

        while (reader.loadRow()){
            Video video = new Video();
            video.setId(reader.getString(0));
            video.setTitle(reader.getString(1));
            video.setViews(reader.getInt(3));
            video.setSeen(false);
            videos.add(video);
        }

        int menuInput = -1;
        do {
            SaxionApp.clear();
            SaxionApp.printLine("***************************************");
            SaxionApp.printLine("* 1) Show watchlist ");
            SaxionApp.printLine("* 2) Watch video");
            SaxionApp.printLine("* 0) Exit program");
            SaxionApp.printLine("***************************************");

            SaxionApp.print("Please make a selection from the menu: ");
            menuInput = SaxionApp.readInt();

            SaxionApp.printLine();

            if (menuInput == 1) {

                int count = 1;
                for (Video v: videos){
                    SaxionApp.print(count + ") "+ v);
                    if (v.isSeen()) {
                        SaxionApp.printLine("[WATCHED]", Color.GREEN);
                    } else {
                        SaxionApp.printLine("[NOT WATCHED]", Color.RED);
                    }
                    count++;

                }

                SaxionApp.pause();
            } else if (menuInput == 2) {

                watch(videos);
                SaxionApp.pause();

            } else {

                SaxionApp.printLine("Goodbye!");
                
            }

        } while (menuInput != 0);
    }

    public void watch(ArrayList<Video> v) {
        int count = 1;
        for (Video video : v) {
            SaxionApp.print(count + ") " + video);
            if (video.isSeen()) {
                SaxionApp.printLine("[WATCHED]", Color.GREEN);
            } else {
                SaxionApp.printLine("[NOT WATCHED]", Color.RED);
            }
            count++;
        }

        SaxionApp.printLine("Pick a video to watch: ");
        int c = SaxionApp.readInt();
        if(c < v.size()-1) {
            if (!v.get(c-1).isSeen()) {
                SaxionApp.printLine("You have watched: ");
                SaxionApp.printLine(v.get(c - 1), Color.orange);
                v.get(c-1).setSeen(true);
            } else {
                SaxionApp.printLine("You have already watched this video!");
            }
        } else {
            SaxionApp.printLine("Couldn't find a video with index " + c + "!", Color.RED);
        }




    }
}