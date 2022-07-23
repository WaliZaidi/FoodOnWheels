package Model;

public interface User {

    boolean Login(int UserID, String Password); //see changelog for details

    default int GenerateID() {

        int ID = 0;

        ID = (int)Math.floor(Math.random()*((9999-1000)+1)+1000);

        return ID;
    }


}
