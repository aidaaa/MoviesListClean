package eu.example.aida.movieslistclean.data.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aida on 12/31/2018.
 */

public class FileManagment {
    //read
    //write

    //last read
    //last write

    //exists


    public void writeJsonDataMovie(File file,String s){
        FileWriter writer=null;
        try {
            writer=new FileWriter(file);
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String readJsonDataMovie(File file){
        StringBuilder builder = new StringBuilder();
        if (isExiste(file)) {
            String read = null;
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                read = br.readLine();
                while (read != null) {
                    builder.append(read);
                }
                reader.close();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return builder.toString();
    }

    public void lastWriteUpdate(File name){
        FileWriter writer=null;
        try {
            writer=new FileWriter(name);
            long currentTime=System.currentTimeMillis();
            writer.write(String.valueOf(currentTime));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            {
              if (writer!=null){
                  try {
                      writer.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
            }
        }
    }

    public long lastReadUpdate(File file){
        StringBuilder builder=new StringBuilder();
        long currentTime=0;
        if (isExiste(file)) {
            String read = null;
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                read = br.readLine();
                while (read != null) {
                    builder.append(read);
                }
                currentTime = Long.parseLong(builder.toString());
                reader.close();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return currentTime;
    }

    public boolean isExiste(File file){
        return file.exists();
    }

}
