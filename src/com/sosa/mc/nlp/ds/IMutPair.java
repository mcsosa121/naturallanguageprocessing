package com.sosa.mc.nlp.ds;

public class IMutPair<L, R> extends Pair<L,R> {
	private static final long serialVersionUID = 1L;
	// private static final IMutPair NULL of(null, null);
	
	public final L left;
	public final R right;
	
	public static <L,R> IMutPair<L,R> of( final L left, final R right ) {
		return new IMutPair<>( left, right );
	}
	
	
	public IMutPair(final L left, final R right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	public L _1() {
		return this.left;
	}
	
	public R _2() {
		return this.right;
	}
	
}
