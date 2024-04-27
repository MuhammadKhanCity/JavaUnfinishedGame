package game.Other;

import game.Characters.MainCharacter;
import game.GameLevels.GameWorld;
import game.GameLevels.Level1;
import game.GameLevels.Level2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class GameSaverLoader {


    public GameSaverLoader(String fileName){

    }

    public static void Save(GameWorld level, MainCharacter mainCharacter, String FileName) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(FileName, append);
            writer.write(level.GetLevelName() + "," + mainCharacter.getCoinCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    public static GameWorld Load(String FileName) throws IOException{
        FileReader fr = null;
        BufferedReader reader = null;
        GameWorld level = null;
        try {
            fr = new FileReader(FileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // file is assumed to contain one name, score pair per line
                String[] tokens = line.split(",");

                if (tokens[0].equals("Level1")){
                    level = new Level1();
                    Game.setLevel(level);
                } else if (tokens[0].equals("Level2")) {
                    level = new Level2();
                    Game.setLevel(level);
                }
                //int score = Integer.parseInt(tokens[1]);
                line = reader.readLine();
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return level;
    }
}
