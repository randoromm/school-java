import java.util.*;
/** Container class to different classes, that makes the whole
 * set of classes one class formally.
 */
public class GraphTask {

    /** Main method. */
    public static void main (String[] args) {
        GraphTask a = new GraphTask();
        a.run();
        //throw new RuntimeException ("Nothing implemented yet!"); // delete this
    }

    /** Actual main method to run examples and everything. */
    public void run() {
        Graph g = new Graph ("G");
        g.createRandomSimpleGraph (5, 7);
        System.out.println (g);
        Stack res = g.sortTopologically();
        System.out.println("Topological sort:");
        while (!res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }
    }

    /**
     * Vertex class, to create objects for vertices in the graph.
     */
    class Vertex {

        private String id;
        private Vertex next;
        private Arc first;
        private int info = 0;
        // You can add more fields, if needed
        private int infoIncEdges = 0;  // This int is used to help with isAcyclic() function.

        Vertex (String s, Vertex v, Arc e) {
            id = s;
            next = v;
            first = e;
        }

        Vertex (String s) {
            this (s, null, null);
        }

        @Override
        public String toString() {
            return id;
        }

        /**
         * Method to check if there are more vertices in the graph after the current one.
         * @return true if there are more vertices after the current one in the graph.
         */
        private boolean hasNext() {
            return next != null;
        }

        /**
         * Method to get all adjacent vertices of a vertex.
         * @return ArrayList containing all adjacent vertices of the vertex.
         */
        private ArrayList<Vertex> getAllChildren() {
            ArrayList<Vertex> vertices = new ArrayList<>();
            Arc a = first;
            if (a == null) return vertices;
            vertices.add(a.target);
            while (a.hasNext()) {
                vertices.add(a.next.target);
                a = a.next;
            }
            return vertices;
        }
    }


    /** Arc represents one arrow in the graph. Two-directional edges are
     * represented by two Arc objects (for both directions).
     */
    class Arc {

        private String id;
        private Vertex target;
        private Arc next;
        private int info = 0;
        // You can add more fields, if needed

        Arc (String s, Vertex v, Arc a) {
            id = s;
            target = v;
            next = a;
        }

        Arc (String s) {
            this (s, null, null);
        }

        @Override
        public String toString() {
            return id;
        }

        /**
         * Method to check if there are more edges for source vertex.
         * @return true if there are more edges after the current one for source vertex.
         */
        private boolean hasNext() {
            return next != null;
        }
    }

    /**
     * Class to create graphs.
     */
    class Graph {

        private String id;
        private Vertex first;
        private int info = 0;
        // You can add more fields, if needed

        Graph (String s, Vertex v) {
            id = s;
            first = v;
        }

        Graph (String s) {
            this (s, null);
        }

        @Override
        public String toString() {
            String nl = System.getProperty ("line.separator");
            StringBuffer sb = new StringBuffer (nl);
            sb.append (id);
            sb.append (nl);
            Vertex v = first;
            while (v != null) {
                sb.append (v.toString());
                sb.append (" -->");
                Arc a = v.first;
                while (a != null) {
                    sb.append (" ");
                    sb.append (a.toString());
                    sb.append (" (");
                    sb.append (v.toString());
                    sb.append ("->");
                    sb.append (a.target.toString());
                    sb.append (")");
                    a = a.next;
                }
                sb.append (nl);
                v = v.next;
            }
            return sb.toString();
        }

        public Vertex createVertex (String vid) {
            Vertex res = new Vertex (vid);
            res.next = first;
            first = res;
            return res;
        }

        public Arc createArc (String aid, Vertex from, Vertex to) {
            Arc res = new Arc (aid);
            res.next = from.first;
            from.first = res;
            res.target = to;
            to.infoIncEdges++; // This is added, to later know how many incoming edges a vertex has.
            return res;
        }

        /**
         * Create a connected undirected random tree with n vertices.
         * Each new vertex is connected to some random existing vertex.
         * @param n number of vertices added to this graph
         */
        public void createRandomTree (int n) {
            if (n <= 0)
                return;
            Vertex[] varray = new Vertex [n];
            for (int i = 0; i < n; i++) {
                varray [i] = createVertex ("v" + String.valueOf(n-i));
                if (i > 0) {
                    int vnr = (int)(Math.random()*i);
                    createArc ("a" + varray [vnr].toString() + "_"
                            + varray [i].toString(), varray [vnr], varray [i]);
                    // Commented out to generate directed graphs.
                    /*createArc ("a" + varray [i].toString() + "_"
                            + varray [vnr].toString(), varray [i], varray [vnr]);*/
                } else {}
            }
        }

