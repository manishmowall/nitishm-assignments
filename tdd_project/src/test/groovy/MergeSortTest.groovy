/**
 * Created by webonise on 23/8/16.
 */
import spock.lang.Specification
class MergeSortTest extends Specification{
    def "sort() should not input null value"() {
        setup:
        MergeSort  mergeSort= new MergeSort()
        int[] inputarray=[];
        when:'if null input given'
        mergeSort.sort(null);
        mergeSort.sort(inputarray);

        then:
        thrown Exception

    }


    def "check boundry condition in mergesort()"(){
        setup:
        MergeSort mergeSort = new MergeSort()

        when:'if low great than high'
        mergeSort.mergesort(4,3);

        then:
        notThrown Exception

    }

    def "low , mid and high should be in increasing order in merge()"(){
        setup:
        MergeSort mergeSort = new MergeSort()

        when:'if low great than high'
        mergeSort.merge(4,3,2);

        then:
        thrown Exception

    }
}
