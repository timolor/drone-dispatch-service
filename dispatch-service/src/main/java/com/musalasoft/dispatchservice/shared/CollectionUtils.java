package com.musalasoft.dispatchservice.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    /**
     * Method to retrieve the last element in a list.
     *
     * @param list {@link List}
     * @return E element
     */
    public static <E> E getLastElement(List<E> list) {
        E element = null;
        if (isNotEmpty(list)) {
            element = list.get(list.size() - 1);
        }
        return element;
    }

    /**
     * Method to retrieve the first element in a list
     *
     * @param list {@link List}
     * @return E element or null
     */
    public static <E> E getFirstElement(List<E> list) {
        if (isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * Method to remove the last element in a list.
     *
     * @param list {@link List}
     * @return E element
     */
    public static <E> E removeLastElement(List<E> list) {
        E element = null;
        if (isNotEmpty(list)) {
            element = list.remove(list.size() - 1);
        }
        return element;
    }

    /**
     * Method to verify if a list is empty or null
     *
     * @param list {@link List}
     * @return true/false
     */
    public static boolean isEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Method to verify if a list is not empty or null
     *
     * @param list {@link List}
     * @return true/false
     */
    public static boolean isNotEmpty(Collection<?> list) {
        return !isEmpty(list);
    }

    /**
     * Method to verify if a list is a singleton or contains only one element.
     *
     * @param list {@link Collection}
     * @return true/false
     */
    public static boolean isSingleton(Collection<?> list) {
        return isNotEmpty(list) && list.size() == 1;
    }

    /**
     * Method to retrieve the size of a collection <i>(nullsafe)</i>
     *
     * @param collection {@link Collection} of <T>
     * @return size of the collection
     */
    public static int size(Collection<?> collection) {
        return isEmpty(collection) ? 0 : collection.size();
    }

    /**
     * Method to retrieve a predicate of a collection that implements the not
     * {@link Collection#contains(Object)}.
     *
     * @param collection {@link Collection} of <T>
     * @return {@link Predicate} of <T>
     * @throws NullPointerException if the parameter is null
     */
    public static <T> Predicate<T> notContains(Collection<T> collection) {
        Objects.requireNonNull(collection);
        return element -> !collection.contains(element);
    }

    /**
     * Method to retrieve a range of immutable objects between 0 and 'X'
     * (exclusive).
     *
     * @param how
     * @return {@link List} of {@link Integer}
     */
    public static List<Integer> getIntRangeList(int how) {
        if (how == 0) {
            return Collections.singletonList(0);
        } else {
            return Collections.unmodifiableList(IntStream.range(0, how).boxed()
                    .collect(Collectors.toList()));
        }
    }

    /**
     *
     * @param <T1>
     * @param <T2>
     * @param collection {@link Collection} of type
     * @param mapper     {@link Function}
     * @return {@link List} o type
     */
    public static <T1, T2> List<T2> mapToList(Collection<T1> collection, Function<T1, T2> mapper) {
        if (isNotEmpty(collection)) {
            return collection.stream().map(mapper).collect(Collectors.toList());
        }
        return new ArrayList<>(0);
    }

    /**
     *
     * @param <T1>
     * @param <T2>
     * @param collection {@link Collection} of type
     * @param mapper     {@link Function}
     * @return {@link Set} o type
     */
    public static <T1, T2> Set<T2> mapToSet(Collection<T1> collection, Function<T1, T2> mapper) {
        if (isNotEmpty(collection)) {
            return collection.stream().map(mapper).collect(Collectors.toSet());
        }
        return new HashSet<>(0);
    }

    /**
     * Method to verify if a {@link String} is present in a {@link Collection}
     *
     * @param collection {@link Collection} of {@link String}
     * @param value      {@link String}
     * @return true/false
     * @throws NullPointerException if collection is null
     */
    public static boolean containsIgnoreCase(Collection<String> collection, String value) {
        Objects.requireNonNull(value);
        if (isNotEmpty(collection)) {
            return collection.stream().anyMatch(value::equalsIgnoreCase);
        }
        return false;
    }
}
