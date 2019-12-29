//Input: 
//["FileSystem","createPath","get"]
//[[],["/a",1],["/a"]]
//Output: 
//[null,true,1]
//Explanation: 
//FileSystem fileSystem = new FileSystem();
//
//fileSystem.createPath("/a", 1); // return true
//fileSystem.get("/a"); // return 1

class FileSystem {
    
    public class TrieNode {
        Map<String, TrieNode> map;
        boolean isLeaf;
        int value;
        
        public TrieNode(int value) {
            this.map = new HashMap<>();
            this.isLeaf = false;
            this.value = value;
        }
    }
    
    private TrieNode root = new TrieNode(0);
    
    private boolean add(String path, int value) {
        String[] arr = path.split("/");
        TrieNode curr = this.root;
        boolean exists = true;
        for (int i = 1;i < arr.length;i++) {
            String str = arr[i];
            if (!curr.map.containsKey(str)) {
                if (i != arr.length - 1) return false; 
                curr.map.put(str, new TrieNode(0));
                exists = false;
            }
            curr = curr.map.get(str);
        }
        if (!exists) {
            curr.value = value;
            curr.isLeaf = true;
        }
        return !exists;
    }

    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        return add(path, value);
    }
    
    public int get(String path) {
        TrieNode curr = this.root;
        String[] arr = path.split("/");
        for (int i = 1;i < arr.length;i++) {
            String str = arr[i];
            if (!curr.map.containsKey(str)) return -1;
            curr = curr.map.get(str);
        }
        if (!curr.isLeaf) return -1;
        return curr.value;
    }
}
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */