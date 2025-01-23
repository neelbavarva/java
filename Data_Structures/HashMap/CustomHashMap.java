public class CustomHashMap {

    public static class EntryNode{
        int hash;
        int key;
        int value;
        EntryNode next;

        public EntryNode(int hash, int key, int value, EntryNode next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    EntryNode arr[] = new EntryNode[7];

    public void add(int key, int value){
        int index = hash(key);
        if(arr[index]==null){
            arr[index] = new EntryNode(index, key, value, null);
        } else {
            EntryNode curr = arr[index];
            while(curr!=null){
                if(curr.key==key){
                    curr.value = value;
                    break;
                } else if(curr.next==null){
                    curr.next = new EntryNode(index, key, value, null);
                    break;
                }
                curr = curr.next;
            }
        }
    }

    public void printHashMap(){
        for(int i=0;i<7;i++){
            EntryNode curr = arr[i];
            while(curr!=null){
                System.out.println("Key: " +  curr.key + " Value: " + curr.value);
                curr = curr.next;
            }
        }
    }

    public int hash(int key){
        return key%7;
    }
}
