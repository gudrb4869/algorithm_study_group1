package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김유나
 * 2023-07-31
 * [문제] 백준 1629번 곱셈
 * [아이디어] A, B, C는 모두 2,147,483,647 이하의 자연수임을 생각해야 한다.
 * A가 밑, B가 지수라고 생각하면 B가 1일 경우 결과는 A%C
 * B/2를 temp라고 하여 temp*temp로 정하도록 한다. 이때, B가 홀수면 temp*temp*A
 * C로 나눈 나머지를 구할 시 곱하는 수 각각에 %C 해주기 
 */
public class BJ_1629_곱셈_김유나 {
	public static long C;
	 public static void main(String[] args) throws IOException {
		 // BufferedReader 이용해 long A, B, C 입력받기
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 
		 long A = Long.parseLong(st.nextToken());
		 long B = Long.parseLong(st.nextToken());
		 C = Long.parseLong(st.nextToken());
		 
		 System.out.println(mutiply(A, B));
	}
	public static long mutiply(long A, long B) {
		if (B == 1) { // B가 1일 경우
			return A % C;
		}
		
		// 함수 재호출 : B/2인 값 temp 저장
		long temp = mutiply(A, B / 2);
		
		
		if (B % 2 == 1) { // 이때, 만약 B가 홀수라면
			return (temp * temp % C) * A % C; // (temp * temp % C) * A % C
		}
		
		return temp * temp % C;
	}
}
