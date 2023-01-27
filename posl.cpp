#include <iostream>
using nemespace std;
int main() {
    const int size=15;
    int n;
    int a[15][15];
    for (int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if (i==j or j==n/2 or i==n/2 or i==n-j-1)
                a[i][j]='*';
            else
                a[i][j]='.';
        }}
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout<< a[i][j] << " ";
        }
        cout << endl;
    }
   
    return 0;
}