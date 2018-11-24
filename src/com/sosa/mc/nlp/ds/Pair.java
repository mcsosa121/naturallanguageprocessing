package com.sosa.mc.nlp.ds;

public abstract class Pair<L, R> {
	private static final long serialVersionUID = 1L;
	
	public static <L, R> Pair<L, R> of( final L left, final R right ) {
		return new IMutPair<L, R>( left, right );
	}
	
	public abstract L _1();
	public abstract R _2();
	
	public String toString() {
		return "( " + _1() + ", " + _2() + " )"; 
	}
}