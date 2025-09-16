package com.ityj.entity;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestVote {

	@Test
	public void testA() {
		Result candidate = findCandidate(new String[]{"A", "B", "A", "C", "C"});
		System.out.println("candidate = " + candidate);
	}


     public Result findCandidate(String[] strs) {
	Result res = new Result();
	if (strs == null || strs.length == 0) {
	  return res;
               }
               Map<String, Integer> map = new HashMap<>();
	for (String str : strs) {
                      if (str == null || "".equals(str)) {
		continue;
                      }
	      Integer count = map.get(str);
	      if (count == null) {
		map.put(str, 1);
	     } else {
		map.put(str, count + 1);
       	     }
	}

	int maxVotes = getMaxVote(map );
		 res.setVotes(maxVotes);



	map.forEach((key, count) -> {
		if (count == maxVotes) {
		  res.addCandidate(key);
		}
	});

     return res;


     }

	public int getMaxVote(Map<String, Integer> map ) {
		 int max = -1;
		for (Integer value : map.values()) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}


}
