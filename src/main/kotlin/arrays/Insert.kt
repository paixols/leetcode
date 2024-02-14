package arrays

fun main() {
    println(
        "Merge Sorted Arrays: ${
            mergeSortedArray(
                nums1 = intArrayOf(1, 2, 3, 0, 0, 0),
                m = 3,
                nums2 = intArrayOf(2, 5, 6),
                n = 3
            )
        }"
    )

    println(
        "Merge Sorted Arrays Optimized: ${
            mergeSortedArrayOptimized(
                nums1 = intArrayOf(1, 2, 3, 0, 0, 0),
                m = 3,
                nums2 = intArrayOf(2, 5, 6),
                n = 3
            )
        }"
    )
}

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing-order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing-order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m+n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Time Complexity for merging = O(n)
 * Space Complexity for merging = O(1)
 *
 * Time Complexity for Sorting (java) = O((M+N)log(M+N))
 * Space Complexity for Sorting (java) = O(log(M+N))
 * */
fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // Iterate over the size of nums2 array, and copy the elements of nums2 to the last part of nums1
    for (i in 0 until n) {
        nums1[m + i] = nums2[i]
    }
    // Sort the array once again
    nums1.sort()

    nums1.forEach { print("$it\n") }
}

/**
 * Time Complexity = O(M+N)
 * Space Complexity = O(1)
 * */
fun mergeSortedArrayOptimized(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // Start with 3 pointers, m, n, and m+n while iterating backwards in order to move the elements of nums2 to nums1

    var r1 = m - 1
    var r2 = n - 1
    var writePointer = m + n - 1

    while (writePointer >= 0) {
        if (r1 >= 0 && r2 >= 0) {
            nums1[writePointer] = if (nums1[r1] > nums2[r2]) nums1[r1--] else nums2[r2--]
        } else if (r1 >= 0) {
            nums1[writePointer] = nums1[r1--]
        } else {
            nums1[writePointer] = nums2[r2--]
        }
        writePointer--
    }

    nums1.forEach { print("$it\n") }

}