import javax.swing.*;

class FinalQuiz {
	static char [] Solutions = new char [] {'b','c','a','c','c','a','b','a','c','b'};
	static char [] UserSolutions = new char []{};
	float count = 0;
	float grade = 0;
	public FinalQuiz(char UsersInput[])
	{
		UserSolutions = UsersInput;
	}
	public float Calculate(){

		for(int i = 0 ; i<10; i++)
		{
			if(Solutions[i] == UserSolutions[i] )
			{
				count++;
			}
		}
		grade = (count/10)*100;
		return grade;
	}
	

}
