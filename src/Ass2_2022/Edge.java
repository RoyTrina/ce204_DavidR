package Ass2_2022;

public class Edge implements Comparable<Edge> {
    final int x;
    final int y; /* Endpoints */
    public final double w; /* Weight    */
    Edge this_edge;
    private Edge that;

    public Edge(int x, int y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    /*
     *  compareTo should return a negative integer if
     *  "this"<"that", 0 if they are equal, and a positive
     *  integer if "this">"that"
     */
    @Override
    public int compareTo(Edge that) {
        this.that = that;
        if (this_edge.w < that.w) {
            return -1;
        } else if (that == this_edge) {
            return 0;
        } else {
            return 1;

        }

    }

    public Edge getThat() {
        return that;
    }

    public void setThat(Edge that) {
        this.that = that;
    }
}
