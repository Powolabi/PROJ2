import java.util.Collections;
import java.util.List;

/**
 * This class will implement the SCAN 
 * disk scheduling algorithm.
 * 
 * @author ...
 */
public class SCAN implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {
		// TODO Auto-generated method stub
		Collections.sort(requests, (request1, request2) -> {
			// Sort by track and then by timeOfArrival in case of ties
			int trackComparison = Integer.compare(request1.getTrack(), request2.getTrack());
			return (trackComparison != 0) ? trackComparison : Integer.compare(request1.getTimeOfArrival(), request2.getTimeOfArrival());
		});

		int totalDistance = 0;
		int direction = 1;

		for (DiskRequest request : requests) {
			int track = request.getTrack();
			totalDistance += Math.abs(track - headPosition);
			headPosition = track;
		}
		return totalDistance;
	}

}
