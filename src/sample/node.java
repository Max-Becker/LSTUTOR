package sample;

class node {

    public node next;
    public String userName;
    public String password;
    public int gradeL1, gradeL2, gradeL3, gradeL4, gradeQuiz;


    public node(String User, String Password, int grade1, int grade2, int grade3, int grade4,int gradeQuiz)
    {
        userName = User;
        password = Password;
        gradeL1 = grade1;
        gradeL2 = grade2;
        gradeL3 = grade3;
        gradeL4 = grade4;
        this.gradeQuiz = gradeQuiz;

    }
    public void printNode()
    {
        System.out.println(userName +" "+ password);
    }

}

class UserList{
    private node head;

    public UserList(){
        head = null;
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    public void add(String Name, String Pass, int grad1, int grad2, int grad3, int grad4,int gradQuiz)
    {
        node newNode = new node(Name, Pass, grad1, grad2, grad3, grad4, gradQuiz);
        newNode.next = head;
        head = newNode;
    }
    public void printUsers()
    {
        node first = head;
        while( first!= null)
        {
            first.printNode();
            first = first.next;
        }
    }
    public node getNode()
    {
        return head;
    }






}