public class Randp {
	
    private int[] nums;
    private int numsLeft;
	
    public Randp(int n) {
        this.numsLeft = n;
        initNums(n);
    }
	
    private void initNums(int n) {
    	nums = new int[n];
    	for (int i = 0; i < n; i++)
    		nums[i] = i+1;
    }
    
    public int size() {
    	return nums.length;
    }
	
    public int nextInt() {
    	if (numsLeft <= 0) return 0;
    	
    	int index = (int) (numsLeft * Math.random());
    	int returnValue = nums[index];
    	
    	if (index < numsLeft) nums[index] = nums[numsLeft-1];
    	numsLeft--;
    	
    	return returnValue;
    }
    
}