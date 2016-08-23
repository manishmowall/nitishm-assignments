/**
 * Created by webonise on 23/8/16.
 */
import spock.lang.Specification
class QuickSortTest extends Specification{
    def "sort() should not input null value"() {
        setup:
        QuickSort  quickSort= new QuickSort()
        int[] inputarray=[];
        when:'if null input given'
        quickSort.sort(null);
        quickSort.sort(inputarray);
        then:
        thrown Exception
    }

    def "check boundry condition in mergesort()"(){
        setup:
        QuickSort quickSort = new QuickSort()

        when:'if low great than high'
        quickSort.quicksort(4,3);

        then:
        thrown Exception

    }

    def "check elements that are swapping in exchange()"(){

        setup:
        QuickSort quickSort=new QuickSort()

        when:'if both number are equal'
        quickSort.exchange(1,1);

        then:
        thrown Exception
    }


}

