def partition_labels(s):
    last = {ch: i for i, ch in enumerate(s)}  # last index of every letter

    sizes = []
    start = end = 0

    for i, ch in enumerate(s):
        end = max(end, last[ch])  # the part must reach this letter's last occurrence
        if i == end:              # nothing inside reaches further: cut here
            sizes.append(end - start + 1)
            start = i + 1

    return sizes


if __name__ == "__main__":
    print(partition_labels("ababcbacadefegdehijhklij"))  # [9, 7, 8]
    print(partition_labels("eccbbbbdec"))                # [10]
    print(partition_labels("a"))                          # [1]
