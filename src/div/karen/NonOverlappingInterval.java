package div.karen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Author: Karen 2017.3.13
 * Description : Q3. Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).  */
public class NonOverlappingInterval {

	public NonOverlappingInterval() {
	}

	public List<Interval> reverse(List<Interval> intervalList, Interval newInterval) {

		List<Interval> result = new ArrayList<>();

		// add insert one into intervalList
		intervalList.add(newInterval);

		// Sort intervals
		Collections.sort(intervalList, Interval.temp);

		Interval preValue = intervalList.get(0);
		for (int i = 0; i < intervalList.size(); i++) {
			// get the interval with loop
			Interval current = intervalList.get(i);
			// if the current start is larger than prev end, change it to next one
			if (current.getStart() > preValue.getEnd()) {
				result.add(preValue);
				preValue = current;
			} else {
				// others merged it with the max end time, and put the merged interval to pre value
				Interval merged = new Interval(preValue.getStart(), Math.max(preValue.getEnd(), current.getEnd()));
				preValue = merged;
			}
		}
		result.add(preValue);

		return result;
	}

	public static void main(String[] args) {

		// Insert interval start and end
		Interval newOne = new Interval(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

		//give a set of interval
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 2));
		input.add(new Interval(3, 5));
		input.add(new Interval(6, 7));
		input.add(new Interval(8, 10));
		input.add(new Interval(12, 16));
		
		System.out.println("Insert interval : [" + newOne.getStart() + ", " + newOne.getEnd() + "]");
		System.out.print("Orignial interval list : ");
		for (Interval orin : input) {
			System.out.print("[" + orin.getStart() + ", " + orin.getEnd() + "] ");
		}

		System.out.print("\nMerged list : ");
		NonOverlappingInterval sb = new NonOverlappingInterval();
		for (Interval in : sb.reverse(input, newOne)) {
			System.out.print("[" + in.getStart() + ", " + in.getEnd() + "] ");
		}

	}
}
