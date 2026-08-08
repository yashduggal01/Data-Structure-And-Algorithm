class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        if(image[sr][sc]==color){
            return image;
        }
        int ncolor = color;
        int pcolor = image[sr][sc];
        solve(image,sr,sc,pcolor,ncolor);
        return image;
    }
    static void solve(int[][] image , int sr , int sc , int pcolor , int ncolor){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=pcolor) return;
        image[sr][sc] = ncolor;
        solve(image,sr+1,sc,pcolor,ncolor);
        solve(image,sr,sc+1,pcolor,ncolor);
        solve(image,sr-1,sc,pcolor,ncolor);
        solve(image,sr,sc-1,pcolor,ncolor);
    }
}