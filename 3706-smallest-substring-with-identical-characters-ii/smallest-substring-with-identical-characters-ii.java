class Solution {
    public int minLength(String s, int k) {
        char chars[] = s.toCharArray();
        int l = 1;
        int r = s.length();
        int ans = 0;

        while(l <= r ) {
            int mid = ( r + l) >> 1;
            if(isValidLength(mid, chars, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

   boolean isValidLength(int len, char chars[], int ops) {
    if(len == 1) {
       return alternatingString(chars, ops);
    }
    int idx = 0;
    while(idx < chars.length) {
        int reps = identicalCharacters(chars, idx); // gives the length of repeating ch
        int used = performOperations(len, reps, ops);
        ops = ops - used;
        if(ops < 0) {
            return false;
        }
        idx += reps;
    }
    return true;
  }

  int identicalCharacters(char chars[], int idx) {
      int count = 0;
      int start = idx;
      while(idx < chars.length && chars[start] == chars[idx]) {
          count++;
          idx++;
      }
      return count;
      
  }

  int performOperations(int len, int reps , int k) {
    if(reps <= len) {
        return 0;
    }
    int l = 0; 
    int r = k;
    int ans = k + 1;
    while(l <= r) {
        int mid = (l + r) >> 1;
        if((reps/ (mid + 1)) <= len) {
            ans = mid;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return ans;
  }

    
   boolean alternatingString(char chars[], int ops) {
        return ops >= Math.min(countMissMatch(chars, 0), countMissMatch(chars, 1));
   }
    int countMissMatch(char chars[], int start) {
        int count = 0;
        for(char ch : chars) {
            if(start != (ch - '0')) {
                count++;
            }
            start = 1 - start;
        }
        return count;
    }
}