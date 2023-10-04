class sumthread extends Thread {
    int j, n;
    matrix m;

    sumthread(int i, int k, matrix obj) {
        super();
        j = i;
        n = k;
        m = obj;
    }

    public void run() {
        try {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += m.mat[i][j];
            }
            System.out.println("sum column of " + j + " :: " + sum);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

class matrix {
    int[][] mat;
    int n;

    matrix(int[][] mat) {
        this.mat = mat;
        n = mat.length;
    }

    public void compute() {
        for (int i = 0; i < n; i++) {
            try {
                sumthread t = new sumthread(i, n, this); // Pass 'this' to provide the matrix object
                t.start();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class mul_thread {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        matrix m = new matrix(mat);
        m.compute();
    }
}
