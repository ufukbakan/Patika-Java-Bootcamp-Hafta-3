package dev.ufuk.bakan;

public class Storage {
    private StorageType storageType;
    private int storageSize;

    public Storage(StorageType storageType, int storageSize) {
        this.storageType = storageType;
        this.storageSize = storageSize;
    }    

    public StorageType getStorageType() {
        return this.storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public int getStorageSize() {
        return this.storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

}
