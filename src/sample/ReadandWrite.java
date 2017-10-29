package sample;

import java.io.*;
import java.lang.*;

public class ReadandWrite extends UserList
{
    private File newFile= new File("./src/resources/DATA.txt");
    private String username, password;
    private int usergrade, assign1, assign2,assign3,assign4;
    private String[] seperator;
    protected UserList linkedList;

    public  void writeToFile(String user, String pass,  int grade1,int grade2,int grade3,int grade4,int gradeQuiz)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(newFile);
            bw = new BufferedWriter((fw));
            bw.write(user+"/"+pass+"/"+ grade1+"/"+ grade2+"/"+grade3+"/"+grade4+"/"+gradeQuiz);
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public void readfromFile()
    {
        BufferedReader br;
        FileReader fr;
        linkedList = new UserList();

        try
       {
            fr = new FileReader(newFile);
            br = new BufferedReader(fr);

            String line;

           while( (line = br.readLine()) != null )
           {

                  seperator = line.split("/");

                linkedList.add(seperator[0],seperator[1],Integer.parseInt(seperator[2]),Integer.parseInt(seperator[3]),Integer.parseInt(seperator[4]),Integer.parseInt(seperator[5]),Integer.parseInt(seperator[6]));

            }

            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
