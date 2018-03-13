package popularProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.graph.Graph;
import util.graph.Vertex;

public class ComparatorTest {
	public static void main(String[] args) {

		test1();
		test2();
	}

	private static void test2() {
		Vertex v1 = new Vertex();
		v1.setTempWeight(1);
		Vertex v2 = new Vertex();
		v2.setTempWeight(2);
		Vertex v3 = new Vertex();
		v3.setTempWeight(3);

		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(3,
				new ComparatorTest().new VertexComp());

		pq.add(v1);
		pq.add(v2);
		pq.add(v3);

		Vertex v4 = v3;
		
		if(pq.contains(v4)){
			System.out.println("Contains v4");
		}

	}

	private static void test1() {
		char test = 'a';

		int aasci = (int) 'a';
		System.out.println(test('a'));
	}

	private static int test(char c) {
		// TODO Auto-generated method stub
		return (int) c;
	}

	class VertexComp implements Comparator<Vertex> {

		@Override
		public int compare(Vertex o1, Vertex o2) {
			if (o1.getTempWeight() < o2.getTempWeight()) {
				return -1;
			}
			if (o1.getTempWeight() > o2.getTempWeight()) {
				return 1;
			}
			return 0;
		}

	}
}
