import java.util.List;

/**
 * This class will implement the First Come First Serve 
 * disk scheduling algorithm.
 * 
 * @author ...
 */
public class FCFS implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {
		// TODO Auto-generated method stub

		int totalDistance = 0;

		for (DiskRequest request : requests) {
			int track = request.getTrack();
			totalDistance += Math.abs(track - headPosition);
			headPosition = track;
		}
		return totalDistance;
	}

}
