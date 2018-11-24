package com.sosa.mc.nlp.ds;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Predicate;

// Should be used for strings
public class Counter {
	public Map<String, Long> cts;
	
	public Counter() {
		this.cts = new HashMap<String, Long>();
	}
	
	public Counter( ArrayList<String> inp ) {
		this.cts  = inp.stream()
				      .collect(
				    		  Collectors.groupingBy( e -> e, Collectors.counting() ) );
	}
	
	public Integer size() {
		return cts.size();
	}
	
	public Set<String> keys() {
		return cts.keySet();
	}
	
	public Collection<Long> values() {
		return cts.values();
	}
	
	public void update( ArrayList<String> inp ) {
		Map<String, Long> ctsn = inp.stream()
									.collect( 
										Collectors.groupingBy( e -> e, Collectors.counting() ) );
		
		// the new counts
		Map<String, Long> ncts = new HashMap<>(this.cts);
		ctsn.forEach(
					(k, v) -> ncts.merge( k, v, (v1,v2) -> v1 + v2 )
				);
		
		this.cts = ctsn;
	}
	
	public void subtract( ArrayList<String> inp ) {
		Map<String, Long> ctsn = inp.stream().collect( Collectors.groupingBy( e -> e, Collectors.counting()));
		Map<String, Long> ncts = new HashMap<>(this.cts);
		ctsn.forEach(
				(k,v) -> ncts.merge( k, v, (v1, v2) -> v1 - v2 )
				);
		
		Predicate<Long> p = x -> ( x != 0 );
		this.cts = ncts.entrySet()
					   .stream()
					   .filter( x -> p.test( x.getValue() ) )
					   .collect( Collectors.toMap(Entry::getKey, Entry::getValue) ); 
	}
	
	// Sum of all the values 
	public Long valsum() {
		return cts.values()
				  .stream()
				  .mapToLong( e -> e )
				  .sum();
	}
}
