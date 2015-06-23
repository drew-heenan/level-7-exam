
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class TestBestRestaurantVoteCounter {

	@Test
	public void testLoadVotes() throws IOException {
		BestRestaurantVoteCounter brvc = new BestRestaurantVoteCounter();
		ArrayList<String> votes = brvc.loadVotes();
		for(String vote : votes) {
			assertTrue(vote.charAt(0) != ' ' && vote.charAt(vote.length()-1) != ' ');
	}}

}
