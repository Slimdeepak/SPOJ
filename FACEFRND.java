import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class FACEFRND {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberfriends = sc.nextInt();
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		while(numberfriends-->0){
			int friend = sc.nextInt();
			map.put(friend,null);
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				list.add(sc.nextInt());
			}
			map.put(friend,list);
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(ArrayList<Integer> l : map.values()){
			for(int item : l){
				set.add(item);
			}
		}
		for(int friends:map.keySet()){
			set.remove(friends);
		}
		//System.out.println(map);
		//System.out.println(set);
		System.out.println(set.size());
	}
}
