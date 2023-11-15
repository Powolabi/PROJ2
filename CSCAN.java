import java.util.Collections;
import java.util.List;

/**
 * This class will implement the C-SCAN 
 * disk scheduling algorithm.
 * 
 * @author ...
 */
public class CSCAN implements IDiskAlgorithm {

	@Override
	public int calculateDistance(List<DiskRequest> requests, int headPosition) {
		// TODO Auto-generated method stub

		Collections.sort(requests, (request1, request2) -> Integer.compare(request1.getTrack(), request2.getTrack()));

		int totalDistance = 0;
		int index = 0;

		for (int i = 0; i < requests.size(); i++) {
			if (requests.get(i).getTrack() >= headPosition) {
				index = i;
				break;
			}
		}

		for (int i = index; i < requests.size(); i++) {
			int track = requests.get(i).getTrack();
			totalDistance += Math.abs(track - headPosition);
			headPosition = track;
		}

		for (int i = 0; i < index; i++) {
			int track = requests.get(i).getTrack();
			totalDistance += Math.abs(track - headPosition);
			headPosition = track;
		}

		return totalDistance;
	}
}




