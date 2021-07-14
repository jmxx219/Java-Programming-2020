import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 *  @version 2019년도 2학기
 *  @author 김상진 
 *  QueueTest.java
 *  최대 면적 섬 찾기. Queue를 이용한 BFS
 */
public class QueueTest01 {
	private static class Location{ 
		int r;
		int c;
		Location(int r, int c){ 
			this.r = r; this.c = c; 
		}
	}
	private static int computeArea(int r, int c, int[][] grid){
		int size = 0;
		Queue<Location> queue = new ArrayDeque<>();
		queue.add(new Location(r,c));
		while(!queue.isEmpty()){
			Location curr = queue.poll();
			++size;
			if(curr.r-1>=0&&grid[curr.r-1][curr.c]==1){ 
				queue.add(new Location(curr.r-1, curr.c));
				grid[curr.r-1][curr.c] = 0;
			}
			if(curr.r+1<grid.length&&grid[curr.r+1][curr.c]==1){ 
				queue.add(new Location(curr.r+1, curr.c));
				grid[curr.r+1][curr.c] = 0;
			}
			if(curr.c+1<grid[0].length&&grid[curr.r][curr.c+1]==1){ 
				queue.add(new Location(curr.r, curr.c+1));
				grid[curr.r][curr.c+1] = 0;
			}
			if(curr.c-1>=0&&grid[curr.r][curr.c-1]==1){
				queue.add(new Location(curr.r, curr.c-1));
				grid[curr.r][curr.c-1] = 0;
			}
		}   
		return size;
	}
	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for(int r=0; r<grid.length; r++)
			for(int c=0; c<grid[r].length; c++)
				if(grid[r][c]==1){
					grid[r][c]=0;
					int area = computeArea(r,c,grid);
					maxArea = Math.max(area, maxArea);
				}
		return maxArea;
	}
	public static void maxAreaOfIsland_test() {
		int[][] map = {	
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
		 	{0,1,0,0,1,1,0,0,1,0,1,0,0},
		 	{0,1,0,0,1,1,0,0,1,1,1,0,0},
		 	{0,0,0,0,0,0,0,0,0,0,1,0,0},
		 	{0,0,0,0,0,0,0,1,1,1,0,0,0},
		 	{0,0,0,0,0,0,0,1,1,0,0,0,0}	
		};
		System.out.println(maxAreaOfIsland(map));
		map = new int[][]{	
			{1,1,1,1,1,1,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{1,1,0,0,0,0,0,1,1,1,0,0,0},
			{1,1,0,0,0,0,0,1,1,0,0,0,0}	
		};
		System.out.println(maxAreaOfIsland(map));
	}
	public static void main(String[] args) {
		maxAreaOfIsland_test();
	}
}
