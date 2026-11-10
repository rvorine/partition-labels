function partitionLabels(s) {
  const last = {}; // last index of every letter
  for (let i = 0; i < s.length; i++) {
    last[s[i]] = i;
  }

  const sizes = [];
  let start = 0, end = 0;

  for (let i = 0; i < s.length; i++) {
    end = Math.max(end, last[s[i]]); // the part must reach this letter's last occurrence
    if (i === end) {                 // nothing inside reaches further: cut here
      sizes.push(end - start + 1);
      start = i + 1;
    }
  }
  return sizes;
}

console.log(partitionLabels("ababcbacadefegdehijhklij")); // [9, 7, 8]
console.log(partitionLabels("eccbbbbdec"));               // [10]
console.log(partitionLabels("a"));                        // [1]

module.exports = { partitionLabels };
