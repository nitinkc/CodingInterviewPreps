# Sliding Window: 5 Variations (Theory + Java + Practice)

## 1. Core theory

A brute force checks every subarray: O(n²) or worse.
A **sliding window** keeps one window `[l, r]` and updates its *state* incrementally.
Each element enters once (when `r` moves) and leaves once (when `l` moves), so the total work is **O(n)**.

### The universal skeleton

```java
int l = 0;
for (int r = 0; r < n; r++) {
    // 1. ADD a[r] to the window state
    while (/* window is invalid */) {
        // 2. REMOVE a[l] from the window state
        l++;
    }
    // 3. window [l..r] is valid -> update the answer
}
```

All five variations use this. They differ in three things:

| What changes        | Examples                                                |
|:--------------------|:--------------------------------------------------------|
| **State**           | running sum, counter, set, hash map, product            |
| **"Invalid" means** | sum > k, count > m, duplicate found, product >= k       |
| **Answer update**   | `max(r-l+1)` for longest, `count += r-l+1` for counting |

### When does sliding window work?

It needs **monotonicity**: growing the window pushes the constraint one way, and shrinking pushes it back.

- Sum constraints need **non-negative** numbers. Negatives break it (use prefix sums + hash map, or a monotonic deque).
- Product constraints need **positive** numbers.
- "Exactly K" is not directly slidable. Use `atMost(K) - atMost(K-1)`.

### Quick recognition table

| Problem says...                         | Variation              | State         | Answer update         |
|:----------------------------------------|:-----------------------|:--------------|:----------------------|
| "any window / subarray of size k"       | 1. Fixed length        | running sum   | none (just track max) |
| "longest subarray with sum <= k"        | 2. Sum constraint      | running sum   | `max(r-l+1)`          |
| "at most m of X" / "at most K distinct" | 3. Number of           | counter / map | `max(r-l+1)`          |
| "no repeating elements"                 | 4. Not repeated        | set           | `max(r-l+1)`          |
| "count subarrays with ..."              | 5. Number of subarrays | product / sum | `count += r-l+1`      |

---

## Variation 1: Fixed length

**Theory.** The window size is given, so no `while` loop is needed. Add the new right element, drop the old left one. Moving from `[10,8,5,16]` to `[8,5,16,7]` changes only two elements, so recomputing the whole sum is wasted work.

**Example.** `[6,10,8,5,16,7,9,6]`, `k=4` -> max sum `39`.

```java
static int maxSumK(int[] nums, int k) {
    int window = 0;
    for (int i = 0; i < k; i++) window += nums[i];
    int best = window;
    for (int r = k; r < nums.length; r++) {
        window += nums[r] - nums[r - k];   // add right, drop left
        best = Math.max(best, window);
    }
    return best;
}
```

**Practice (LeetCode)**

- [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) (Easy)
- [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/) (Medium)
- [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) (Medium)
- [2461. Maximum Sum of Distinct Subarrays With Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/) (Medium)

---

## Variation 2: Sum constraint

**Theory.** The size is not fixed: the window grows and shrinks. Expand `r` every step. When the sum exceeds `k`, shrink from the left until valid again.

This is safe only because the numbers are **non-negative**. Adding an element never lowers the sum and removing one never raises it, so shrinking never discards a better answer.

`<` and `<=` are the same pattern. **Exactly `k`** is a trap: it is not monotonic, so use prefix sums + hash map instead.

**Example.** `[3,1,2,7,4,2,1,1,5]`, `k=8` -> longest length `4` (`[4,2,1,1]`).

```java
static int longestSumAtMost(int[] nums, int k) {
    int l = 0, total = 0, best = 0;
    for (int r = 0; r < nums.length; r++) {
        total += nums[r];
        while (total > k) total -= nums[l++];   // invalid -> shrink
        best = Math.max(best, r - l + 1);
    }
    return best;
}
```

**Practice (LeetCode)**

