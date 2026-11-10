using System;
using System.Collections.Generic;

class PartitionLabels
{
    static List<int> Solve(string s)
    {
        int[] last = new int[26]; // last index of every letter
        for (int i = 0; i < s.Length; i++)
        {
            last[s[i] - 'a'] = i;
        }

        var sizes = new List<int>();
        int start = 0, end = 0;

        for (int i = 0; i < s.Length; i++)
        {
            end = Math.Max(end, last[s[i] - 'a']); // the part must reach this letter's last occurrence
            if (i == end)                          // nothing inside reaches further: cut here
            {
                sizes.Add(end - start + 1);
                start = i + 1;
            }
        }
        return sizes;
    }

    static void Main()
    {
        Console.WriteLine(string.Join(", ", Solve("ababcbacadefegdehijhklij"))); // 9, 7, 8
        Console.WriteLine(string.Join(", ", Solve("eccbbbbdec")));               // 10
        Console.WriteLine(string.Join(", ", Solve("a")));                        // 1
    }
}
