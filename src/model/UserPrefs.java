package model;

public class UserPrefs
{
    private String storageLocation;

    public String getStorageLocation()
    {
        //TODO: Supply reasonable default value if this has not been set.
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation)
    {
        this.storageLocation = storageLocation;
    }
}
