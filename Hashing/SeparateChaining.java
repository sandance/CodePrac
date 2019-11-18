import org.graalvm.compiler.phases.common.jmx.HotSpotMBeanOperationProvider;

public class Entry <K, V> {
    private K key;
    private V value;

    private boolean tompStone;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        tompStone = false;
    }

    //getters

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public boolean isTompStone(){
        return  tompStone;
    }
    public void setKey(K key){
        this.key = key;
    }

    public void setValue(V value){
        this.value = value;
    }

    public void setTompStone(boolean tompStone){
        this.tompStone = tompStone;
    }



}





class SeparateChaining {
    private int numOfEntries, totalCollisions, tableSize;
    private double loadFactor;
    private boolean rehashing;

    private ArrayList <LinkedList <Entry<K,V> > > hashTable;
    public SeparateChaining() {
        rehashing   = false;
        loadFactor  = 0;
        tableSize   = 0;

        hashTable = new ArrayList<LinkedList<Entry<K,V>>>  ();

        for(int i=0; i < tableSize; i++) {
            hashTable.add(new LinkedList<Entry<K,V>> ();)
        }
        
    }

    private int [] searchForEntry (K key) {
            int homePosition = key.hashCode() % tableSize;

            // get chain length
            int chainSize = hashTable.get(homePosition).size();

            //searching the chain
            for(int i=0; i < chainSize; i++) {
                if(hashTable.get(homePosition).get(i).getKey().hashCode() == key.hashCode) {
                    int [] positionInfo = { homePosition, i};
                    return positionInfo;
                }
            }
            return null;
        }
    


    public V get (K key) {
        int [] positionInfo = searchForEntry(key);

        if (positionInfo != null) {
            int homePosition = positionInfo[0];
            int index = positionInfo[1];

            return hashTable.get(homePosition).get(index).getValue();
        }
        return null;
    }

    public void put(K key, V value) {
        int [] positionInfo = searchForEntry(key);
        
        //does not exist before 
        if (positionInfo == null) {
            int homePosition = key.hashCode() % tableSize;
            
            hashTable.get(homePosition).add(new Entry<K,V>(key, value));

            //increament number of entries
            numOfEntries++;



        } else {
            hashTable.get(positionInfo[0]).get(positionInfo[1]).setValue(value);
        }
    }



}