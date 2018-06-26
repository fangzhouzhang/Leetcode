public class Main {

    public static void main(String[] args) {
       int[][] nums = {{28,-11,-80,-29,41,94,-79}, {26,-70,-100,49,-2,-91,86}, {57,74,-49,18,76,-31,-1}, {80,76,-52,71,99,81,-56}, {43,58,-36,66,-36,97,88}, {70,69,-94,36,73,39,-19}, {-100,-70,-65,-21,64,-37,51}};
        MaximumSubmatrix maximumSubmatrix = new MaximumSubmatrix();
        maximumSubmatrix.maxSubmatrix(nums);
    }
}
