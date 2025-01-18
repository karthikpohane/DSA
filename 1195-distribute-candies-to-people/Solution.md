# README - Distribute Candies Solution

## Problem Description

In this problem, you are tasked with distributing a given number of candies (`candies`) to a group of people (`num_people`). You need to distribute the candies in such a way that:

1. The first person receives 1 candy, the second person receives 2 candies, the third person receives 3 candies, and so on.
2. If you run out of candies before reaching the last person, you distribute the remaining candies as much as possible.

Once all candies are distributed, you should return the array `nums`, where `nums[i]` represents the number of candies received by the `i`-th person.

## Code Solution

```java
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people]; // Array to store candies for each person
        int i = 0; // Index of the person to receive candies
        int candyToGive = 1; // Number of candies to give to the current person

        // Distribute candies until all are distributed
        while (candies > 0) {
            nums[i] += Math.min(candies, candyToGive); // Give the current person the minimum of remaining candies or required candies
            candies -= candyToGive; // Decrease the candies count by the given amount
            candyToGive++; // Increase the candies to give to the next person
            i = (i + 1) % num_people; // Move to the next person in a circular manner
        }

        return nums; // Return the array of candies distributed
    }
}
```

## Explanation

### Key Idea

The goal is to distribute candies to a set of people in a sequence. To manage the circular distribution, we use the expression `i = (i + 1) % num_people;` inside the loop, which ensures that the index `i` stays within the valid range of people, looping back to the first person once the last person has been reached.

### How Circular Movement Works

The key line of code that enables circular movement through the array is:

```java
i = (i + 1) % num_people;
```

#### How does this work?

1. **`i + 1`**: This increments the index, moving to the next person.
2. **`% num_people`**: The modulo operation ensures that once the index reaches `num_people`, it wraps around back to `0`. This is essential for achieving the circular distribution.
   
   - If `i` is the last person (i.e., `i == num_people - 1`), adding 1 will make `i = num_people`, but using `% num_people` will reset `i` back to 0.
   - This allows us to continuously distribute candies to the people in a round-robin fashion, ensuring each person gets their turn, even after reaching the end of the array.

### Example

Consider `candies = 7` and `num_people = 4`. The distribution would proceed as follows:

- Person 0 receives 1 candy (`i = 0`).
- Person 1 receives 2 candies (`i = 1`).
- Person 2 receives 3 candies (`i = 2`).
- Person 3 receives 1 candy (`i = 3`).
- Person 0 receives the remaining 1 candy (`i = 0`).

Final distribution: `[2, 2, 3, 0]`

### Why the Modulo?

The modulo operator `%` is a simple and efficient way to achieve circular traversal over an array. It ensures that when the index exceeds the last person (i.e., `i == num_people`), the index wraps around to the beginning (`i = 0`), allowing the loop to continue distributing candies without exceeding the array bounds.

### Time Complexity

The time complexity of this solution is **O(candies)** because the number of iterations depends directly on the number of candies to distribute, not on the number of people. Each iteration distributes some number of candies and increments the index `i` in a circular manner.

### Space Complexity

The space complexity is **O(num_people)** because we store the candies distributed to each person in the `nums` array, which has a length of `num_people`.

## Usage

To use this code, instantiate the `Solution` class and call the `distributeCandies` method with the total number of candies and the number of people. For example:

```java
Solution solution = new Solution();
int candies = 7;
int num_people = 4;
int[] result = solution.distributeCandies(candies, num_people);

// Output: [2, 2, 3, 0]
```

This will distribute the candies according to the rules outlined above and return an array representing the candies each person received.
