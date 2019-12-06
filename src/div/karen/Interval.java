package div.karen;
import java.util.Comparator;

public class Interval {
	private int start;
	private int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	/* Comparator for sorting the list by start and end */
	public static Comparator<Interval> temp = new Comparator<Interval>() {

		public int compare(Interval s1, Interval s2) {

			// For ascending order
			if (s1.getStart() != s2.getStart()) {
				return s1.getStart() - s2.getStart();
			} else {
				return s1.getEnd() - s2.getEnd();
			}
		}
	};

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
