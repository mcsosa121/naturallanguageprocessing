package com.sosa.mc.nlp.ds;

public interface IMatrix<T> extends Iterable<T> {
	public T get( int i, int j ) throws ArrayIndexOutOfBoundsException;
	public T[] getRow( int i ) throws ArrayIndexOutOfBoundsException;
	public T[] getCol( int j ) throws ArrayIndexOutOfBoundsException;
	public void set( int i, int j ) throws ArrayIndexOutOfBoundsException;
	public IMatrix<T> transpose();
	public Pair<Integer, Integer> shape();
	
}
