package sample;

class node {

    public node next;
    public String userName;
    public String password;


    public node(String User, String Password)
    {
        userName = User;
        password = Password;

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

    public void add(String Name, String Pass)
    {
        node newNode = new node(Name, Pass);
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