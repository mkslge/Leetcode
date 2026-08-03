class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> groupedInts = new HashMap<>();
        Arrays.sort(strings);
        for(String str : strings) {
            StringBuilder key = new StringBuilder();
            for(int i = 1;i < str.length();i++) {
                int diff = (str.charAt(i) - str.charAt(i - 1)  + 26 ) % 26;
                key.append(diff).append(",");
            }

            groupedInts.computeIfAbsent(
                key.toString(), 
                _ -> new ArrayList<>()
            ).add(str);

        }
        

        return new ArrayList<>(groupedInts.values());


    }
}