        /**
         * Create an adjacency matrix of this graph.
         * Side effect: corrupts info fields in the graph
         * @return adjacency matrix
         */
        public int[][] createAdjMatrix() {
            info = 0;
            Vertex v = first;
            while (v != null) {
                v.info = info++;
                v = v.next;
            }
            int[][] res = new int [info][info];
            v = first;
            while (v != null) {
                int i = v.info;
                Arc a = v.first;
                while (a != null) {
                    int j = a.target.info;
                    res [i][j]++;
                    a = a.next;
                }
                v = v.next;
            }
            return res;
        }

        /**
         * Create a connected simple (directed, no loops, no multiple
         * arcs) random graph with n vertices and m edges.
         * @param n number of vertices
         * @param m number of edges
         */
        public void createRandomSimpleGraph (int n, int m) {
            if (n <= 0)
                return;
            if (n > 2500)
                throw new IllegalArgumentException ("Too many vertices: " + n);
            if (m < n-1 || m > n*(n-1)/2)
                throw new IllegalArgumentException
                        ("Impossible number of edges: " + m);
            first = null;
            createRandomTree (n);       // n-1 edges created here
            Vertex[] vert = new Vertex [n];
            Vertex v = first;
            int c = 0;
            while (v != null) {
                vert[c++] = v;
                v = v.next;
            }
            int[][] connected = createAdjMatrix();
            int edgeCount = m - n + 1;  // remaining edges
            while (edgeCount > 0) {
                int i = (int)(Math.random()*n);  // random source
                int j = (int)(Math.random()*n);  // random target
                if (i==j)
                    continue;  // no loops
                if (connected [i][j] != 0 || connected [j][i] != 0)
                    continue;  // no multiple edges
                Vertex vi = vert [i];
                Vertex vj = vert [j];
                createArc ("a" + vi.toString() + "_" + vj.toString(), vi, vj);
                connected [i][j] = 1;
                // Commented out, because for topological sorting i need directed graphs.
                /*createArc ("a" + vj.toString() + "_" + vi.toString(), vj, vi);
                connected [j][i] = 1;*/
                edgeCount--;  // a new edge happily created
            }
        }

        /**
         * Main method for topological sorting.
         * @return Stack of topologically sorted vertices.
         */
        public Stack<Vertex> sortTopologically() {
            if (!this.isAcyclic())
                throw new RuntimeException("Graph '" + this.id + "' is not acyclic. Not possible to sort topologically.");
            Set<Vertex> visited = new HashSet<>();
            Stack<Vertex> sorted = new Stack<>();
            for (Vertex v : getAllVertices()) {
                if (visited.contains(v)) continue;
                sortTopUtil(v, sorted, visited);
            }
            return sorted;
        }

        /**
         * Utility/helping method for topological sorting.
         * @param v Current vertex in the process.
         * @param sorted Stack of sorted vertices (result stack).
         * @param visited Set of visited vertices.
         */
        private void sortTopUtil(Vertex v, Stack<Vertex> sorted, Set<Vertex> visited) {
            visited.add(v);
            for (Vertex child : v.getAllChildren()) {
                if (visited.contains(child)) continue;
                sortTopUtil(child, sorted, visited);
            }
            sorted.push(v);
        }

        /**
         * Method to gather all the vertices in the graph.
         * @return ArrayList of all vertices in the graph.
         */
        private ArrayList<Vertex> getAllVertices() {
            ArrayList<Vertex> vertices = new ArrayList<>();
            Vertex v = this.first;
            if (v == null) throw new RuntimeException("Graph '" + id + "' is empty");
            vertices.add(v);
            while (v.hasNext()) {
                vertices.add(v.next);
                v = v.next;
            }
            return vertices;
        }

        /**
         * Main method to check if the randomly generated directed graph is acyclic or not.
         * @return True if graph is a DAG (Directed Acyclic Graph).
         */
        private boolean isAcyclic() {
            ArrayList<Vertex> vertices = getAllVertices();
            Stack<Vertex> roots = new Stack<>();
            for (Vertex v : vertices) {
                if (v.infoIncEdges == 0) roots.push(v);
            }
            if (roots.isEmpty()) return false;
            while (!roots.isEmpty()) {
                isAcyclicUtil(roots.pop(), vertices, roots);
            }

            return vertices.isEmpty();
        }

        /**
         * Utility method for checking if the graph is acyclic or not.
         * The method removes the roots of the graph one by one until
         * there are none left (in which case it's acyclic graph).
         * If the list of vertices is not empty after removal process, it's not an acyclic graph.
         * @param v Current vertex in observation.
         * @param vertices List of all vertices.
         * @param roots Stack of roots.
         */
        private void isAcyclicUtil(Vertex v, ArrayList<Vertex> vertices, Stack<Vertex> roots) {
            ArrayList<Vertex> children = v.getAllChildren();
            vertices.remove(v);
            for (Vertex child : children) {
                child.infoIncEdges--;
                if (child.infoIncEdges == 0) {
                    roots.push(child);
                    isAcyclicUtil(child, vertices, roots);
                }
            }
        }
    }
}