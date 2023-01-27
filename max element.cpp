#include <iostream>
using namespace std;

int main() {
 const int size = 100;
    int n, m;
    int a[size][size];

    cin >> n >> m;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> a[i][j];
        }
    }

    int max = a[0][0];
    int maxi = 0, maxj = 0;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (max < a[i][j]) {
                max = a[i][j];
                maxi = i;
                maxj = j;
            }
        }
    }

    cout << maxi << ' ' << maxj;
       return 0;
}