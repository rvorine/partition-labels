fun partitionLabels(s: String): List<Int> {
    val last = IntArray(26) // last index of every letter
    for (i in s.indices) {
        last[s[i] - 'a'] = i
    }

    val sizes = mutableListOf<Int>()
    var start = 0
    var end = 0

    for (i in s.indices) {
        end = maxOf(end, last[s[i] - 'a']) // the part must reach this letter's last occurrence
        if (i == end) {                    // nothing inside reaches further: cut here
            sizes.add(end - start + 1)
            start = i + 1
        }
    }
    return sizes
}

fun main() {
    println(partitionLabels("ababcbacadefegdehijhklij")) // [9, 7, 8]
    println(partitionLabels("eccbbbbdec"))               // [10]
    println(partitionLabels("a"))                        // [1]
}
