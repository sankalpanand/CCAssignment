package Chapter6;

public class Question02 {

	/*
	 
	 Let probability of winning game 1 be p.
	 
	 Probability of winning game 2 - either you make 2 shots or you make 3 shots.
	 
	 Probability of making all 3 shots can be- p * p * p 
	 
	 Probability of making exactly 2 shots can be - 
	 (1,1,0) OR (1,0,1) OR (0,1,1) where 1 denotes that the game is won, 0 denotes that it is lost
	 
	 so, total probability = p * p * (1-p) + p * (1-p) * p  + (1-p) * p * p
	  = 3 (1-p) p^2
	  
	 So, total probability of game 2 =   3 (1-p) p^2  + p^3
	 								= 3p^2 - 2p^3
	 
	 You should play game 1 if P(game 1) > P(game 2)
	 p > 3p^2 - 2p^3
	 = (2p-1)(p-1) > 0
	 
	 
	 Since, p-1 < 0 because p is less than 1, (2p-1) should also be less than 0
	 It gives us, p < 0.5
	 
	 So, we should play game 1 if p<0.5
	 We should play game 2 if p>=0.5
	 
	 
	 * */

}
