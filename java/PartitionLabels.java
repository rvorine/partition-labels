import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    static List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // last index of every letter
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> sizes = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); // the part must reach this letter's last occurrence
            if (i == end) {                                // nothing inside reaches further: cut here
                sizes.add(end - start + 1);
                start = i + 1;
            }
        }
        return sizes;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij")); // [9, 7, 8]
        System.out.println(partitionLabels("eccbbbbdec"));               // [10]
        System.out.println(partitionLabels("a"));                        // [1]
    }
}
