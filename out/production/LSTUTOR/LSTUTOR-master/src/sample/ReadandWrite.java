package sample;

import java.io.*;

public class ReadandWrite
{
    private static String FILE = "/resources/DATA.txt";
    private String username, password;
    private int usergrade;
    String[] Data;

    public static  void writeToFile(String user, String pass, int grade)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {

            fw = new FileWriter(FILE);
            bw = new BufferedWriter((fw));
            bw.write(user+"/"+pass+"/"+grade);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void readfromFile()
    {
        BufferedReader br = null;
        FileReader fr = null;
        try
        {
            fr = new FileReader(FILE);
            br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null);
            {

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
