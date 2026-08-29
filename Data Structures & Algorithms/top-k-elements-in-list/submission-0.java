class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
		// Mapping numbers-->freq
		for (int num : nums) {
			hp.put(num, hp.getOrDefault(num, 0) + 1);
		}

		List<Integer>[] bucket = new List[nums.length + 1];
		// why List ? there will be more than one number with same frequency
		for (int num : hp.keySet()) {

			int frequency = hp.get(num);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(num);
		}

		int index = 0;
		int[] result = new int[k];
		for (int i = bucket.length - 1; i >=0 && index < k; i--) {

			if (bucket[i] != null) {
				for (int b : bucket[i]) {

					result[index] = b;
					index++;
					if (index == k) {
						break;
					}

				}
			}

		}
		
		return result;
}
}
