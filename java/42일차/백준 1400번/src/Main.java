import java.io.*;
import java.util.*;

class Light{
	char type;
	int rowTime;
	int colTime;
	int curRowTime;
	int curColTime;
	
	public Light(char type, int rowTime, int colTime, int curRowTime, int curColTime) {
		this.type = type;
		this.rowTime = rowTime;
		this.colTime = colTime;
		this.curRowTime = curRowTime;
		this.curColTime = curColTime;
		
	}
}
class Truck{
	int row, col, cnt;
	public Truck(int row, int col, int cnt) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
	}
}
public class Main {
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static char[][] map;
	static boolean[][] visit;
	static int N,M,ans;
	static int lightCnt;
	static Light[] light;
	static Queue<Truck> q;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while(true) {
			lightCnt = 0;
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) {
				br.readLine();
				break;
			}
			
			map = new char[N][M];
			q = new LinkedList<>();
			visit = new boolean[N][M];
			flag = false;
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = ch[j];
					if(map[i][j]-'0' >= 0 && map[i][j]-'0' <= 9) {
						lightCnt = Math.max(lightCnt, map[i][j]-'0');
						flag = true;
					}
					if(map[i][j] == 'A') {
						visit[i][j] = true;
						q.add(new Truck(i,j,0));
					}
				}
			}
			if(flag) {
				light = new Light[lightCnt+1];
				
				for (int i = 0; i < lightCnt+1; i++) {
					st = new StringTokenizer(br.readLine());
					int idx = Integer.parseInt(st.nextToken());
					char type = st.nextToken().charAt(0);
					
					int rowTime = Integer.parseInt(st.nextToken());
					int colTime = Integer.parseInt(st.nextToken());
					
					int curRowTime = 0;
					int curColTime = 0;
					
					if(type == '-') 	 curRowTime = rowTime;
					else if(type == '|') curColTime = colTime;
				
					light[idx] = new Light(type,rowTime,colTime,curRowTime,curColTime);
				}
			}
			
			
			int ans = bfs();
			if(ans == -1) System.out.println("impossible");
			else 		  System.out.println(ans);
			
			br.readLine();
		}	
	}
	private static int bfs() {
		
		while(true) {
			int size = q.size();
			if(size == 0) break;
			
			for (int s = 0; s < size; s++) {
				Truck truck = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = truck.row + dx[i];
					int ny = truck.col + dy[i];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(map[nx][ny] == '.' || visit[nx][ny]) continue;
					if(map[nx][ny] == 'B') {
						return truck.cnt+1;
					}
					if(map[nx][ny]-'0' >= 0 && map[nx][ny]-'0' <= 9) {
						//앞에 신호등이 있으면
						
						//신호를 확인한다
						//가로신호등 이면서 가로로 진행중 
						if(light[map[nx][ny]-'0'].type == '-' && i%2 == 1) {
							visit[nx][ny] = true;
							q.add(new Truck(nx,ny,truck.cnt+1));
						}
						//세로신호등 이면서 세로로 진행중 
						else if(light[map[nx][ny]-'0'].type == '|' && i%2 == 0) {
							visit[nx][ny] = true;
							q.add(new Truck(nx,ny,truck.cnt+1));
						}
						//앞에 신호등이 있는데 방향이 달라서 기다려야함
						else if(light[map[nx][ny]-'0'].type == '-' && i%2 == 0
								|| light[map[nx][ny]-'0'].type == '|' && i%2 == 1) {
							
							q.add(new Truck(truck.row,truck.col,truck.cnt+1));
						}
					}else {
						//일반 길
						if(map[nx][ny] == '#') { 
							visit[nx][ny] = true;
							q.add(new Truck(nx,ny,truck.cnt+1));
						}
					}

				}
			}
			if(!flag) continue;
			for (int j = 0; j < light.length; j++) {
				
				//시간을 빼준다.
				if(light[j].type == '-') {
					light[j].curRowTime--;
					//시간이 끝났으면
					if(light[j].curRowTime == 0) {
						//다른방향 불을켜주고 타입을 바꿔준다.
						light[j].curColTime = light[j].colTime;
						light[j].type = '|';
					}
				}else if(light[j].type == '|') {
					light[j].curColTime--;
					//시간이 끝났으면
					if(light[j].curColTime == 0) {
						//다른방향 불을켜주고 타입을 바꿔준다.
						light[j].curRowTime = light[j].rowTime;
						light[j].type = '-';
					}
				}
			}
		}
		return -1;
	}
}