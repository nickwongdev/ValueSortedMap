package com.yskts.valuesortedmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** @author niwong */
public class QueueSet<T> implements Set<T> {
	private Queue<T> queue = new LinkedList<T>();

	public int size() {

		return queue.size();
	}

	public boolean isEmpty() {

		return queue.isEmpty();
	}

	public boolean contains(final Object o) {

		return queue.contains(o);
	}

	public Iterator<T> iterator() {

		return queue.iterator();
	}

	public Object[] toArray() {

		return queue.toArray();
	}

	public <T> T[] toArray(final T[] a) {

		return toArray(a);
	}

	public boolean add(final T t) {

		return queue.add(t);
	}

	public boolean remove(final Object o) {

		return queue.remove(o);
	}

	public boolean containsAll(final Collection<?> c) {

		return queue.containsAll(c);
	}

	public boolean addAll(final Collection<? extends T> c) {

		return queue.addAll(c);
	}

	public boolean retainAll(final Collection<?> c) {

		return queue.retainAll(c);
	}

	public boolean removeAll(final Collection<?> c) {

		return queue.removeAll(c);
	}

	public void clear() {
		queue.clear();
	}
}
