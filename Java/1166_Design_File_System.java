class FileSystem {
    HashMap<String, Integer> files;
    public FileSystem() {
        files = new HashMap<>();
        files.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        int fileIndex = path.lastIndexOf("/");
        String parent = path.substring(0, fileIndex);

        if(!files.containsKey(parent) || files.containsKey(path)) {
            return false;
        }

        files.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return files.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
