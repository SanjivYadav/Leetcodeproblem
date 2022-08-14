class Solution:
    
    def getNextWords(self, word, wordSet, visited, path):
        res = set()
        for i in range(len(word)):
            for j in range(26):
                newWord = word[:i] + chr(j+ord('a')) + word[i+1:]
                if newWord in wordSet and newWord not in visited:
                    res.add(newWord)
                    for p in path[word]:
                        if newWord not in path:
                            path[newWord] = []
                        path[newWord].append([newWord] + p)
        return res
    
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        wordSet = set(wordList)
        if endWord not in wordSet:
            return []
        level1, level2 = {beginWord}, {endWord}
        visited1, visited2 = set(), set()
        path1, path2 = {beginWord: [[beginWord]]}, {endWord: [[endWord]]}
        while level1 and level2:
            newLevel1 = set()
            visited1.update(level1)
            for n1 in level1:
                newLevel1.update(self.getNextWords(n1, wordSet, visited1, path1))
            newLevel2 = set()
            visited2.update(level2)
            for n2 in level2:
                newLevel2.update(self.getNextWords(n2, wordSet, visited2, path2))
            
            finalSet = set()
            if len(newLevel1 & visited2) > 0 or len(newLevel2 & visited1) > 0:
                finalSet = (newLevel1 & visited2) | (newLevel2 & visited1)
            elif len(newLevel1 & newLevel2) > 0:
                finalSet = newLevel1 & newLevel2
            if finalSet:
                res = set()
                for n in finalSet:
                    for p1 in path1[n]:
                        for p2 in path2[n]:
                            res.add('.'.join(p1[::-1][:-1]+p2))
                
                return [path.split('.') for path in res]
            level1 = newLevel1
            level2 = newLevel2
        return []