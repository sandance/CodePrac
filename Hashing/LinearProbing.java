

class LinearProbing {

    public int searchForEntry(K key) {
        int index;
        int homePosition = key.hashCode() % tableSize;

        for(int i=0; i < tableSize; i++) {
            index = (homePosition + i * step) % tableSize;

            if(hashTable.get(index) == null) {
                return -1;
            } else if ( hashTable.get(index).isTompStone()) 
                continue;
            else if (key.hashCode() == HashTable.get(index).getKey().hashCode())
                return index;
        }
    }


    public V get(K key){
        int positionInfo = searchForEntry(key);
        if (positionInfo != -1)
            return hashTable.get(positionInfo).getValue();
        return null;
    }

    public void delete(K key) {
        int positionInfo = searchForEntry(key);

        if(positionInfo != -1) {
            hashTable.get(positionInfo[0]).setTompStone(true);
            numOfEntries--;
        }
    }


    public void put(K key, V value) {
        int positionInfo = searchForEntry(key);

        if(positionInfo == -1) {
            int homePosition = key.hashCode() % tableSize;
            int index;

            for(int i=0; i < tableSize; i++) {
                index = (homePosition * i * step ) % tableSize;

                if(hashTable.get(index) == null || hashTable.get(index).isTompStone()) {
                    hashTable.set(index, (new Entry<K, V>(key, value)));
                }
            }
        }
    }
}

