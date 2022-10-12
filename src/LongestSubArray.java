import java.util.*;

public class LongestSubArray {
	public static int lenOfLongSubarr(int A[], int N, int K) {
		int start = 0;
		int end = -1;
		int currsum = 0;
		int a = -1;
		HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			currsum += A[i];
			System.out.println(currsum + "  Start " + start + " End " + end);

			if (currsum - K == 0) {
				end = i;
				if (end - start > a) {
					a = end - start;
					currsum = A[i];
				}
			} else if (store.containsKey(currsum - K)) {
				start = currsum - K + 1;
				end = i;
				if (end - start > a) {
					a = end - start;
					currsum = A[i];
				}
			} else {
				store.put(currsum, i);
			}
		}

		return a + 1;
	}

	public static int len(int A[], int N, int K) {
		for (int i = 0; i < N; i++) {
			int sum = A[i];
			for (int j = i + 1; j < N; j++) {
				sum = sum + A[j];
				if (sum == K) {
					System.out.println(i + "  " + j);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int A[] = { -13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
		int N = A.length;
		int K = 15;
		System.out.println(lenOfLongSubarr(A, N, K));
	}

}
