package dynamic_programming.strategy_for_dp_question;

public class Example_8_2_PlaceTiles {

    // Size of the plot is 2 * n, each tile is 2 * 1
    int countWays( int n ){
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 2;
        return countWays(n-1) + countWays(n-2);
    }

    // Size of the plot is 3 * n, each tile is 2 * 1
    int countWays3NPlot( int n ){
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        if ( n == 2 ) return 3;
        return countWays(n-1) + countWays(n-2);
    }
}
