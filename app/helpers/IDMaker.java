package helpers;

public enum IDMaker {
    INSTANCE;

    private int ID = 0;

    public String getNewID() {
        ID++;
        return Integer.toString(ID);
    }

}
