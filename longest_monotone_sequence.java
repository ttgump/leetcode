/*
Given an unsorted array of integers, find the longest monotone elements sequence.
*/

public int longestConsecutive(int[] num) {
	if(num == null) return 0;
	if(num.length == 0 || num.length == 1) return num.length;
	int con = 1;
	int maxCon = 1;
	short increase = 0;
	if(num[0] < num[1]) {increase = 1; con = 2; maxCon = 2;}
	else if(num[0] > num[1]) {increase = -1; con = 2; maxCon = 2;}
	for(int i = 2; i < num.length; i++) {
		if(increase == 1) {
			if(num[i-1] < num[i]) {
				con++;
				if(con > maxCon) maxCon = con;
			}
			else if(num[i-1] == num[i]){
				increase = 0;
				con = 1;
			}
			else {
				increase = -1;
				con = 1;
			}
		}
		else if(increase == -1){
			if(num[i-1] > num[i]) {
				con++;
				if(con > maxCon) maxCon = con;
			}
			else if(num[i-1] == num[i]){
				increase = 0;
				con = 1;
			}
			else {
				increase = 1;
				con = 1;
			}
		}
		else {
			if(num[i-1] < num[i]) {
				increase = 1;
				con = 2;
				if(con > maxCon) maxCon = con;
			}
			else if(num[i-1] > num[i]) {
				increase = -1;
				con = 2;
				if(con > maxCon) maxCon = con;
			}
		}
	}
	return maxCon;
}