class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {

            int [] curr = getArray(s);
            String convertedArray = arrayToString(curr);
            if(map.containsKey(convertedArray)) {
                map.get(convertedArray).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(convertedArray, newList);
            }

        }
        for(List<String> currList : map.values()) {
            sol.add(currList);
        }
        return sol;
    }

    private int [] getArray(String str) {
        int [] sol = new int [26];
        for(char c : str.toCharArray()) {
            sol[c - 'a']++;
        }
        return sol;
    }

    private String arrayToString(int [] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length;i++) {
            sb.append(arr[i]).append(',');
        }
        return sb.toString();
    }



    
}
