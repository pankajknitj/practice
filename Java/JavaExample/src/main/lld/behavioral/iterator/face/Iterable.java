package main.lld.behavioral.iterator.face;

public interface Iterable<T> {
    Iterator<T> emailIterator();
    Iterator<T> smsIterator();
    Iterator<T> unreadIterator();
}
