package Chapter6;

public class Question08 {

	/*
	 
	 If Egg 1 breaks on 10th floor, then we will have to check from floor 1-9 for egg 2. So 10 drops in total.
	 If Egg 1 breaks on 100th floor, then we will have to check from floor 10,20...90,91,92...99 for egg 2. 
	 So 19 drops in total.
	 
	 Since each drop of Egg 1 takes one more step, Egg 2 is allowed one less step.
	 We should try minimizing number of steps by egg 2 by 1 drop each time.
	 Therefore, Egg 1 must start at floor x, then go up by x-1 floor, then by x-2, and so on till 100.
	 
	 So, x + (x-1) + (x-2) + .... + 1 = 100
	 Solving which gives us x = 13.65 ~ 14.
	 
	 
	 * */

}
