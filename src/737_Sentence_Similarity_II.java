//Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
//
//For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
//
//Note that the similarity relation is transitive. For example, if “great” and “good” are similar, and “fine” and “good” are similar, then “great” and “fine” are similar.
//
//Similarity is also symmetric. For example, “great” and “fine” being similar is the same as “fine” and “great” being similar.
//
//Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
//
//Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

// Union find
class UnionFindSet {
public:
    bool Union(const string& word1, const string& word2) {
        const string& p1 = Find(word1, true);
        const string& p2 = Find(word2, true);
        if (p1 == p2) return false;        
        parents_[p1] = p2;
        return true;
    }
    
    const string& Find(const string& word, bool create = false) {
        if (!parents_.count(word)) {
            if (!create) return word;
            return parents_[word] = word;
        }
        
        string w = word;
        while (w != parents_[w]) {
            parents_[w] = parents_[parents_[w]];
            w = parents_[w];
        }
        
        return parents_[w];
    }
private:
    unordered_map<string, string> parents_;
};
 
class Solution {
public:
    bool areSentencesSimilarTwo(vector<string>& words1, vector<string>& words2, vector<pair<string, string>>& pairs) {
        if (words1.size() != words2.size()) return false;
        
        UnionFindSet s;
        for (const auto& pair : pairs)
            s.Union(pair.first, pair.second);
        
        for (int i = 0; i < words1.size(); ++i) 
            if (s.Find(words1[i]) != s.Find(words2[i])) return false;
        
        return true;
    }
};