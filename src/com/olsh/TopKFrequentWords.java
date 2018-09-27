/**
#692. Top K Frequent Words
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new HashMap<String, Integer>();
        for (String word : words) {
            if (frequencies.get(word) == null) {
                frequencies.put(word, 1);
            } else {
                frequencies.put(word, frequencies.get(word) + 1);
            }
        }
        List<String> res = new ArrayList<String>();
        for (String word : frequencies.keySet()) {
            findPosAndInsert(k, word, res, frequencies);
        }
        return res.subList(0, k);
    }

    public void findPosAndInsert(int k, String word, List<String> res, Map<String, Integer> f) {
        if (res.isEmpty()) {
            res.add(word);
        } else if (res.size() == 1) {
            if (compare(word, res.get(0), f)) {
                res.add(0, word);
            } else {
                res.add(word);
            }
        } else {
            String middle = res.get(res.size() / 2);
            if (compare(word, middle, f)) {
                findPosAndInsert(k, word, res.subList(0, res.size() / 2), f);
            } else {
                findPosAndInsert(k, word, res.subList(res.size() / 2, res.size()), f);
            }
        }
    }

    public boolean compare(String w1, String w2, Map<String, Integer> frequencies) {
        if (frequencies.get(w1) != frequencies.get(w2)) {
            return frequencies.get(w1) > frequencies.get(w2);
        } else {
            return w1.compareTo(w2) < 0;
        }
    }
}
