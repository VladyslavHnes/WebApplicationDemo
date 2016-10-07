package model;

/**
 * Created by vlad on 27.08.2016.
 */
public abstract class User {

    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String firstName){
        this.lastName = firstName;
    }

    public String getName(){
        return lastName;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return login;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

}
