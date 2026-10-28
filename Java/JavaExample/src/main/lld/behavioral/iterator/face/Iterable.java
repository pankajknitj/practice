package main.lld.behavioral.iterator.face;

// A Contract for collection.
public interface Iterable<T> {
    Iterator<T> emailIterator();
    Iterator<T> smsIterator();
    Iterator<T> unreadIterator();
}
