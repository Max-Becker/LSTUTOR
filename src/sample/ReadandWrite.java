package sample;

import java.io.*;
import java.lang.*;

public class ReadandWrite extends UserList
{
    private static File newFile = new File("/resources/DATA.txt");
    private String username, password;
    private static int usergrade;
    static UserList linkedList = new UserList();

    public static  void writeToFile(String user, String pass, int grade)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {

            fw = new FileWriter(newFile);
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
            fr = new FileReader(newFile);
            br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null);
            {
                String[] seperate = line.split("/");
                usergrade = Integer.parseInt(seperate[2]);
                linkedList.add(seperate[0],seperate[1],usergrade);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
