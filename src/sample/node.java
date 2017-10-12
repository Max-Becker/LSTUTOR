package sample;

class node {

    public node next;
    public String userName;
    public String password;
    public int grades;


    public node(String User, String Password, int Grades)
    {
        userName = User;
        password = Password;
        grades = Grades;

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

    public void add(String Name, String Pass, int Grad)
    {
        node newNode = new node(Name, Pass,Grad);
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