- [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) (Medium): shortest window with sum >= target (mirror image).
- [1208. Get Equal Substrings Within Budget](https://leetcode.com/problems/get-equal-substrings-within-budget/) (Medium): closest to "longest with sum <= k".
- [1838. Frequency of the Most Frequent Element](https://leetcode.com/problems/frequency-of-the-most-frequent-element/) (Medium)

---

## Variation 3: "Number of" constraint

**Theory.** The state is a **counter** of the thing you are limiting (zeros, a specific character, distinct characters). It is the same skeleton as variation 2 with a different state. For "at most K distinct", the state becomes a `HashMap<char, count>`, and "invalid" is `map.size() > K`.

**Example.** `"lltllttlll"`, at most one `l` -> longest `3` (`"ltt"`).

```java
static int longestAtMostM(String s, char bad, int m) {
    int l = 0, cnt = 0, best = 0;
    for (int r = 0; r < s.length(); r++) {
        if (s.charAt(r) == bad) cnt++;
        while (cnt > m) {
            if (s.charAt(l) == bad) cnt--;
            l++;
        }
        best = Math.max(best, r - l + 1);
    }
    return best;
}
```

**Map version: at most K distinct characters**

```java
static int longestKDistinct(String s, int K) {
    Map<Character, Integer> freq = new HashMap<>();
    int l = 0, best = 0;
    for (int r = 0; r < s.length(); r++) {
        freq.merge(s.charAt(r), 1, Integer::sum);
        while (freq.size() > K) {
            char c = s.charAt(l++);
            if (freq.merge(c, -1, Integer::sum) == 0) freq.remove(c);  // remove at 0, or size() lies
        }
        best = Math.max(best, r - l + 1);
    }
    return best;
}
```

**Practice (LeetCode)**

- [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) (Medium): best first problem for this type.
- [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/) (Medium): at most 2 distinct.
- [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) (Medium, Premium)
- [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) (Medium)
- [1493. Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) (Medium)

---

## Variation 4: Not repeated

**Theory.** The state is a **set** of what is in the window. "Invalid" means the *incoming* character is already in the set. Note the order: the check happens **before** adding, unlike variations 2 and 3 where you add first and then check.

**Example.** `"zxyzxyz"` -> `3` (`"xyz"`).

```java
static int longestUnique(String s) {
    Set<Character> seen = new HashSet<>();
    int l = 0, best = 0;
    for (int r = 0; r < s.length(); r++) {
        while (seen.contains(s.charAt(r))) seen.remove(s.charAt(l++));
        seen.add(s.charAt(r));
        best = Math.max(best, r - l + 1);
    }
    return best;
}
```

For lowercase-only input, a `boolean[26]` is faster and is often what interviewers expect.

**Practice (LeetCode)**

- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) (Medium): the standard one.
- [1695. Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/) (Medium): same idea, track the sum instead of the length.

---

## Variation 5: Number of subarrays

**Theory.** This is the one people find hard. The trick is the counting line.

After shrinking, `[l..r]` is valid. Because numbers are positive, **every subarray ending at `r` and starting anywhere in `l..r` is also valid**, since a shorter one has a smaller product. That gives `r - l + 1` subarrays, and they are all new because each ends at `r`, so none was counted at an earlier `r`.

Longest uses `max(r-l+1)`. Counting uses `count += r-l+1`.

**Example.** `[10,5,2,6]`, `k=100` -> `8`.

| r | window after shrink | r-l+1 | total |
|---|---|---|---|
| 0 | [10] | 1 | 1 |
| 1 | [10,5] | 2 | 3 |
| 2 | [5,2] (10·5·2 = 100 is not < 100, so `l` moves) | 2 | 5 |
| 3 | [5,2,6] | 3 | 8 |

```java
static int countProductLessThan(int[] nums, int k) {
    if (k <= 1) return 0;          // no valid subarray; without this, l runs past r
    long prod = 1;                 // long: int can overflow before the while loop shrinks
    int l = 0, count = 0;
    for (int r = 0; r < nums.length; r++) {
        prod *= nums[r];
        while (prod >= k) prod /= nums[l++];
        count += r - l + 1;        // all subarrays ENDING at r
    }
    return count;
}
```

**Practice (LeetCode)**

- [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/) (Medium): the example above.
- [1358. Number of Substrings Containing All Three Characters](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/) (Medium)
- [1248. Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/) (Medium): "exactly k", use `atMost(k) - atMost(k-1)`.
- [992. Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/) (Hard): same exactly-k trick with a map.

---

## Pitfalls checklist

- **Monotonicity:** negatives break sum windows; zeros and negatives break product windows.
- **Exactly K:** `atMost(K) - atMost(K-1)`, never a direct slide.
- **Longest vs count:** `max(r-l+1)` vs `count += r-l+1`.
- **Add-then-check vs check-then-add:** variations 2, 3 and 5 add first; variation 4 checks before adding.
- **Map cleanup:** remove keys when the count hits 0, or `size()` over-counts.
- **Overflow:** use `long` for products and large sums.
- **Edge cases:** `k <= 1` for products, `k > n` for fixed windows, empty input.

## Suggested first pass

One problem per type, then the harder ones: **643 -> 1208 -> 1004 -> 3 -> 713**.
