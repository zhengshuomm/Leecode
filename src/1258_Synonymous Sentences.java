//Input:
//synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
//text = "I am happy today but was sad yesterday"
//Output:
//["I am cheerful today but was sad yesterday",
//​​​​​​​"I am cheerful today but was sorrow yesterday",
//"I am happy today but was sad yesterday",
//"I am happy today but was sorrow yesterday",
//"I am joy today but was sad yesterday",
//"I am joy today but was sorrow yesterday"]

class Solution {
    Map<String, String> map = new HashMap<>();
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for (List<String> list : synonyms) {
            map.put(list.get(0), list.get(0));
            map.put(list.get(1), list.get(1));
        }
        
        for (List<String> list : synonyms) {
            String r1 = find(map, list.get(0));
            String r2 = find(map, list.get(1));
            if (!r1.equals(r2)) {
                map.put(r1, r2);
            }
        }
        
        Map<String, List<String>> edges = new HashMap<>();
        for (String s : map.keySet()) {
            String parent = find(map, s);
            edges.putIfAbsent(parent, new ArrayList<>());
            edges.get(parent).add(s);
        }
        
        System.out.println(edges);
        List<String> result = new ArrayList<>();
        dfs(result, text.split(" "), "", 0, edges, map);
        Collections.sort(result);
        return result;
    }
    
    private void dfs(List<String> result, String[] texts, String cur, int index,  Map<String, List<String>> edges, Map<String, String> map) {
        if (index == texts.length) {
            result.add(cur);
            return;
        }
        String text = texts[index];
        if (map.containsKey(text)) {
            String parent = find(map, text);
            for (String s : edges.get(parent)) {
                // cur = index == 0? s : cur + " " + s;
                dfs(result,  texts, index == 0? s : cur + " " + s, index + 1, edges, map);
            }
        }else {
            cur = index == 0? text : cur + " " + text;
            dfs(result, texts, cur, index + 1, edges, map);
        }
    }
    
    private String find(Map<String, String> map, String s) {
        while (!s.equals(map.get(s))) {
            s = map.get(s);
        }
        return s;
    }
}