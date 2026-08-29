class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hp.containsKey(complement)) {
				return new int[] {hp.get(complement),i};
			}
			hp.put(nums[i],i);
		}

		return new int[] { -1, -1 };
    }
}
